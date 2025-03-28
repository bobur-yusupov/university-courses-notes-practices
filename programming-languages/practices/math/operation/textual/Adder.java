package math.operation.textual;

public class Adder 
{
    public static String addAsText(String str1, String str2)
    {
        try {
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            return String.valueOf(num1 + num2);
        } catch (NumberFormatException e1) {
            try {
                double num1 = Double.parseDouble(str1);
                double num2 = Double.parseDouble(str2);

                return String.valueOf(num1 + num2);
            } catch (NumberFormatException e2) {
                return "Operands are not numbers.";
            }
        }
    }
}