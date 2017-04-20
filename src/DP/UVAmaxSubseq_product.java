package DP;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/23/2017.
 */
public class UVAmaxSubseq_product {





    static BigInteger maxSubArraySum(BigInteger a[])
    {
        int size = a.length;
        BigInteger max_so_far = new BigInteger("-1111111"), max_ending_here = BigInteger.ZERO;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here.multiply(a[i]);
            if (max_so_far.compareTo(max_ending_here)<0)
                max_so_far = max_ending_here;
            if (max_ending_here.compareTo(BigInteger.ZERO)<0)
                max_ending_here = BigInteger.ZERO;
        }
        return max_so_far;
    }
    public static void main(String []args)throws Throwable {


        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while(sc.ready()){
        String[] s = sc.nextLine().split(" ");
        BigInteger l[] = new BigInteger[100];
        int  n = 0;
        while (true) {
            int x = Integer.parseInt(s[n]);
            if (x == -999999) break;
            l[n] = new BigInteger(x + "");
            n++;
        }
        BigInteger max = l[0];
        for (int i = 0; i < n; i++) {
            BigInteger k = l[i];
            max = k.compareTo(max) > 0 ? k : max;
            for (int j = i + 1; j < n; j++) {
                k = k.multiply(l[j]);
                max = k.compareTo(max) > 0 ? k : max;
            }
        }
        out.println(max.toString());
    }
    out.flush();
}




















    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

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
