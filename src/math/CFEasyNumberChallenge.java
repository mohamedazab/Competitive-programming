package math;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
/**
 * Created by moham on 1/30/2017.
 */

public class CFEasyNumberChallenge {


    static ArrayList<Integer> primes;
    static int[] isComposite;
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


   static  long numDiv(long N) {
        int PF_idx = 0;
        long PF = primes.get(PF_idx), ans = 1;
        while (N != 1 && (PF * PF <= N)) {
            long power = 0;
            while (N % PF == 0) { N /= PF; power++; }
            ans *= (power + 1);
            PF = primes.get(++PF_idx);
        }
        if (N != 1) ans *= 2;
        return ans;
    }

    static long []val;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int mod=(1<<30);
        int ans=0;
        val=new long[a*b*c+1];
        sieve(a*b*c+1);
        //val[1]=1;
        for (int i = 1; i <=a ; i++) {
            for (int j = 1; j <=b ; j++) {
                for (int k = 1; k <=c ; k++) {
                    if(val[i*j*k]==0)
                    {
                        val[i*j*k]=numDiv(i*j*k);
                    }
                ans+=val[i*j*k];

                ans%=mod;
                }
            }
        }

        System.out.println(ans);


    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(File x) throws FileNotFoundException {	br = new BufferedReader(new FileReader(x));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }

}

