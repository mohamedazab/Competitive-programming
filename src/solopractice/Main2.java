package solopractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main2 {

	
static	double  rCircumCircle(double ab, double bc, double ca) {
		return ab * bc * ca / (4.0 * area(ab, bc, ca)); }
	
static	double  area(double ab,double bc,double ca)
	{
		double s = (ab + bc + ca) / 2.0;
		return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));		//take care of overflow
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(br.ready()){
		String r[]=br.readLine().split(" ");
		double a=Double.parseDouble(r[0]);
		double b=Double.parseDouble(r[1]);
		double c=Double.parseDouble(r[2]);
		
		double k=0.5*(a+b+c);
		double areatri=area(a,b,c);
		double radsm=areatri/k;
		double areasm=radsm*radsm*Math.PI;
		double radb=rCircumCircle(a,b,c);
		double areab=radb*radb*Math.PI;
		double ans1=areatri-areasm;
		double ans2=areasm;
		double ans3=areab-areatri;
		out.printf("%.4f %.4f %.4f\n", ans3,ans1,ans2);
		}
		out.flush();
		
		
		
		
		
		
	}

}
