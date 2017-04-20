package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by moham on 1/21/2017.
 */
public class UVAhow_Do_you_Add {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
      while (true) {
          int n = sc.nextInt();
          int k = sc.nextInt();
          if(n==0&&k==0)break;
          dp = new int[n + 1][k + 1];

          for (int[] v : dp) {
              Arrays.fill(v, -1);
          }
          System.out.println(solve(k, n));
      }
    }
    static final int INF=(int)1e9;
    static int dp[][];
    public static int solve(int k,int n){

        if(k==0&&n==0){
            return 1;
        }
        if(k==0)return 0;
        if(dp[n][k]!=-1)return dp[n][k];
        int ans=0;
        for (int i = 0; i <=n ; i++) {
            ans+=solve(k-1,n-i);

            ans%=1000000;

        }
        return dp[n][k]=ans%1000000;
    }


}
