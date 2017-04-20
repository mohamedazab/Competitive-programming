package DP;

public class TravelingSalesMan {

	
	static int dist[][];//distance from to 
	static int n;
	static int mem[][];
	//mask &(1<<i)==(1<<i) bit i is on
	//mask|=(1<<j) set bit j to 1
	//mask&=~(1<<i)set bit i to 0
	//all done mask =2^n-1 or (1<<n-1)
	public int tsp(int mask,int pos){
		if(mask==(1<<n)-1)
			return 0;
		
		if(mem[pos][mask]!=-1 )return mem[pos][mask];
		int r=(int)1e9;
		for (int i = 0; i <n; i++) {
			if((mask&1<<i)==0)r=Math.min(r, tsp(mask|1<<i,i ));
		}
		return mem[pos][mask]=r;
		
	}
	
	
	public static void main(String[] args) {
		
		
		
	}

}
