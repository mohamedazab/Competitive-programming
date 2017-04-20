package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class wateringflowersCF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
		String r[]=br.readLine().split(" ");
		int n=Integer.parseInt(r[0]);
		Point c1=new Point(Integer.parseInt(r[1]),Integer.parseInt(r[2]));
		Point c2=new Point(Integer.parseInt(r[3]),Integer.parseInt(r[4]));
		Point arr[]=new Point[n];
		long r1=0; long r2=0;
		for (int i = 0; i < n; i++) {
			String rm[]=br.readLine().split(" ");
			Point p1=new Point(Integer.parseInt(rm[0]),Integer.parseInt(rm[1]));
			arr[i]=p1;
			
			
				
			
		}
		
		long max=Long.MAX_VALUE;
		//System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			r1=arr[i].dist2(c1);
			r2=0;
		//	System.out.println(r1);
			for (int j = 0; j < arr.length; j++) {
				if(arr[j].dist2(c1)>r1&&arr[j].dist2(c2)>r2)
					{
					r2=arr[j].dist2(c2);
					}
			}
			
			
		//	System.out.println(r1+"   "+r2+"   "+(r1+r2));
			if(max>r1+r2)
				max=r1+r2;
		}
		for (int i = 0; i < arr.length; i++) {
			r2=arr[i].dist2(c2);
			r1=0;
			//System.out.println(r2);
			for (int j = 0; j < arr.length; j++) {
				if(arr[j].dist2(c2)>r2&&arr[j].dist2(c1)>r1)
					{
					r1=arr[j].dist2(c1);
					}
			}
			
			
		//	System.out.println(r1+"   "+r2+"   "+(r1+r2));
			if(max>r1+r2)
				max=r1+r2;
		}
		
		
		out.println(max);
		
		
		out.flush();
		

	}
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		long x, y;                  

		Point(long a, long b) { x = a; y = b; }  
		
		public String toString(){
			return x+"  "+y;
		}
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public long dist2(Point p) { return sq(x - p.x) + sq(y - p.y); }
		
		static long sq(long x) { return x * x; }
		
		
		
		
		
		
		
	}




}
