package Datastructures;

/**
 * Created by moham on 2/6/2017.
 */


import java.io.*;
import java.util.*;

public class HRcutTheTree {

    static int n;
    static int nodesValues[];
    static ArrayList[]adjList;
    static long[]subtreeSum;
    static void compute_Sub_Tree_Sum(int n){
        adjList=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            adjList[i]=new ArrayList(n-1);
        }
        compute(0);


    }
    static int compute(int node){
        int my=nodesValues[node];
        int sum=0;
       for (int  i=0;i<adjList[node].size();i++){
           sum+=compute((int)adjList[node].get(i));
       }
       subtreeSum[node]=my+sum;
        return my+sum;
    }



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");


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

