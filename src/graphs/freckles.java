package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class freckles {

	
	static ArrayList<Edge>[] adjList;
	static int V;
	
	
	static double dist(double x1,double y1,double x2,double y2){
		
		
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		while(tc-->0){
			br.readLine();
			int n=Integer.parseInt(br.readLine());
			TreeMap <Integer,pair>tr=new TreeMap<Integer,pair>();
			
			for (int i = 0; i < n; i++) {
				String sr[]=br.readLine().split(" ");
				
				tr.put(i,new pair(Double.parseDouble(sr[0]), Double.parseDouble(sr[1])));
			}
		adjList=new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i]=new ArrayList<Edge>();
		}
		V=n;
			for (int i = 0; i < n; i++) {
				pair p1=tr.get(i);
				for (int j = 0; j < n; j++) {
					if(i!=j){
						
						pair q=tr.get(j);
						adjList[i].add(new Edge(j,dist(p1.x	,p1.y, q.x, q.y)));
						
					}
				}
			}
			 DecimalFormat df = new DecimalFormat("#.00");
			
			System.out.println( df.format(prim()));
			
			if(tc!=0)System.out.println();
			
			
			
			
			
			
		}
		
		
	}
	
	static double prim()
	{
		double mst = 0;
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
		int to;double cost;
		
		Edge(int a, double b)
		{
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
		
	}

	
	
	
	
	
	static class pair 
	{
		double x;double y;
		
		pair(double a, double b)
		{
			x = a;
			y = b;
		}
		
		
		
	}

}

