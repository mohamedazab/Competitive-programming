package solopractice;







import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int oneposx=0;int oneposy=0;
		for (int i = 0; i < 5; i++) {
			
			String x[]=br.readLine().split(" ");
			for (int j = 0; j < x.length; j++) {
				if(x[j].equals("1"))
					{oneposy=j;
					oneposx=i;
					System.out.println(Math.abs(oneposy-2)+Math.abs(oneposx-2));
					return;
					}
				
			}
		}
			
	}
	}
