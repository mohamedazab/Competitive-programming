package Datastructures;

/**
 * Created by moham on 2/2/2017.
 */


import java.io.*;
import java.util.*;

public class CFxeniaAndBitOperations {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		int n=sc.nextInt();
		int m=sc.nextInt();
		int N=1<<n;


		int in[]=new int[N+1];
		for (int i = 1; i <=N; i++) {
			in[i]=sc.nextInt();
		}
		boolean or=n%2!=0;
		SegmentTree s=new SegmentTree(in,or);
		while (m-->0){
			//System.out.println(Arrays.toString(s.sTree));
			int idx=sc.nextInt();
			int val=sc.nextInt();
			s.update_point(idx,val);
			in[idx]=val;
			//System.out.println(Arrays.toString(s.sTree));

			out.println(s.sTree[1]);
		}


		out.flush();
	}









	static class SegmentTree {

		int N;
		int[] array, sTree;

		SegmentTree(int[] in,boolean or)
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];
			build(1,1,N,or);
		}

		void build(int node, int b, int e,boolean or)
		{
			if(b == e)
				sTree[node] = array[b];
			else
			{
				build(node<<1,b,(b+e)/2,!or);
				build((node<<1)+1,(b+e)/2+1,e,!or);
				sTree[node] = or?sTree[node<<1]|sTree[(node<<1)+1]:sTree[node<<1]^sTree[(node<<1)+1];
			}
		}


		void update_point(int index, int val) {
			index += N - 1;
			sTree[index] = val;
			boolean or=true;
			while (index > 1) {
				index >>= 1;
				sTree[index] =or?sTree[index<<1]|sTree[(index<<1)+1]:sTree[index<<1]^sTree[(index<<1)+1];
				or=!or;

			}
		}


	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}


	}










}

