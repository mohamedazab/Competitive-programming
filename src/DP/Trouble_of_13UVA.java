package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Trouble_of_13UVA {

	static int Budget;
	static int items[][];
	static int n;
	static int mem[][];//n,p,f
	
	static int INF =(int)1e9;
	public static int  solve(int exp,int idx){
		
		if(exp>Budget+200) return -1*INF;
		if(idx==n){
			
			if(exp>Budget&&exp<=2000)
				return -1*INF;
				return 0;
		
		}
		if(mem[idx][exp]!=-1)return mem[idx][exp];
		int c1=solve(exp+items[idx][0], idx+1)+items[idx][1];
		int c2=solve(exp,idx+1);
		
		return mem[idx][exp]=Math.max( c1, c2);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		while(sc.ready()){
			Budget=sc.nextInt();
			n=sc.nextInt();
			
			items=new int[n][2];
			for (int i = 0; i < n; i++) {
				int price=sc.nextInt();
				int fav=sc.nextInt();
				items[i][0]=price;
				items[i][1]=fav;
				
			}
			
			mem=new int[n+1][10201];
			for (int i = 0; i < mem.length; i++) {
				
					Arrays.fill(mem[i], -1);
				
			}
			out.println(solve(0,0));
			
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
