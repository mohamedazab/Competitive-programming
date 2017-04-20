package math;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class wetsharksandbishopsCF {
	
	
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int x=sc.nextInt();
		
		TreeMap<Integer,Integer>xs=new TreeMap< Integer,Integer>();
		TreeMap<Integer,Integer>ys=new TreeMap<Integer, Integer>();
		int count=0;
		int xa[]=new int[x];
		int ya[]=new int[x];
		TreeMap<Integer,Integer> rep=new TreeMap();
		for (int i = 0; i < x; i++) {
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			xa[i]=x2;ya[i]=y2;
		}
			
		for (int i = 0; i < x; i++) {
			int x2=xa[i];
			int y2=ya[i];
			int key1=x2-y2;
			int key2=x2+y2;
			//boolean inboth=false;
			if(xs.containsKey((key1))){
				count+=xs.get(key1);
				xs.replace(key1, xs.get(key1)+1);
				//inboth=true;
				
				//System.out.println(x2+"  "+y2+"  "+key1+"   "+(xs.get(key1)-1));
				
			}else{
				xs.put(key1,1);}
			
				if(ys.containsKey((key2))){
					
					
					count+=ys.get(key2);
					
					ys.replace(key2, ys.get(key2)+1);
				//	System.out.println(x2+"   "+y2+"  "+key2+"   "+(ys.get(key2)-1));
				}else
					ys.put(key2, 1);
					
			
			
			
		
			}
		System.out.println(count);
		
		
		
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
