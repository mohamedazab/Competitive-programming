package Strings;

/**
 * Created by moham on 2/1/2017.
 */


import java.io.*;
import java.util.*;

public class SpojAneedleInHayStack {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

     while (sc.ready()) {
         sb = new StringBuilder("");
         Patlen = sc.nextInt();
         String p = sc.nextLine();
         String v = sc.nextLine();
         if (p.length() > v.length()) {
             out.println();
         }
         char[] x = (p + '&' + v).toCharArray();
         prefixFunction(x);
         out.println(sb+"\n");

     }

        out.flush();
    }

    static int Patlen;
    static void  prefixFunction(char[] s){
        int n=s.length;
        int pi[]=new int[n];

        //use pi of len pat+1
        for (int i = 1,j=0; i < n; i++) {

            while (j>0&&s[i]!=s[j]){//j<=patlen
                j=pi[j-1];
            }
            if(s[i]==s[j])j++;
            pi[i]=j;//print


        }
       // System.out.println(Arrays.toString(pi));
        for (int i = Patlen+1; i < n; i++) {
          //  System.out.println(i+" "+pi[i]+"jk");
            if(pi[i]==Patlen){
                sb.append((i-Patlen-pi[i])+"\n");
            }
        }

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

