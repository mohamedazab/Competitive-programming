package Datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class similarpair {

	static int t;
	static ArrayList<Integer> []adjList;
	static long count;
	static SegmentTree sm;
	public static void dfs (int index){
	int start=index-t;int end=index+t;
	
	
	
		long y=sm.query(start, end);
		count+=y;
		
		sm.update_point(index, 1);
        //System.out.println(index+"  range "+start+" "+end+"  "+y);
		for (int i = 0; i < adjList[index].size(); i++) {
			//System.out.println(i+"");
			
			dfs(adjList[index].get(i));
		}
		
		sm.update_point(index, 0);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// out=new PrintWriter(System.out); 
		Scanner sc = new Scanner(System.in);		
		String input[]=sc.nextLine().split(" ");
		int n=Integer.parseInt(input[0]);
	 t=Integer.parseInt(input[1]);
		adjList=new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adjList[i]=new ArrayList<Integer>();
		}
		boolean froot[]=new boolean[n+1];
		for (int i = 1; i < n; i++) {
			String r[]=sc.nextLine().split(" ");
			int s1=Integer.parseInt(r[0]);
			int s2=Integer.parseInt(r[1]);
			froot[s2]=true;
			adjList[s1].add(s2);
			
			
		}
		
	/*for (int i = 1; i <= n; i++) {
		System.out.println(adjList[i].toString());
	}*/
		
		int rootidx=0;
		for (int i = 1; i < froot.length; i++) {
			if(froot[i]==false)
				{rootidx=i;break;}
		}
		//System.out.println("root"+rootidx);
		
		int N = 1; while(N < n) N <<= 1; //padding
		
		int[] in = new int[N + 1];
		 sm=new SegmentTree(in);
		 
		 count=0;
		 dfs(rootidx);
		
		System.out.println(count);
		
	
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
	
	


	
	// Range Sum Query (with lazy propagation)

		
	
static class SegmentTree {		// 1-based DS, OOP
	
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
			sTree[node] = sTree[node<<1]+sTree[(node<<1)+1];
		}
	}
	
	
	void update_point(int index, int val)			// O(log n)
	{
		index += N - 1;				
		sTree[index] = val;			
		while(index>1)				
		{
			index >>= 1;
			sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
		}
	}
	
	

	long query(int i, int j)
	{
		if(i<1)
			i=1;
		
		return query(1,1,N,i,j);
		
	}
	
	long query(int node, int b, int e, int i, int j)	// O(log n)
	{//System.out.println("twst  "+i+" "+j);
		
			
		if(i>e || j <b)
			return 0;		
		if(b>= i && e <= j)
			return sTree[node];
		
		
	
		long q1 = query(node<<1,b,(b+e)/2,i,j);
		long q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
		return q1 + q2;	
		
				
	}
	
	


}}
