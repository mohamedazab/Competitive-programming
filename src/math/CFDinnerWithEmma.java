package math;

/**
 * Created by moham on 1/30/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class CFDinnerWithEmma {



    static long gcd(long n, long m) {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb=new StringBuilder("");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int max=-1;
        for (int i = 0; i < a; i++) {
            int min2=(int)1e9+2;
            for (int j = 0; j <b ; j++) {
               min2=Math.min(min2,sc.nextInt());
            }
            max=Math.max(min2,max);
        }
        out.println(max);

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
