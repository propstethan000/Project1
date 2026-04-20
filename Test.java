import java.util.Scanner;
public class Test {
static final String[] hex= {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
public static void main(String[] args) {
Scanner input= new  Scanner(System.in);
System.out.println("Enter a number:");
int num1=input.nextInt();
int num2=input.nextInt();
System.out.println("Your numbers are " + num1 + " and " + num2);
int sum=num1+num2;
System.out.println("The sum is " + sum);
input.close();
// Convert to hexadecimal
String hex1=toHex(num1);
String hex2=toHex(num2);
String hexSum=toHex(sum);
// Object code 
System.out.println("Object code for:");
System.out.println("C000"+ hex1);
System.out.println("6000"+ hex2);
System.out.println("E1000A");
System.out.println("00");
System.out.println("0000");
// Display hexadecimal values
System.out.println("Hexadecimal values:");
System.out.println("Number 1: 0x" + hex1);
System.out.println("Number 2: 0x" + hex2);
System.out.println("Sum: 0x" + hexSum);

}
private static String toHex(int num) {
String hexString="";
while(num>0) {
int rem=num%16;
hexString=hex[rem]+hexString;
num=num/16;
}
 return hexString;
}
}
