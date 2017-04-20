package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;




public class bentlyot2 {

	static PriorityQueue<Event> EQ;//X
	static TreeMap<Point,LineSegment>PointsToSegments;
	static TreeSet<LineSegment>Y;
	static TreeSet<Point>ans;
	static TreeMap<Point,IntersLineSegment>intersectionSegments;
	static final double INF=1e9;
	static final double  EPS=1e-9;

	static class IntersLineSegment{

		LineSegment SegE1;LineSegment SegE2;
		public IntersLineSegment(LineSegment S1,LineSegment S2) {
			SegE1=S1;SegE2=S2;

		}



	}
	static class Event implements Comparable<Event>{
		Point p;int type;

		public Event(Point p,int t) {
			this.p=p;this.type=t;}	  


		@Override
		public int compareTo(Event o) {
			int x= (this.p).compareTo(o.p);
			if(x==0)return this.type-o.type;
			return x;
		}
		@Override
		public boolean equals(Object obj) {

			return this.compareTo((Event)obj)==0?true:false;
		}

		@Override
		public String toString() {
			return "Event:"+ p.toString()+"  "+type;
		}

	}









	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//LineSegment s1=new LineSegment(new Point(1, 0), new Point(-2, 8));
		//LineSegment s2=new LineSegment(new Point(-1,1), new Point(5, 5));
		//LineSegment s3=new LineSegment(new Point(5, 0), new Point(5, -5));
		//System.out.println(s1.intersect(s2));
		//System.out.println(s2.intersect(s3));
		//	System.out.println(s3.intersect(s1));

		int N=Integer.parseInt(br.readLine());
		PointsToSegments=new TreeMap<Point,LineSegment>();
		EQ=new PriorityQueue<>();
		ans=new TreeSet<Point>();
		Point pstart=new Point(-1*INF,INF);
		Point pend=new Point(-1*INF,-1*INF);
		intersectionSegments=new TreeMap<>();
		LineSegment Sweap= new LineSegment(pstart,pend);
		for (int i = 0; i < N; i++) {
			String nums[]=br.readLine().split(" ");
			int x1=Integer.parseInt(nums[0]);
			int y1=Integer.parseInt(nums[1]);
			int x2=Integer.parseInt(nums[2]);
			int y2=Integer.parseInt(nums[3]);
			Point start=new Point(x1,y1);
			Point end=new Point(x2,y2);
			Event E1;
			Event E2;
			if(x1<x2){
				E1=new Event(start, -1);//x1start
				E2=new Event(end, 1);
			}else
				if(x1>x2){
					E1=new Event(end, -1);
					E2=new Event(start, 1);
				}else{
					if(y1<y2)
					{E1=new Event(start, -1);
					E2=new Event(end, 1);
					}else
					{
						E1=new Event(end, -1);
						E2=new Event(start, 1);
					}

				}

			LineSegment x=new LineSegment(E1.p,E2.p);




			PointsToSegments.put(start, x);
			PointsToSegments.put(end, x);
			EQ.add(E1);
			EQ.add(E2);


		}


		class compareAccordingTo implements Comparator<LineSegment>{



			@Override
			public int compare(LineSegment l1, LineSegment l2) {


				double pl1=Math.min(l1.p.y, l1.q.y);
				if(l1.intersect(Sweap)!=null)
				{	 pl1=l1.intersect(Sweap).y;

				}
				double pl2=Math.min(l2.p.y, l2.q.y);
				if(l2.intersect(Sweap)!=null)
				{	 pl2=l2.intersect(Sweap).y;

				}



				return (pl1>pl2)? 1 :Math.abs(pl1-pl2)<EPS?0: -1;
			}

		}
		Y=new TreeSet<LineSegment>(new compareAccordingTo() ); 





