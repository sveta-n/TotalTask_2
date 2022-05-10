import java.util.Scanner;

public class TotalTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите уравнение:");
        while (true) {
            String str = scanner.next();
            if (str.equalsIgnoreCase("exit")) {
                break;
            }
            char[] chars = str.toCharArray();
            if (chars[4] != 'x'){
                toTargetExpression(chars);
            }
            System.out.println(targetExpression(chars));
        }
    }

    private static void toTargetExpression(char[] chars) {
        if (chars[0] == 'x') {
            chars[0] = chars[4]; // перенос результата на место x
            chars[1] = chars[1] == '+' ? '-' : '+'; // изменение знака на противоположный
        } else {
            chars[2] = chars[4]; // перенос результата на место x
            if (chars[1] == '+') {
                chars[1] = '-'; // изменение + на -
                chars[4] = '-'; // вместо х записываем - как признак того что в конечном результате вырежения нужно изменить знак
            }
        }
    }

    private static int targetExpression(char[] chars) {
        int a = Integer.parseInt(String.valueOf(chars[0]));
        int b = Integer.parseInt(String.valueOf(chars[2]));
        char sign = chars[1];
        int result = 0;
        if (sign == '+'){
            result = a + b;
        } else if (sign == '-'){
            result = a - b;
        } else {
            throw new IllegalArgumentException();
        }
        if (chars[4] == '-') {
            result = -result;
        }
        return result;
    }
}