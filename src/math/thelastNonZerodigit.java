package math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class thelastNonZerodigit{

	
	
	static ArrayList<Integer> primes;
	static int[] isComposite;
	static class pair{
		int p1,p2;
		public pair(int pa,int pb) {
p1=pa;p2=pb;
		}
		
	}
	
	static ArrayList<pair>primepairs;
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
	    
	    primepairs=new ArrayList<pair>(); 
	    
	    for (int i = 0; i < primes.size()-1; i++) {
			if(primes.get(i)+2==primes.get(i+1)){
				primepairs.add(new pair(primes.get(i),primes.get(i+1)));
				
			}
		}
	    
	    
	    
	    
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
 sieve(20000000);
		while(sc.ready()){
		int n1=sc.nextInt();
	pair p=primepairs.get(n1-1);
	out.printf("(%d, %d)\n",p.p1,p.p2);
		
		
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
