package tasks;

import java.util.Scanner;

public class Task04 {

    /**
     * Написать программу, которая играет с вами в угадай число.
     * Сначала программа печатает: "Введи нижную и верхнюю границы"
     * Пользователь вводит.
     * Программа проверяет, что нижняя граница меньше верхней.
     * Иначе выводит в консоль сообщение об ошибке и завершается.
     *
     * Далее программа пытается угадать какое число загадал пользователь
     * в введенном отрезке.
     * Тактика может быть любая: random, перебор, бин поиск.
     * Программа выводит своё предположение.
     * Пользователь должен ввести "yes", если программа угадал.
     * Программа завершается.
     * Иначе любое другое сообщение. Тогда программа продолжает угадывать.
     *
     * Пример:
     * Введи границы
     * 0 10
     * Это 1?
     * no
     * Это 3?
     * no
     * Это 5?
     * yes
     * Отличная игра(завершение)
     *
     */
    public static void main(String[] args) {
    	 Scanner in = new Scanner(System.in);
         System.out.print("Введите границы: ");
         String []text=in.nextLine().split(" ");
   
         int start = Integer.parseInt(text[0]);
         int end = Integer.parseInt(text[1]);
         if (start > end) {
        	 System.out.printf("Вы ввели некорректные значения!");
         }
         else {
        	 int i_from = start;
        	 System.out.printf("Вы загадали %d? Вводите no, если нет, и yes, если программа угадала\n",start);
        	 String ans = in.nextLine();
    	 while (ans.equals("no") && i_from < end) {
        		 i_from += 1;
            	 System.out.printf("Вы загадали %d? \n",i_from);
        
        		 ans = in.nextLine();
     
        	 }
        	 System.out.printf("Конец!", end);
         }
    }
}
