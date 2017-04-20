package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TrainsortingUVA {

	
	
	static int n;
	static int nums[];
	static int memL[][];
	static int memD[][];
	
	static int LIS(int i,int prevIDX){ //return length of LIS;//
		//prev can be number for better complexity 
		
		if(i==n)return 0;
		
		if(memL[i][prevIDX]!=-1)return memL[i][prevIDX];
		
		int c1=LIS(i+1, prevIDX);//LEAVE
		
		int c2=0;
		if(prevIDX==n||nums[i]>=nums[prevIDX])
			c2=LIS(i+1, i)+1;
		
		return memL[i][prevIDX]=Math.max(c1, c2);
		
	}
	static int LDS(int i,int prevIDX){ //return length of LIS;//
		//prev can be number for better complexity 
		
		if(i==n)return 0;
		
		if(memD[i][prevIDX]!=-1)return memD[i][prevIDX];
		
		int c1=LDS(i+1, prevIDX);//LEAVE
		
		int c2=0;
		if(prevIDX==n||nums[i]<=nums[prevIDX])
			c2=LDS(i+1, i)+1;
		
		return memD[i][prevIDX]=Math.max(c1, c2);
		
	}
	
	static int solve(){ //return length of LIS;//
		//prev can be number for better complexity 
		int ans=0;
		for (int j = 0; j < n; j++) {
			ans=Math.max(ans, LIS(j,j)+LDS(j,j)-1);
		}
		return ans;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{

		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int tc=sc.nextInt();
		while(tc-->0){
			  n=sc.nextInt();
			nums=new int[n];
		
			memL=new int[n+1][n+1];
			memD=new int[n+1][n+1];
			for (int i = 0; i < memL.length; i++) {
				Arrays.fill(memL[i], -1);
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i]=sc.nextInt();
			}
			
			int t1=LIS(0, n);
			for (int i = 0; i < memD.length; i++) {
				Arrays.fill(memD[i], -1);
			}
			int t2=LDS(0,n);
			
			
			
			
			
			out.println(solve());
			
			
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
