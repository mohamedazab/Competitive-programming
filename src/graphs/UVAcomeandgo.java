package graphs;

/**
 * Created by moham on 2/14/2017.
 */


import java.io.*;
import java.util.*;

public class UVAcomeandgo {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        while (true){

            V=sc.nextInt();int m=sc.nextInt();
            if(V==0&&m==0)break;
            dfs_low=new int[V];
            dfs_num=new int[V];
            inSCC=new boolean[V];
            findSCC=new int[V];
            counter=0;SCC=0;
            adjList=new ArrayList[V];
            stack=new Stack<>();
            for (int i = 0; i < V; i++) {
                adjList[i]=new ArrayList<>(2000);
            }
            for (int i = 0; i <m ; i++) {
            int u=sc.nextInt()-1,v=sc.nextInt()-1,p=sc.nextInt();
            if(p==2){
                adjList[v].add(u);
            }
            adjList[u].add(v);
            }
            tarjanSCC();
            if(SCC>1)out.println(0);else out.println(1);
           // System.out.println(SCC);

        }


        out.flush();
    }

    static ArrayList<Integer>[] adjList;
    static int V, counter, SCC, dfs_num[], dfs_low[];
    static boolean[] inSCC;
    static Stack<Integer> stack;
    static int[] findSCC;
    static void tarjanSCC(int u)
    {
        dfs_num[u] = dfs_low[u] = ++counter;
        stack.push(u);

        for(int v: adjList[u])
        {
            if(dfs_num[v] == 0)
                tarjanSCC(v);
            if(!inSCC[v])
                dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
        }
        if(dfs_num[u] == dfs_low[u])
        {
            //SCC
            while(true)
            {
                int v = stack.pop();
                inSCC[v] = true;
                findSCC[v] = SCC;
                if(v == u)
                    break;
            }
            SCC++;
        }


    }

    static void tarjanSCC()
    {
        for(int i = 0; i < V; ++i)
            if(dfs_num[i] == 0)
                tarjanSCC(i);

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

