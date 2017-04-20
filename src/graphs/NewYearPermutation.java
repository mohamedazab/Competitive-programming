package graphs;

/**
 * Created by moham on 1/31/2017.
 */


import java.io.*;
import java.util.*;

public class NewYearPermutation {


    static boolean  adjMat[][];
    static int V,nums[],k[],numsM[];
    static boolean visited[];
    static boolean taken[];
    static final  int INF=(int)1e9;
    static int dfs(int u)
    {
        visited[u] = true;
        int pos=INF;
        if(!taken[u])
             pos=u;
        for(int i = 0; i < V; ++i)
            if(adjMat[u][i] && !visited[i])
            {
               pos=Math.min(dfs(i),pos);
                System.out.println("now "+pos);
            }
        return pos;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");

        V=sc.nextInt();
        taken=new boolean[V];
        visited=new boolean[V];
        k=new int[V];
        nums=new int[V];
        numsM=new int[V];
        adjMat =new boolean [V][V];
        for (int i = 0; i <V ; i++) {
            adjMat[i]=new boolean[V];
        }
        for (int i = 0; i <V ; i++) {
           int r=sc.nextInt()-1;
           numsM[i]=r;
            k[r]=i;

        }




        for (int i = 0; i < V; i++) {
            String s=sc.nextLine();
            for (int j = 0; j <V ; j++) {

                boolean x=s.charAt(j)=='0'?false:true;

                adjMat[i][j]=x;
            }

        }
        System.out.println(Arrays.toString(k));
        for (int i = 0; i <V ; i++) {
            visited=new boolean[V];
            System.out.println("calling "+i+" "+k[i]);
            int r=dfs(k[i]);
           // System.out.println((i+1)+" "+r);
            taken[k[i]]=false;
            taken[r]=true;
            int tmp=k[i];
            k[i]=r;
            //swap the node with pos r
            k[numsM[r]]=tmp;

            //System.out.println("took  "+r);
            System.out.println(Arrays.toString(k));
            nums[r]=i+1;
        }
        System.out.println(Arrays.toString(nums));








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

