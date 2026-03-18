// Import Scanner to input in the terminal
import java.util.Scanner;

public class Compliler{
    // List of every ascii character
    static final String[] asciiStrings = {"[null]","[start of heading]","[start of text]","[end of text]","[end of transmission]","[enquiry]","[acknowledge]","[bell]","[backspace]","[horizontal tab]","[line feed]","[vertical tab]","[form feed]","[carrage return]","[shift out]","[shift in]","[data link escape]","[device control 1]","[device control 2]","[device control 3]","[device control 4]","[negative acknowledge]","[synchronus idle]","[eng of trans block]","[cancel]","[end of medium]","[substitute]","[escape]","[file separator]","[group separator]","[record separator]","[unit separator]"," ","!\"","#","$","%","&","\'","(",")","*","+",",","-",".","/","0","1","2","3","4","5","6","7","8","9",":",";","<","=",">","?","@","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","[","\\","]","^","_","`","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","{","|","}","~",""};

    public static void main(String[] args) {

        // Scanner class created to recieve input from user
        Scanner input = new Scanner(System.in);

        // Step 1
        // User inputs command (Only print() works in this case)
        String strInput = input.next();

        // Program reads each character in the input and stores them in 'value'. If there is no command set and the 'value' variable finds a print staement, it will begin writing the assembly code.
        String value = "";
        boolean command = false;
        for (String index : strInput.split("")) {
            if (index.equals("\"")){
                if (!command){
                    if (value.equals("print(")){
                        value = "";
                        command = true;
                        continue;
                    }
                }else{
                    value = "";
                    command = false;
                }
            }
            value += index;
            if (command){

                // The first print statement would detect the hexidecimal of the ascii value and store it into the accumulator.
                System.out.print("D0 00 " + getHex(index) + " ");

                // The second print statement would then send it from the accumulator into the output.
                System.out.print("F1 FC 16 ");
            }
        }

        // The assembly code stops.
        System.out.println("00\n");

        // Step 2


        input.close();
    }

    // This method gets the hexidecimal value of a single character.
    private static String getHex(String value){
        String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        int index = 1+getAsciiIndex(value);
        return hex[(index/16)%16] + hex[index%16];
    }

    // This method gets the index of a single character in the ascii list stated above.
    private static int getAsciiIndex(String value){
        for (int i = 0; i < asciiStrings.length; i++) {
            if (asciiStrings[i].equals(value)){
                return i;
            }
        }
        return 0;
    }
}