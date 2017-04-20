package Strings;

/**
 * Created by moham on 2/1/2017.
 */


import java.io.*;
import java.util.*;

public class VasilysMultiSet {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        TreeSet<Integer>t=new TreeSet<>();
        TreeMap<Integer,Integer>occ=new TreeMap<>();
        occ.put(0,1);
        t.add(0);
        int q=sc.nextInt();
        while (q-->0){
            String s[]=sc.nextLine().split(" " );
            int x=Integer.parseInt(s[s.length-1]);
            char c=s[0].charAt(0);
          /*  System.out.println(occ.toString());
            System.out.println(t.toString());
            System.out.println("hi"+x);*/
            if(c=='+'){
                if(occ.containsKey(x)){
                    occ.put(x,occ.get(x)+1);
                }else {
                    occ.put(x,1);
                    t.add(x);
                }
            }
            if(c=='-'){
                int k=occ.get(x)-1;
                if(k==0){
                    occ.remove(x);
                    t.remove(x);
                }
            }
            if(c=='?'){
                int max=-(int)1e9;
                for (Integer m:t) {
                    max=Math.max(m^x,max);
                }
                out.println(max);
            }



        }

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

