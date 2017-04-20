package General;

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
import java.util.TreeMap;


public class HRlilysHomework {

	
	
	static int solve(TreeMap<Integer, Integer> tr,int arrT[],int sorted[]){
		int swaps=0;
		for (int i = 0; i < arrT.length; i++) {
			if(sorted[i]==arrT[i])continue;
			int tmp=tr.get(sorted[i]);
			int numSorted=sorted[i];
			int numtmp2=arrT[i];
			tr.put(numtmp2, tmp);
			arrT[tmp]=numtmp2;
			arrT[i]=numSorted;
			swaps++;
		}
		return swaps;
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		int sorted[]=new int [n];
		int arrT[]=new int[n];
		TreeMap<Integer,Integer> tr=new TreeMap<>();
		for (int i = 0; i < n; i++) {
			sorted[i]=sc.nextInt();
			arrT[i]=sorted[i];
			tr.put(sorted[i],i);
		}
		Arrays.sort(sorted);
		int []sorted2=new int[n];
		for (int i = 0; i < sorted2.length; i++) {
			sorted2[i]=sorted[n-i-1];
		}
		TreeMap<Integer,Integer> tr2=(TreeMap<Integer, Integer>) tr.clone();
		int[] arrT2=arrT.clone();
		
		
		System.out.println(Math.min(solve(tr, arrT, sorted2), solve(tr2, arrT2, sorted)));
		out.flush();
	
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
