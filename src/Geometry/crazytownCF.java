package Geometry;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class crazytownCF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		
		String r[]=br.readLine().split(" ");
		int xh=Integer.parseInt(r[0]);
		int yh=Integer.parseInt(r[1]);
	
		 r=br.readLine().split(" ");
		
		int xu=Integer.parseInt(r[0]);
		int yu=Integer.parseInt(r[1]);
	
		int lines=0;
		int n=Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			r=br.readLine().split(" ");
			long a=Integer.parseInt(r[0]);
			long b=Integer.parseInt(r[1]);
			long c=Integer.parseInt(r[2]);
			
				//good note if 2 points are on opposite sides of the line there subist coord in line equ will have diff signs
				long s1=a*xu+b*yu+c;
				long s2=a*xh+b*yh+c;
				if((s2>0&&s1<0)||(s2<0&&s1>0))
					lines++;
					
				
					
			
			
		}
		
		out.println(lines);
		out.flush();
		
	}
}