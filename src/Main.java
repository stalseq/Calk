import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");

        String input = scanner.nextLine();
        System.out.println(calk(input));


    }

    public static String calk(String input) throws IOException {
        boolean pr;
        int a;
        int b;
        int result = 0;




        String[] op = {"+", "-", "/", "*"};
        String[] op1 = {"\\+", "-", "/", "\\*"};


        System.out.println("Результат");

        int x = -1;
        for (int i = 0; i < op.length; i++) {
            if (input.contains(op[i])) {
                x = i;
                break;
            }
        }

        if (x == -1) {
            System.out.println("Неверная орефметическая операция");
            return input;
        }
        String[] input1 = input.split(op1[x]);

        if (input1.length != 2) {
            throw new IOException("Должно быть два операнда");
        }

        if (Converter.prov(input1[0]) && Converter.prov(input1[1])) {
            a = Converter.convertToArabian(input1[0]);
            b = Converter.convertToArabian(input1[1]);
            pr = true;
        } else if (!Converter.prov(input1[0]) && !Converter.prov(input1[1])) {
            a = Integer.parseInt(input1[0]);
            b = Integer.parseInt(input1[1]);
            pr = false;
        } else {
            throw new IOException("Числа должны быть в одном формате");
        }
        if (a > 10 || b > 10) {
            throw new IOException("Числа должны быть от 0 до 10");
        }
        {


            switch (op[x]) {
                case "+": {
                    result = Integer.parseInt(String.valueOf(a + b));
                    break;
                }
                case "*": {
                    result = Integer.parseInt(String.valueOf(a * b));
                    break;
                }
                case "-": {
                    result = Integer.parseInt(String.valueOf(a - b));
                    break;
                }
                case "/": {
                    result = Integer.parseInt(String.valueOf(a / b));
                    break;
                }
            }

            if(pr){
                if(result <= 0){throw new IOException("Римское число не может быть отрицательным");}
                return Converter.convertToRes(result);}else{
                return String.valueOf(result);}
        }




    }
}