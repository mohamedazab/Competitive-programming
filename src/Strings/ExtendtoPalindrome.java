package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ExtendtoPalindrome {
	static int[] failureFunc(String pat){
		int[] longestPrefix=new int[pat.length()];
		
		for (int i = 1,k=0; i < longestPrefix.length; i++) {
		while(k>0&&pat.charAt(k)!=pat.charAt(i))
			k=longestPrefix[k-1];
		
		
		if(pat.charAt(k)==pat.charAt(i))
			longestPrefix[i]=++k;
		else
			longestPrefix[i]=k;
		}

		return longestPrefix;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		 StringBuilder sb=new StringBuilder();
		// int next=4;
		while(sc.ready()){
		 
		 StringBuilder s=new StringBuilder(sc.nextLine());
		String tmp=s.toString();
		String s2=s.toString();
		s2=((s.reverse()).toString())+"."+s2;

		int fal[]=failureFunc(s2);
		
		//System.out.println(Arrays.toString(fal));
		//System.out.println(tmp+"   "+s);
		int pref1=fal[fal.length-1];
		
		if(tmp.equals(s.toString())){
			
		}else{
		
		
		//	System.out.println(s);
			tmp+=s.substring(pref1, s.length());
			
			
		
	}
		sb.append(tmp+"\n");


	}
		System.out.print(sb);
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

