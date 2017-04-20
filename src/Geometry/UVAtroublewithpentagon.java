package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVAtroublewithpentagon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(br.ready()){
			double r=Double.parseDouble(br.readLine());
			double res=r*Math.sin(72*Math.PI/180.0)/Math.sin(63*Math.PI/180.0);
			long r1=10000000000L;
			double dist=(double)Math.round(res * r1) / (double)r1;
			out.printf("%.10f\n",dist);
			
			
		}
		
	}

}
