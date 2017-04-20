package math;

/**
 * Created by moham on 1/30/2017.
 */
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;



/**
 * Created by moham on 1/30/2017.
 */

public class CFpetyaAndHisFrieends {


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



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb=new StringBuilder("");
        int n=sc.nextInt();
        sieve(1000009);
        int leave=0;
       // System.out.println(primes.toString());
        if(n==2){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            BigInteger a=new BigInteger("1");
            for (int j = 0; j <n ; j++) {
                if(j==leave)continue;
               a= a.multiply(new BigInteger(primes.get(j)+""));
               // System.out.print (primes.get(j)+" ");

            }
           // System.out.println();
            leave++;
            sb.append(a+"\n");

        }
        out.print(sb);
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

