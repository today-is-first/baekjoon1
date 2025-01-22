import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	List<Integer> li = new ArrayList<Integer>();
    	
    	for(int i=0; i<n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(num == 0 && li.size() > 0) li.remove(li.size()-1);
    		else li.add(num);
    	}
    	
    	System.out.println(li.stream().mapToInt(Integer::intValue).sum());
    }
}