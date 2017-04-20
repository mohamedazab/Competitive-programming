package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import Geometry.UVA478.Circle;
import Geometry.UVA478.Polygon;
import Geometry.UVA478.Rectangle;


public class UVA478 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		 ArrayList<Circle> cir=new ArrayList<Circle>();
		 ArrayList<Rectangle> rect=new ArrayList<Rectangle>();
		 ArrayList<Polygon> tri=new ArrayList<Polygon>();
		 int fig=0;
		 while(true){
			 String m=br.readLine();
			 if(m.equals("*"))
			 break;
			 String []r=m.split(" ");
			 String c=r[0];
			 switch(c){
			 case "r":
				 String in[]=br.readLine().split(" ");
				 double x=Double.parseDouble(in[0]);
				 double y=Double.parseDouble(in[1]);
				 double a=Double.parseDouble(in[2]);
				 double b=Double.parseDouble(in[3]);
				 Point xy=new Point(x,y);
				 Point ab=new Point(a,b); 
				 rect.add(new Rectangle(xy,ab,++fig));
				 break;
			 case "t":
				 String inet[]=br.readLine().split(" ");
				 double xa=Double.parseDouble(inet[0]);
				 double ya=Double.parseDouble(inet[1]);
				 double xb=Double.parseDouble(inet[2]);
				 double yb=Double.parseDouble(inet[3]);
				 double xc=Double.parseDouble(inet[4]);
				 double yc= Double.parseDouble(inet[5]);
				 Point xa1=new Point(xa,ya);
				 Point xb1=new Point(xb,yb);
				 Point xc1=new Point(xc,yc);
				 	Point am[]={xa1,xb1,xc1};			 
				 tri.add(new Polygon(am,++fig));
				 break;
				 
			 case "c":
				 String ineet[]=br.readLine().split(" ");
				 double xce=Double.parseDouble(ineet[0]);
				 double yce=Double.parseDouble(ineet[1]);
				 double rad=Double.parseDouble(ineet[2]);
				 Point cent1=new Point(xce,yce);
				 cir.add(new Circle(cent1,rad,++fig));
				 
				 
				 
			 
			 }
			 
		 }
		
		 int count=0;
		 while(true){
			
			 String ineet[]=br.readLine().split(" ");
			if(ineet[0].equals("9999.9")&&ineet[1].equals("9999.9"))
				break;
			 double xce=Double.parseDouble(ineet[0]);
			 double yce=Double.parseDouble(ineet[1]);
			 
			 Point cent1=new Point(xce,yce);
			for (int i = 0; i < cir.size(); i++) {
				if(cir.get(i).inside(cent1)!=-1)
					out.printf("");
					
			} 
			
			 
		 }
		 
		 
		out.flush();
	}
	
static	class Rectangle {

		static final double EPS = 1e-9;
		int num;
		Point ll, ur;

		Rectangle(Point a, Point b,int n) { ll = a; ur = b;num=n; }

		double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

