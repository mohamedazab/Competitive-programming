package DP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange {

	static int n,m,coins[];
	static long mem[][];
	public static long solve(int rem,int idx){
		
		if(rem==0)return 1;
		if(idx==m||rem<coins[idx])return 0;
		if(mem[rem][idx]!=-1)return mem[rem][idx];
		
		
		return mem[rem][idx]=solve(rem, idx+1)+solve(rem-coins[idx], idx);
		
		
		
		
	}


	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		 n=sc.nextInt();
		 m=sc.nextInt();
		coins=new int[m];
		for (int i = 0; i < coins.length; i++) {
			coins[i]=sc.nextInt();
		}
		Arrays.sort(coins);
		mem=new long[n+1][m+1];
		for(long[]x:mem)Arrays.fill(x, -1);
		out.println(solve(n, 0));
		out.flush();
	
	
	
	
	
	
	
	}
	
	

static class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
	public Scanner(File x) throws FileNotFoundException{	br = new BufferedReader(new FileReader(x));}

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
