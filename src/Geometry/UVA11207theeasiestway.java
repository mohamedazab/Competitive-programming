package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11207theeasiestway {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(true){
			int t=Integer.parseInt(br.readLine());
			if(t==0)
				break;
			double maxL=0;int maxnum=0;
			for (int i = 0; i < t; i++) {
				String r[]=br.readLine().split(" ");
				int l=Integer.parseInt(r[0]);
				int w=Integer.parseInt(r[1]);
				double side1=Math.min(l, w)/2.0;
				double side2=Math.min(Math.max(l, w)/4.0,Math.min(l, w));
				
							
				{if(maxL<Math.max(side1, side2))
				{
					maxL=Math.max(side1, side2);
					maxnum=i+1;
				}}
				
				
				
			}
			out.println(maxnum);
		}
	out.flush();

	}

}
