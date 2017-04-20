package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CFAntonandLines {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		int n=Integer.parseInt(br.readLine());
		
		String r[]=br.readLine().split(" ");
		int xr=Integer.parseInt(r[0]);
		int xe=Integer.parseInt(r[1]);
		Line arr[]=new Line[n];
		for (int i = 0; i < n; i++) 
			
		{
			 r=br.readLine().split(" ");
			int m=Integer.parseInt(r[0]);
			int k=Integer.parseInt(r[1]);
			arr[i]=new Line(m,k,xr,xe);
			
		
		}
		Arrays.sort(arr);
boolean yes=false;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].yes>0)
			{yes=true;
				
			}
		}
		if(yes)
			out.println("YES");
		else
			out.println("NO");
		out.flush();
		
	}
	static class Line implements Comparable <Line> {

		static final double INF = 1e9, EPS = 1e-9;
		
		double a, b, c; double xe,xs;int yes;
		
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
		Line(double m,double yinterc,double xs,double xe ) { a = -m; b = 1; c = -yinterc;this.xe=xe;this.xs=xs;yes=0; } 
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
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}

		@Override
		public int compareTo(Line m) {
			
			Point p=this.intersect(m);
			//System.out.println(p.x+"  "+p.y);
			if(p!=null)
				if(p.x<xe&&p.y>xs)
				{
					yes++;
					m.yes++;
					return -1;
					
				}else					
			return 0;
			return 1;
			
		}
				
	}
static 	class Point implements Comparable<Point>{

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
		
		Point rotate(double angle)
		{
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
		
		
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		
		//returns true if it is on the line defined by a and b
		
		
		
		
		
		
		
		
	}















}
