package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class weddingShopping {

	
	static int mon[][];
	static int C,M;
	static int prices[][];
	
	
	public static int dp(int money,int g){
		if(money>M)return -10000000;
		if(g==C)
			{//System.out.println("laststep "+money);
			return money;
			}
		if(mon[money][g]!=-1)
			{//System.out.println("saved  "+mon[money][g]);
			return mon[money][g];}
		int ans=-1;
		for (int i = 1; i <= prices[g][0]; i++) {
		ans=Math.max(ans, dp(money+prices[g][i],g+1));
		//System.out.println(ans+"fd");
		}
		
		return mon[money][g]=ans;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out=new PrintWriter(System.out); 
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases-->0){
			
			 M=sc.nextInt();
			C=sc.nextInt();
			mon=new int[210][25];
			prices=new int[25][25];
			for (int i = 0; i < mon.length; i++) {
			Arrays.fill(mon[i], -1);	
			}
			for (int i = 0; i < C; i++) {
				int k=sc.nextInt();
				prices[i][0]=k;
				for (int j = 1; j <=k; j++) {
					prices[i][j]=sc.nextInt();
					
				}
				
				
				
			}
			
			int x=dp(0,0);
			if(x>0)
			out.println(x);
			else
				out.println("no solution");
		
			//out.println(taken);
			/*for (int i = 0; i < M; i++) {
				System.out.println(Arrays.toString(mon[i]));
			}*/
		}out.flush();
		
		
		
		
		
		

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
