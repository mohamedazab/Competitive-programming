package graphs;

/**
 * Created by moham on 1/31/2017.
 */

import java.io.*;
import java.util.*;

public class CFstreet {
    static int len,width;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int cases=sc.nextInt();
        while (cases-->0) {
            V = sc.nextInt();
            len = sc.nextInt();
            width = sc.nextInt();
            rectangle[] x = new rectangle[V];
            adjList = new ArrayList[V + 2];
            for (int i = 0; i < V + 2; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < V; i++) {
                int h = sc.nextInt();
                int w = sc.nextInt();
                int dist = sc.nextInt();
                boolean left = sc.nextInt() == 1 ? false : true;
                x[i] = new rectangle(w, h, dist, left);
                adjList[0].add(new Edge(i + 1, dist));
                adjList[i + 1].add(new Edge(V + 1, len - (h + dist)));
            }

            for (int i = 1; i <= V; i++) {
                for (int j = i + 1; j <= V; j++) {

                    adjList[i].add(new Edge(j, getDist(x[i - 1], x[j - 1])));
                    adjList[j].add(new Edge(i, getDist(x[i - 1], x[j - 1])));
                }
            }
            System.out.println(Arrays.deepToString(adjList));
            double ans=dijkstra(0, V + 1);
            out.printf("%.6f\n",ans);
        }






        out.flush();
    }
/////////////////////////////
    static double EPS=1e-7;
static double getDist(rectangle a,rectangle b){

    if(a.left==b.left||a.w+b.w-width>EPS){
        int lower=Math.max(a.lower,b.lower);
        int higher=Math.min(a.upper,b.upper);
        if(lower==higher)return 0;
        return lower-higher;
    }
    if (!notoverlap(a,b)) {
        return width-a.w-b.w;
    }
    if(a.left)return get(a,b);
        return get(b,a);
    }
///////////
static double get(rectangle a,rectangle b){
    double x1=b.leftP-a.rightP;
    double x2=-1;
    if(a.lower>b.upper+EPS){
        x2=a.lower-b.upper;

    }else x2=b.lower-a.upper;

    return Math.sqrt(x1*x1+x2*x2);



}
    //////////////////

    static boolean notoverlap(rectangle a,rectangle b){

        if(a.lower>b.upper+EPS||b.lower>=a.upper+EPS)
            return true;
        return false;

    }


    ////////////////////////
    static final int INF = (int)1e9;
    static ArrayList<Edge>[] adjList;
    static int V;
////////////////////////////////////////////
static double dijkstra(int S, int T)
{
    double[] dist = new double[V+2];
    Arrays.fill(dist, INF);
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    dist[S] = 0;
    pq.add(new Edge(S, 0));
    while(!pq.isEmpty())
    {
        Edge cur = pq.remove();
        if(cur.node == T)
            return dist[T];
        if(cur.cost > dist[cur.node]+EPS)
            continue;
        for(Edge nxt: adjList[cur.node])
            if(cur.cost + nxt.cost < dist[nxt.node])
            {
                dist[nxt.node] = cur.cost + nxt.cost;
                pq.add(new Edge(nxt.node, dist[nxt.node]));
            }

    }
    return -1;
}
//////////////////////////////////////
static class rectangle {
    int w,h,dist;
    int lower;int upper, leftP, rightP;
    boolean left;
    public rectangle(int w,int h,int dist,boolean left){
        this.w=w;this.h=h;this.left=left;this.dist=dist;
        lower=dist;upper=dist+h;
        if(left){
            leftP=0;
            rightP=w;
        }
        else {
            leftP=width-w;
            rightP=0;
        }


    }

    @Override
    public String toString() {
        return "lower "+lower+" upper "+upper+" left right "+leftP+" "+rightP;
    }
}


static class Edge implements Comparable<Edge>
{
    int node;double cost;

    Edge(int a, double b)
    {
        node = a;
        cost = b;
    }

    public int compareTo(Edge e)
    {
        if(cost > e.cost)
            return 1;
        else if(cost<e.cost)return -1;

        return node - e.node;
    }

    @Override
    public String toString() {
        return " to "+node+" cost "+cost;
    }
}
//////////////////////////////////////

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

