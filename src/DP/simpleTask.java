package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by moham on 1/29/2017.
 */
public class simpleTask {

    static int edges[][];
    static int V,M,me;
    static long ans;
    static int cntSubtr;
    static long computed[];
    static void printm(int k){

        for (int i = 0; i <V ; i++) {
            if(((1<<i)&k)==(1<<i)) System.out.print((i+1)+" ");
        }
    }

    static long  sol(int node,int mask)				//O(V + E) adjList, O(V^2) adjMat
    {
        long ans=0;
        if(Integer.bitCount(mask)>2&&edges[node][me]==1){

                ans++;
                printm(mask);
                System.out.println("YY");


        }
        for (int i = 0; i <edges[node].length ; i++) {
            if(edges[node][i]==1&&(mask&(1<<i))==0)
              ans+=  sol(i,mask|(1<<i));
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        V=sc.nextInt();
        M=sc.nextInt();
        edges=new int[V][V];
        computed=new long[((1<<19)-1)];
        for (int i = 0; i < M; i++) {
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            edges[a][b]=1;
            edges[b][a]=1;
        }
        long k=0;
        for (int i = 0; i < V; i++) {
            me=i;
            k+=sol(i,(1<<i));
            System.out.println(k);


        }

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
