package DP;


import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/29/2017.
 */
public class animals {

    static int n,X,W[];
    static final int INF=(int)1e9;
    static int mem[][];

    static int solve(int idx,int x){
    if(x==0)return 0;
    if(idx>=W.length)return 0;
    //if(x<W[idx])return -INF;
    if(mem[idx][x]!=-1)return mem[idx][x];
    int ans=0;
    if(x>=W[idx])ans=1+solve(idx+1,x-W[idx]);
     ans=Math.max(ans,solve(idx+1,x));

    return mem[idx][x]=ans;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(new File("input.txt"));
        PrintWriter out=new PrintWriter(new File("output.txt"));
       // Scanner sc=new Scanner(System.in);
        // PrintWriter out=new PrintWriter(System.out);
         n=sc.nextInt();
        X=sc.nextInt();
        String a[]=sc.nextLine().split(" ");
        W=new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            W[i]=Integer.parseInt(a[i])*(n-i);
        }
      // System.out.println(Arrays.toString(W));
        mem=new int[n+1][X+1];
        for(int m[]:mem)Arrays.fill(m,-1);
       int ans= solve(0,X);
       if(ans==-INF)out.println(0);
       else
        out.println(ans);
        out.flush();
    }








    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(File x) throws FileNotFoundException{	br = new BufferedReader(new FileReader(x));}

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
