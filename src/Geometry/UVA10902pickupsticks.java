package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
class Point implements Comparable<Point>{

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
	
	static double sq(double x) { return x * x; }
	boolean between(Point p, Point q)
	{
		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
	}

	// Another way: find closest point and calculate the distance between it and p

	
}
class Line {

	static final double INF = 1e9, EPS = 1e-9;
	
	double a, b, c;
	
	Line(Point p, Point q)
	{
		if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
		else
		{
			a = (p.y - q.y) / (q.x - p.x);
			b = 1.0;
			c = -(a * p.x + p.y);
		}
					
	}
	
	Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 
	
	boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
	
	boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
	
	Point intersect(Line l)
	{
		if(parallel(l))
			return null;
		double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
		double y;
		if(Math.abs(b) < EPS)
			 y = -l.a * x - l.c;
		else
			y = -a * x - c;
		
		return new Point(x, y);
	}
	
	
			
}

class LineSegment {

	Point p, q; int n;
	
	LineSegment(Point a, Point b,int n) {this.n=n; p = a; q = b; }
	

	boolean intersect(LineSegment ls)
	{
		Line l1 = new Line(p, q);
				Line l2 = new Line(ls.p, ls.q);
		if(l1.parallel(l2))
		{
			if(l1.same(l2))
				return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
			return false;
		}
		Point c = l1.intersect(l2);
		return c.between(p, q) && c.between(ls.p, ls.q);
	}
	

}
public class UVA10902pickupsticks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)break;
			
			ArrayList<LineSegment> top=new ArrayList<LineSegment>();
			for (int i = 0; i < n; i++) {
				String r[]=br.readLine().split(" ");
				double xs=Double.parseDouble(r[0]);
				double ys=Double.parseDouble(r[1]);
				double xe=Double.parseDouble(r[2]);
				double ye=Double.parseDouble(r[3]);
				LineSegment x=new LineSegment(new Point(xs,ys),new Point(xe,ye),i+1);
				ArrayList<LineSegment> index=new ArrayList<LineSegment>();
				for (int j = 0; j < top.size(); j++) {
					
					if(!x.intersect(top.get(j)))
						{
						index.add(top.get(j));
						
						}
				}
				top=index;
				
				top.add(x);
				
			}
			out.print("Top sticks:");
			int i=0;
			for ( i = 0; i < top.size()-1; i++) {
				
				out.print(" "+top.get(i).n+",");
			}
			
			out.print(" "+top.get(i).n+".\n");
			
			
			
			
			
			
			
		}
		out.flush();

	}
	

}
*/