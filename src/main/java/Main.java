import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        login : userInput.introduceCredentials();
        boolean flag = true;
        while(flag){
            System.out.println("Introduceti exit pentru a va deconecta");
            Scanner scanner = new Scanner(System.in);
            if(scanner.next().equals("exit")){
                System.out.println("Successful logout");
                break;
            }
        }{

        }
    }
}
