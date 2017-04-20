package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class jumpingchampion {
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
		sieve(1000001);
		int n=sc.nextInt();
		while(n-->0){
	TreeMap <Integer,Integer> fr=new TreeMap<Integer, Integer>();
	int maxn=-1;int maxd=-1;
		int l=sc.nextInt();
		int h=sc.nextInt();
		int il=primes.indexOf(l);int ih=primes.indexOf(h);
	if(il==-1){
	int i=0;
	if(l<2)l=2;
		for ( i = l; i < 1000001; i++) {
		if(isComposite[i]==0){
			break;
		}
	
	}
	il=primes.indexOf(i);
	}
	if(ih==-1){
		int i=0;
		for ( i = h; i>=2; i--) {
		if(isComposite[i]==0){
			break;
		}
		
	}
		ih=primes.indexOf(i);
		}
	
//	System.out.println(il+"    "+ih);
		for (int i = il; i <ih ; i++) {
			
			int diff=primes.get(i+1)-primes.get(i);
			//System.out.println(primes.get(i+1)+"  "+primes.get(i)+" = "+diff);
			if(fr.containsKey(diff)){
				fr.replace(diff, fr.get(diff)+1);
				
				if(maxn<fr.get(diff)){maxn=fr.get(diff);
				if(diff!=maxd)
				{
				maxd=diff;}
				}
					
			}else
			{
				
				fr.put(diff, 1);
				if(maxn<1)maxn=1;
				if(maxd<1){
					maxd=diff;
					}
				}
				
				
			}
		
	//System.out.println(fr.toString());
		//System.out.println(maxd+"    "+maxdif2+" "+maxn);
		if(fr.size()<1)
		{out.println("No jumping champion");
			
		}else{
			boolean m1=fr.containsValue(maxn);
			fr.remove(maxd);
			boolean m2=fr.containsValue(maxn);
			if(m2)
				out.println("No jumping champion");
			else
		out.printf("The jumping champion is %d\n",maxd );
			
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



