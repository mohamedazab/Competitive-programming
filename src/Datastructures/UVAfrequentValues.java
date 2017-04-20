package Datastructures;

/**
 * Created by moham on 2/5/2017.
 */


import java.io.*;
import java.util.*;

public class UVAfrequentValues {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int q = sc.nextInt();

            int N = 1;
            while (N < n) N <<= 1; //padding

            node[] in = new node[N + 1];
            for (int i = 0; i < in.length; i++) {
                in[i] = new node(INF, INF, INF, -INF, -INF, -INF);
            }

            for (int i = 0; i < n; i++) {
                int r = sc.nextInt();
                in[i + 1] = new node(r, r, r, 1, 1, 1);
            }
            SegmentTree seg = new SegmentTree(in);
            //System.out.println(Arrays.toString(seg.sTree));
            while (q-- > 0) {
                node mr = seg.query(sc.nextInt(), sc.nextInt());
                int ans = Math.max(mr.startfreq, Math.max(mr.endfreq, mr.maxfreq));
                out.println(ans);
            }
        }

        out.flush();
    }

    static class SegmentTree {

        int N;
        node[] array, sTree, lazy;

        SegmentTree(node[] in)
        {
            array = in; N = in.length - 1;
            sTree = new node[N<<1];
            for (int i = 0; i <sTree.length ; i++) {
                sTree[i]=new node(-INF,-INF,-INF,-INF,-INF,-INF);
            }
            build(1,1,N);
        }

        void build(int node, int b, int e)
        {
            if(b == e)
                sTree[node] = array[b];
            else
            {
                build(node<<1,b,(b+e)/2);
                build((node<<1)+1,(b+e)/2+1,e);
                sTree[node] = getbest(sTree[node<<1],sTree[(node<<1)+1]);
            }
        }



        node query(int i, int j)
        {
            return query(1,1,N,i,j);
        }

        node query(int node, int b, int e, int i, int j)	// O(log n)
        {
            if(i>e || j <b)
                return new node(-INF,-INF,-INF,-INF,-INF,-INF);
            if(b>= i && e <= j)
                return sTree[node];

            node q1 = query(node<<1,b,(b+e)/2,i,j);
            node q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
            return getbest(q1,q2);	/////rsq change to what is needed max min

        }

        node getbest(node node1,node node2){
            int start=node1.start;
            int end=node2.end;
            int NodeR=(node1.end==node2.start)?(node1.end):INF;
            int m= NodeR==INF?-INF:node1.endfreq+node2.startfreq;
            if(m==-INF){
                int maxfreq=Math.max(node1.maxfreq,node2.maxfreq);
                int max=-1;
                if(maxfreq==node1.maxfreq)max=node1.max;
                else max=node2.max;
                return new node(start,end,max,node1.startfreq,node2.endfreq,maxfreq);

            }else {

                int maxfreq=Math.max(node1.maxfreq,Math.max(node2.maxfreq,m));
                int max=-1;
                if(maxfreq==node1.maxfreq)max=node1.max;
                else
                    if(maxfreq==m)
                        max=NodeR;
                    else
                    max=node2.max;
                    int startfreq=node1.startfreq;
                    int endfreq=node2.endfreq;
                    if(node1.start==NodeR)startfreq=m;
                    if(node2.end==NodeR)endfreq=m;
                return new node(start,end,max,startfreq,endfreq,maxfreq);

            }


        }


    }
    static  final int INF=(int)1e6;
    static class node{
        int start,end,max,startfreq,endfreq,maxfreq;

        public node(int start,int end,int max,int startfreq,int endfreq,int maxfreq){
            this.start=start;
            this.end=end;
            this.max=max;
            this.startfreq=startfreq;
            this.endfreq=endfreq;
            this.maxfreq=maxfreq;
        }

        @Override
        public String toString() {
            return "start "+start+" "+startfreq+" end "+end+" "+endfreq+" max "+max+" "+maxfreq;
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

