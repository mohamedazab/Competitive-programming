package linearDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class anyaAndSmartphones{
     
	
	
	
	
	static class pair implements Comparable <pair>{
		int sc,num; int bef; int nxt;
		public pair(int a,int b,int bef,int nxt) {
		sc=a;num=b;this.bef=bef;this.nxt=nxt;
		}
		@Override
		public int compareTo(pair o) {
			if(sc!=o.sc)
				return sc-o.sc;
			else
				return num-o.num;
		}
		 
		public String toString(){
			return num+" "+nxt+" "+bef+" "+sc;
			
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
 
		int n=sc.nextInt();int m=sc.nextInt();
		
		int k=sc.nextInt();
		int scr=1;
		TreeMap<Integer, pair> ans=new TreeMap<Integer,pair >();
		int arr[]=new int [n+1];
		arr[0]=-1;
		for (int i = 1; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		for (int i = 1; i <=n; i++) {
			int tmp=arr[i];
			if(i==n)
				ans.put(tmp,new pair(scr,tmp,arr[i-1],-1) );
			else
			ans.put(tmp,new pair(scr,tmp,arr[i-1],arr[i+1]) );
			
			if(i%k==0)
			{
				scr++;
			}
		}
		
		
		
		long stp=0;
		for (int i = 0; i < m; i++) {
			int mi=sc.nextInt();
			
			pair x=ans.get(mi);
			stp+=x.sc;
			
			
		pair af=ans.get(x.nxt);		
		pair b=ans.get(x.bef);
		pair b2=null;
		if(b!=null){
		 b2=ans.get(b.bef);
		x.nxt=b.num;
		b.bef=x.num;
		 if(b2!=null){
			x.bef=b2.num;
			b2.nxt=x.num;
		}else
			{
			x.bef=-1;
			}
		if(x.sc!=b.sc){		
		x.sc--;b.sc++;
		}
		
		}
		if(af!=null&&b!=null){
		af.bef=b.num;
		b.nxt=af.num;					
				}
		else{
			if(b!=null)
					b.nxt=-1;					
				}
				
			
			
	//	System.out.println(x+"..."+b+"..."+af+"..."+b2);
			//System.out.println(ans.toString());
		}
		out.print(stp);
		
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