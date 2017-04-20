package math;

import java.util.ArrayList;

public class Primes {

	/*
	 * 1. Sieve of Eratosthenes: generate all primes in [2, N]
	 */
	static ArrayList<Integer> primes;
	static int[] isComposite;
	
	
	
	static long gcd(long n, long m) {
		return m == 0 ? n : gcd(m, n % m);
	}
	static int numDiffPF[];

	static void modifiedSieve(int MAX_N){
	numDiffPF=new int[MAX_N];
		for (int i = 2; i < MAX_N; i++)
			if (numDiffPF[i] == 0) // i is a prime number
			{	primes.add(i);
				for (int j = i; j < MAX_N; j += i)
					numDiffPF[j]++;
			}
	}


	static void sieve(int N)	// O(N log log N) 
	{
	    												
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
		primes = new ArrayList<Integer>();
		
	    for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
	    	if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
	    	{
	    		primes.add(i);
	    		if(1l * i * i <= N)
	    			for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
	    				isComposite[j] = 1;
	    	}   
	}
	
	/*
	 * 2. Primality Test
	 * 
	 *  Preprocessing: call sieve with sqrt(N), O(sqrt(N) log log sqrt(N))
	 *  Query: best case O(1), worst case O(sqrt(N) / log sqrt(N))
	 */
	static boolean isPrime(int N)
	{
		if(N < isComposite.length)
			return isComposite[N] == 0;
		for(int p: primes)					//may stop if p * p > N
			if(N%p==0)
				return false;
		return true;
	}
}
