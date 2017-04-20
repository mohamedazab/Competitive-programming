package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/29/2017.
 */
public class CFTheLeastRoundWay {

    static int n ;
    static final int INF=(int)1e9+5;
    static int table[][];
    static int table2[][];
    static int table5[][];
    static int table22[][];
    static int table55[][];
    static boolean zeroPath[][];
    static StringBuilder sb;
    static boolean z=false;

    static void path(){
        zr=table[n-1][n-1]==0?true:false;
        sb=new StringBuilder("");
        if(zeroPath[0][0])ZeroC();
        else
        if(z)
        calc5(0,0);
        else calc(0,0);
    }
    static boolean zr=false;

    static void calc(int i,int j){
        if(i>=n-1&&j>=n-1) return;
        if (table[i][j] == 0 && i <= n - 1 && j < n - 1) {
            zr = true;

        }
        if(i==n-1){
            sb.append("R");
            calc(i,j+1);
        }
        else if(j==n-1){
            sb.append("D");
            calc(i+1,j);
        }
        else {


            if (table2[i][j] == table2[i + 1][j] + table22[i][j]) {
                sb.append("D");
                calc(i + 1, j);
            } else {
                sb.append("R");
                calc(i, j + 1);
            }
        }


    }

    static void calc5(int i,int j){
        if(i>=n-1&&j>=n-1) return;
        if (table[i][j] == 0 && i <= n - 1 && j <= n - 1) {
            zr = true;

        }
        if(i==n-1){
            sb.append("R");
            calc5(i,j+1);
        }
        else if(j==n-1){
            sb.append("D");
            calc5(i+1,j);
        }
        else {

            if (table5[i][j] == table5[i + 1][j] + table55[i][j]) {
                sb.append("D");
                calc5(i + 1, j);
            } else {
                sb.append("R");
                calc5(i, j + 1);
            }
        }

    }

    static void ZeroC(){

        int i=0,j=0;
        boolean f=false;
        for ( i = 0; i <=n-1 ; i++) {
            for ( j = 0; j <=n-1; j++) {
             if(table[i][j]==0) {
                 f=true;
                 break;
             }
            }
            if(f)break;
        }
        for (int k1=0;k1<i;k1++)
            sb.append("D");
        for (int k1=0;k1<j;k1++)
            sb.append("R");
        for (int k1=i;k1<n-1;k1++)
            sb.append("D");
        for (int k1=j;k1<n-1;k1++)
            sb.append("R");


    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
         n=sc.nextInt();
        table=new int [n+1][n+1];
        table2=new int [n+1][n+1];
        table5=new int [n+1][n+1];
        zeroPath=new boolean[n+1][n+1];
        for (int i = 0; i <n+1 ; i++) {
            Arrays.fill(table5[i],INF);
            Arrays.fill(table2[i],INF);

        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                table[i][j]=sc.nextInt();
                if(table[i][j]==0)zeroPath[i][j]=true;
                table2[i][j]=getZ(table[i][j]);
                table5[i][j]=getF(table[i][j]);
            }
        }
        table22=new int[n+1][n+1];
        table55=new int[n+1][n+1];
        for (int i = 0; i <n+1 ; i++) {
            table22[i]=table2[i].clone();
            table55[i]=table5[i].clone();
        }



        z=table2[n-1][n-1]>table5[n-1][n-1]?true:false;
       for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
            if(i==n-1&&j==n-1){
                continue;
            }
                boolean r=zeroPath[i][j+1];
                boolean c=zeroPath[i+1][j];
                 table2[i][j]=table2[i][j+1]+getZ(table[i][j]);
                 table2[i][j]=Math.min(table2[i+1][j]+getZ(table[i][j]),table2[i][j]);
                 table5[i][j]=table5[i][j+1]+getF(table[i][j]);
                 table5[i][j]=Math.min(table5[i+1][j]+getF(table[i][j]),table5[i][j]);
                 if(r||c||zeroPath[i][j]){
                     if(table2[i][j]>=1&&table5[i][j]>=1){
                         zeroPath[i][j]=true;
                         table2[i][j]=1;
                         table5[i][j]=1;
                     }
                 }

                ///out of corners;
                if(table2[i][j]>table5[i][j]){
                    z=true;//represent going 5
                }else z=false;

            }

        }

        int ans=Math.min(table5[0][0],table2[0][0]);
        path();
        if(zr||zeroPath[0][0]) System.out.println(1);
        else
            out.println(ans);

        out.println(sb.toString());
        out.flush();


    }
    static void print(int x[][]){
        for (int i=0;i<x.length;i++){
            System.out.println(Arrays.toString(x[i]));
        }
    }
    public static int  getZ(int k){

        int cnt=0;
        if(k==0)return 1;
        while (k%2==0){
            cnt++;
            k/=2;
        }
        return cnt;
    }
    public static int  getF(int k){

        int cnt=0;
        if(k==0)return 1;
        while (k%5==0){
            cnt++;
            k/=5;
        }
        return cnt;
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
