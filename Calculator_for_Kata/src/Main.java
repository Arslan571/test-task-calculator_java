import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two either Arabic or Roman numbers: ");
        String expression = scanner.nextLine();
        System.out.println(Parse(expression));
    }

    public static String Parse(String expression) throws Exception
    {
        int firstNumber;
        int secondNumber;

        String operand;
        String answer;

        boolean isRoman;

        String[] operands = expression.split("[+\\-*/]");

        if(operands.length != 2) throw new Exception("We need two numbers!!!");
        operand = OperationDetection(expression);

        if(operand == null)
            throw new Exception("The wrong sign has been entered!!!");

        if(Roman.isRoman(operands[0]) && Roman.isRoman(operands[1]))
        {
            firstNumber = Roman.ToArabian(operands[0]);
            secondNumber = Roman.ToArabian(operands[1]);
            isRoman = true;
        } else if(!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1]))
        {
            firstNumber = Integer.parseInt(operands[0]);
            secondNumber = Integer.parseInt(operands[1]);
            isRoman = false;
        }else
        {
            throw new Exception("The numbers must be in the same format!!!");
        }

        if(firstNumber > 10 || secondNumber > 10)
        {
            throw new Exception("The numbers must be from 1 to 10!!!");
        }

        int arabian  = calculation(firstNumber, secondNumber, operand);
        if(isRoman)
        {
            if(arabian <= 0)
            {
                throw new Exception("Roman numbers can only be greater than zero!!!");
            }
            answer = Roman.ToRoman(arabian);
        }else{
            answer = String.valueOf(arabian);
        }
        return answer;
    }

    static String OperationDetection(String expression)
    {
        if(expression.contains("+"))
            return "+";
        else if(expression.contains("-"))
            return "-";
        else if(expression.contains("*"))
            return "*";
        else if(expression.contains("/"))
            return "/";
        else return null;
    }

    static int calculation(int a, int b, String operand)
    {
        if(operand.equals("+"))
            return a + b;
        else if(operand.equals("-"))
            return a - b;
        else if(operand.equals("*"))
            return a * b;
        else
            return a / b;
    }

    }

    class Roman
    {
        static String[] array = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
        "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV", "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

        public static boolean isRoman(String val)
        {
            for(int i = 0; i < array.length; i++)
                if(val.equals(array[i]))
                    return true;

            return false;
    }

    public static int ToArabian(String roman)
    {
        for(int i = 0; i < Roman.array.length; i++)
            if(roman.equals(array[i]))
                return i;

        return -1;
    }

    public static String ToRoman(int arabian)
    {
        return array[arabian];
    }

}
