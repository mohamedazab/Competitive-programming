package DP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hackerRankEqual {




	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int cases=sc.nextInt();
		while(cases-->0){
		int n=sc.nextInt();
		int arr[]=new int [n];
		int min=10000000;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]<min)min=arr[i];
		}
		int i=0;
		int ans=1000000000;
		while(min-i>=0&&i!=5){

			int minTmp=min-i;
			int deltas[]=new int[n];
			for (int j = 0; j < deltas.length; j++) {
				deltas[j]=arr[j]-minTmp;
			}
			int factors=0;
			for (int j = 0; j < deltas.length; j++) {
				int num5=deltas[j]/5;
				int num2=(deltas[j]%5)/2;
				int num1=deltas[j]%5%2;
				factors+=num5+num2+num1;
			}
			i++;
			ans=Math.min(ans, factors);
		}
		out.println(ans);
		}
		out.flush();

	}
	
	

static class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
	public Scanner(File x) throws FileNotFoundException{	br = new BufferedReader(new FileReader(x));}

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
