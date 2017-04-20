
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
      //PrintWriter out=new PrintWriter(new File("names.txt"));
      PrintWriter out=new PrintWriter(new File("playes_in.txt"));
        String names[]={"abdelrahman","Mohamed","Mahmoud","Saher","Khaled","Ibrahim","safaa","Alaa","abdelrahman2",
                "Mohamed2","Mahmoud2","Saher2","Khaled2","Ibrahim2","safaa2","Alaa2","kamal","ahmed","ayman","yasser","kareem","yosra","nour"};
        String pele ="pele";

        int mid=1;
        String round[] ={"groups","final","SimiFinal"};
        int year=0;
        int num_rating =50;
        double rating[] ={1.3,2.5,3.2,4.6,5.7,6.8,7.9,8.2,9.1,10.2,5.2,3.5,1.3};
       /*   for (int i = 0; i <2680 ; i++) {
            year+=2000;
            out.printf("INSERT INTO cup_matches VALUES(%d,'%s',%d,%d,%f);\n",mid,round[i%3],year,num_rating,rating[i%rating.length]);
            mid++;
            year++;
            year%=100;
            num_rating++;

        }*/
        int count=0;
        out.printf("INSERT INTO played_in (mid,name,year,position) VALUES");
        for (int j=0;j<names.length;j++) {
            mid=0;
            for (int i = 0; i < 2680; i++) {

                if(count==58960)break;

                    count++;
                year += 2000;
                if (count <=118) {
                    out.printf("(%d,'%s',%d,%d),\n", mid + 1, pele, year, i % 11 + 1);

                } else {
                    if(count<=58959)
                    out.printf("(%d,'%s',%d,%d),\n", mid + 1, names[j], year, i % 11 + 1);
                    else
                        out.printf("(%d,'%s',%d,%d);\n", mid + 1, names[j], year, i % 11 + 1);
                }
                year++;
                year %= 100;
                num_rating++;
                mid++;

            }

        }



        out.flush();
        out.close();



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
