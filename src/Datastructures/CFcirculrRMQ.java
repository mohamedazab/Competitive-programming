package Datastructures;

/**
 * Created by moham on 2/2/2017.
 */


import java.io.*;
import java.util.StringTokenizer;

public class CFcirculrRMQ {
    static int n;
    static int INF=(int)1e9;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int n = sc.nextInt();
        int N = 1; while(N < n) N <<= 1;
        long[] in = new long[N + 1];
        for(int i = 1; i <= n; i++)
            in[i] = sc.nextInt();
        for(int i = n+1; i <=N; i++)
            in[i] = INF;
        SegmentTree seg=new SegmentTree(in,n);
        int q=sc.nextInt();
        while (q-->0){

            String sr[]=sc.nextLine().split(" ");
            int left=Integer.parseInt(sr[0])+1;
            int right=Integer.parseInt(sr[1])+1;

            if(sr.length==2){
                out.println(seg.query(left,right));
            }else{
                seg.update_range(left,right,Integer.parseInt(sr[2]));
            }

        }

        out.flush();
    }

    static class SegmentTree {

        int N;
        long[] array, sTree, lazy;
        static int n;
        SegmentTree(long[] in,int rn) {
            array = in;
            N = in.length - 1;
            n=rn;
            sTree = new long[N << 1];
            lazy = new long[N << 1];
            build(1, 1, N);
        }

        void build(int node, int b, int e) {
            if (b == e)
                sTree[node] = array[b];
            else {
                build(node << 1, b, (b + e) / 2);
                build((node << 1) + 1, (b + e) / 2 + 1, e);
                sTree[node] = Math.min(sTree[node << 1], sTree[(node << 1) + 1]);
            }
        }


        void update_point(int index, int val) {
            index += N - 1;
            sTree[index] += val;
            while (index > 1) {
                index >>= 1;
                sTree[index] = Math.min(sTree[index << 1], sTree[(index << 1) + 1]);
            }
        }


        void update_range(int i, int j, int val) {

            int left = i;
            int right = j;
            if (left > right)
            {
                update_range(1,1,N,left, n,val);
                update_range(1,1,N,1, right,val);
            }else
                update_range(1, 1, N, i, j, val);
        }

        void update_range(int node, int b, int e, int i, int j, int val) {
            if (i > e || j < b)
                return;
            if (b >= i && e <= j) {
                sTree[node] += val;
                lazy[node] += val;
            } else {
                propagate(node, b, e);
                update_range(node << 1, b, (b + e) / 2, i, j, val);
                update_range((node << 1) + 1, (b + e) / 2 + 1, e, i, j, val);
                sTree[node] = Math.min(sTree[node << 1], sTree[(node << 1) + 1]);
            }

        }

        void propagate(int node, int b, int e) {
            int mid = (b + e) / 2;
            lazy[node << 1] += lazy[node];
            lazy[(node << 1) + 1] += lazy[node];
            sTree[node << 1] += lazy[node];
            sTree[(node << 1) + 1] +=lazy[node];
            lazy[node] = 0;
        }

        long query(int i, int j) {
            int left = i;
            int right = j;
            if (left > right){
                return Math.min(query(1,1,N,left, n), query(1,1,N,1, right));
            }
            return query(1, 1, N, i, j);
        }

        long query(int node, int b, int e, int i, int j) {
            if (i > e || j < b)
                return INF;
            if (b >= i && e <= j)
                return sTree[node];
            propagate(node, b, e);
            long q1 = query(node << 1, b, (b + e) / 2, i, j);
            long q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
            return Math.min(q1, q2);

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

