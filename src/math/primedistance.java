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

public class primedistance{

	
	
	static ArrayList<Integer> primes;
	static int[] isComposite;

	
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
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
 sieve( (int)Math.sqrt(2147483647));
 int tc=sc.nextInt();
		while(tc-->0){
	int l=sc.nextInt();
	int u=sc.nextInt();
	int min1,min2,d1=(int)1e9;
	int max1,max2,d2=-1;
	int cnt=0;
	for (int i = 0; i < primes.size()-1; i++) {
		if(primes.get(i)>=l&&primes.get(i)<=u){
			int a=primes.get(i);
			if(primes.get(i+1)>=l&&primes.get(i+1)<=u){
				
				
			}
			
			
		}
	}
	
	
	out.println("There are no adjacent primes.");
	
	///	out.printf("%d,%d are closest, %d,%d are most distant.",min1,min2,max1,max2);
	
		tc--;
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