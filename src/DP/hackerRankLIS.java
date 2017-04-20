package DP;

import java.util.Scanner;

public class hackerRankLIS {
	static int nums[],n;
	static int LIS_EFF(){
		 int parent[]=new int[n],seq[]=new int[n+1]//track end of each inc subseq 
				,length=0;	
		
		for (int i = 0; i < nums.length; i++) {
			
			int low=1;
			int high=length;
			//binarysearch
			//find element to replace
			while(low<=high)
			{
				
				int mid=(int)Math.ceil((low+high)/2);
				if(nums[seq[mid]]<nums[i])
					low=mid+1;
				else
					high=mid-1;
				
			}
			
			
			
			int pos=low;
			parent[i]=seq[pos-1];//update parent
			 seq[pos]=i;
			 length=length<pos?pos:length;
			
			
			
			
			
		}
		return length;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=sc.nextInt();
		}
		System.out.println(LIS_EFF());
	}
	
}
