package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CFshaassandlights {

	
	
	static final int  mod=1000000007;
	static int n,m;
	static ArrayList<Integer> contgZeros;
	static long[][] comb;

	static long nCr(int n , int k)
	{
		if(n < k)
			return 0;
		if(k == 0 || k == n)
			return 1;
		if(comb[n][k] != -1)
			return comb[n][k];
		if(n - k < k)
			return comb[n][k] = nCr(n, n - k)%mod;
		return comb[n][k] = nCr(n - 1, k - 1)%mod + nCr(n - 1, k)%mod;
	}
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		 m=sc.nextInt();
		 int idx=1;
		 ArrayList<Integer>zerosBetw=new ArrayList<>();
		contgZeros=new ArrayList<>();
		int nums[]=new int[m];
		comb=new long[1000][1000];
		for (long[]v:comb)Arrays.fill(v,-1);
		for (int i = 0; i <m ; i++) {
			nums[i]=sc.nextInt();

		}
		Arrays.sort(nums);

		for (int i = 0; i < m; i++) {
			int k=nums[i];
			if(i!=0){
				zerosBetw.add(k-idx-1);
				contgZeros.add(k-idx-1);
			}else {
				contgZeros.add(k-idx);
			}

			idx=k;
		}
		contgZeros.add(n-idx);
		if(n==m){
			System.out.println(1);
			return;
		}

		long ans=1;
		for (int i = 0; i <zerosBetw.size() ; i++) {

			ans=((ans%mod)*(pow(zerosBetw.get(i))%mod))%mod;
		}
		int cntZeros=contgZeros.get(0);
		for (int i = 0; i <contgZeros.size()-1 ; i++) {
			int nxt=contgZeros.get(i+1);
			ans=(ans%mod)*((nCr(cntZeros+nxt,nxt)%mod))%mod;
			cntZeros+=nxt;
		}
		System.out.println(ans);


		
		
	}
	static long pow(int k){
	long ans=1;
		for (int i = 0; i < k-1; i++) {
			ans=((ans%mod)*2)%mod;

		}return ans;
	}
	
	static	class Scanner 
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
