
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {


	static long []cities;
		static TreeSet<Long>towers,rad;
	public static boolean valid(long x){

		if(rad.higher(x)==null)
		return true;
		//System.out.println(rad.higher(x));
		return false;

	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		StringBuilder sb=new StringBuilder("");

		int n=sc.nextInt(),m=sc.nextInt();
		cities=new long[n];towers=new TreeSet<Long>();
		for (int i = 0; i <n ; i++) {
			cities[i]=sc.nextInt();
		}
		for (int i = 0; i <m ; i++) {
			towers.add(sc.nextLong());
		}

		rad=new TreeSet<Long>();
		for (int i = 0; i <n ; i++) {
			long min=100000000000l;
			if(towers.ceiling(cities[i])!=null)
				min=Math.min(min,Math.abs(towers.ceiling(cities[i])-cities[i]));
			if(towers.floor(cities[i])!=null)
				min=Math.min(min,Math.abs(towers.floor(cities[i])-cities[i]));
			rad.add(Math.abs(min));

		}
		long low =0;
		long high=100000000000l;
		//System.out.println(rad.toString());
		while(high>low){
			long mid=(high+low)/2l;
			if(valid(mid))
				high=mid;
			else
				low=mid+1;
			//System.out.println(mid+" "+low+" "+high);
		}

		out.println(high);

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