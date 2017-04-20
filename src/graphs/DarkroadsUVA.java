package graphs;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DarkroadsUVA {

	
	static ArrayList<Edge>[] adjList;
	static int V;
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true){
		String sr[]=br.readLine().split(" ");
		V=Integer.parseInt(sr[0]);
		int edges=Integer.parseInt(sr[1]);	
		if(V==0&&edges==0)return ;
		int tot=0;
		adjList=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i]=new ArrayList<Edge>();
		}
		
		for (int i = 0; i < edges; i++) {
			sr=br.readLine().split(" ");
			int a=Integer.parseInt(sr[0]);
			int b=Integer.parseInt(sr[1]);
			int c=Integer.parseInt(sr[2]);
			tot+=c;
			adjList[a].add(new Edge(b,c));
			adjList[b].add(new Edge(a,c));
			
			
		}
		System.out.println(tot-prim());
		
		
		}
			
						
		
		
		
	}
	
	static int prim()
	{
		int mst = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(visited[cur.to])
				continue;
			visited[cur.to] = true;
			mst += cur.cost;
			for(Edge nxt: adjList[cur.to])
				if(!visited[nxt.to])
					pq.add(nxt);
		}
		
		return mst;
	}
	
	
	
	static class Edge implements Comparable<Edge>
	{
		int to;int cost;
		
		Edge(int a, int b)
		{
			to = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return to - e.to;
		}
		
	}

	
	
	
	


}

