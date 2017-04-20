package math;

/**
 * Created by moham on 2/13/2017.
 */


import java.io.*;
import java.util.*;

public class UVA_numbermaze {



    static int R,C,maze[][];
    static int mem[][];
    static final int dx[]={1,0};//row
    static final int dy[]={0,1};//col
    static boolean valid(int row,int col){
        return row<R&&row>=0&&col<C&&col>=0;
    }

    static int solve(int r,int c){
        if(r==R-1&&C-1==c)return maze[r][c];
        //visited[r][c]=true;
        int ans=(int)1e9;
        if(mem[r][c]!=-1)return mem[r][c];
        for (int i = 0; i <2 ; i++) {

            if(valid(r+dx[i],c+dy[i])){
                {
                    ans=Math.min(ans,maze[r][c]+solve(r+dx[i],c+dy[i]));

                }

            }
        }
       // visited[r][c]=false;
        return mem[r][c]=ans;

    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int cases=sc.nextInt();
        while (cases-->0){
            R=sc.nextInt();
            C=sc.nextInt();
            maze=new int[R][C];
            mem=new int[R+1][C+1];
            for (int i = 0; i <R ; i++) {
                for (int j = 0; j <C ; j++) {
                    maze[i][j]=sc.nextInt();
                }
            }
            for (int i = 0; i <R ; i++) {
                Arrays.fill(mem[i],-1);
            }
            out.println(solve(0,0));

        }
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

