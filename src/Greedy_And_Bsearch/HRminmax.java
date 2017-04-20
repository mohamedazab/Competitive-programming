package Greedy_And_Bsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class HRminmax {

	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		ArrayList<Integer> minmax=new ArrayList<>(100);
		int max=-1;
		int p=sc.nextInt(),q=sc.nextInt();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			int d=(arr[i]+arr[i+1])/2;
			int d2=d+1;
			if((arr[i]+arr[i+1]%2)!=0)
				if(d2<=q&&d2>=p)minmax.add(d2);
			
			if(d<=q&&d>=p)minmax.add(d);			
		}
		if(!minmax.contains(p))minmax.add(p);
		if(!minmax.contains(q))minmax.add(q);
		Collections.sort(minmax);
		max=p;
		int difftill=-10000000;
		for (int i = 0; i < minmax.size(); i++) {
			int x=minmax.get(i);
			int mindf=Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				mindf=Math.min(mindf, Math.abs(arr[j]-x));
			}
			if(mindf>difftill)
			{
				max=x;
				difftill=mindf;
			}
		}
		System.out.println(max);
		
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
