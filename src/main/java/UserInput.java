import java.util.Scanner;

public class UserInput {
    private ReadLoginInfo loginInfo;
    private Scanner scanner;

    public UserInput() {
        this.loginInfo = ReadLoginInfo.getInstance();
        this.scanner = new Scanner(System.in);
    }

    /**
     * @return true if the credentials are valid, false otherwise
     */
    public boolean introduceCredentials() {
        String userInput;
        String passInput;
        System.out.println("Username: ");
        userInput = scanner.nextLine();
        System.out.println("Password: ");
        passInput = scanner.nextLine();
        return loginInfo.checkUserCredentials(userInput, passInput);
    }
}
