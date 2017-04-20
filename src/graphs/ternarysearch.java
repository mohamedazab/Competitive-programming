package graphs;

public class ternarysearch {
	//function f range left-right inc then dec or opposite function get max or min 
		static double tsearch(double f,double left,double right ,double prec){
			if(Math.abs(right-left)<prec)
				{//System.out.println(true);
				return (left+right)/2.0;
				}
			double leftthird=(2*left+right)/3;
			double rightthird=(left+2*right)/3;
			if(f(leftthird)<f(rightthird))
			return(tsearch(f, leftthird, right, prec));
			else
				return tsearch(f, left, rightthird, prec);
			
		}

		private static int f(double leftthird) {
			// TODO Auto-generated method stub
			return 0;
		}
}
