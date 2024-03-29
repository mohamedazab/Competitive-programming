import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class D {




	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		char[] start=sc.nextLine().toCharArray();
		char[] target=sc.nextLine().toCharArray();
		int steps[]=new int[ start.length];
		for (int i = 0; i <steps.length ; i++) {
			steps[i]=sc.nextInt()-1;
		}
		int cntStart[]=new int[27];
		int cnttarget[]=new int[27];

		for (int i = 0; i <target.length ; i++) {
			cnttarget[target[i]-'a']++;

		}
		for (int i = 0; i <start.length ; i++) {
			cntStart[start[i]-'a']++;

		}
		int max=0;
		boolean flag=false;
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(steps));
		System.out.println(Arrays.toString(cntStart));
		System.out.println(Arrays.toString(cnttarget));

		for (int i = 0; !flag&&i <steps.length ; i++) {
			int x=start[steps[i]]-'a';
			cntStart[x]--;
			System.out.println(cntStart[x]+" "+cnttarget[x]+" "+x);
			if(cntStart[x]<cnttarget[x]&&cnttarget[x]!=0)flag=true;
			else max++;
		}
		System.out.println();
		System.out.println(Arrays.toString(cntStart));
		System.out.println(Arrays.toString(cnttarget));
		System.out.println(max);

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
