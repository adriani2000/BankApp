import java.io.*;

public class ReadLoginInfo {
    private static ReadLoginInfo ourInstance = new ReadLoginInfo();
    private static final String loginCredentialsLocation = "src\\main\\resources\\loginInfo";

    private ReadLoginInfo() {
    }

    public static ReadLoginInfo getInstance() {
        return ourInstance;
    }

    /**
     * @param filePath the location of the file holding user credentials
     * @return true if the said file exists and it's not a directory, false otherwise
     */

    private static boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            System.out.println("File exists");
        } else {
            System.out.println("File doesn't exist");
        }
        return file.exists() && !file.isDirectory();
    }

    /**
     * @param userName
     * @param pass
     * @return true if user's credentials are valid, false otherwise
     */
    public boolean checkUserCredentials(String userName, String pass) {
        boolean flag = false;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(loginCredentialsLocation))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] credentials = line.split(" ");
                    flag = credentials[0].replace("\n", "").replace("\r", "").equals(userName)
                            && credentials[1].replace("\n", "").replace("\r", "").equals(pass);
                    if (flag)
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (flag) {
            System.out.println("Login successful");

        } else {
            System.out.println("Wrong username / password");
        }
        return flag;
    }

}
