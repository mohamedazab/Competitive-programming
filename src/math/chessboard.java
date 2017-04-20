package math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chessboard {

	static double[] arr;
	public static void main(String[] args) throws IOException {
	PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
	int tc=sc.nextInt();
	 arr=new double[301];
	 arr[1]=0;arr[2]=4;
	 int j=1;
	 double x=Math.sqrt(2);
	for (int i = 3; i < arr.length; i++) {
		int k=(int) Math.pow(j, 2);
		arr[i]=(i*i-k)+(k*x);
		j++;
	}
		while(tc>0){
			sc.nextLine();
			int c=sc.nextInt();
			
				out.printf("%.3f\n",arr[c]);
				tc--;
				if(tc!=0)
					out.println();}
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
