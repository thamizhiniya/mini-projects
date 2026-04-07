import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        while(true){
            boolean hasupper = false;
            boolean hasdigit = false;
            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            boolean lengthValid = password.length() >= 8 ;

            for (int i=0;i <password.length();i++){
                char c = password.charAt(i);
                if(Character.isUpperCase(c)){
                    hasupper = true;
                }
                if(Character.isDigit(c)){
                    hasdigit = true;
                }
            }
            if(!hasupper){
                System.out.println("Password must contain at least one uppercase letter.");
               
            }
            if(!hasdigit){
                System.out.println("Password must contain at least one digit.");
                
            }
            if(!lengthValid){
                System.out.println("Password must be at least 8 characters long.");
                
            }
            if(hasupper && hasdigit && lengthValid){
                System.out.println("Password is accepted.");
                break;
            }
            else{
                System.out.println("Please try again.");
            }
        }
        scanner.close();
    }
    
}
