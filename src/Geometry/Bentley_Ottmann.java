package Geometry;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeSet;
 
public class Bentley_Ottmann {
 
	static final double INF = 1e9, EPS = 1e-9;
 
	static Line sweep;
 
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
 
		PriorityQueue<X_Node> q=new PriorityQueue<X_Node>(); // The X_Structure
 
		TreeSet<LineSegment> set=new TreeSet<LineSegment>(); // The Y_Structure
 
		TreeSet<Point> ans=new TreeSet<Point>();
 
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			String s=br.readLine();
			String []sa=s.split(" ");
			double x1=Double.parseDouble(sa[0]);
			double y1=Double.parseDouble(sa[1]);
			double x2=Double.parseDouble(sa[2]);
			double y2=Double.parseDouble(sa[3]);
 
			Point p1=new Point(x1, y1),p2=new Point(x2, y2);
 
			if(x2<x1 || (x2==x1 && y2<y1)){
				p1=new Point(x2, y2);
				p2=new Point(x1, y1);
			}
 
			LineSegment ls=new LineSegment(p1,p2);
			q.add(new X_Node(ls, null, 1));
			q.add(new X_Node(ls, null, 2));
		}
 
		while(!q.isEmpty()){
 
 
			X_Node cur=q.poll();
			sweep=new Line(new Point(cur.x,0),new Point(cur.x, INF));
 System.out.println(cur.x+" "+cur.y);
			if(cur.type==1){
 
				set.add(cur.ls1);
 
 
				LineSegment successor=null;
				LineSegment predecessor=null;
				if(set.higher(cur.ls1)!=null)
					successor=set.higher(cur.ls1);
 
				if(set.lower(cur.ls1)!=null)
					predecessor=set.lower(cur.ls1);
 
 
				if(successor!=null && successor.intersect(cur.ls1)){
					q.add(new X_Node(successor, cur.ls1 , 3));
				}
 
				if(predecessor!=null && predecessor.intersect(cur.ls1)){
					q.add(new X_Node(cur.ls1, predecessor, 3));
				}
 
 
			}else
				if(cur.type==2){
 
					LineSegment successor=null;
					LineSegment predecessor=null;
					if(set.higher(cur.ls1)!=null)
						successor=set.higher(cur.ls1);
 
					if(set.lower(cur.ls1)!=null)
						predecessor=set.lower(cur.ls1);
 
 
					if(successor !=null && predecessor!=null && successor.intersect(predecessor)){
						Point p=new Line(successor.p, successor.q).intersect(new Line(predecessor.p, predecessor.q));
 
						if(p!=null && (p.x-cur.x>EPS || (p.x==cur.x && p.y>cur.y))){
							q.add(new X_Node(successor, predecessor, 3));
						}
 
					}
 
				}else{
 
					LineSegment successor=null;
					LineSegment predecessor=null;
					if(set.higher(cur.ls1)!=null)
						successor=set.higher(cur.ls1);
 
					if(set.lower(cur.ls2)!=null)
						predecessor=set.lower(cur.ls2);
 
 
					ans.add(new Point(cur.x,cur.y));
 
					set.remove(cur.ls1);
					set.remove(cur.ls2);
 
					sweep=new Line(new Point(cur.x+EPS,0),new Point(cur.x+EPS, INF));
 
					set.add(cur.ls1);
					set.add(cur.ls2);
 
 
					if(successor!=null && cur.ls2.intersect(successor)){
						Point p=new Line(successor.p, successor.q).intersect(new Line(cur.ls2.p, cur.ls2.q));
 
						if(p!=null && (p.x-cur.x>EPS || (p.x==cur.x && p.y>cur.y))){
 
							q.add(new X_Node(successor, cur.ls2, 3));
						}
 
					}
 
					if(predecessor!=null && cur.ls1.intersect(predecessor)){
						Point p=new Line(predecessor.p, predecessor.q).intersect(new Line(cur.ls1.p, cur.ls1.q));
 //System.out.println(p.x+"  -  "+p.y);
// System.out.println(predecessor+" **** "+cur.ls1);
						if(p!=null && (p.x-cur.x>EPS || (p.x==cur.x && p.y>cur.y))){
							q.add(new X_Node(cur.ls1,predecessor, 3));
						}
 
					}
 
 
 
				}
		///	System.out.println(q);
 
		}
 
 
		int cnt=ans.size();
		pw.println(cnt);
		for(int i=0;i<cnt;i++){
			Point p=ans.pollFirst();
			if(Math.abs(0-p.x)<.005)
				p.x=0;
			if(Math.abs(0-p.y)<.005)
				p.y=0;
 
			pw.printf("%.2f %.2f",p.x,p.y);
			if(i<cnt-1)
				pw.println();
		}
 
 
		pw.flush();
		pw.close();
	}
 
	static class X_Node implements Comparable<X_Node>{
		double x;
		double y;
		LineSegment ls1;
		LineSegment ls2; // NULL if it is not an intersection point
		int type;	// 1 --> start
					// 2 --> end
					// 3 --> intersection
		
		
@Override
public String toString() {
	//return x+"  "+y+ " type "+type+"--"+ls1+"---"+ls2;
	 return "Event:"+ "("+x+" "+y+")"+"  "+type;
}
		X_Node(LineSegment ls1,LineSegment ls2,int type){
			this.ls1=ls1;
			this.ls2=ls2;
			this.type=type;
 
			if(type==1){
				x=ls1.p.x;
				y=ls1.p.y;
			}else
				if(type==2){
					x=ls1.q.x;
					y=ls1.q.y;
				}else{
					Point p=new Line(ls1.p, ls1.q).intersect(new Line(ls2.p, ls2.q));
 
					x=p.x;
					y=p.y;
				}
		}
 
		public int compareTo(X_Node o) {
			if(this.x==o.x)
				return (this.y-o.y>0)? 1 : -1 ;
			return (this.x-o.x>0)? 1 : -1 ;
		}
 
	}
 
	static class Point implements Comparable<Point>{
		double x, y;                  
 
		Point(double a, double b) {
			x = a;
			y = b; 
		}
 
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
 
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
 
	}
 
	static class LineSegment implements Comparable<LineSegment>{
 
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
 
		public String toString(){
			return "("+p.x+","+p.y+") --> ("+q.x+","+q.y+")";
		}
 
		public int compareTo(LineSegment o) {
			Line l1=new Line(this.p, this.q);
			Line l2=new Line(o.p, o.q);
			double y1=this.p.y;
			if(!l1.parallel(sweep))
				y1=l1.intersect(sweep).y;
			double y2=o.p.y;
			if(!l2.parallel(sweep))
				y2=l2.intersect(sweep).y;
 
			if(Math.abs(y1-y2)<EPS)
				return 0;
			return (y1>y2)? 1 : -1;
		}
 
	}
 
	static class Line{
 
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
      //    System.out.println(x+" "+y);
			return new Point(x, y);
		}
		
 
	}
 
 
}