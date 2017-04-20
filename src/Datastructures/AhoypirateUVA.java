package Datastructures;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import Datastructures.serejaandbrackets.br;

public class AhoypirateUVA {

	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int i = 1; i <=t; i++) {
		int m=sc.nextInt();	
		StringBuilder sb=new StringBuilder();
		out.printf("Case %d:\n",i);
		for (int j = 0; j < m; j++) {
			
		
		
			int T=sc.nextInt();
			String x=sc.nextLine();
		
		for (int k = 0; k < T; k++) {
			sb.append(x);
		}
			
		}
		int n=sb.length();
		
		int N = 1; while(N < n) N <<= 1; //padding
		int[] in = new int[N + 1];
		for(int k = 1; k <= n; k++)
			{
			in[k]=sb.charAt(k-1)-'0';
			}
		
		
		
		SegmentTree sm=new SegmentTree(in);
		int q=sc.nextInt();
		int qs=1;
	System.out.println(sb);
		for (int j = 1; j <=q; j++) {
			
			System.out.println(Arrays.toString(sm.sTree));
		String qur[]=sc.nextLine().split(" ");	
			char c=qur[0].charAt(0);
			int a=Integer.parseInt(qur[1]);
			int b=Integer.parseInt(qur[2]);
			if(c=='F'){
				sm.update_range(a, b, 1);
			}
			if(c=='E'){
				sm.update_range(a, b, 0);
			}if(c=='I'){
				
				sm.update_range(a, b, -1);
			}else
			{
				out.printf("Q%d: %d\n",qs,sm.query(a, b));
				qs++;
			}
			
			
			
		}
		
		
		
		}
		
		
		out.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static class br{
		int op;int cl; 
		public br(int a,int b) {
		op=a;cl=b;
			
			
			
		}
		
	}

		static class SegmentTree {		// 1-based DS, OOP
			
			int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
			br[] array, sTree;
			ArrayList<Integer> []lazy;
			
			SegmentTree(br[] in)		
			{
				array = in; N = in.length - 1;
				sTree = new br[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
				lazy = new ArrayList [N<<1];
				for (int i = 0; i < N<<1; i++) {
					lazy[i]=new ArrayList();
				}
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
					br b1=sTree[node<<1];
					br b2=sTree[(node<<1)+1];
					int x=Math.min(b1.op, b2.cl)*2;
				sTree[node]= new br(b1.op+b1.op,b2.cl+b2.cl);
					
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
				{if(val==1)
				{sTree[node].op+=sTree[node].cl;sTree[node].cl=0;
					
				}else
					if(val==-1){
						sTree[node].cl+=sTree[node].op;sTree[node].op=0;
					}
					else{int tmp=sTree[node].op;
						sTree[node].op=sTree[node].cl;sTree[node].cl=tmp;
					}
								
					lazy[node].add(val) ;				
				}							
				else		
				{
					//propagate(node, b, e);
					update_range(node<<1,b,(b+e)/2,i,j,val);
					update_range((node<<1)+1,(b+e)/2+1,e,i,j,val);
	sTree[node] = new br(sTree[node<<1].op + sTree[(node<<1)+1].op,sTree[node<<1].cl + sTree[(node<<1)+1].cl);		
				}
				
			}
			
			public void update(int val, int node){
				if(val==1)
				{sTree[node].op+=sTree[node].cl;sTree[node].cl=0;
					
				}else
					if(val==-1){
						sTree[node].cl+=sTree[node].op;sTree[node].op=0;
					}
					else{int tmp=sTree[node].op;
						sTree[node].op=sTree[node].cl;sTree[node].cl=tmp;
					}
			}
			void propagate(int node, int b, int e)		
			{
				int mid = (b+e)/2;
				lazy[node<<1]=new ArrayList(lazy[node]);
				lazy[(node<<1)+1] = new ArrayList(lazy[node]);
				sTree[node<<1] = (mid-b+1)*lazy[node];		
				sTree[(node<<1)+1] = (e-mid)*lazy[node];		
				lazy[node] = ;
			}
			
		
				
		

			
			
			
			
			
			br query(int i, int j)
			{
				return query(1,1,N,i,j);
			}
			
			br query(int node, int b, int e, int i, int j)	// O(log n)
			{
				if(i>e || j <b)
					return new br(0,0);		
				if(b>= i && e <= j)
					return sTree[node];
				
				br b1 = query(node<<1,b,(b+e)/2,i,j);
				br b2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
				return new br(b1.op+b2.op,b1.cl+b2.cl);	
						
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
*/