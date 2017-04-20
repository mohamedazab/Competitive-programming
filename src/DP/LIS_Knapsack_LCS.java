package DP;

import java.util.Arrays;

public class LIS_Knapsack_LCS {

	static int n;
	static int nums[];
	static int mem[][];
	static int LIS(int i,int prevIDX){ //return length of LIS;//
		//prev can be number for better complexity 
		
		//n^2
		
		if(i==n)return 0;
		
		if(mem[i][prevIDX]!=-1)return mem[i][prevIDX];
		
		int c1=LIS(i+1, prevIDX);//LEAVE
		
		int c2=0;
		if(prevIDX==n||nums[i]>=nums[prevIDX])
			c2=LIS(i+1, i)+1;
		
		return mem[i][prevIDX]=Math.max(c1, c2);
		
	}

	static int LIS2(int i){ //return length of LIS;//
		//1D mem
		//prev can be number for better complexity

		//n^2

		if(i==n)return 0;

		//if(mem[i][prevIDX]!=-1)return mem[i][prevIDX];

		//int c1=LIS(i+1, prevIDX);//LEAVE

		int c2=LIS2(i+1);
		int k=i;
		for ( i = i+1;  i <nums.length ;  i++) {
			if(nums[i]>nums[k])c2=Math.max(c2,LIS2(i)+1);
		}


		return c2; //mem[i][prevIDX]=Math.max(c1, c2);

	}
	
	
	
	
	static void LIS_EFF(){
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
		//print LIS
			 String s="";
			 int last=seq[length];
			 for (int j = length-1; j >=0; j--) {
			   s=nums[last]+s;
			   last=parent[last];
			}
		System.out.println(s);
	
	}
	
	
	
	
	
	
	
	
	
	static int weights[];
	static 	int cost[];
	static int knapsack(int i,int rem){ 
		
		if(i==n)return 0;
		
		//if(mem[i][rem]!=-1)return mem[i][rem];
		
		int c1=knapsack(i+1, rem);//LEAVE
		
		int c2=0;
		if(rem>=weights[i])
			c2=knapsack(i+1, rem-weights[i])+cost[i];
		
		return Math.max(c1, c2);
		
	}
		/*given 2str longest comman subsequence*/
	static String s1;static String s2;
	static int mems1s2[][];
 static	int lcs(int i,int j){
	 if(i==s1.length()||j==s2.length())return 0;
	 if(mems1s2[i][j]!=-1)return mems1s2[i][j];
	 if(s1.charAt(i)==s2.charAt(j))
		 return 1+lcs(i+1, j+1);
	 
	 int c1=lcs(i+1,j);
	 int c2=lcs(i,j+1);
	 // 4 choices i+1 j+1 will be called in either of them 
	 
	 return mem[i][j]=Math.max(c1, c2);
	 
	 
 }
		
	public static void main(String[] args) {
		
		//nums=new int[n];
		 n=4;
		int []nr={1,2,3,3};
		nums=nr;
		mem=new int [n+1][n+1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(mem[i], -1);
		}
		LIS_EFF();
		
	}
	
	
}
