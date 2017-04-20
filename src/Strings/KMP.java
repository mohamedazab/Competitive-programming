package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class KMP {





	static void prefixFunction(char[] s){

		///pattern in text
		int n=s.length;
		int pi[]=new int[n];
		//O(N^2)
		/*for (int i = 0; i <n ; i++) {
			//loop  p[i]+1 -- compare
		}*/
		//j is last pi
		for (int i = 1,j=0; i < n; i++) {

			while (j>0&&s[i]!=s[j]){
				j=pi[j-1];
			}
			if(s[i]==s[j])j++;
			pi[i]=j;


		}

		System.out.println(Arrays.toString(pi));
	}


	static int[] countPrefixOccur(int[]pi){

		//pi longest proper suffix matching a prefix and the position after the last char in that prefix
		//ans[0]=len+1 ocurr. of ""
		int []ans=new int[pi.length];
		for (int i = 0; i <ans.length ; i++) {
			ans[pi[i]]++;
		}
		for (int lenPref = pi.length-1; lenPref>0 ; lenPref--) {
			ans[pi[lenPref-1]]+=ans[lenPref];
		}
		for (int i = 0; i < ans.length; i++) {
			ans[i]++;
		}
		return ans;




	}
	static int[] failureFunc(String pat){
		int[] longestPrefix=new int[pat.length()];
		
		for (int i = 1,k=0; i < longestPrefix.length; i++) {
		while(k>0&&pat.charAt(k)!=pat.charAt(i))
			k=longestPrefix[k-1];
		
		
		if(pat.charAt(k)==pat.charAt(i))
			longestPrefix[i]=++k;
		else
			longestPrefix[i]=k;
		}
		System.out.println(Arrays.toString(longestPrefix));
		return longestPrefix;
	}
	
    static void KMPfunc(String str,String pat){
    	
    	int n=str.length();
    	int m=pat.length();
    	int longestPrefix[]=failureFunc(pat);
    	for (int i = 0,k=0; i < n; i++) {
    		while(k>0&&pat.charAt(k)!=str.charAt(i))
    			k=longestPrefix[k-1];
    		
    		
    		if(pat.charAt(k)==str.charAt(i))
    			++k;
    		
    		if(k==m)
    		{	System.out.println(i-m+1+"\n");
    		//how many matches
    		// fail to the best
    		k=longestPrefix[k-1];
    		}
    	}	
    }
    
	
    
    public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);

		//KlMPfunc(c1, c2);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		char c[]=(s1).toCharArray();
		System.out.println(c.length);
		prefixFunction(c);
		//prefixFunction(c2);

	}
    
    static class Trie{
    	static Node root;
    	///suffix trie
    	public Trie (String s){
			for (int i = 0; i <s.length() ; i++) {
				put(s,i);
			}


		}
    	static void put(String s,int i){
    		Node cur=root;
			for (int j = i; j <s.length() ; j++) {
					Node nxt=cur.next[s.charAt(j)-'a'];
					if(nxt==null)
					nxt=new Node(j==s.length());
					else
						nxt.cnt++;
					cur=nxt;
			}

		}

		static boolean search(String s){
			Node cur=root;
			for (int j = 0; j <s.length() ; j++) {
				Node nxt=cur.next[s.charAt(j)-'a'];
				if(nxt==null)
					return false;
				cur=nxt;
			}
			return true;
		}
		static int findOCC(String s){
			Node cur=root;
			int cnt;
			for (int j = 0; j <s.length() ; j++) {
				Node nxt=cur.next[s.charAt(j)-'a'];
				if(nxt==null)
					return 0;
				cur=nxt;
			}
			return cur.cnt;
		}

		static class Node{
			int cnt;
			Node[] next;
			boolean end;
			public Node(boolean end){
				next=new Node[26];
				this.end=end;
			}


		}
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
