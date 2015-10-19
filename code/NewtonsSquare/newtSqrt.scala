
def improve(guess : Double, a : Double) : Double = (guess + (a/guess))/2

def abs(y : Double) : Double = if (y > 0) y else -y

def goodEnough(guess : Double, a : Double) : Boolean = abs(a - (guess * guess)) < 0.0001

def newtSqrtIter(a : Double, guess : Double): Double = 
	if (goodEnough(guess,a)) guess else newtSqrtIter(a,improve(guess,a))

def newtSqrt(a : Double):Double = newtSqrtIter(a,1.0)

newtSqrt(100);
