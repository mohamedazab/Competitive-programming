package Datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class serejaandbrackets {

	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		String r=sc.nextLine();
		int n=r.length();
	
		int N = 1; while(N < n) N <<= 1; //padding
		
		br[] in = new br[N + 1];
		for (int i = 0; i < in.length; i++) {
			in[i]=new br(0,0,0);
		}
		
		for(int i = 0; i < n; i++)
			in[i+1] =new br( r.charAt(i)=='('?1:0,r.charAt(i)==')'?1:0,0);
		SegmentTree sm=new SegmentTree(in);
		int q=sc.nextInt();
		while(q-->0){
			int a=sc.nextInt();
			int b=sc.nextInt();
			out.println(sm.query(a, b).len);
			
			
		}
		out.flush();
		
	}



	

static class br{
	int op;int cl; int len;
	public br(int a,int b,int c) {
	op=a;cl=b;len=c;
		
		
		
	}
	
}

	static class SegmentTree {		// 1-based DS, OOP
		
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		br[] array, sTree, lazy;
		
		SegmentTree(br[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new br[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new br[N<<1];
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
			sTree[node]= new br(b1.op+b2.op-x/2,b1.cl+b2.cl-x/2,b1.len+b2.len+x);
				
			}
		}
		
		
	
			
	

		
		
		
		
		
		br query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		br query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return new br(0,0,0);		
			if(b>= i && e <= j)
				return sTree[node];
			
			br b1 = query(node<<1,b,(b+e)/2,i,j);
			br b2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
			 int x=Math.min(b1.op, b2.cl)*2;
			return new br(b1.op+b2.op-x/2,b1.cl+b2.cl-x/2,b1.len+b2.len+x);	
					
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
