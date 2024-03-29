package tasks;

public class Task02 {

    /**
     * @param dayOfWeek от 0 до 6 включительно
     * @return Возвращает "rest" для субботы и воскресенья.
     * Для остальных дней "work".
     * @throws IllegalArgumentException Если dayOfWeek не от 0 до 6.
     */
    public static String shouldIWork(int dayOfWeek) {
    	if (dayOfWeek > 6 || dayOfWeek < 0) {
    		throw new IllegalArgumentException();
    	}
    	else {
    		if (dayOfWeek > 4) {
    			return "rest";
    		}
    		else {
    			return "work";
    		}
    	}
    }

}
