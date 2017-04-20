package Datastructures;

/**
 * Created by moham on 2/14/2017.
 */




import java.io.*;
import java.util.*;

public class CFPharohsbank {

    static final int inf=-(int)1e9;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int n = sc.nextInt();
        int N = 1; while(N < n) N <<= 1; //padding

        pair[] in = new pair[N + 1];
        for(int i = 1; i <= N; i++) {
            int x = i<=n?sc.nextInt():inf;
            in[i] = new pair(x, i, i);
        }
        int pref[]=new int[n+1];
        for (int i = n-1; i >=0 ; i--) {
         pref[i]=pref[i+1]+in[i+1].val;
        }
       // System.out.println(Arrays.toString(pref));
      //  System.out.println(45);
        SegmentTree x=new SegmentTree(in,pref);
        int q=sc.nextInt();
     //   System.out.println(Arrays.toString(x.sTree));
        while (q-->0){
            int l=sc.nextInt();
            int r=sc.nextInt();
           pair ans= x.query(l,r);
           System.out.println(ans.val+" "+(ans.endidx-ans.startidx+1));

        }

        out.flush();
    }



    static class SegmentTree {

        static final int inf=-(int)1e8;

        int N,prefix[];
        pair[] array, sTree;

        SegmentTree(pair[] in,int prefix[])
        {
            array = in; N = in.length - 1;
            sTree = new pair[N<<1];
            this.prefix=prefix;
            build(1,1,N);
        }

        void build(int node, int b, int e)
        {
            if(b == e)
                sTree[node] = array[b];
            else
            {
                build(node<<1,b,(b+e)/2);
                build((node<<1)+1,(b+e)/2+1,e);

                sTree[node] = getbest(sTree[node<<1],sTree[(node<<1)+1]);
               System.out.println("p"+sTree[node]+" l "+" r "+sTree[node<<1]+sTree[(node<<1)+1]);

            }
        }



        pair query(int i, int j)
        {
            return query(1,1,N,i,j);
        }

        pair query(int node, int b, int e, int i, int j)
        {
            if(i>e || j <b)
               return new pair(inf,b,e);
            if(b>= i && e <= j)
                return sTree[node];
            pair q1 = query(node<<1,b,(b+e)/2,i,j);
            pair q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
            return getbest(q1,q2);

        }
        pair getbest(pair a ,pair b)
        {
            if(a.val<=inf)return b;
            if(b.val<=inf)return a;
            if(b.endidx>=prefix.length){
                a.val=inf;
                return a;
        }

            int checkdiff=prefix[a.endidx]-prefix[b.startidx-1];
            int candidateStart=a.endidx+1;int candidateEnd=b.startidx-1;
            if(a.val>=0){
                checkdiff+=a.val;
                candidateStart=a.startidx;
            }else{
                candidateStart++;
            }
            if(b.val>=0){
                checkdiff+=b.val;
                candidateEnd=b.endidx;
            }else candidateEnd--;
            pair nr=new pair(checkdiff,candidateStart,candidateEnd);
            if(candidateEnd<candidateStart)nr.val=inf;
            pair arr[]={nr,a,b};
            Arrays.sort(arr);
            return arr[2];

        }

    }

   static class pair implements Comparable<pair>{
       int val,startidx,endidx;
       public pair(int a,int b,int c){
           val=a;
           startidx=b;
           endidx=c;
       }

       @Override
       public int compareTo( pair o) {
        if(val==o.val)return (endidx-startidx)-(o.endidx-o.startidx);
          // if(val==o.val)return startidx-o.startidx;
        return val-o.val;
       }

       @Override
       public String toString() {
           return "{"+val+" "+startidx+" "+endidx+"}\n";
       }
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

