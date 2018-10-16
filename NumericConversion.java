import java.util.Scanner;
//I commented on this
public class NumericConversion
{
    static String optionChoice;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        while(true)
        {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");

            System.out.print("Please enter an option: ");
            optionChoice = scan.next();

            if(optionChoice.equals("1"))
            {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scan.next();
                System.out.print("Result: ");
                System.out.println(hexStringDecode(input));

            }
            else if(optionChoice.equals("2"))
            {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scan.next();
                System.out.print("Result: ");
                System.out.println(binaryStringDecode(input));
            }
            else if(optionChoice.equals("3"))
            {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scan.next();
                System.out.print("Result: ");
                System.out.println(binaryToHex(input));
            }
            else
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }

        }




    }

    public static long hexStringDecode(String hex)
    {
        hex = hex.toUpperCase();
        hex = hex.replace("0X", "");
        hex = hex.replace("0B", "");
        long decimal = 0;
        int digit = 0;
        for(int i = hex.length()-1; i >= 0; i--)
        {
            decimal += hexCharDecode(hex.charAt(i)) * Math.pow(16, digit);
            digit ++;
        }

        return decimal;
    }

    public static short hexCharDecode(char digit)
    {
        short hexChar = 0;
        digit = Character.toUpperCase(digit);
        switch(digit)
        {
            case '0':
            {
                hexChar = 0;
                break;
            }
            case '1':
            {
                hexChar = 1;
                break;
            }
            case '2':
            {
                hexChar = 2;
                break;
            }
            case '3':
            {
                hexChar = 3;
                break;
            }
            case '4':
            {
                hexChar = 4;
                break;
            }
            case '5':
            {
                hexChar = 5;
                break;
            }
            case '6':
            {
                hexChar = 6;
                break;
            }
            case '7':
            {
                hexChar = 7;
                break;
            }
            case '8':
            {
                hexChar = 8;
                break;
            }
            case '9':
            {
                hexChar = 9;
                break;
            }
            case 'A':
            {
                hexChar = 10;
                break;
            }
            case 'B':
            {
                hexChar = 11;
                break;
            }
            case 'C':
            {
                hexChar = 12;
                break;
            }
            case 'D':
            {
                hexChar = 13;
                break;
            }
            case 'E':
            {
                hexChar = 14;
                break;
            }
            case 'F':
            {
                hexChar = 15;
                break;
            }



        }
        return hexChar;
    }

    public static short binaryStringDecode(String binary)
    {
        binary = binary.toUpperCase();
        binary = binary.replace("0X", "");
        binary = binary.replace("0B", "");
        short decodedBin = 0;
        int digit = 0;
        for(int i = binary.length()-1; i >= 0; i--)
        {
            int pow = (int) Math.pow(2, digit);
            decodedBin += Integer.parseInt(String.valueOf(binary.charAt(i))) * pow;
            digit ++;
        }

        return decodedBin;
    }

    public static String binaryToHex(String binary)
    {
        binary = binary.replace("0X", "");
        binary = binary.replace("0B", "");
        int length = binary.length();
        int sum = 0;
        String result = "";
        for(int i = length-1; i > 0; i -= 4)
        {
            sum = 0;
            sum += Integer.parseInt(binary.substring(i, i+1));
            sum += Integer.parseInt(binary.substring(i-1, i)) * 2;
            sum += Integer.parseInt(binary.substring(i-2, i-1)) * 4;
            sum += Integer.parseInt(binary.substring(i-3, i-2)) * 8;

            if(sum < 10)
            {
                result = sum + result;
            }
            if(sum == 10)
                result = "A" + result;
            if(sum == 11)
                result = "B" + result;
            if(sum == 12)
                result = "C" + result;
            if(sum == 13)
                result = "D" + result;
            if(sum == 14)
                result = "E" + result;
            if(sum == 15)
                result = "F" + result;

        }
        return result;

    }
}
