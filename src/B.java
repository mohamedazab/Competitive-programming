
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class B {




  static ArrayList<Integer> primes;
  static TreeSet<Long>Tpr;
  static int[] isComposite;




  static void sieve(int N)
  {
    Tpr=new TreeSet<>();
    isComposite = new int[N+1];
    isComposite[0] = isComposite[1] = 1;
    primes = new ArrayList<Integer>();

    for (int i = 2; i <= N; ++i)
      if (isComposite[i] == 0)
      {
        primes.add(i);
        long x=i;
        Tpr.add(x*x);
        if(1l * i * i <= N)
          for (int j = i * i; j <= N; j += i)
            isComposite[j] = 1;
      }
  }






  public  static void main (String args[])throws Exception{

    Scanner sc=new Scanner(System.in);
    PrintWriter out=new PrintWriter(System.out);
    int n=sc.nextInt();

    sieve(1000009);
    for (int i = 0; i <n ; i++) {
        long k=sc.nextLong();
      out.println(Tpr.contains(k)?"YES":"NO");
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