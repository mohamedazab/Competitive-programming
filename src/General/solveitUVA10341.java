package General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solveitUVA10341 {

	static double p, q, r, s, t, u;
	static final double  EPS = 1e-9;
	public static double app(double x){
		
		return p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*x*x+u;
		
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out); 
		Scanner sc = new Scanner(System.in);
		while(sc.ready()){
		String rm[]=sc.nextLine().split(" ");
		 p=Double.parseDouble(rm[0]);
		 q=Double.parseDouble(rm[1]);
		 r=Double.parseDouble(rm[2]);
		 s=Double.parseDouble(rm[3]);
		 t=Double.parseDouble(rm[4]);
		 u=Double.parseDouble(rm[5]);
		 double low=0; double h=1;
		 if(app(h)*app(low)>0)
			 out.println("No solution");
		 else{
			 double mid=0;
		 while(low+EPS<h){
			  mid=(low+h)/2;
			 double fmid=app(mid);
			 double flow=app(low);
			 if(fmid*flow<=0)
				 h=mid;
			 else
				 low=mid;
			 
			 
			 
		 }
		 out.printf("%.4f\n", mid);
		 }
		}
		 out.flush();
		

	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

	
}
