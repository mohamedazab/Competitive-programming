package Greedy_And_Bsearch;

/**
 * Created by moham on 2/12/2017.
 */


import java.io.*;
import java.util.*;
public class UVA_bitmask {

    public static int convert(char[] s){

        int ans=0;
        int cnt=0;
        for (int i = s.length-1; i >=0 ; i--) {
         ans+= Math.pow(2,cnt)*(s[i]=='0'?0:1);
         cnt++;
        }
        return ans;
    }
   static int check(char[] s1,char[] s2){///s1>s2

        for (int i = 0; i <s1.length ; i++) {
            if(s1[i]!=s2[i])return s1[i]==0?1:-1;
        }
        return 0;
    }
    static char[] pad(String s,int n){

       while(s.length()<n){
           s="0"+s;
       }
       return s.toCharArray();

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int n=sc.nextInt();
        int l=sc.nextInt();
        int u=sc.nextInt();
        char[] max=Integer.toBinaryString(u).toCharArray();
        char[] min=Integer.toBinaryString(l).toCharArray();
        char[] nS=Integer.toBinaryString(n).toCharArray();
        String maxS=Integer.toBinaryString(u);
        String minS=Integer.toBinaryString(l);
        String nns=Integer.toBinaryString(n);
        int maxlen=Math.max(Math.max(max.length,min.length),nS.length);
        max=pad(Integer.toBinaryString(u),maxlen);
        nS=pad(Integer.toBinaryString(n),maxlen);
        min=pad(Integer.toBinaryString(l),maxlen);

        char[] ans=max.clone();
        for (int i = 0; i<maxlen; i++) {
        if(nS[i]=='0'&&min[i]=='0'){
            if(convert(ans)+(int)Math.pow(2, maxlen-i-1)<=convert(max)){
                ans[i]='0';
            }

        }else {


        }

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

