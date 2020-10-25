package tasks;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;

/**
 * Построить частотный словарь(Map) символов английского или русского алфавита.
 * Для этого взять любой большой кусок текста и сохранить его в файле.
 * Соответственно в коде надо из файла читать.
 */
public class Task03 {

    public static void main(String[] args) {
        Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\file\\textAndroid.txt"))){
        	String line;
        	line = reader.readLine();
        	while (line != null) {
        		char[] chars = line.toCharArray();
        		
        	    for (int i = 0; i < chars.length; i++) {
        	        if (frequencies.containsKey(chars[i])) {
        	        	frequencies.put(chars[i], frequencies.get(chars[i]) + 1);
        	        }
        	        else {
        	        	frequencies.put(chars[i], 0);
        	        }
        	    }
        	    line = reader.readLine();
        	} 
        	
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        System.out.println(frequencies);
    }

}
