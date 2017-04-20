package hackerCup;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class HCR1_P2 {

	
	static int[][] adjMatrix;
	static int N;
	static final int INF=(int)100000000;
	static ArrayList<Pair> families;
	static int mem[][];
	static void floyd()
	{
		
		
		for(int k = 0; k < N; k++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
					{
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						
					}
	}
	public static int rec(int i,int mypos){
		

		if(i>=families.size())return 0;

		if(mem[mypos][i]!=-1)return mem[mypos][i];
		//System.out.println(i+" pos "+mypos);

		if(i<families.size()-1){
			Pair family1=families.get(i);
			Pair family2=families.get(i+1);
			int mealone=adjMatrix[mypos][family1.from]+adjMatrix[family1.from][family1.to]+adjMatrix[family1.to][family2.from]+adjMatrix[family2.from][family2.to];
			int option21=adjMatrix[mypos][family1.from]+adjMatrix[family1.from][family2.from];
			int option211=adjMatrix[family2.from][family1.to]+adjMatrix[family1.to][family2.to];

			return  mem[mypos][i]=Math.min(mealone+rec(i+1, family2.to), option21+option211+rec(i+2, family2.to));

			
		}else{
			return adjMatrix[mypos][families.get(i).from]+adjMatrix[families.get(i).from][families.get(i).to];
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner sc=new Scanner(new File("manic_moving.txt"));
		//Scanner sc=new Scanner(System.in);
		
		PrintWriter out=new PrintWriter(new File("HC3.txt"));
		//PrintWriter out=new PrintWriter(System.out);
		int q=sc.nextInt();
		int cases=1;
		while(cases<=q){
			N=sc.nextInt();
			int M=sc.nextInt();
			int K=sc.nextInt();
			adjMatrix=new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(adjMatrix[i], INF);
				adjMatrix[i][i]=0;
			}
			for (int i = 0; i < M; i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				int cost=sc.nextInt();
				adjMatrix[from-1][to-1]=cost;
				adjMatrix[to-1][from-1]=cost;
			}
			
			floyd();
			families=new ArrayList<Pair>(K);
			for (int i = 0; i <K; i++) {
				families.add(new Pair(sc.nextInt()-1, sc.nextInt()-1));
			}
			mem=new int[N+1][K+1];
			for(int[]v:mem)Arrays.fill(v,-1);
			long cost=rec(0, 0);
			
		//	System.out.println(Arrays.deepToString(adjMatrix));
			//System.out.println(cost);
			long ans=cost<INF?cost:-1;
		///	System.out.println("****************************************************");
			out.printf("Case #%d: %d\n",cases,ans);
			cases++;
			
			
			
			
			
		}
		out.flush();
		
		
		
	}
	static class Pair
	{
		int from, to;
		
		Pair(int a, int b) { from = a; to = b; }

		@Override
		public String toString() {
			return "from to "+from+"  "+to;
		}
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
