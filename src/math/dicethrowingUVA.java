package math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class dicethrowingUVA{

	static int x;
	static long[][]mem;
	static long solve(int n ,int xsofar){
			
		if(n==0){
			if(xsofar<x)return 0;
			else
				return 1;
		}
		if(mem[n][xsofar]!=-1)return mem[n][xsofar]; 
		long ans=0;
		for (int i = 1; i <= 6; i++) {
			ans+=solve(n-1, xsofar+i);
		}
	//	System.out.println(ans);
		return mem[n][xsofar]=ans;
		
		
		
		
	}
	
	static long gcd(long n, long m) {
		return m == 0 ? n : gcd(m, n % m);
	}
	

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
   
    while (true){
 
    int n=sc.nextInt();
     x=sc.nextInt();
     if(n==0&&x==0)break;
      mem=new long[25][151];
    for (int i = 0; i < mem.length; i++) {
		Arrays.fill(mem[i],-1);
	}
     
    long a1=solve(n, 0);
    long a2=(long) Math.pow(6, n);
    long a3=gcd(a1, a2);
 
   // out.println(a1+"/"+a2);
 
    a1/=a3;a2/=a3;
   if(a1==a2)out.println(1);
   else
	   if(a1==0)out.println(0);
	   else
    out.println(a1+"/"+a2);
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