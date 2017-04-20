package General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class bicoloring {
	static int[] color;
	static boolean bipartitieCheck(int u)
	{
		for(int v: adjList[u])
			if(color[v] == -1)
			{
				color[v] = 1 ^ color[u];
				if(!bipartitieCheck(v))
					return false;
			}
			else
				if(color[v] == color[u])
					return false;
		return true;
	}



	
	static ArrayList<Integer>[] adjList;
	
	static int V;
	

	


public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out=new PrintWriter(System.out); 
	
	while (true){
	
	int n=Integer.parseInt(br.readLine());
	if(n==0)break;
	int l=Integer.parseInt(br.readLine());
	
	 adjList=new ArrayList[n]; 
	color=new int [n];
	Arrays.fill(color, -1);
	 V=n;
	 
	for (int i = 0; i < n; i++) {
		adjList[i]=new ArrayList<Integer>();
	}
	 
	 for (int i = 0; i < l; i++) {
		String r[]=br.readLine().split(" ");
		int a=Integer.parseInt(r[0]);
		int b=Integer.parseInt(r[1]);
		adjList[a].add(b);
		adjList[b].add(a);
		
	}
	 
	
	boolean rm=bipartitieCheck(0);
	
	 if(rm)
		 out.println("BICOLORABLE.");
	 else
		 out.println("NOT BICOLORABLE.");
	 
	
	}
	out.flush();

}

}
