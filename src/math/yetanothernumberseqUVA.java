package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class yetanothernumberseqUVA {
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
	int[]	period={0,60,300,1500,15000};
		int cases=sc.nextInt();
		while(cases-->0){
		int a=sc.nextInt();
		int b=sc.nextInt();
		 int n=sc.nextInt();
	    int m=sc.nextInt();
	    int arr[]=new int [period[m]+1];
	   
	    int p=(int) (Math.pow(10, m));
	  //  System.out.println(p);
	     arr[0]=a%p;arr[1]=b%p;
		for (int i = 2; i <period[m]&&i<=(n%period[m]); i++) {
			arr[i]= ((arr[i-1]+arr[i-2]))%p;
		} 
		 out.println(arr[n%period[m]]);
		
		
		}
		
		out.flush();
		
	}
		

static 	class Scanner 
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
