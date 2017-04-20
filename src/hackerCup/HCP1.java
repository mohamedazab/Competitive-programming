package hackerCup;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class HCP1 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(new File("manic_moving.out"));
		
		int t=sc.nextInt();
		int id=1;
		while(t-->0){
			V=sc.nextInt();
			adj=new int [V][V];
			for(int i=0;i<V;i++)
				for(int j=0;j<V;j++)
					if(i==j)
						adj[i][j]=0;
					else
						adj[i][j]=inf;
			m=sc.nextInt();
			k=sc.nextInt();
			while(m-->0){
				int x=sc.nextInt()-1;
				int y=sc.nextInt()-1;
				int z=sc.nextInt();
				adj[x][y]=adj[y][x]=Math.min(adj[x][y], z);
			}
			floyd();
			s=new int [k];
			d=new int [k];
			for(int i=0;i<k;i++){
				s[i]=sc.nextInt()-1;
				d[i]=sc.nextInt()-1;
			}
			mem=new int [3][k+1];
			for(int i=0;i<3;i++)
				Arrays.fill(mem[i], -1);
			int ans=0;
			for(int i=0;i<k;i++)
				if(adj[0][s[i]]==inf || adj[0][d[i]]==inf)
					ans=-1;
			if(ans!=-1){
				for(int i=k-5;i>=0;i-=1000){
					dp(i, 0);
					dp(i, 1);
				}
				ans=adj[0][s[0]]+dp(0, 0); // 0 -->SAME NODE  1-->>PREV NODE
			}
			pw.println("Case #"+id+": "+ans);
			id++;
		}
		
		pw.flush();
		pw.close();
	}
	
	public static int dp(int i,int n){
		if(i==k-1){
			if(n==0)
				return adj[s[i]][d[i]];
			else
				return adj[d[i-1]][d[i]];
		}
		if(mem[n][i]!=-1)
			return mem[n][i];
		int ans=inf;
		if(i<k-1){
			if(n==0){				
				ans=Math.min(ans, adj[s[i]][d[i]]+adj[d[i]][s[i+1]]+dp(i+1, 0));
				ans=Math.min(ans, adj[s[i]][s[i+1]]+adj[s[i+1]][d[i]]+dp(i+1, 1));
			}else{
				ans=Math.min(ans, adj[d[i-1]][d[i]]+adj[d[i]][s[i+1]]+dp(i+1, 0));
				ans=Math.min(ans, adj[d[i-1]][s[i+1]]+adj[s[i+1]][d[i]]+dp(i+1, 1));
			}
		}
		return mem[n][i]=ans;
	}
	static boolean [] v;
	static int []s,d;
	static int inf=(int)(1e9);
	static int[][] adj;
	static int[][] p;
	static int V,m,k;
	static int [][]mem;
	
	static void floyd()
	{
		p = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				p[i][j] = i;
		
		for(int k = 0; k < V; k++)
			for(int i = 0; i < V; i++)
				for(int j = 0; j < V; j++)
					if(adj[i][j] > adj[i][k] + adj[k][j])
					{
						adj[i][j] = adj[i][k] + adj[k][j];
						p[i][j] = p[k][j];
					}
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	         try {
					br = new BufferedReader(new FileReader(new File("manic_moving.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}