		while(!EQ.isEmpty()){
			Event curr=EQ.peek();
			Point E=curr.p;
			Sweap.p.x=Sweap.q.x=E.x;
			if(curr.type==-1)//start
			{
				LineSegment segE=PointsToSegments.get(E);//////handle if intersection
				Y.add(segE);
				LineSegment segA;
				LineSegment segB;

				segA=Y.higher(segE); //succ
				segB=Y.lower(segE);//perdec
				Point inters1;
				if(segA!=null){
					Point pm=segA.intersect(segE);
					if(pm!=null){
						inters1=new Point(pm.x,pm.y);
						//System.out.println(inters1);
						Event i=new Event(inters1,0);
						IntersLineSegment x=new IntersLineSegment(segA, segE);
						intersectionSegments.put(i.p, x);
						EQ.add(i);
					}
				}

				if(segB!=null){
					Point pm=segB.intersect(segE);
					//	System.out.println(inters1);
					if(pm!=null){
						inters1=new Point(pm.x,pm.y);
						Event i=new Event(inters1,0);
						IntersLineSegment x=new IntersLineSegment(segB, segE);
						intersectionSegments.put(i.p, x);
						EQ.add(i);
					}
				}





			}
			if(curr.type==1)//end
			{
				LineSegment segE=PointsToSegments.get(E);//////handle if intersection
				LineSegment segA;
				LineSegment segB;
				segA=Y.higher(segE);
				segB=Y.lower(segE);
				Y.remove(segE);
				Point inters1;
				if(segA!=null&&segB!=null){
					Point pm=segA.intersect(segB);
					if(pm!=null){
						inters1=new Point(pm.x,pm.y);
						//	System.out.println(inters1);
						Event i=new Event(inters1,0);
						if((inters1.x-E.x>EPS||(inters1.x==E.x&&inters1.y>E.y))){
							IntersLineSegment x=new IntersLineSegment(segB, segA);
							intersectionSegments.put(i.p, x);
							EQ.add(i);
						}
					}
				}




			}
			if(curr.type==0)
			{

				ans.add(E);
				Point inters1;
				IntersLineSegment x=intersectionSegments.get(E);

				LineSegment segA=Y.higher(x.SegE1);//l-succ
				LineSegment segB=Y.lower(x.SegE1);//l--predc
				Y.remove(x.SegE1);
				Y.remove(x.SegE2);
				Sweap.p.x+=EPS;
				Sweap.q.x+=EPS;


				Point ps1=	Sweap.intersect(x.SegE1);
				Point ps2=	Sweap.intersect(x.SegE2);

				LineSegment segE1;//above after swap l2
				LineSegment segE2;//below after swap;l1
				if(ps1!=null&&ps2!=null&&ps1.y-ps2.y>=0){
					segE1=x.SegE1;
					segE2=x.SegE2;
				}else{
					if(ps1==null){
						if(ps2.y>E.y){
							segE1=x.SegE2;
							segE2=x.SegE1;
						}else
						{segE1=x.SegE1;
						segE2=x.SegE2;

						}

					}

					if(ps2==null){
						if(ps1.y>E.y){
							segE1=x.SegE1;
							segE2=x.SegE2;
						}else
						{segE1=x.SegE2;
						segE2=x.SegE1;

						}

					}
					segE1=x.SegE2;
					segE2=x.SegE1;
				}

				Y.add(segE1);
				Y.add(segE2);


				Sweap.p.x-=EPS;
				Sweap.q.x-=EPS;


				if(segE1!=null&&segA!=null){
					Point pm=segA.intersect(segE1);

					if(pm!=null){
						inters1=new Point(pm.x,pm.y);
						Event i=new Event(inters1,0);
						//System.out.println("in ************ "+inters1+"  "+EQ.contains(i)+" "+E);
						if((inters1.x-Sweap.p.x>=EPS||(inters1.x==E.x&&inters1.y>E.y))&&!EQ.contains(i)){
							IntersLineSegment m=new IntersLineSegment(segA, segE1);
							intersectionSegments.put(i.p, m);
							EQ.add(i);
						}	
					}

				}
				if(segE2!=null&&segB!=null){////s//u 
					Point pm=segB.intersect(segE2);

					//System.out.println(inters1+" "+E);
					//	System.out.println(segA+" /* "+segB+" */ "+segE1+" /* "+segE2);
					if(pm!=null){
						inters1=new Point(pm.x,pm.y);

						Event i=new Event(inters1,0);
						//System.out.println("in ------------ "+inters1+EQ.contains(i)+" "+E);
						if((inters1.x-Sweap.p.x>EPS||(inters1.x==E.x&&inters1.y>E.y))&&!EQ.contains(i))
						{IntersLineSegment m=new IntersLineSegment(segB, segE2);
						intersectionSegments.put(i.p, m);
						EQ.add(i);
						}
					}

				}


			}
			EQ.poll();
			//	System.out.println(EQ);
			//EQ.poll();
			//	System.out.println(Y);
			///	System.out.println(EQ.poll());
			///	System.out.println("******");
		}
		PrintWriter out=new PrintWriter(System.out);
		int c=ans.size();
		out.println(c);
		int i=1;
		for(Point t:ans)
		{
			DecimalFormat df = new DecimalFormat("####0.00");
			if(df.format(t.x).equals("-0.00"))
				t.x=0;
			if(df.format(t.y).equals("-0.00"))
				t.y=0;
			if(i<c)
			{
				out.printf("%.2f %.2f",t.x,t.y);
				out.println();
			}
			else
				out.printf("%.2f %.2f",t.x,t.y);

			i++;
		}



		out.flush();
		out.close();






	}


















	static class LineSegment   {

		Point p, q; 

		LineSegment(Point a, Point b) { p = a; q = b;if(a.x==b.x); }



		Point intersect(LineSegment ls)
		{
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
			if(l1.parallel(l2))
			{
				return null;
			}
			Point c = l1.intersect(l2);
			return c.between(p, q) && c.between(ls.p, ls.q)?c:null;

		}







		public String toString(){
			return p.toString()+" and "+q.toString();
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



	}

	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		double x, y;//end1 ,beg=-1,inters =0   


		Point(double a, double b) { x = a; y = b;

		}
		Point(double a, double b,int t,LineSegment L1,LineSegment L2) { x = a; y = b;

		{
		}  
		}

		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;

			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}

		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }

		static double sq(double x) { return x * x; }



		boolean between(Point p, Point q)
		{//System.out.println(Math.max(p.y, q.y)+" "+Math.min(p.y, q.y)	+ "   hi");
			return x <= Math.max(p.x, q.x) + EPS && x + EPS >= Math.min(p.x, q.x)
					&& y <= Math.max(p.y, q.y) + EPS && y + EPS >= Math.min(p.y, q.y);
		}

		public String toString(){
			return " ("+x+" "+y+")";
		}

	}
}
