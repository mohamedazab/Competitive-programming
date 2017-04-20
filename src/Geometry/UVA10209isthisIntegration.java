package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA10209isthisIntegration {

	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out=new PrintWriter(System.out);
			
			while(br.ready()){
			double l=Double.parseDouble(br.readLine());
			double rect=l*l/2.0;
			double tri=l*l*Math.sin(Math.PI/3.0)/4.0;
			double sector=Math.PI*l*l/12.0;
			double smallpart=rect-tri-sector;
			double ans1=8.0*smallpart;
			
			double starpart=l*l-(l*l*Math.PI/4.0)-4*smallpart;
			
			double ans2=starpart*4.0;
			double remaining=l*l-(ans1+ans2);
			double num1=(double)Math.round(remaining * 1000) / (double)1000;
			double num2=(double)Math.round(ans2 * 1000) / (double)1000;
			double num3=(double)Math.round(ans1 * 1000) / (double)1000;
			out.printf("%.3f %.3f %.3f\n", num1,num2,num3);
			
			
			
			

	}
			out.flush();
			}

}
