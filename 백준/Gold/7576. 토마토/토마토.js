const [[maxCol, maxRow], ...arr] = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt', 'utf8')
  .toString()
  .trim()
  .split('\n')
  .map((el) => el.split(' ').map(Number));

const directions = [
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0],
];

let cnt = 0;
let unripeTomatoes = 0;

const findRipeTomato = (arr) => {
  const tomatoList = [];
  arr.forEach((a, row) => {
    a.forEach((tomato, col) => {
      if (tomato === 1) tomatoList.push([row, col, cnt]);
      if (!tomato) unripeTomatoes += 1;
    });
  });
  return tomatoList;
};

const affectToOtherTomato = (row, col, cnt) => {
  directions.forEach(([r, c]) => {
    const newRow = row + r;
    const newCol = col + c;
    if (newRow < 0 || newCol < 0 || newRow > maxRow - 1 || newCol > maxCol - 1) return;
    const otherTomato = arr[newRow][newCol];
    if (otherTomato) return;
    arr[newRow][newCol] = 1;
    queue.push([newRow, newCol, cnt + 1]);
  });
};

const checkTomatoRipped = () => {
  let isAllRipped = true;
  arr.forEach((a, row) => {
    a.forEach((tomato, col) => {
      if (!tomato) isAllRipped = false;
    });
  });
  return isAllRipped;
};

const queue = findRipeTomato(arr);
let queueIndex = 0;
if (!unripeTomatoes) return console.log(cnt);

while (queueIndex < queue.length) {
  const [row, col, newCount] = queue[queueIndex];
  queueIndex += 1;
  affectToOtherTomato(row, col, newCount);
  cnt = Math.max(cnt, newCount);
}

console.log(checkTomatoRipped() ? cnt : -1);