		boolean contains(Point p)
		{
			return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
		}

		
	}
	static class Circle { 	//equation: (x-c.x)^2 + (y-c.y)^2 = r^2

		static final double EPS = 1e-9;
		int num;
		Point c;
		double r;

		Circle(Point p, double k,int n) { c = p; r = k;num=n; }

		int inside(Point p)	//1 for inside, 0 for border, -1 for outside
		{
			double d = p.dist(c);

			return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
		}

		double circum()	{ return 2 * Math.PI * r; }

		double area() { return Math.PI * r * r; }



		

	}
	static class Triangle {

		static final double EPS = 1e-9;
		int num;
		
		Point a, b, c;
		double ab, bc, ca;

		Triangle(Point p, Point q, Point r,int n)	//counter clockwise
		{num=n;
			a = p;
			if(Point.ccw(p, q, r)) { b = q; c = r; }
			else { b = r; c = q; }

			ab = a.dist(b); bc = b.dist(c); ca = c.dist(a);
		}

		double perm()
		{
			return ab + bc + ca;
		}

		double area()
		{
			double s = (ab + bc + ca) / 2.0;
			return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));		//take care of overflow
		}

		double area2() 
		{  return Math.abs(a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x) / 2.0; }
		/*
		 * 1. We take the absolute value because the result could be negative which means that point q is on
		 *    the left of the line segment pr
		 * 
		 * 2. If the area is zero, then the three points are collinear
		 */

		double area3()
		{
			return 0.5 * ((c.y - a.y) * (b.x - a.x) - (b.y - a.y) * (c.x - a.x));
		}

		double rInCircle()
		{
			return area() / (perm() * 0.5);
		}

		Point inCenter()				//intersection of the angle bisectors, center of inscribed circle
		{
			double p = perm();
			double x = (a.x * bc + b.x * ca + c.x * ab) / p;
			double y = (a.y * bc + b.y * ca + c.y * ab) / p;
			return new Point(x, y);
		}

		double rCircumCircle()
		{
			return ab * bc * ca / (4.0 * area());
		}

		Point circumCircle() 
		{
			double bax = b.x - a.x, bay = b.y - a.y;
			double cax = c.x - a.x, cay = c.y - a.y;

			double e = bax * (a.x + b.x) + bay * (a.y + b.y);
			double f = cax * (a.x + c.x) + cay * (a.y + c.y);
			double g = 2.0 * (bax * (c.y - b.y) - bay * (c.x - b.x));

			if (Math.abs(g) < EPS) return null;

			return new Point((cay*e - bay*f) / g, (bax*f - cax*e) / g);

		}

		static double areaMedians(double ma, double mb, double mc)		//medians of the triangle
		{
			double s = (ma + mb + mc) / 2.0;							//max(ma, mb, mc) < s
			return Math.sqrt(s * (s - ma) * (s - mb) * (s - mc)) * 4.0 / 3.0;
		}

		static double areaHeights(double ha, double hb, double hc)		//heights of the triangle
		{
			double ha_1 = 1.0 / ha, hb_1 = 1.0 / hb, hc_1 = 1.0 / hc;
			double s = (ha_1 + hb_1 + hc_1) / 2.0;
			return 1.0 / (Math.sqrt(s * (s - ha_1) * (s - hb_1) * (s - hc_1)) * 4.0);
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
static class Polygon { 
	// Cases to handle: collinear points, polygons with n < 3
int num;
	static final double EPS = 1e-9;
	
	Point[] g; 			//first point = last point, counter-clockwise representation
	
	
	

	
	Polygon(Point[] o,int n) {num=n; g = o; }

	double perimeter()
	{
		double sum = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
			sum += g[i].dist(g[i+1]);
		return sum;
	}
	
	double area() 		//clockwise/anti-clockwise check, for convex/concave polygons
	{
		double area = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
			area += g[i].x * g[i+1].y - g[i].y * g[i+1].x;
		return Math.abs(area) / 2.0;			//negative value in case of clockwise
	}

	boolean isConvex()
	{
		if(g.length <= 3) // point or line
			return false;
		boolean ccw = Point.ccw(g[g.length - 2], g[0], g[1]);		//edit ccw check to accept collinear points
		for(int i = 1; i < g.length - 1; ++i)
			if(Point.ccw(g[i-1], g[i], g[i+1]) != ccw)
				return false;
		return true;
	}
	
	boolean inside(Point p)	//for convex/concave polygons - winding number algorithm 
	{
		double sum = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
		{
			double angle = Point.angle(g[i], p, g[i+1]);
			if((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && p.between(g[i], g[i+1]))
				return true;
			if(Point.ccw(p, g[i], g[i+1]))
				sum += angle;
			else
				sum -= angle;
		}

		return Math.abs(2 * Math.PI - Math.abs(sum)) < EPS;		//abs makes it work for clockwise
	}
	/*
	 * Another way if the polygon is convex
	 * 1. Triangulate the poylgon through p
	 * 2. Check if sum areas == poygon area
	 * 3. Handle empty polygon
	 */
	
	

	Point centroid()		//center of mass
	{
		double cx = 0.0, cy = 0.0;
		for(int i = 0; i < g.length - 1; i++)
		{
			double x1 = g[i].x, y1 = g[i].y;
			double x2 = g[i+1].x, y2 = g[i+1].y;

			double f = x1 * y2 - x2 * y1;
			cx += (x1 + x2) * f;
			cy += (y1 + y2) * f;
		}
		double area = area();		//remove abs
		cx /= 6.0 * area;
		cy /= 6.0 * area;
		return new Point(cx, cy);
	}
}


static class Vector {

	double x, y; 

	Vector(double a, double b) { x = a; y = b; }

	Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

	Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

	double dot(Vector v) { return (x * v.x + y * v.y); }

	double cross(Vector v) { return x * v.y - y * v.x; }

	double norm2() { return x * x + y * y; }

	Vector reverse() { return new Vector(-x, -y); }

	Vector normalize() 
	{ 
		double d = Math.sqrt(norm2());
		return scale(1 / d);
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
	
	Point rotate(double theta, Point p)			//rotate around p
	{
		Vector v = new Vector(p, new Point(0, 0));
		return translate(v).rotate(theta).translate(v.reverse());
	}
	
	Point translate(Vector v) { return new Point(x + v.x , y + v.y); }
	
	Point reflectionPoint(Line l) 	//reflection point of p on line l
	{
		Point p = l.closestPoint(this);
		Vector v = new Vector(this, p);
		return this.translate(v).translate(v);
	}
	
	boolean between(Point p, Point q)
	{
		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
	}
	
	//returns true if it is on the line defined by a and b
	boolean onLine(Point a, Point b) 
	{
		if(a.compareTo(b) == 0) return compareTo(a) == 0;
		return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
	}
	
	boolean onSegment(Point a, Point b)
	{
		if(a.compareTo(b) == 0) return compareTo(a) == 0;
		return onRay(a, b) && onRay(b, a);
	}
	
	//returns true if it is on the ray whose start point is a and passes through b
	boolean onRay(Point a, Point b)
	{
		if(a.compareTo(b) == 0) return compareTo(a) == 0;
		return new Vector(a, b).normalize().equals(new Vector(a, this).normalize());
	}
	
	// returns true if it is on the left side of Line pq
	// add EPS to LHS if on-line points are accepted
	static boolean ccw(Point p, Point q, Point r)
	{
		return new Vector(p, q).cross(new Vector(p, r)) > 0;
	}
	
	static boolean collinear(Point p, Point q, Point r)
	{
		return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
	}
	
	static double angle(Point a, Point o, Point b)  // angle AOB
	{
		Vector oa = new Vector(o, a), ob = new Vector(o, b);
		return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
	}
	
	static double distToLine(Point p, Point a, Point b) //distance between point p and a line defined by points a, b (a != b)
	{
		if(a.compareTo(b) == 0) p.dist(a);
		// formula: c = a + u * ab
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		Point c = a.translate(ab.scale(u)); 
		return p.dist(c);
	}
	// Another way: find closest point and calculate the distance between it and p

	static double distToLineSegment(Point p, Point a, Point b) 
	{
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		if (u < 0.0) return p.dist(a);
		if (u > 1.0) return p.dist(b);        
		return distToLine(p, a, b); 
	}
	// Another way: find closest point and calculate the distance between it and p
}




}
