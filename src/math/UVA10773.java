package math;
import java.util.*;
/**
 * Created by moham on 1/23/2017.
 */
public class UVA10773 {

    public static void main (String args[]){

        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        for (int i = 1; i <=q ; i++) {


        double d=sc.nextInt();
        double v=sc.nextInt();
        double u=sc.nextInt();
        if(u<=v||v==0){
            System.out.printf("Case %d: can't determine\n",i);
        }
        else{
            double diff=Math.abs((d/Math.sqrt(u*u-v*v))-d/u);
            System.out.printf("Case %d: %.3f\n",i,diff);
        }

    }

    }

}
