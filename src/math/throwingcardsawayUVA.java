package math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class throwingcardsawayUVA {

	static int[] arr;
	public static void main(String[] args) throws IOException {
	PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
		arr=new int [500001];
		int s2count=1;
		int s2num=2;
		int s2pow=0;
		arr[1]=1;
		arr[2]=2;
		for (int i = 3; i < arr.length; i++) {
			arr[i]=s2num;
			s2num+=2;
			s2pow++;
			
			if(Math.pow(2, s2count)==s2pow){
				s2count++;
				s2pow=0;
				s2num=2;
			}
		}
		//System.out.println(Arrays.toString(arr));
		while(true){
			
			int c=sc.nextInt();
if(c==0)break;
				out.printf("%d\n",arr[c]);}
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
