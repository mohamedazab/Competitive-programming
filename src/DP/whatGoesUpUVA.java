package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class whatGoesUpUVA {

	
	static int nums[],n;
	static String LIS_EFF(){
		 int parent[]=new int[n],seq[]=new int[n+1]//track end of each inc subseq 
				,length=0;	
		
		for (int i = 0; i < nums.length; i++) {
			
			int low=1;
			int high=length;
			//binarysearch
			//find element to replace
			while(low<=high)
			{
				
			
				
				int mid=(int) Math.ceil((low+high)/2);
				if(nums[seq[mid]]<nums[i])
					{
					low=mid+1;
					}
				else
					high=mid-1;
				
				
			}
		
			
			
			int pos=low;
			parent[i]=seq[pos-1];//update parent
			 seq[pos]=i;
			 length=length<pos?pos:length;
			
			
			
			
			
		}
		//print LIS
		String s="";
		 
			 int last=seq[length];
			 for (int j = length-1; j >=0; j--) {
			s=nums[last]+"\n"+s;
			
			   last=parent[last];
			}
			return length+"\n-\n"+s.substring(0, s.length()-1).toString();
			
			
	
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		ArrayList<Integer> num=new ArrayList<Integer>(100000);
	//	int x=8;
	while(sc.ready())
		num.add(sc.nextInt());
		
	n=num.size();
	nums=new int [n];
	for (int i = 0; i < nums.length; i++) {
		nums[i]=num.get(i);
	}
	out.println(LIS_EFF());
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
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
