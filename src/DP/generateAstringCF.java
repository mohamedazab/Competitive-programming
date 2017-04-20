package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class generateAstringCF {

	static int num;
	static long insdel;
	static long copy;
	static long mem[];
	public static long solve(int rem){
		if(rem==0)return 0 ;
		if(rem<0)
			return Math.abs(rem)*insdel;
		if(mem[rem]!=-1)return mem[rem];
		int inside=num-rem;
		long ret=Math.min(solve(rem-1)+insdel,solve(rem-inside)+copy);
	//	System.out.println(rem+inside+"   rem  "+rem+"    num  "+num+"  ret  "+ret);
		return mem[rem]=ret;
	
		
	}
	public static void main(String[] args) throws IOException {
Scanner sc=new Scanner(System.in);
 num=sc.nextInt();
 insdel=sc.nextInt();
 copy=sc.nextInt();
 mem=new long[num+1];
 Arrays.fill(mem, -1);
 System.out.println(insdel+solve(num-1));
 

		
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


