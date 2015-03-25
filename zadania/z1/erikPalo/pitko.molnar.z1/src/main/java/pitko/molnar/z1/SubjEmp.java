package pitko.molnar.z1;

import java.util.Arrays;

public class SubjEmp {
	public Subject subj;
	public int nOfSubj;
	public int bio;
	public int chem;
	public int cze;
	public int eng;
	public int math;
	
	public int max(){
		int[] values = new int[5];
		values[0] = bio;
		values[1] = chem;
		values[2] = cze;
		values[3] = eng;
		values[4] = math;
		
		Arrays.sort(values);
		return values[4];
	}

}
