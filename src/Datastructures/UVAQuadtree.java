package Datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class UVAQuadtree {

	
	static int div;
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out); 
		Scanner sc = new Scanner(System.in);
		int cases=Integer.parseInt(sc.nextLine());
		while(cases-->0){
		String t1=sc.nextLine();
		String t2=sc.nextLine();
	
		tree tr1=new tree(t1);
//System.out.println(tr1.print(tr1.root1));
		tree tr2=new tree(t2);
		int x=tr1.addtree(tr2);
		out.printf("There are %d black pixels.\n",x);
		
		}
		out.flush();
		
		

	}
	static class tree{
		node root1;
		static String s1;
		
		public tree(String sr) {
			s1=sr;
			
			if(!s1.isEmpty())
			
			
				construct1();

			
			
		}
		
		public int addtree(tree t1){
			return addnode(root1,t1.root1,32);
			
			
		}
		
		public String  print(node n){
			String r1="";
			if(n==null)return " null ";
			if(n.c=='p'){
				
				r1+=n.c+" childrens "+print(n.n1)+print(n.n2)+print(n.n3)+print(n.n4)+"\n";
				
				
			}
			else
				r1=" "+n.c+" ";
			return r1;
			
			
		}
		public int addnode(node n1,node n2,int di){
			if(n1==null&&n2==null)return 0;
			if(n1==null&&n2!=null)
				return nodev(n2,di);
			if(n1!=null&&n2==null)
				return nodev(n1,di);
			
			//System.out.println(n1.c+" and "+n2.c);
			if(n1.c=='e'&&n2.c=='e')
				return 0;
			if(n1.c=='f'||n2.c=='f')
				return di*di;	
			if(n1.c=='p'||n2.c=='p'){
				
				int x1=addnode(n1.n1,n2.n1,di/2);
				int x2=addnode(n1.n2,n2.n2,di/2);
				int x3=addnode(n1.n3,n2.n3,di/2);
				int x4=addnode(n1.n4,n2.n4,di/2);
				return x1+x2+x3+x4;
				
			}
			return 0;	
			
		
			
		}
		private int nodev(node n2, int di) {
			if(n2==null)return 0;
			if(n2.c=='f')return di*di;
			if(n2.c=='e')return 0;
			if(n2.c=='p'){
				
				int m1=nodev(n2.n1, di/2);
				int m2=nodev(n2.n2, di/2);
				int m3=nodev(n2.n3, di/2);
				int m4=nodev(n2.n4, di/2);
				return m1+m2+m3+m4;
			}
			return 0;
		}
public void construct1(){
	
	
	if(s1.charAt(0)=='p')
	{ 
		root1=new node('p');
	s1=s1.substring(1);
	root1.n1=construct();
	s1=s1.substring(1);;
	root1.n2=construct();
	s1=s1.substring(1);
	root1.n3=construct();
	s1=s1.substring(1);
	root1.n4=construct();
	if(!s1.equals(""))
	s1=s1.substring(1);
		
		
		
		
	}
	else
		{
		root1=new node(s1.charAt(0));
		}
	
}
		public node construct(){
			if(s1.equals(""))return null ;
			node prev1=null;
		if(s1.charAt(0)=='p')
		{ 
		 prev1=new node('p');
		s1=s1.substring(1);
		prev1.n1=construct();
		
		prev1.n2=construct();
		
		prev1.n3=construct();
		
		prev1.n4=construct();
		
			
			
			
			
		}
		else
			{
			prev1=new node(s1.charAt(0));
			s1.substring(1);
			}
return prev1; 
		
	
		}
		
	}
	
	static class node{
	node	n1,n2,n3,n4;
	char c;
	
	public node(char c) {
		this.c=c;
		
	}
	public node(char c,node n1,node n2,node n3 ,node n4) {
		this.c=c;
		this.n1=n1;this.n2=n2;this.n3=n3;this.n4=n4;
		
		
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
