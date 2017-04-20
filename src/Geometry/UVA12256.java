package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA12256 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int ix=1;
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			long a=1;long b=1;long c=1;
			long sum=0;
			for (int i = 4; i <=n; i++) {
				sum=a+c+b;
				c=b;
				b=a;
				a=sum;
			}
			
			out.printf("Case %d: %d\n",ix,(sum));
			ix++;
			//minimum when any side ith equal to the sum of the other sides
			
			
			
		}out.flush();

	}

}
