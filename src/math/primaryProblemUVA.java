package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class primaryProblemUVA {

	
	
	static ArrayList<Integer> primes;
	static int[] isComposite;
	static boolean isPrime(int N)
	{
		if(N < isComposite.length)
			return isComposite[N] == 0;
		for(int p: primes)					//may stop if p * p > N
			if(N%p==0)
				return false;
		return true;
	}
	static void sieve(int N)	// O(N log log N) 
	{
	    												
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
		primes = new ArrayList<Integer>();
		
	    for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
	    	if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
	    	{
	    		primes.add(i);
	    		if(1l * i * i <= N)
	    			for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
	    				isComposite[j] = 1;
	    	}   
	}
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
		sieve(1000000);
		
		
	while(true){
		int n=sc.nextInt();
		
		if(n==0){
			break;
		}
		int index1=0;boolean y=false;
		for (int i = 0; i < primes.size(); i++) {
			
			if(primes.get(i)>n)
			{break;
				
				}
			if(isComposite[n-primes.get(i)]==0){
				index1=primes.get(i);y=true;break;
				
				
			}
				
			}
			
		
		
		
		if(y)
		out.printf("%d:\n%d+%d\n",n,index1,n-index1);
		else
			out.printf("%d:\nNO WAY!\n",n);
		
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
