package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVAbilliard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		while (true){
		String r[]=br.readLine().split(" ");
		int a=Integer.parseInt(r[0]);
		int b=Integer.parseInt(r[1]);
		int s=Integer.parseInt(r[2]);
		int m=Integer.parseInt(r[3]);
		int n=Integer.parseInt(r[4]);
		if(a==0&&b==0&&s==0&&m==0&&n==0)
			break;
		double h1=a*m;double h2=b*n;
		double totdist=Math.sqrt((h1*h1+h2*h2));//a*a*m*m+b*b*n*n
		//System.out.println(a+"  "+b+" "+m+" "+n+" "+totdist+"  "+((double)(m*a)/totdist));
		double v=totdist/s;
	
		double ang=Math.acos((double)(m*a)/(double)totdist)*180.0/Math.PI;
		out.printf("%.2f %.2f\n", ang,v);
		
		}out.flush();

	}

}
