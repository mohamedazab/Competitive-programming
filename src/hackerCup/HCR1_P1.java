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



public class HCR1_P1 {

   static int N,M;
   static int pies[][];//day and pies//n*m
   static final long INF=(long)1e12;
   static long mem[][];
   public static long piesolve(int daysLeft,int have){
	   if(daysLeft<0)return 0;
	   if(have>daysLeft)return 0;
	   long r=INF;
	   if(mem[daysLeft][have]!=-1)return mem[daysLeft][have];
	    if(have>0)
		   r=Math.min(r, piesolve(daysLeft-1,have-1));
		   int today=N-daysLeft-1;
		   long sum_tobuy=0;
		//   System.out.println(daysLeft+"  "+today);
		   for (int i = 0; i <Math.min(daysLeft+1, M); i++) {
			 //  System.out.println(daysLeft+"   "+have);
			   sum_tobuy+=pies[today][i];
			r=Math.min(r,sum_tobuy+(i+1)*(i+1)+piesolve(daysLeft-1, have+i));
		//	System.out.println("r = "+r);
		   
	   }
		   return mem[daysLeft][have]=r;
	   
	   
   }
	
	public static void main(String[] args) throws IOException {		
		Scanner sc=new Scanner(new File("pie_progress.txt"));
		//Scanner sc=new Scanner(System.in);
		
		PrintWriter out=new PrintWriter(new File("HC1.txt"));
		//PrintWriter out=new PrintWriter(System.out);
		int q=sc.nextInt();
		int cases=1;
		while(cases<=q){
		N=sc.nextInt();
		M=sc.nextInt();
		pies=new int[N][M];
		for (int i = 0; i <N ; i++) {
			for (int j = 0; j < M; j++) {
				pies[i][j]=sc.nextInt();
			}
			Arrays.sort(pies[i]);
		}
		
		mem=new long[N+1][N+1];
		for(long[]v:mem)Arrays.fill(v, -1);
		out.printf("Case #%d: %d\n",cases,piesolve(N-1, 0));

		cases++;
		
		}
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
