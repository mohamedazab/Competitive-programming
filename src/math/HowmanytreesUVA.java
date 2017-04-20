package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class HowmanytreesUVA {
	
	static BigInteger nCr4(int N, int K)		// O(K)
	{
		if(K > N)
			return new BigInteger("0");
		BigInteger res =new BigInteger("1");
		
		for(int i = 1; i <= K; ++i)
			res = (res.multiply(new BigInteger((N - K + i+"")))).divide( new BigInteger(i+""));
		return res;
	}
	
	public static BigInteger cat(int n){
		if(n==0)return new BigInteger("1");
		
		else
			{BigInteger x=nCr4(2*n,n);
			 return x.divide(new BigInteger(n+1+""));
			}
		
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
	while(sc.ready()){
		int n=sc.nextInt();
		out.println(cat(n));
		
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
