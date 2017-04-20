package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class expressionbracketingUVA {

static long cat[];
static long supercat[];

static void generatecatalanNumbers(int n){
	cat=new long[n+1];
	cat[0]=1;cat[1]=1;
	for (int i = 1; i < cat.length-1; i++) {
		cat[i+1]=((2*(2*i+1))*cat[i]/(i+2));
		//System.out.println(cat[i+1]+" "+cat[i]+" "+i+" "+((2*(2*i+1))/(i+2)));
	}
	//System.out.println(Arrays.toString(cat));
	
	
	
}
static void generateSupercatalanNumbers(int n){
	supercat=new long[n+1];
	supercat[0]=supercat[1]=supercat[2]=1;
	for (int i = 3; i <= n; i++) {
		supercat[i]=(3*(2*i-3)*supercat[i-1]-(i-3)*supercat[i-2])/i;
	}
	
	
	//System.out.println(Arrays.toString(supercat));
	
}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
			generatecatalanNumbers(26);
		generateSupercatalanNumbers(26);
		while(sc.ready()){
		int n=sc.nextInt();
	//	System.out.println(supercat[n]+" "+cat[n-1]);
		out.println(supercat[n]-cat[n-1]);}
		
		
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