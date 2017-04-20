package graphs;

/**
 * Created by moham on 1/31/2017.
 */


import java.io.*;
import java.util.*;

public class CFKefaandPark {

    static int cats[];
    static ArrayList<Integer> adjList[];
    static int ans;
    static int m;

    static void dfs(int u ,int num)				//O(V + E) adjMat, O(V^2) adjMat
    {
        int consec=cats[u]+num;
        if(consec>m){
            return;
        }
        if(cats[u]==0)
            consec=0;
        if(adjList[u].isEmpty())
            ans++;
        for (int v : adjList[u])
        {
            dfs(v,consec);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int n=sc.nextInt();
         m=sc.nextInt();
        cats=new int[n];
        adjList=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            adjList[i]=new ArrayList<>();
        }
        for (int i = 0; i <n ; i++) {
            cats[i]+=sc.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            adjList[Math.min(u,v)].add(Math.max(v,u));
        }
        dfs(0,0);

        System.out.println(ans);


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

