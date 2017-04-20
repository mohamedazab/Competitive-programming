package graphs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class trafficflow {

	
	static ArrayList<Edge>[] adjList;
	static int V;
	static int min,min2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		int im=1;
		while(im<=tc){
			String sr[]=br.readLine().split(" ");
			int n=Integer.parseInt(sr[0]);
			int m=Integer.parseInt(sr[1]);
			
			adjList=new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i]=new ArrayList<Edge>();
		}
		V=n;
		TreeMap<Edge,Integer> tr=new TreeMap<Edge, Integer>();
			for (int i = 0; i < m; i++) {
				 sr=br.readLine().split(" ");
				 int x=Integer.parseInt(sr[0]);
				 int y=Integer.parseInt(sr[1]);
				int z= Integer.parseInt(sr[2]);
			//System.out.println(y+"  "+z+"hi");
			Edge q=new Edge(x,y,z);
			if(tr.containsKey(q))
			{
				tr.put(q, Math.max(tr.get(q),z));
			}
			else
				tr.put(q, z);
		
			for(Entry<Edge, Integer> entry : tr.entrySet()) {
				  Edge key = entry.getKey();
				  Integer value = entry.getValue();
                 key.cost=Math.max(key.cost, value);
				 adjList[key.from].add(key);
				}
		
		
		System.out.println(tr.toString());
			prim();
			out.printf("Case #%d: %d\n",im++,min);
			
			
			
			
			
			
			
			
		}
			
		}
		
		out.flush();
	}
	
	static double prim()
	{
		int mst = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0,0));
		int min=(int)1e9;
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(visited[cur.to])
				continue;
			visited[cur.to] = true;
			mst += cur.cost;
			if(cur.cost<min&&cur.cost!=0){
				
				min=cur.cost;
			}
			
			System.out.println(cur.cost+"  here "+min);
			for(Edge nxt: adjList[cur.to])
				if(!visited[nxt.to])
					pq.add(nxt);
		}
		
		return mst;
	}
	
	
	
	static class Edge implements Comparable<Edge>
	{
		int from;int to;int cost;
		
		Edge(int x,int a, int b)
		{from=x;
			to = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost>e.cost)return 1;
			else
				if(cost<e.cost)return -1;
			return to - e.to;
		}
		
		@Override
		public boolean equals(Object o)
		{
			Edge e=(Edge)o;
			int x1=this.from;
		int x2=this.to;
		int y1=e.from;int y2=e.to;
			
			return (x2==y2&&x1==y1)||(x1==y2&&x2==y1); 
			
		}
		
	}

	
	
	
		
		
	

}

