package DP;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/30/2017.
 */
public class CFworkingOut {

    static long topL[][], buLeft[][], topR[][], buR[][];
    static int n,m,nums[][];


    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        n=sc.nextInt();
        m=sc.nextInt();
        topL =new long[n+2][m+2];
        buLeft =new long[n+2][m+2];
        topR =new long[n+2][m+2];
        buR =new long[n+2][m+2];
        nums=new int[n+2][m+2];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                nums[i][j]=sc.nextInt();
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
            topL[i][j]=Math.max(topL[i][j-1], topL[i-1][j])+nums[i][j];
            }
        }

        for (int i = n; i >=1 ; i--) {
            for (int j = 1; j<m+1; j++) {
                buLeft[i][j]=Math.max(buLeft[i][j-1], buLeft[i+1][j])+nums[i][j];
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = m; j>=1; j--) {
                topR[i][j]=Math.max(topR[i][j+1], topR[i-1][j])+nums[i][j];
            }
        }

        for (int i = n; i >=1 ; i--) {
            for (int j = m; j>=1; j--) {
                buR[i][j]=Math.max(buR[i][j+1], buR[i+1][j])+nums[i][j];
            }
        }
        long ans=0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <m ; j++) {
            long a1=topL[i][j-1]+buR[i][j+1]+topR[i-1][j]+buLeft[i+1][j];
            long a2=topR[i][j+1]+buLeft[i][j-1]+topL[i-1][j]+buR[i+1][j];
              ans=Math.max(ans,Math.max(a1,a2));

            }


        }
        System.out.println(ans);
       // print(topL);
       // System.out.println();
       // print(buR);






    }




    static void print(int x[][]){
        for (int i=0;i<x.length;i++){
            System.out.println(Arrays.toString(x[i]));
        }
    }






    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

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
