package Datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class uva11235frequentvalues {

	
	
	
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out); 
		Scanner sc = new Scanner(System.in);
		String fs[]=sc.nextLine().split(" ");
		int n = Integer.parseInt(fs[0]);
		if(n==0);//////////////////////////////////////
		int q=Integer.parseInt(fs[1]);
int N = 1; while(N < n) N <<= 1; //padding

		String r[]=sc.nextLine().split(" ");
		int[] in = new int[N + 1];
		
		
		
		for(int i = 1; i <= n; i++)
		{int x=Integer.parseInt(r[i-1]);
		
			in[i] =x;}
			
			
		
	
	SegmentTree sm=new	SegmentTree(in);
		
		
		for (int i = 0; i < q; i++) {
			
			String qr[]=sc.nextLine().split(" "); 
			int start=Integer.parseInt(qr[0]);
			int end=Integer.parseInt(qr[1]);
			out.println(sm.query(start, end));
		   
			
			
		}
		
		out.flush();
		

	}
	
	
	



	

	// Range Sum Query (with lazy propagation)

	static class SegmentTree {		// 1-based DS, OOP
		int count=0;
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array, sTree, lazy;
		
		SegmentTree(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new int[N<<1];
			build(1,1,N);
		}
		
		void build(int node, int b, int e)	// O(n)
		{
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				build(node<<1,b,(b+e)/2);
				build((node<<1)+1,(b+e)/2+1,e);
				sTree[node] = Math.max(sTree[node<<1],sTree[(node<<1)+1]);
			}
		}
		
		
		
		
		void update_range(int i, int j, int val)		// O(log n) 
		{
			update_range(1,1,N,i,j,val);
		}
		
		void update_range(int node, int b, int e, int i, int j, int val)
		{
			if(i > e || j < b)		
				return;
			if(b >= i && e <= j)		
			{
				sTree[node] += (e-b+1)*val;			
				lazy[node] += val;				
			}							
			else		
			{
				propagate(node, b, e);
				update_range(node<<1,b,(b+e)/2,i,j,val);
				update_range((node<<1)+1,(b+e)/2+1,e,i,j,val);
				sTree[node] = sTree[node<<1] + sTree[(node<<1)+1];		
			}
			
		}
		void propagate(int node, int b, int e)		
		{
			int mid = (b+e)/2;
			lazy[node<<1] += lazy[node];
			lazy[(node<<1)+1] += lazy[node];
			sTree[node<<1] += (mid-b+1)*lazy[node];		
			sTree[(node<<1)+1] += (e-mid)*lazy[node];		
			lazy[node] = 0;
		}
		
		int query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		int query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			propagate(node, b, e);
			int q1 = query(node<<1,b,(b+e)/2,i,j);
			int q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
			return Math.max(q1 , q2);	
					
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
