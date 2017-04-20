import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main5 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		while(tc-->0)
		{
			String s = sc.next();
			int nonZero = 0;
			
			int n = sc.nextInt();
			char[] arr = new char[s.length()];
			int cc = 0;
			for(int i=nonZero;i<s.length();i++)
				arr[cc++]=s.charAt(i);
			Arrays.sort(arr);
			TreeMap<Character,Integer> s1=new TreeMap<Character,Integer>(),s2=new TreeMap<Character,Integer>();
			for (int i = 0; i < arr.length&&(s1.size())<(s.length()-n); i++) {
				
				if(s1.containsKey(arr[i]))
					s1.put(arr[i], s1.get(arr[i])+1);
				else
					s1.put(arr[i], 1);
				
				

				if(s2.containsKey(arr[arr.length-i-1]))
					s2.put(arr[arr.length-i-1], s2.get(arr[arr.length-i-1])+1);
				else
					s2.put(arr[arr.length-i-1], 1);
			}
			
			String sr1="",sr2="";
			for (int i = 0; i < s.length(); i++) {
				char c=s.charAt(i);
				if(s1.containsKey(c)){
					sr1+=c;
					int count=s1.get(c);
					if(count==1)
						s1.remove(c);
					else
						s1.put(c, count-1);
				}
				if(s2.containsKey(c)){
					sr2+=c;
					int count=s2.get(c);
					if(count==1)
						s2.remove(c);
					else
						s2.put(c, count-1);
				}
				
				
			}
	
			System.out.println("String1 "+sr1+"\n"+"String2 "+sr2);
		}
		
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
