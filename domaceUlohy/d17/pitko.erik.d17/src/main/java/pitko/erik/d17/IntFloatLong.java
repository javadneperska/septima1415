package pitko.erik.d17;

import java.util.InputMismatchException;

public class IntFloatLong {
	private int i;
	private float f;
	private long l;

	public void setNum(String x) {
		try {
			if (x.contains(".")){
				this.f = Float.parseFloat(x);
			}else if ((Long.parseLong(x) > Integer.MAX_VALUE || Long.parseLong(x) < Integer.MIN_VALUE)){
				this.l = Long.parseLong(x);				
			}else{
				this.i = Integer.parseInt(x);								
			}
		} catch (InputMismatchException e) {
			System.out.println("wrong type !");
		}
	}

	public String getNum() {
		if (i != 0){
			return ("int: " + String.valueOf(this.i));
		}else if (f != 0){
			return ("float: " + String.valueOf(this.f));			
		}else{
			return ("long: " + String.valueOf(this.l));
		}
	}
}
