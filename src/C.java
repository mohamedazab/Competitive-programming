
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;



public class C {
	static long vertex;
	static int f(long n,long x){
		BigInteger ans=BigInteger.ONE;
		if(x<vertex)ans=new BigInteger(n+"");
		else {
			long tmp=x-vertex+1;
			BigInteger m1=new BigInteger(tmp+"");
			BigInteger m2=new BigInteger((tmp+1)+"").multiply(m1).divide(new BigInteger(2+""));
			ans=new BigInteger(n+"").subtract(m2);
			//System.out.println("search "+ans+" "+m2);
			ans.subtract(new BigInteger(x+""));
			System.out.println( );
		}
		//System.out.println(n+" "+m+" "+x);
		System.out.println(x+"  min "+ans);
		//return (int) ans;
		if(ans.compareTo(BigInteger.ZERO)<0)return -1; //ended already get smaller day
		if(ans.compareTo(BigInteger.ZERO)==0)return 0;
		return 1;
	}

	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);


		long n=sc.nextLong();
		long k=sc.nextLong();

		long ans=0l;
		long n1=n;
		 vertex=k+2;
		/*for (long i = 1; i <=100000000000l ; i++) {
			//System.out.println("hi "+" "+i+" "+n1+" "+(f(n,i)));
			n1-=i;


			if(n1<=0){
				f(n,i);
				ans=i;break;
			}

			n1=Math.min(n,n1+k);
		}*/

		long low=1l;
		long hi=n;
		while(low<=hi){
			long mid=(long)(low+hi)/2l;
			System.out.println("going "+hi+" "+low+" "+mid);
			int ar=f(n,mid);
			//System.out.println(ar);

			if(ar<0){
				hi=mid-1l;
				System.out.println("**** bigger");
			}
			else {
				if(ar==0){
					//System.out.println("ibroke");
					break;
				}
				System.out.println("***** smaller");
				low=mid+1l;
			}
		}



		System.out.println(low);

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