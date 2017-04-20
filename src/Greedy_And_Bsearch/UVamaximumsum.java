package Greedy_And_Bsearch;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by moham on 1/23/2017.
 */
public class UVamaximumsum {


 public static void main(String[]args)throws Throwable{

     Scanner sc=new Scanner(System.in);
     PrintWriter out=new PrintWriter(System.out);
     while(true){
         int n=sc.nextInt();
         if(n==0)break;
         ArrayList<Integer>arr=new ArrayList<>();
         for (int i = 0; i <n ; i++) {
             arr.add(sc.nextInt());
         }
        int max=0;
         boolean haszeros=false;
         int maxneg=-11111111;
         ArrayList<Integer>sol=new ArrayList<>(n);
         for (int i = 0; i <n ; i++) {
             if(arr.get(i)>0)sol.add(arr.get(i));
             if(arr.get(i)<0)maxneg=Math.max(maxneg,arr.get(i));
             if(arr.get(i)==0)haszeros=true;
         }
         StringBuilder sb=new StringBuilder("");
         if(sol.size()>0){
             for (int i = 0; i <sol.size() ; i++) {
                 sb.append(sol.get(i)+" ");
             }
             out.println(sb.substring(0,sb.length()-1));

         }else
             if(haszeros)out.println(0);
         else out.println(maxneg);



     }
     out.flush();

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
