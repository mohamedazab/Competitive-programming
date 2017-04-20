import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
		
		
 String r=sc.nextLine();
 int num=r.indexOf('e');
 String n=r.substring(0,num);
 //System.out.println(n);
 int point=n.indexOf('.');
 
 int b=Integer.parseInt(r.substring(num+1));
 int point2=point+b;
 String output="";
 BigInteger d=new BigInteger(r.substring(point+1, num));
 if(b<(r.substring(point, num)).length())
 {if(!d.equals(BigInteger.ZERO))
	 output=n.substring(0, point)+n.substring(point+1,point+1+b)+"."+n.substring(point+1+b); 
 else
	 output=n.substring(0, point);
 }
  
 else
	{int rest=b-(r.substring(point, num).length())+1;
//	System.out.println(rest);
	for (int i = 0; i <rest; i++) {
		output+="0";
	}
//	System.out.println(output);
	output= n.substring(0, point)+n.substring(point+1,num)+output;

	// System.out.println(output);
	}
 

 if(output.charAt(output.length()-1)=='.')
	output= output.substring(0, output.length()-1);
 if(output.charAt(0)=='0'&&output.length()>1&&output.charAt(1)!='.')output=output.substring(1);
 out.print(output);
 
 
 
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