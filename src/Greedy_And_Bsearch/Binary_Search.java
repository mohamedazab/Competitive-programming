package Greedy_And_Bsearch;

/**
 * Created by moham on 4/8/2017.
 */


import java.io.*;
import java.util.*;

public class Binary_Search
{

    static boolean valid(long x){
        return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        long low =0;
        long high=100000000000000l;
        long ans=0;


        //get maximum
        while(high>=low){
            long mid=(high+low)/2l;
            if(valid(mid))
            {low=mid+1;
                ans=mid;
            }
            else
                high=mid-1;

        }

        out.println(ans);


        ///////////////get min
        while(high>low){
            long mid=(high+low)/2l;
            if(valid(mid))
                high=mid;
            else
                low=mid+1;
            //System.out.println(mid+" "+low+" "+high);
        }

        out.println(high);


        out.flush();
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}

