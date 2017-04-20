package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class codeforces744C {

static int []type;
static int []RedR;
static int []bluR;
static int n;
static int sumb;
static int sumr;

static int mem[][][];//mem mask zero the rest of the othe
public static int solve(int mask,int which,int otherSoFar){

	if(mask==(1<<n)-1) return 0;
	
	if(mem[mask][which-1][otherSoFar]!=-1)return mem[mask][which-1][otherSoFar];
	int A=0;
	int B=0;
	int r=18*((int)1e7);
for (int i = 0; i <n; i++) {
	if((mask&(1<<i))==(1<<i)){
		if(type[i]==1)A++;
		else
			B++;
	}
}


for (int i = 0; i < n; i++) {
	
	if((mask &(1<<i))!=(1<<i)){
		int tmpmask=mask|(1<<i);
		int red=which==1?otherSoFar:0;
		int blue=which==2?otherSoFar:0;
		
		int redREQ=Math.max(0, red-A);
		int blueREQ=Math.max(0, blue-B);
		
		int Collect=Math.max(redREQ, blueREQ);
		int redAfter=red+Collect-redREQ;
		int blueAfter=blue+Collect-blueREQ;
		if(redAfter==0){
			r=Math.min(r, Collect+solve(tmpmask, 2, blueAfter));
		}
		if(blueAfter==0)
			r=Math.min(r, Collect)+solve(tmpmask, 1, redAfter);
		
		
		
	}
	
}

return mem[mask][which-1][otherSoFar]=r;
	
	
	
}



	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		 n=sc.nextInt();
		 type=new int[n];
		 RedR =new int[n];
		 bluR=new int[n];
		 
		 for (int i = 0; i <n; i++) {
			String s[]=sc.nextLine().split(" ");
			type[i]=s[i].charAt(0)=='R'?1:2;
			RedR[i]=Integer.parseInt(s[1]);
			bluR[i]=Integer.parseInt(s[2]);
			sumr+=Math.max(0, RedR[i]-n);
			sumb+=Math.max(0, bluR[i]-n);
			
		}
		
		 mem=new int[(1<<n)][2][n];
		 for (int i = 0; i < (1<<n); i++) {
			for (int j = 0; j < mem[i].length; j++) {
				Arrays.fill(mem[i][j], -1);
			}
		}
		int ans=Math.max(sumb, sumr);
		 if(sumb>sumr)
		 ans+=solve(0, 1, sumb-sumr);else ans+=solve(0, 2, sumr-sumb);
		
		 System.out.println(ans);
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
