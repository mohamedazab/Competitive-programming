package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxsubseqProduct {

	
	
	static int n;
	static int nums[];
	static BigInteger save[];
	
	static BigInteger solve(int idx, BigInteger sofar){ 
		
		if(idx==n)return sofar;
		
		if(!save[idx].equals(new BigInteger(-99999999+"")))
		{//System.out.println(Arrays.toString(save));
		//	return save[idx];
		}
		
			
		
		int ans=nums[idx];
		BigInteger ans2=new BigInteger(ans+"");
		BigInteger meTlast=sofar.multiply(ans2);
		if(idx==0){
			meTlast=ans2;
			sofar=ans2;
		}
		BigInteger rec=solve(idx+1,meTlast);
		BigInteger r2=solve(idx+1,ans2);
		if(rec.compareTo(r2)<0)rec=r2;
	/*	System.out.println(idx+"***************");
		System.out.println("meTlast "+meTlast.toString());
		System.out.println("ans2 "+ans2.toString());
		System.out.println("rec "+rec.toString());
		System.out.println("sofar "+sofar.toString());
		System.out.println("************");*/
		if(sofar.compareTo(ans2)>=0&&sofar.compareTo(meTlast)>=0&&sofar.compareTo(rec)>=0)
			return save[idx]=sofar;
		
		if(ans2.compareTo(sofar)>=0&&ans2.compareTo(meTlast)>=0&&ans2.compareTo(rec)>=0)
			return save[idx]=ans2;
			
		if(rec.compareTo(ans2)>0&&rec.compareTo(meTlast)>0&&rec.compareTo(sofar)>0)
			return save[idx]= rec;
		return save[idx]=meTlast;
		}
		
		
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{

		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int tc=sc.nextInt();
		while(tc-->0){
			 nums=new int[100];
			 save=new BigInteger[101];
			 Arrays.fill(save, new BigInteger(-99999999+""));
			for (int i = 0; i < nums.length; i++) {
			int x=sc.nextInt();
			if(x==-999999)
			{n=i;
				break;
			}
				nums[i]=x;
			}			
			out.println(solve(0,new BigInteger("0")));
			
			
		}
		out.flush();
		out.close();
		
		
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
