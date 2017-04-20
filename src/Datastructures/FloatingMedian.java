package Datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class FloatingMedian {
	
	static int seed, mul, add, N, K;static FenwickTree fr;
	
	
	public static void main(String[] args) {
		
		
		System.out.println(sumOfMedians(10,0,13,5,2));
	}
	
	public static long sumOfMedians(int seed,int mul,int add,int N,int K){
		
		FloatingMedian.seed=seed;FloatingMedian.mul=mul;FloatingMedian.add=add;FloatingMedian.N=N;FloatingMedian.K=K;
		
		
		
		Queue<Integer> elements=new LinkedList<Integer>();
		int count=1;
		long medians=0;
		elements.add(seed);
		fr=new FenwickTree(N);
		fr.point_update(seed, 1);
		for (int i = 1; elements.size()<K; i++) {
			int x=gen(elements.peek());
			elements.add(x);
			fr.point_update(x, 1);
			count++;
		}
		
		while(count<N){
		
		medians+=fr.findIndex((K+1)/2);
		
	int y=	elements.remove();
	
	
	fr.point_update(y, 0);
	int m=gen(y);
	elements.add(m);
	fr.point_update(m, 1);
	count++;
		
		}
	return medians;
	}
	
		
	
	public static int gen(int tk){
		
		
		return (tk*mul+add)%65536;
	}
	
	
	
static 	class FenwickTree { // one-based DS

		int n;
		int[] ft;
		
		FenwickTree(int size) { n = size; ft = new int[n+1]; }
		
		int rsq(int b) //O(log n)
		{
			int sum = 0;
			while(b > 0) { sum += ft[b]; b -= b & -b;}		//min?
			return sum;
		}
		
		int rsq(int a, int b) { return rsq(b) - rsq(a-1); }	
		
		void point_update(int k, int val)	//O(log n), update = increment
		{
			while(k <= n) { ft[k] += val; k += k & -k; }		//min?
		}

		int point_query(int idx)	// c * O(log n), c < 1
		{
			int sum = ft[idx];
			if(idx > 0)
			{
				int z = idx ^ (idx & -idx);
				--idx;
				while(idx != z)
				{
					sum -= ft[idx];
					idx ^= idx & -idx;
				}
			}
			return sum;
		}
		
		void scale(int c) {	for(int i = 1; i <= n; ++i)	ft[i] *= c;	}
		
		int findIndex(int cumFreq)
		{
			int msk = n;
			while((msk & (msk - 1)) != 0)
					msk ^= msk & -msk;			//msk will contain the MSB of n
			
			int idx = 0;
			while(msk != 0)
			{
				int tIdx = idx + msk;
				if(tIdx <= n && cumFreq >= ft[tIdx])
				{
					idx = tIdx;
					cumFreq -= ft[tIdx];
				}
				if(tIdx <= n && cumFreq <= ft[tIdx])
				{
					idx = tIdx;
					cumFreq -= ft[tIdx];
					break;
				}
				msk >>= 1;
			}
			if(cumFreq != 0)
				return idx;
			return idx;
		}
	}

}
