package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MuricasSkyline {

	
	static int n;
	
	static int heights[],width[],mem[][];
	

	
	static int LIS(int i,int prevIDX){ //return length of LIS;//
		//prev can be number for better complexity 
		
		//n^2
		
		if(i==n)return 0;
		
		if(mem[i][prevIDX]!=-1)return mem[i][prevIDX];
		
		int c1=LIS(i+1, prevIDX);//LEAVE
		
		int c2=0;
		if(prevIDX==n||heights[i]>heights[prevIDX])
			c2=LIS(i+1, i)+width[i];
		
		return mem[i][prevIDX]=Math.max(c1, c2);
		
	}
	
	static int LDS(int i,int prevIDX){ //return length of LIS;//
		//prev can be number for better complexity 
		
		//n^2
		
		if(i==n)return 0;
		
		if(mem[i][prevIDX]!=-1)return mem[i][prevIDX];
		
		int c1=LDS(i+1, prevIDX);//LEAVE
		
		int c2=0;
		if(prevIDX==n||heights[i]<heights[prevIDX])
			c2=LDS(i+1, i)+width[i];
		
		return mem[i][prevIDX]=Math.max(c1, c2);
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int cases=sc.nextInt();
	for (int i = 1; i <=cases; i++) {
		n=sc.nextInt();
		heights=new int [n];
		width=new int[n];
		for (int j = 0; j < n; j++) {
			heights[j]=sc.nextInt();
		}
		for (int j = 0; j < n; j++) {
			width[j]=sc.nextInt();
		}
		mem=new int[n+1][n+1];
		for (int j = 0; j < mem.length; j++) {
			Arrays.fill(mem[j], -1);
		}
	int inc=LIS(0, n);
	for (int j = 0; j < mem.length; j++) {
		Arrays.fill(mem[j], -1);
	}
	int dec=LDS(0,n);	
	if(inc>=dec){
		out.printf("Case %d. Increasing (%d). Decreasing (%d).\n",i,inc,dec);
	}else{
		out.printf("Case %d. Decreasing (%d). Increasing (%d).\n", i,dec,inc);
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

