package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class beeUVA {

	
	
	static long arr[];
    static long arr2[];
	
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
	while(true){
		int n=sc.nextInt();
		if(n==-1)break;
		if(n==0){
			out.println(0+" "+1);continue;
		}
		arr=new long [n];
		arr2=new long[n];
		arr[0]=2;arr2[0]=1;
		for (int i = 1; i <n; i++) {
			arr[i]=arr[i-1]+arr2[i-1]+1;
			arr2[i]=arr[i-1];
		}
		out.println(arr2[n-1]+" "+arr[n-1]);
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
