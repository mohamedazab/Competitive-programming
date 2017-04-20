package Geometry;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UVA587Treasure {

	private static ArrayList<String> Parse(String str) {
	    ArrayList<String> output = new ArrayList<String>();
	    Matcher match = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+").matcher(str);
	    while (match.find()) {
	        output.add(match.group());
	    }
	    return output;
	}

	
	public static pair dir(pair r,String dir){
	ArrayList<String> nums=Parse(dir);
	String num=nums.get(0);
	String dir2=nums.get(1);
	double ang=Math.cos(Math.PI/4.0);
	double xmov=ang*Integer.parseInt(num);
	double ymov=ang*Integer.parseInt(num);
	
		switch(dir2){
		case "N":
			r.y+=Integer.parseInt(num);break;
		case "S":
			r.y-=Integer.parseInt(num);break;
		case "E":
			r.x+=Integer.parseInt(num);break;
		case "W":
			r.x-=Integer.parseInt(num);break;
		
		case "NE":
			
			r.x+=xmov;
			r.y+=ymov;break;
		case "NW":
			r.x-=xmov;
			r.y+=ymov;break;
		case "SE":
			r.x+=xmov;
			r.y-=ymov;break;
		case "SW":	
		r.x-=xmov;
		r.y-=ymov;break;
		
		}
		
		
		return r;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String input="";
		
		
		
		int n=0;
		while(true){
			pair r=new pair(0,0);
			input=br.readLine();
			if(input.equals("END"))break;
			String com[]=input.split(",");
			for (int i = 0; i < com.length; i++) {
				r=dir(r,com[i]);
			}
			out.println("Map #"+(++n));
			
			double x=(double)Math.round(r.x * 1000) / (double)1000;
			double y=(double)Math.round(r.y * 1000) / (double)1000;
			
			out.printf("The treasure is located at (%.3f,%.3f).\n",x,y);
			double val=Math.sqrt(r.x*r.x+r.y*r.y);
			double dist=(double)Math.round(val * 1000) / (double)1000;
			out.printf("The distance to the treasure is %.3f.\n",dist);
			out.println();
			
			
			
			
		}
		out.flush();
	}

}
class pair{
	double x; double y;
	public pair(double x,double y) {
		this.x=x;this.y=y;
	}
}