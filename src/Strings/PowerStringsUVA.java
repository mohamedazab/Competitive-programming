package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


	

public class PowerStringsUVA {

	static StringBuilder sb;
	static void solve(StringBuilder c1){
	//	System.out.println(a.length());
		int max=1;
		for (int i = 1; i <=c1.length()/2; i++) {
			StringBuilder c2=new StringBuilder(c1.substring(0, i));
			if(c1.length()%c2.length()==0)
			{int k=KMPfunc(c1,c2);
			int c3=k*c2.length();
			if(c3==c1.length())
				max=Math.max(k,max);
			}
		}
		sb.append(max+"\n");
		
		
		
		
		
		
	
	}
	
	static int[] failureFunc(StringBuilder pat){
		int[] longestPrefix=new int[pat.length()];
		int fu=1;
		for (int i = 1,k=0; i < longestPrefix.length; i++) {
		while(k>0&&pat.charAt(k)!=pat.charAt(i))
			k=longestPrefix[k-1];
		
		
		if(pat.charAt(k)==pat.charAt(i))
			longestPrefix[i]=++k;
		else
			longestPrefix[i]=k;
		if(i!=longestPrefix.length)
		fu=Math.max(longestPrefix[i], fu);
		}
		System.out.println(fu==1?1:fu+1);
		
		return longestPrefix;
	}
	
    static int KMPfunc(StringBuilder str,StringBuilder pat){
    	int count=0;
    	int n=str.length();
    	int m=pat.length();
    	int longestPrefix[]=failureFunc(pat);
    	for (int i = 0,k=0; i < n; i++) {
    		while(k>0&&pat.charAt(k)!=str.charAt(i))
    			k=longestPrefix[k-1];
    		
    		
    		if(pat.charAt(k)==str.charAt(i))
    			++k;
    		
    		if(k==m)
    		{	
    			count++;//System.out.println(i-m+1+"\n");
    		//how many matches
    		// fail to the best
    		k=longestPrefix[k-1];
    		}
    	}	
    	return count;
    }
    
	
    
    public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		 sb=new StringBuilder();
		while(true){
		StringBuilder c1=new StringBuilder(sc.nextLine());
		if(c1.toString().equals("."))break;
	System.out.println(Arrays.toString(failureFunc(c1)));
	failureFunc(c1);
		//System.out.println(arr.toString());
	   // solve(c1);
		
	}//System.out.print(sb);
    
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
