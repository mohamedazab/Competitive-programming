package math;

/**
 * Created by moham on 1/30/2017.
 */


import java.io.*;
import java.util.*;

public class CFroundTableKnights {


    static ArrayList<Integer> primes;
    static int[] isComposite;
    static void sieve(int N)	// O(N log log N)
    {

        isComposite = new int[N+1];
        isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
        primes = new ArrayList<>();

        for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N))
            if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
            {

                primes.add(i);
                if(1l * i * i <= N)
                    for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
                        isComposite[j] = 1;
                if(primes.size()>51)return;
            }
    }


    static long gcd(long n, long m) {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb=new StringBuilder("");
      // int n=sc.nextInt();
      /* int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        boolean yess=false;
        TreeMap<Integer,Integer>tr=new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            int nxt=i;
            for (int j = nxt+1; j < arr.length; j++) {
                if(arr[j]==1){
                    nxt=j;
                    break;
                }
            }
            if(nxt==i)break;
            if(tr.containsKey(nxt-i))
            tr.put(nxt-i,tr.get(nxt-i)+1);
            else tr.put(nxt-i,1);

            if(tr.get(nxt-i)>1){
                yess=true;
                break;
            }
            i=nxt-1;
        }
       // System.out.println(Arrays.toString(arr));
        //System.out.println(tr.toString());

        out.print(yess?"YES":"NO");*/

        out.flush();


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
