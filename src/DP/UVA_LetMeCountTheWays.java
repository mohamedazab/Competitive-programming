package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/23/2017.
 */
public class UVA_LetMeCountTheWays {

    static int n,coins[]={1,5,10,25,50};
    static long mem[][];

    static void solveE(){
      Arrays.fill(mem[0],1);

        for (int coin = 1; coin <30001 ; coin++) {
            for (int j = 0; j < 5; j++) {
                if(j>0){
                    mem[coin][j]=mem[coin][j-1];
                }
                if(coin-coins[j]>=0){
                    //System.out.println(coin+" "+(coin-coins[j]));
                    mem[coin][j]+=mem[coin-coins[j]][j];
                }
            }
        }
        //System.out.println(Arrays.deepToString(mem));



    }
    public static long solve(int rem,int idx){
      //  System.out.println(rem+" "+idx);
        if(rem==0)return 1;
        if(idx==5||rem<coins[idx])return 0;
        if(mem[rem][idx]!=-1)return mem[rem][idx];
        long cnt=solve(rem,idx+1);


        return mem[rem][idx]=cnt+solve(rem-coins[idx],idx);

    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        StringBuilder sb=new StringBuilder();
        mem=new long[30000+1][5];
        solveE();
        while(sc.ready()){
        n=sc.nextInt();
       // if(n==0)break;

        //for(long[]x:mem)Arrays.fill(x, -1);
        long ans=mem[n][4];
        sb.append((ans>1?"There are "+ans+" ways to produce "+n+" cents change.\n":"There is only "+ans+" way to produce "+n+" cents change.\n"));
        }
        out.print(sb);
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
