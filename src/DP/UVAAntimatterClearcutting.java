package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer; 



public class UVAAntimatterClearcutting {


	static int n,k;
	static int mem[];
	static	int xTree[],yTree[];

	static int solve(int mask){
		
		if((Integer.bitCount(mask)>=k))return 0;
		//System.out.println(Integer.toBinaryString(mask));
		if(mem[mask]!=-1)return mem[mask];
		int ret=(int)(1e9);
		ArrayList<Integer> still=new ArrayList<>();
		for (int i = 0; i <n; i++) {
			if((mask&(1<<i))==0)
				still.add(i);
			
			
		}
		
		//System.out.println(still.toString());
		for (int i = 0; i <still.size(); i++) {
			for (int j = 0; j < still.size(); j++) {
				if(i==j)continue;
				ret=Math.min(ret, 1+solve(mask|treesShot[still.get(i)][still.get(j)]));
			}
		}
		if(ret==((int) 1e9)) return 1;
				return mem[mask]=ret;
		
		
		
	}
	
	public static boolean collinear(int i,int j,int k){
		int x1=xTree[j]-xTree[i];
		int y1=yTree[j]-yTree[i];
		int x2=xTree[k]-xTree[i];
		int y2=yTree[k]-yTree[i];
		
		
		if(x1*y2-x2*y1==0)return true;
		else
			return false;
		
		
	}
	static int treesShot[][];
	public static void preload(){
		treesShot=new int [n][n];
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <n; j++) {
				if(i!=j){
					int msk=0;
					msk|=1<<i;
					msk|=1<<j;
					for (int k = 0; k < n; k++) {
						if(k!=i&&k!=j)
						{
							if(collinear(i, j, k))msk|=1<<k;
						}
					}
					
					treesShot[i][j]=msk;
				}
			}
		}
		
		
	}
	//shot =1 in the mask
	
	
	public static void main(String[] args) throws IOException {


		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int q=sc.nextInt();
		int cases=1;
		while(cases<=q){
			n=sc.nextInt();
			k=sc.nextInt();
			xTree=new int[n];
			yTree=new int[n];
			for (int i = 0; i < n; i++) {
				xTree[i]=sc.nextInt();
				yTree[i]=sc.nextInt();
			}
			preload();
			mem=new int[1<<16];
			Arrays.fill(mem, -1);
			out.printf("Case #%d:\n%d\n",cases,solve(0));
			if(cases<q)out.println();
			cases++;
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
