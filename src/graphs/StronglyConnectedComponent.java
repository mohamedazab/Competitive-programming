package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {

	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static int[] findSCC;
	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		
		for(int v: adjList[u])
		{
		 	if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u])
		{
			//SCC
			while(true)
			{
				int v = stack.pop();
				inSCC[v] = true;
				findSCC[v] = SCC;
				if(v == u)
					break;
			}
			SCC++;
		}
		
		
	}
	
	static void tarjanSCC()
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
			
	}
	
}
