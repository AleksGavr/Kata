import java.util.*;

public class Main {
    public static void main(String[] args) {
        String oper = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        String input = in.nextLine().replaceAll("\\s", "");
        in.close();

//  проверяю корректно лм введена арифметическая операция
        if (input.contains("+")) oper = "+";
        else if (input.contains("-")) oper = "-";
        else if (input.contains("*")) oper = "*";
        else if (input.contains("/")) oper = "/";
        else System.out.println("ФМОУЗ-ДОО нет такой операции");

//  делаю массив из аргументов, где разделителем является арифметическая операция из допустимых
        String[] arr = input.split("[+\\-*/]");

//  проверяю чтобы количество операндов было ровно для одной операции
        if (arr.length != 2) System.out.println("ФМОУЗ-ДОО количество операндов не соот-т");

//  присваиваю переменным каждый из операндов (пока строковое)
        String arg1 = arr[0];
        String arg2 = arr[1];

//  создаю массивы для соотнесения операндов арабским или римским числам
        String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VI", "VII", "IX", "X"};
        String[] rome2 = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic2 = {100, 90, 50, 40, 10, 9, 5, 4, 1};

//  проверяю является ли первый аргумент арабским числом
        int argA1 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i].equals(arg1)) {
                argA1 = (i + 1);
            }
        }

/*  если первый аргумент арабское число, то второе по условию тоже должно быть арабским, поэтому
не заморачиваюсь и сразу определяю его значение. Так как
пока еще не на "ты" с ООП в java, чтобы не путаться буду делать по нубски-топорно - всё процедурно. Иначе
не скоро смогу сдать работу в академию, пока всё изучу. Да и будет ли тогда уже смысл сдавать? :D
Поэтому заранее прошу прощение за такое неоправданно огромное количество строк в программе. Что с лузера взять? ;-)
 */
        int argA2 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i].equals(arg1)) {
                argA2 = (i + 1);
            }
        }

//  Преобразую переменные из строки в число и произвожу итоговое вычисление
        if (oper.equals("+")) System.out.println(argA1 + argA2);
        if (oper.equals("-")) System.out.println(argA1 - argA2);
        if (oper.equals("*")) System.out.println(argA1 * argA2);
        if (oper.equals("/")) System.out.println(argA1 / argA2);

//  Если это выражение записано не арабскими числами, тоже самое делаем с с римскими.
//  сначала определяем эквивалент арабскими и производим вычисление
        int argR1 = 0;
        for (int i = 0; i < rome.length; i++) {
            if (rome[i].equals(arg1)) {
                argR1 = (i + 1);
            }
        }

        int argR2 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (rome[i].equals(arg2)) {
                argR2 = (i + 1);
            }
        }
//        System.out.println(argR2);
        if (oper.equals("+")) System.out.println(argR1 + argR2);
        if (oper.equals("-")) System.out.println(argR1 - argR2);
        if (oper.equals("*")) System.out.println(argR1 * argR2);
        if (oper.equals("/")) System.out.println(argR1 / argR2);

//теперь преобразуем ответ обратно в римские числа
        String result = "";
        int j = 0;
        int num = 9;

        while (j < rome2.length) {
            while (num >= arabic2[j]) {
                int tmp = num / arabic2[j];
                num = num % arabic2[j];
                for (int i = 0; i < tmp; i++)
                    result = result + rome2[j];
            }
            j++;
        }

        //return ret.ToString();
        System.out.println(result);

    }
}