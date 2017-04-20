package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class HRBFS_short_reach {

	
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int q=sc.nextInt();
		while(q-->0){
		V=sc.nextInt();
		int edges=sc.nextInt();
		adjList=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i]=new ArrayList<>();
		}
		for (int i = 0; i < edges; i++) {
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adjList[u].add(new Edge(v, 6));
			adjList[v].add(new Edge(u, 6));
		}
		int s=sc.nextInt()-1;
		
	
		dijkstra(s);
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < V; i++) {
			if(i!=s)
				sb.append((dist[i]==INF?-1:dist[i])+" ");
		}
		out.println(sb.substring(0,sb.length()-1));
		}
		out.flush();
	
	}
	
	
	
	
	
	static final int INF = (int)1e9;
	static ArrayList<Edge>[] adjList;
	static int V;
	static int[] dist;
	static int dijkstra(int S)
	{
		 dist = new int[V];

		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.cost > dist[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node])
				if(cur.cost + nxt.cost < dist[nxt.node])
				{
					dist[nxt.node] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.node, dist[nxt.node]));
				}
				
		}
		return -1;
	}

	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b)
		{
			node = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
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
