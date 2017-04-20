package Datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class uva1991{
	
	static class numk implements Comparable<numk>{

		int num; TreeMap<Integer,Integer>coeff;
		int count;
		
		public numk(int num,int idx) {
	this.num=num;
	if(coeff==null)coeff=new TreeMap<Integer,Integer>();
	count=1;
	coeff.put(count,idx);
	
}
		public void update(int idx){
			coeff.put(++count,idx);
		}
		@Override
		public int compareTo(numk o) {
			return num-o.num;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		while(sc.ready()){
		int n=sc.nextInt();int m=sc.nextInt();
 TreeMap<numk,numk> nr=new TreeMap<numk,numk>();
 for (int i = 1; i <= n; i++) {
	 numk a=new numk(sc.nextInt(),i);
	if(nr.containsKey(a))
	{numk r=nr.get(a);
	r.update(i);
		
	}else{
		nr.put(a, a);
	}
}
 StringBuilder sb=new StringBuilder();
 while(m-->0){
	 int k=sc.nextInt();
	 int v=sc.nextInt();
	 numk a=new numk(v,0);
	 if(nr.containsKey(a)){
		int pos=nr.get(a).coeff.get(k)==null?0:nr.get(a).coeff.get(k);
		// System.out.println(v+"   "+k+"     "+nr.get(a).coeff);
		 sb.append(pos+"\n");
	 }else
		 sb.append("0\n");
	 
	 
 }
		
 out.print(sb);
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