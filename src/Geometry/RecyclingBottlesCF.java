package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*class Point implements Comparable<Point>{

	static final double EPS = 1e-9;

	double x, y;                  

	Point(double a, double b) { x = a; y = b; }  
	
	public int compareTo(Point p)
	{
		if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
		if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
		return 0;
	}
	
	public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
	public double dist2(Point p) { return sq(x - p.x) + sq(y - p.y); }
	static double sq(double x) { return x * x; }
	boolean between(Point p, Point q)
	{
		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
	}

	// Another way: find closest point and calculate the distance between it and p

	
}
public class RecyclingBottlesCF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String t[]=br.readLine().split(" ");
		Point adil=new Point(Double.parseDouble(t[0]),Double.parseDouble(t[1]));
		Point bera=new Point(Double.parseDouble(t[2]),Double.parseDouble(t[3]));
		Point bin=new Point(Double.parseDouble(t[4]),Double.parseDouble(t[5]));
		int n=Integer.parseInt(br.readLine());
		
		Point[] points=new Point[n];
		for (int i = 0; i <n; i++) {
			String []r=br.readLine().split(" ");
			points[i]=new Point(Double.parseDouble(r[0]),Double.parseDouble(r[1]));
			
			
		}
		Point clAD=null;Point clBE=null;
		Point clAD2;Point clBE2;
		double minsofar1=1000000000;double minsofar2=1000000000;
		double dist=0;
		double adp[]=new double[n];
		double bep[]=new double[n];
		for (int i = 0; i < bep.length; i++) {
			adp[i]=adil.dist(points[i])-bin.dist(points[i]);
			bep[i]=bera.dist(points[i])-bin.dist(points[i]);
       if(adp[i]<minsofar1)
       {
    	   minsofar1=adp[i];
    	   clAD2=clAD;
    	   clAD=points[i];
       }
       if(bep[i]<minsofar2)
       {
    	   minsofar2=bep[i];
    	   clBE2=clBE;
    	   clBE=points[i];
       }	
		}
		
		
		for (int i = 0; i < points.length; i++) {
			dist+=points[i].dist(bin);
		}
		dist*=2;
		
		if(clBE.compareTo(clAD)==0)
			
		
		
		
		System.out.println(dist);

	}

}*/
