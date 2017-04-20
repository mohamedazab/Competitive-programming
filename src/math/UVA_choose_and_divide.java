
package math;

/**
 * Created by moham on 2/12/2017.
 */


import java.io.*;
import java.util.*;

public class UVA_choose_and_divide {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        while (sc.ready()){
            int p=sc.nextInt();
            int q=sc.nextInt();
            int r=sc.nextInt();
            int s=sc.nextInt();
            int arr1[]={p,r-s,s};
            int arr2[]={p-q,q,r};
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            double ans=1;
            int i=0,j=0;
            while (i!=3||j!=3){
                if(i>2)break;
                while (arr1[i]>1){
                    ans*=arr1[i];
                    arr1[i]--;

                    while(j<3&&ans>arr2[j])
                    {
                        if(arr2[j]<=1&&j<3){
                        j++;
                    }else {
                        ans/=arr2[j];
                        arr2[j]--;
                        }

                    }
                }
                i++;
            }
            for (int k = 0; k < 3; k++) {
                while (arr2[k]>1){
                    ans/=arr2[k];
                    arr2[k]--;
                }
            }

            out.printf("%.5f\n",ans);
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

