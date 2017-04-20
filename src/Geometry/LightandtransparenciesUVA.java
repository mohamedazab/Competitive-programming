package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;




public class LightandtransparenciesUVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		int cases=Integer.parseInt(br.readLine());
		
		while(cases-->0){
			br.readLine();
		int n=Integer.parseInt(br.readLine());
		LineSegment[] lines=new LineSegment[n];
		 ArrayList<Double> numarr=new ArrayList<Double>(500);
		for (int i = 0; i < n; i++) {
			String r[]=br.readLine().split(" ");
			double xs=Double.parseDouble(r[0]);
			double ys=Double.parseDouble(r[1]);
	    numarr.add(xs);
	    double xc=Double.parseDouble(r[2]);
	    numarr.add(xc);
		double yc=Double.parseDouble(r[3]);	
	    double coef=Double.parseDouble(r[4]);
			lines[i]=new LineSegment(xs,xc,coef);
			
			
			
		}
		Arrays.sort(lines);
       Collections.sort(numarr);
		
	out.println(numarr.size()+1);
	out.printf("-inf %.3f %.3f\n",numarr.get(0),1.0);
		
		for (int i = 0;i<numarr.size()-1; i++) {
			
			double start=numarr.get(i);
			double end=numarr.get(i+1);
			double coef=1;
			for (int j = 0; j < lines.length; j++) {
				if(lines[j].x1<=start&&lines[j].x2>=end)
					coef*=lines[j].co;
				else
				{
					if(lines[j].x1>end)
						break;
				}
			}
			
			
			coef=(double)Math.round(coef * 1000) / (double)1000;
			out.printf("%.3f %.3f %.3f\n",start,end,coef);
			
					}
		
		if(cases>=1)
		out.printf("%.3f +inf %.3f\n\n",numarr.get(numarr.size()-1),1.0);
		else
			out.printf("%.3f +inf %.3f\n",numarr.get(numarr.size()-1),1.0);	
		
		
	}
		
		out.flush();

	
	}


static class LineSegment implements Comparable<LineSegment>  {

	double x1 , x2 , co;
	
	LineSegment(double a,double b,double c) {
		this.co=c;
		this.x1=Math.min(a, b);
		this.x2=Math.max(a, b);
				}
	

	
	@Override
	public int compareTo(LineSegment o) {
		
		
		
		return x1>o.x1?1:-1;
		
		
	}


	
}




}

