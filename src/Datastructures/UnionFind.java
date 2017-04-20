package Datastructures;

//Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
public class UnionFind {                                              
	int[] p, rank, setSize;
	int numSets;
	//main sets p[i]=i
	//1l<N long power of 2
	public UnionFind(int N) 
	{
		 p = new int[N];
		 rank = new int[N];
		 setSize = new int[N];
		 numSets = N;
		 for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
	}
	
	public int findSet(int i) 
	{ 
		if (p[i] == i) return i;
		else return p[i] = findSet(p[i]);
	 }
	
	public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
	
	public void unionSet(int i, int j) 
	{ 
		 if (isSameSet(i, j)) 
			 return;
		 numSets--; 
		 int x = findSet(i), y = findSet(j);
		 // rank is used to keep the tree short
		 if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
		 else
		 {	p[x] = y; setSize[y] += setSize[x];
		 	if(rank[x] == rank[y]) rank[y]++; 
		 } 
	}
	
	public int numDisjointSets() { return numSets; }
	
	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}