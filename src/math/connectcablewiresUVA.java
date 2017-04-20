package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class connectcablewiresUVA {
static BigInteger fib[];
	
	static BigInteger fibonacci(int n) 		//O(log n)
	{
		if (n == 0)
			return  new BigInteger("0");
		if (n <= 2)
			return new BigInteger("1");
		if (fib[n]!=null)
			return fib[n];
		
		int k = n >> 1;
		BigInteger a = fibonacci(k), b = fibonacci(k+1);
		
		if (n%2 == 0)
			{return fib[n] = new BigInteger(a.multiply(b.multiply(new BigInteger(2+"")).subtract(a)).toString());
			
			
			}
		return  fib[n] = new BigInteger(b.multiply(b).add(a.multiply(a)).toString());
	}	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
		
		while(true){
			
			int n=sc.nextInt();
			if(n==0)break;
			fib=new BigInteger[2*n+2];
			out.println(fibonacci(2*n));
			
			
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
