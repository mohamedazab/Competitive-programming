package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBstreetTopcoder {

	static int itms[][];
	static int n;
	static int save[][];
	public static int solve(int i,int lastc){
		
		if(i>=n)return 0;
	
	//System.out.println(i+"  "+lastc);
	if(save[i][lastc]!=-1)
		return save[i][lastc];
	int	ans =(int) 1e6;
		if(lastc!=0)
			ans=Math.min(ans,itms[i][0]+solve(i+1,0));
		if(lastc!=1)
			ans=Math.min(ans,itms[i][1]+solve(i+1,1));
		if(lastc!=2)
			ans=Math.min(ans,itms[i][2]+solve(i+1,2));
		
		return save[i][lastc]=ans;
		
	}
	public static void main(String[] args) throws IOException {
Scanner sc=new Scanner(System.in);
 n=sc.nextInt();
itms=new int[n][3];
for (int i = 0; i < n; i++) {
	itms[i][0]=sc.nextInt();
	itms[i][1]=sc.nextInt();
	itms[i][2]=sc.nextInt();
	
}
save=new int [n][4];
for (int i = 0; i < n; i++) {
	Arrays.fill(save[i], -1);
	
}
System.out.println(solve(0,3));
		
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


