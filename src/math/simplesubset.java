package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class simplesubset {
	static ArrayList<Integer> primes;
	static int[] isComposite;
	
	static void sieve(int N)	// O(N log log N) 
	{
	    												
		isComposite = new int[N+1];					
		primes = new ArrayList<Integer>();
		
	    for (int i = 2; i <= N; ++i) 					
	    	if (isComposite[i] == 0) 					
	    	{
	    		primes.add(i);
	    		if(1l * i * i <= N)
	    			for (int j = i * i; j <= N; j += i)	
	    				isComposite[j] = 1;
	    	}   
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		sieve(10000002);
		int arr[]=new int[n];
		int count1=0;
		int numP1=-1;
	
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
			
			if(arr[i]==1)count1++;
			else{
				if(isComposite[arr[i]+1]==0)numP1=arr[i];
			}
		}
		
		
		
		int a1=-1,a2=-1;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(isComposite[arr[i]+arr[j]]==0&&(arr[i]!=1&&arr[j]!=1))
				{a1=arr[i];
				a2=arr[j];
					break;
				}
			}
		}
		
		String s1="";
		String s2="";
		
		
		
		int	lastlen=count1;
			
			for (int i = 0; i < count1-1; i++) {
				s1+=(1+" ");
			}
			if(count1>0)
			s1+=(1);
			if(numP1!=-1)
			{lastlen+=1;
			if(s1.length()>0)
				s1+=" "+numP1;
			else
				s1+=numP1;
			}
	
			
				
				if(a1!=-1&&a2!=-1&&lastlen<2)
				{lastlen=2;
					s2=(a1+" "+a2);
				}
				else
				{ if(lastlen<1)
				{lastlen=1;
					s2=arr[0]+"";}
				}
				
				
				out.println(lastlen);
				if(s1.length()>s2.length())
					{
					
					out.println(s1);
					
					}
				else{
					out.println(s2);
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
