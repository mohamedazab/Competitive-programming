package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class pair1 implements Comparable<pair1>{
	int x; int y;
	public pair1(int x,int y) {
		this.x=x;this.y=y;
	}
	@Override
	public int compareTo(pair1 m) {
		
		
		if(x>m.x)
			return 1;
		else
			if(x==m.x)
				return 0;
			else
				return -1;
	}
}
public class UVA920SunnyMountains {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
		int c=Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			int n=Integer.parseInt(br.readLine());
			pair1 pairs[]=new pair1[n];
			
			for (int j = 0; j < n; j++) {
				String mr[]=br.readLine().split(" ");
				pairs[j]=new pair1(Integer.parseInt(mr[0]),Integer.parseInt(mr[1]));
				
			}
			Arrays.sort(pairs);
			double h=0;
			
			int bigH=0; 
			for (int j =pairs.length-2 ; j >=0; j--) {
				if(bigH<pairs[j+1].y)
					{bigH=pairs[j+1].y;
					
					}
				if(pairs[j].y<=bigH)
					continue;
				double xlength=pairs[j+1].x-pairs[j].x;
				double ylength=pairs[j].y-pairs[j+1].y;
				double hyp=Math.sqrt(xlength*xlength+ylength*ylength);
				
			    double dist=hyp*((double)(pairs[j].y-bigH)/(double)ylength);
				
				
					h+=dist;
				
			}
			
			
			out.printf("%.2f\n", h);
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		out.flush();
		
	}

}
