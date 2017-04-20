package General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA10583UbiquitousReligions {

	


		static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
		static ArrayList<Integer>[] adjList;
		static boolean[] visited;
		static int V;
		static int count;

		
		public static void preTraversal() 
		{

			for(int i = 0; i < V; ++i)		//non-connected
				if(!visited[i])
					{count++;
					dfs(i);					//or bfs
					}
		}
		
//		1.Depth-First Search (DFS)
		static void dfs(int u)				//O(V + E) adjList, O(V^2) adjMat	
		{
			visited[u] = true;

			//for adjacency list
			for(int v: adjList[u])
				if(!visited[v])
					dfs(v);

			
		}
		

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out); 
		int cases=1;
		while (true){
		String r[]=br.readLine().split(" ");
		int n=Integer.parseInt(r[0]);
		int m=Integer.parseInt(r[1]);
		if(n==0&&m==0)break;
		 adjList=new ArrayList[n]; 
		 visited=new boolean[n];
		 V=n;
		 count=0;
		for (int i = 0; i < n; i++) {
			adjList[i]=new ArrayList<Integer>();
		}
		 
		 for (int i = 0; i < m; i++) {
			 r=br.readLine().split(" ");
			int a=Integer.parseInt(r[0])-1;
			int b=Integer.parseInt(r[1])-1;
			adjList[a].add(b);
			adjList[b].add(a);
			
		}
		 preTraversal();
		out.printf("Case %d: %d\n", cases++,count);
		
		
		}
		out.flush();

	}

}
