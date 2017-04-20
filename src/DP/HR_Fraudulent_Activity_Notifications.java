package DP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HR_Fraudulent_Activity_Notifications {



	static double construct(){

		int cnt=0;
		int med=0;

		for (int i = 0;cnt<=d; i++) {
			if(d%2==0){
				if(cnt+sorting[i]>=d/2){
					if(cnt+sorting[i]==d/2){
						int ans=i;
						int ans2=0;
						for (i=i+1;ans2==0;i++)if(sorting[i]!=0)ans2=i;
						return (ans+ans2)/2.0;
					}
					else return i;
				}
			}
			else{
				if(cnt>=d/2+1)return med;
				if(sorting[i]>0)
					med=i;
			}
			cnt+=sorting[i];
		}
		return -1;


	}
	static int sorting[];
	static int d;
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		d=sc.nextInt();
		int arr[]=new int [n];
		sorting =new int[201];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
			if(i<d)
				sorting[arr[i]]++;
		}
		
		int not=0;
		int low=0;

		for (int high = d; high < arr.length; high++) {
			double med=construct();
			if(arr[high]>=2*med)not++;
			sorting[arr[low]]--;
			sorting[arr[high]]++;
			low++;
		}
		System.out.println(not);


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
