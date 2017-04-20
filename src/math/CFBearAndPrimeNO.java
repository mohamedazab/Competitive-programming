package math;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
/**
 * Created by moham on 1/30/2017.
 */

public class CFBearAndPrimeNO {


    static int[] isComposite;

    static void sieve(int N)
    {

        isComposite = new int[N+1];
        isComposite[0] = isComposite[1] = 1;
        for (int i = 2; i <= N; ++i)
            if (isComposite[i] == 0)
            {

                    for (int j = i ; j <= N; j += i)	{
                        isComposite[j] = 1;
                        save[i]+=arr[j];
                    }
            }
    }



    static int  save[];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb=new StringBuilder("");
        int n=sc.nextInt();

        arr=new int[(int)1e7+1];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()]++;
        }

        save=new int [(int)1e7+1];
        sieve((int)1e7);

        for (int i = 1; i < save.length; i++) {

            save[i]+=save[i-1];
        }


        int m=sc.nextInt();
        for (int i = 0; i <m ; i++) {
            int x1=sc.nextInt();
            int x2=sc.nextInt();
           int ans=save[Math.min(x2,(int)1e7)]-save[Math.min(x1-1,(int) 1e7)];
            sb.append(ans+"\n");

        }
        out.print(sb);
        out.flush();




    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(File x) throws FileNotFoundException {	br = new BufferedReader(new FileReader(x));}

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