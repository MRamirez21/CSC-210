public class HexConver {

    public static void main(String[] args) {
        System.out.println("Start");

        if (args.length == 0) {
            return;
        }

        String hexVal = args[0].toLowerCase();  
        System.out.println("Hex input: " + hexVal);

        int hexDigit = 0;
        int answer = 0;

        int length = hexVal.length();

        for (int i = length - 1; i >= 0; i--) {
            char c = hexVal.charAt(i);

            switch (c) {
                case '0':
                    hexDigit = 0;
                    break;
                case '1':
                    hexDigit = 1;
                    break;
                case '2':
                    hexDigit = 2;
                    break;
                case '3':
                    hexDigit = 3;
                    break;
                case '4':
                    hexDigit = 4;
                    break;
                case '5':
                    hexDigit = 5;
                    break;
                case '6':
                    hexDigit = 6;
                    break;
                case '7':
                    hexDigit = 7;
                    break;
                case '8':
                    hexDigit = 8;
                    break;
                case '9':
                    hexDigit = 9;
                    break;
                case 'a':
                    hexDigit = 10;
                    break;
                case 'b':
                    hexDigit = 11;
                    break;
                case 'c':
                    hexDigit = 12;
                    break;
                case 'd':
                    hexDigit = 13;
                    break;
                case 'e':
                    hexDigit = 14;
                    break;
                case 'f':
                    hexDigit = 15;
                    break;
                default:
                    System.out.println("Invalid hex digit: " + c);
                    return;
            }

            int power = length - 1 - i;

            
            answer += hexDigit * Math.pow(16, power);
        }

        System.out.println("Decimal value: " + answer);
        System.out.println("Program ends.");
    }
}
