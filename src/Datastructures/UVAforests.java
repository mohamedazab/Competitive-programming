package Datastructures;

/**
 * Created by moham on 2/5/2017.
 */


import java.io.*;
import java.util.*;

public class UVAforests {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int cases = sc.nextInt();
        //sc.nextLine();
        while (cases-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int[][] observaationList = new int[p + 1][q + 1];
            for (int i = 0; i <= p; i++) {
                observaationList[i] = new int[q + 1];
            }
            while (true) {
                String s = sc.nextLine();
                if (s==null||s.isEmpty()) break;
                String k[] = s.split(" ");
                int person = Integer.parseInt(k[0]);
                int tree = Integer.parseInt(k[1]);
                observaationList[person][tree] = 1;

            }
            UnionFind opinions=new UnionFind(p);
            //System.out.println(Arrays.deepToString(observaationList));

            for (int i = 1; i < observaationList.length; i++) {

                for (int j = i + 1; j < observaationList.length; j++) {
                    boolean same = true;
                    for (int k = 1; k < q + 1; k++) {
                        if (observaationList[i][k] != observaationList[j][k]) {
                            same = false;
                            break;
                        }
                    }
                    if (same) opinions.unionSet(i-1,j-1);
                }

            }
            out.println(opinions.numSets);
            if (cases != 0) out.println();

        }

        out.flush();
    }

    static class UnionFind {
        int[] p, rank, setSize;
        int numSets;
        public UnionFind(int N) {
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            numSets = N;
            for (int i = 0; i < N; i++) {
                p[i] = i;
                setSize[i] = 1;
            }
        }

        public int findSet(int i) {
            if (p[i] == i) return i;
            else return p[i] = findSet(p[i]);
        }

        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) {
                p[y] = x;
                setSize[x] += setSize[y];
            } else {
                p[x] = y;
                setSize[y] += setSize[x];
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize[findSet(i)];
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

