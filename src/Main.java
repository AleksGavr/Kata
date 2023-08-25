import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        String input = in.nextLine().replaceAll("\\s", "");
        in.close();

        System.out.println("Output: \n" + calc(input));
//        String result = calc(input);
//        System.out.println(result);

    }
    public static String calc(String input){
        String result = "";
        String oper = "";
        //  проверяю корректно лм введена арифметическая операция
        if (input.contains("+")) oper = "+";
        else if (input.contains("-")) oper = "-";
        else if (input.contains("*")) oper = "*";
        else if (input.contains("/")) oper = "/";
        else
            try {
                throw new Exception();
            }
            catch (Exception ex){
                System.out.println("формат математической операции не удовлетворяет заданию - один оператор (+, -, /, *)");
                System.exit(0);
            }

//  делаю массив из аргументов, где разделителем является арифметическая операция из допустимых
        String[] arr = input.split("[+\\-*/]");

//  проверяю чтобы количество операндов было ровно для одной операции
        try{
            if(arr.length != 2) {
                throw new Exception();
            }
        }
        catch (Exception ex){
            System.out.println("формат математической операции не удовлетворяет заданию: должны быть два операнда");
            System.exit(0);
        }

//  присваиваю переменным каждый из операндов (пока строковое)
        String arg1 = arr[0];
        String arg2 = arr[1];

//  создаю массивы для соотнесения операндов арабским или римским числам
        String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] rome2 = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic2 = {100, 90, 50, 40, 10, 9, 5, 4, 1};

//  проверяю является ли первый аргумент арабским числом
        boolean ar1 = false;
        int argA1 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i].equals(arg1)) {
                argA1 = (i + 1);
                ar1 = true;
            }
        }

/*  если первый аргумент арабское число, то второе по условию тоже должно быть арабским, поэтому
не заморачиваюсь и сразу определяю его значение. Так как
пока еще не на "ты" с ООП в java и с методами постоянно косячу, чтобы не путаться буду делать по нубски-топорно
 - всё процедурно. Иначе не скоро смогу сдать работу в академию, пока всё изучу. Да и будет ли тогда уже смысл
  сдавать? :D Поэтому заранее прошу прощение за такое неоправданно огромное количество строк в программе.
  Что с лузера взять? ;-)*/

        boolean ar2 = false;
        int argA2 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i].equals(arg2)) {
                argA2 = (i + 1);
                ar2 = true;
            }
        }

//  Преобразую переменные из строки в число и произвожу итоговое вычисление
        if((ar1 == true) && (ar2 == true)) {
            if (oper.equals("+")) result = (argA1 + argA2) + "";//System.out.println(argA1 + argA2);
            if (oper.equals("-")) result = (argA1 - argA2) + "";//System.out.println(argA1 - argA2);
            if (oper.equals("*")) result = (argA1 * argA2) + "";//System.out.println(argA1 * argA2);
            if (oper.equals("/"))result = (argA1 / argA2) + "";//System.out.println(argA1 / argA2);
        }


//  Если это выражение записано не арабскими числами, тоже самое делаем и с римскими.
//  сначала определяем эквивалент арабскими и производим вычисление
        ar1 = false;
        int argR1 = 0;
        for (int i = 0; i < rome.length; i++) {
            if (rome[i].equals(arg1)) {
                argR1 = (i + 1);
                ar1 = true;
            }
        }

        ar2 = false;
        int argR2 = 0;
        for (int i = 0; i < arabic.length; i++) {
            if (rome[i].equals(arg2)) {
                argR2 = (i + 1);
                ar2 = true;
            }
        }
        int num = 0;
        if((ar1 == true) && (ar2 == true)) {
            if (oper.equals("+")) num = (argR1 + argR2);
            if (oper.equals("-")) num = (argR1 - argR2);
            if (oper.equals("*")) num = (argR1 * argR2);
            if (oper.equals("/")) num = (argR1 / argR2);
            try {
                if (num <= 0) {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("в римской системе нет 0 и отрицательных чисел");
                System.exit(0);
            }
        }


//        String result = "";
        int j = 0;
        while (j < rome2.length) {
            while (num >= arabic2[j]) {
                int tmp = num / arabic2[j];
                num = num % arabic2[j];
                for (int i = 0; i < tmp; i++)
                    result = result + rome2[j];
            }
            j++;
        }
        try{
            if(result == ""){
                throw new Exception();
            }

        }
        catch (Exception ex){
            System.out.println("формат математической операции не удовлетворяет заданию");
            System.exit(0);
        }
        return result;

    }
}


