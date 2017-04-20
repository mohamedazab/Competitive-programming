package math;

/**
 * Created by //mohamedAzab //.
 */

import java.io.*;
import java.util.*;

public class SoldiersAndNumberGame {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int n=sc.nextInt();
        modifiedSieve(5000001);
        for (int i = 1; i <numDiffPF.length ; i++) {
            numDiffPF[i]+=numDiffPF[i-1];
        }
        while(n-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long ans = 0;
            ans=numDiffPF[a]-numDiffPF[b];
            sb.append(ans+"\n");
        }

    out.print(sb.toString());
    out.flush();
    }

////////////////////////////////////////
    static long numDiffPF[];
    static void modifiedSieve(int MAX_N){
        numDiffPF=new long[MAX_N];
        for (int i = 2; i < MAX_N; i++)
            if (numDiffPF[i] == 0) // i is a prime number
                for (int j = i; j < MAX_N; j += i){
                    int c=j;
                    while(c%i == 0)
                    {
                        numDiffPF[j]++;
                        c/=i;
                    }
                }
    }
///////////////////////////////////////////

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

