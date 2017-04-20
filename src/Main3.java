import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main3 {

 static boolean s(int a,int b,int a1,int b1,int a2,int b2 ){
	boolean ok=true;
	 if(a1>a || a2>a || b1>b || b2>b)
			ok = false;
		else
		{
			if(a2+a1 > a)
			{
				if(b1+b2>b)
				{
					//System.out.println("dv");
					ok = false;
				}
				
			}
			
			
		}
	 return ok;

 }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = br.readLine().split(" " );

		int a =Math.max(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;
		int b = Math.min(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;


		sa = br.readLine().split(" ");
    
		int a1 =Math.max(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;
		int b1 = Math.min(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;


		sa = br.readLine().split(" ");

		int a2 =Math.max(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;
		int b2 = Math.min(Integer.parseInt(sa[0]) , Integer.parseInt(sa[1])) ;
		
		
		
	boolean ok=s(a, b, a1, b1, a2, b2)|| s(a, b, b1, a1, b2, a2)||s(a, b, a1, b1, b2, a2)||s(a, b, b1, a1, a2, b2);
	
		System.out.println(ok?"YES" :"NO");
		
		}


	
		
		
		

}