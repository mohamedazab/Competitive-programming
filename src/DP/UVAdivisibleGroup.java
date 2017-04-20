package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVAdivisibleGroup {

	static int numbers[];
	static int n;
	static int d;
	static int m;
	static int mem[][][];
static int knapsack(int i,int sum,int cnt){ 
	//System.out.println(sum+" "+d);
	sum%=d;
	if(sum<0)
		sum+=d;
	if(cnt>m)return 0;
	   if(cnt==m)return (sum)==0?1:0;
		if(i==n)
			return 0;
		//System.out.println(i+" "+cnt+" "+sum+"  sum%d "+(sum%d) );
	if(mem[i][cnt][sum]!=-1)
		return mem[i][cnt][sum];
		int c1=knapsack(i+1, sum,cnt);
		int c2=knapsack(i+1, sum+numbers[i],cnt+1);
		return mem[i][cnt][sum]=c1+c2;
		
		
		
	
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int sets=1;
		while(true){ 
		n=sc.nextInt();
		int q=sc.nextInt();
		numbers=new int[n];
		if(n==0)break;
	
		for (int i = 0; i < n; i++) {
			numbers[i]=sc.nextInt();
		}
		
		out.printf("SET %d:\n",sets);
		for (int i = 1; i <=q; i++) {
			 d=sc.nextInt();
			m=sc.nextInt();
			mem=new int[n+1][m+1][d+1];
			for (int x = 0; x <=n; x++) {
				for (int j = 0; j <= m; j++) {
					Arrays.fill(mem[x][j],-1);
				}
			}
			int ans=knapsack(0, 0, 0);
			out.printf("QUERY %d: %d\n",i,ans);
		}

		sets++;
		
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
