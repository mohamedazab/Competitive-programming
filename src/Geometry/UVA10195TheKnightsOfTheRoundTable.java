package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA10195TheKnightsOfTheRoundTable {


		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out=new PrintWriter(System.out);
			
			while(br.ready()){
				
				String t[]=br.readLine().split(" ");
				double a=Double.parseDouble(t[0]);
						double b=Double.parseDouble(t[1]);
								double c=Double.parseDouble(t[2]);
								double s=0.5*(a+b+c);
								double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
								double r=area/s;
								double x=(double)Math.round(r * 1000) / (double)1000;
								out.printf("The radius of the round table is: %.3f/n",x);
				}
			out.flush();
			}

	}

