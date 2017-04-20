package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA1092LaurelHardy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);	
		int N=Integer.parseInt(br.readLine());
		for (int i = 1; i <=N; i++) {
			String rm[]=br.readLine().split(" ");
			int r=Integer.parseInt(rm[0]);
			int d=Integer.parseInt(rm[1]);
			int h1=Integer.parseInt(rm[2]);
			double AB=2*Math.sqrt(r*r-(r-d)*(r-d));
			double bigangle=Math.asin((double)(r-h1)/(double)r);
			
			double angle2=Math.asin((double)(r-d)/(double)r);
			double fangle=bigangle-angle2;
			double h2=h1+AB*Math.sin(fangle);
			 h2=(double)Math.round(h2 * 10000) / (double)10000;
			out.printf("Case %d: %.4f\n",i,h2);
			
			
			
		}
		out.flush();
		
	}

}
