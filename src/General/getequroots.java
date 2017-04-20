package General;

public class getequroots {
	static final double  EPS=1e-9;
	
	
	//parameters
	
	int p,t,q,r,s;
	
	public double f(double x){
		return 0;
	}
	
	double fd(double x){ // the derivative of function f
		  return -p*Math.exp(-x) + q*Math.cos(x) - r*Math.sin(x) + s/(Math.cos(x)*Math.cos(x)) + 2*t*x;
		}
		 
		double newton(){
		  if (f(0)==0) return 0;
		  for (double x=0.5; ;){             // initial guess x = 0.5
		    double x1 = x - f(x)/fd(x);      // x1 = next guess
		    if (Math.abs(x1-x) < EPS) return x;  // the guess is accurate enough
		    x = x1;
		  }
		}
	
	double secant(){
		  if (f(0)==0) return 0;
		  for (double x0=0, x1=1; ; ){               // initial guess for x0 and x1
		    double d = f(x1)*(x1-x0)/(f(x1)-f(x0));  // compute delta
		    if (Math.abs(d) < EPS) return x1;            // the guess is accurate enough
		    x0 = x1;
		    x1 = x1 - d;
		  }
		}
	double bisection(){
		  double lo = 0, hi = 1;
		  while (lo + EPS < hi){
		    double x = (lo+hi)/2;
		    if (f(lo) * f(x) <= 0){
		      hi = x;
		    } else {
		      lo = x;
		    }
		  }
		  return (lo+hi)/2;
		}
		 
}
