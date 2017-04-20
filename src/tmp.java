import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class tmp {

    public static void main(String[] args)throws Throwable {
        Scanner sc=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out,true);



        pw.flush();
        pw.close();
    }
  /*  static int dfs2(int i, int j)
    {
        //if(valid(i,j)&&mem[i][j]!=-1)return mem[i][j];
        grid[i][j] = 'X';
        int zr=0;
        for(int k = 0; k < 4; ++k)
        {
            int x = i + dx[k], y = j + dy[k];
            if(valid(x, y)&& grid[x][y] == '.')
                zr+=dfs2(x, y);
            else
            if(valid(x,y)&&grid[x][y]=='*')zr++;
        }
        return mem[i][j]=zr;

    }

*/


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