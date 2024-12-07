import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception {
        String[] data = input.split(" ");
        if (data.length != 3) {
            throw new Exception();
        }

        validateDigital(data[0], data[2]);
        validateOperation(data[1]);

        int first = Integer.parseInt(data[0]);
        String operation = data[1];
        int second = Integer.parseInt(data[2]);

        int result = switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new Exception();
        };

        return Integer.toString(result);
    }

    public static void validateDigital(String first, String second) throws Exception {
        String regex = "([1-9]|10)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(first);
        Matcher matcher2 = pattern.matcher(second);
        if (!matcher1.matches() || !matcher2.matches()) {
            throw new Exception();
        }
    }

    public static void validateOperation(String operation) throws Exception {
        String regex = "[+\\-*/]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(operation);
        if (!matcher.find()) {
            throw new Exception();
        }
    }
}
