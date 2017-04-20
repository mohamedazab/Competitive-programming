package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class UVAGaurdtheland {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		int n=Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) 
			
		{
			String r[]=br.readLine().split(" ");
			int x=Integer.parseInt(r[0]);
			int y=Integer.parseInt(r[1]);
	
			int xc=Integer.parseInt(r[2]);
			int yc=Integer.parseInt(r[3]);
			
			Rectangle rect1=new Rectangle(new Point(x,y),new Point(xc,yc));
			
			 r=br.readLine().split(" ");
			int xl=Integer.parseInt(r[0]);
			int yl=Integer.parseInt(r[1]);
	
			int xm=Integer.parseInt(r[2]);
			int ym=Integer.parseInt(r[3]);
			Rectangle rect2=new Rectangle(new Point(xl,yl),new Point(xm,ym));
			int st,weak,not;
			Rectangle intrs=rect1.intersect(rect2);
			if(intrs==null){
				st=0;
				weak=(int) (rect1.area()+rect2.area());
				not=100*100-weak;
				
			}else
			{st=(int)intrs.area();
			weak=(int) ((int)rect1.area()+rect2.area()-2*st);
			not=(int)100*100-st-weak;
				
			}
			out.printf("Night %d: %d %d %d\n",i,st,weak,not);
			
			
		
					
	

	}
		out.flush();

}
	
	 static class Rectangle {

			static final double EPS = 1e-9;
			
			Point ll, ur;

			Rectangle(Point a, Point b) { ll = a; ur = b; }

			double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

			boolean contains(Point p)
			{
				return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
			}

			Rectangle intersect(Rectangle r)
			{
				Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
				Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
				if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
					return new Rectangle(ll, ur);
				return null;
			}

		}
	static class Line {

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
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}
				
	}
	 static class LineSegment {

		Point p, q;
		
		LineSegment(Point a, Point b) { p = a; q = b; }
		

		boolean intersect(LineSegment ls)
		{
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
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
	
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		public String toString(){
			return x+"  "+y;
		}
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
		

	class Rectangle {

		static final double EPS = 1e-9;
		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

		boolean contains(Point p)
		{
			return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
		}

		Rectangle intersect(Rectangle r)
		{
			Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
			Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
			if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
				return new Rectangle(ll, ur);
			return null;
		}

	}
	}
	

}
