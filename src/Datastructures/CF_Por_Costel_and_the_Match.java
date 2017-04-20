package Datastructures;

/**
 * Created by moham on 2/2/2017.
 */


import java.io.*;
import java.util.*;

public class CF_Por_Costel_and_the_Match {
    static int []op;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("meciul.in"));
        PrintWriter out = new PrintWriter("meciul.out");
        StringBuilder sb = new StringBuilder("");
        int t=sc.nextInt();
        while (t-->0){
        int n=sc.nextInt();
        int m=sc.nextInt();
        UnionFind setI=new UnionFind(n);
        op=new int[n];
        Arrays.fill(op,-1);
        while (m-->0){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            if(setI.isSameSet(a,b)){
                out.println("NO");
            }else {
                if(op[a]!=-1){
                    setI.unionSet(b,op[a]);

                }else op[a]=b;
                if(op[b]!=-1){
                    setI.unionSet(a,op[b]);
                }else op[b]=a;


                out.println("YES");

            }

            }
        }
        out.flush();
    }


   static class UnionFind {
        int[] p, rank, setSize;
        int numSets;

        public UnionFind(int N)
        {
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            numSets = N;
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
        }

        public int findSet(int i)
        {
            if (p[i] == i) return i;
            else return p[i] = findSet(p[i]);
        }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j)
        {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
            else
            {	p[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() { return numSets; }

        public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(File x) throws FileNotFoundException{	br = new BufferedReader(new FileReader(x));}

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

