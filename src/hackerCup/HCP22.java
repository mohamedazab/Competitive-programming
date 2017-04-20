package hackerCup;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HCP22 {

	
	public static void main(String[] args)throws Exception {
		
		Scanner sc=new Scanner(new File("lazy_loading.txt"));
		//Scanner sc=new Scanner(System.in);
		int Q=sc.nextInt();
		//PrintWriter out=new PrintWriter(System.out);
		PrintWriter out=new PrintWriter(new File("HC2.txt"));

		for (int i = 1; i <= Q; i++) {
			
			int n=sc.nextInt();
			int nums[]=new int [n];
			for (int j = 0; j < n; j++) {
				nums[j]=sc.nextInt();
			}
			Arrays.sort(nums);
			int c=0;
			int rem=n;
			for (int j = n-1; j >=0; j--) {
				if(rem==0)break;
				int mul=nums[j];
				rem--;
				if(nums[j]*(rem+1)<50){
					 break;
				}
				while(mul<50){
					
					mul+=nums[j];					
					rem--;
				}
		
					c++;
					
				
				
				
			}
			
			
			out.printf("Case #%d: %d\n",i,c);	
			}
		
	
		out.flush();
		out.close();
		
		
		
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
