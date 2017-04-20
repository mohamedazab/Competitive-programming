package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class pebbleSolitaire {

	
	static int n;
	static int mem[];
	
	
	static int solve(int msk){
		if(mem[msk]!=-1)return mem[msk];
		
		int r=0;
		for (int i = 0; i < 10; i++) {
			if((msk&(1<<i))==(1<<i)&&(msk&(1<<(1+i)))==(1<<(1+i))&&(msk&(1<<i+2))!=(1<<i+2)){
				int tmask=msk;
				tmask&=~(1<<i);
				tmask&=~(1<<(i+1));
				tmask|=(1<<i+2);
				r=Math.max(r, 1+solve(tmask));
			}
			
			if((msk&(1<<i))!=(1<<i)&&(msk&(1<<(1+i)))==(1<<(1+i))&&((msk&(1<<i+2))==(1<<i+2))){
				int tmask=msk;
				tmask&=~(1<<(i+2));
				tmask&=~(1<<(i+1));
				tmask|=(1<<i);
				r=Math.max(r,1+ solve(tmask));
			}
				
		}
		
		return mem[msk]=r;
	}
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner sc=new Scanner(System.in);
		
		 int q=sc.nextInt();
		 while(q-->0){
		int	msk=0;
		String s=sc.nextLine();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='o'){
				msk|=(1<<i);
				
			}
		}
		mem=new int[1<<12];
		Arrays.fill(mem, -1);
		int ans=solve(msk);
		System.out.println(Integer.bitCount(msk)-ans);
		
	}
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
