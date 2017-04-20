package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dollarsUVaCoinChange {

	
	static final int[]coins={5,10,20,50,100,200,500,1000,2000,5000,10000};
	static int mem[][];
	public static int solve(int idx,int rem){
		int tmp=rem;
		if(rem==0)return 1;
		
		if(rem<0||idx==coins.length)
			return 0;
		if(mem[idx][rem]!=-1)return mem[idx][rem];
		int ret=solve(idx+1,rem);
		/*while(rem>0){
			ret+=solve(idx+1,rem-coins[idx]);
			rem-=coins[idx];
			
		}*/
		//or
		ret=solve(idx+1,rem)+solve(idx,rem-coins[idx]);
		
		return mem[idx][tmp]=ret;
	
		
	}
	public static void main(String[] args) throws IOException {
Scanner sc=new Scanner(System.in);
 double n=sc.nextDouble();
 int x=(int) (n*100);
 mem=new int[11][30001];
 for (int i = 0; i < mem.length; i++) {
	Arrays.fill(mem[i], -1);
}
 System.out.println(solve(0,x));

		
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


