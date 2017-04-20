package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/29/2017.
 */
public class CesarLegion {

    static int n1,n2,k1,k2,mem[][][][];
    static final int mod=(int )1e8;

    static int solve(int i1,int w, int num1,int num2){
     //   System.out.println(i1+" "+w+" "+num1+" "+num2);
        if(num1==n1&&num2==n2){
            return 1;
        }
        if(mem[i1][w][num1][num2]!=-1)return mem[i1][w][num1][num2];

        int ans=0;
        if(num1<n1){
            if(w==0&&i1<k1) //k1
                ans+=solve(i1+1,0,num1+1,num2);
            ans%=mod;
            if(w==1&&k1>0){
                ans+=solve(1,0,num1+1,num2);

            }
            ans%=mod;

        }if(num2<n2){
            if(w==1&&i1<k2) //k1
                ans+=solve(i1+1,1,num1,num2+1);
            ans%=mod;
            if(w==0&&k2>0){
                ans+=solve(1,1,num1,num2+1);

            }
            ans%=mod;

        }
        return mem[i1][w][num1][num2]=ans%mod;

    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        n1=sc.nextInt();
        n2=sc.nextInt();
        k1=sc.nextInt();
        k2=sc.nextInt();
        mem=new int [Math.max(k1,k2)+1][2][n1+n2+1][n1+n2+1];
        for (int i = 0; i <mem.length ; i++) {
            for (int j = 0; j <mem[i].length ; j++) {
                for (int k = 0; k <mem[i][j].length ; k++) {
                    Arrays.fill(mem[i][j][k],-1);
                }
            }
        }
        int ans=solve(0,0,0,0);

        System.out.println(ans);




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
