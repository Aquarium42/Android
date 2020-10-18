package tasks;

public class Task01 {

    public static int min(int[] ints) {
    	int min_ = ints[0];
    	for(int i : ints) {
    	       if (i < min_) {
    	    	   min_ = i;
    	       }
    	   }
        return min_;
    }

    public static float average(int[] ints) {
    	float sum_ = 0;
    	for (float i: ints) {
    		sum_ += i;
    	}
        return sum_/ints.length;
    }

}
