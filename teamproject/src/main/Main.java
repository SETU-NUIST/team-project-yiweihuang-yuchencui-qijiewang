package main;

import controller.MovieManager;

import javax.swing.JOptionPane;

public class Main {
    private static final String CORRECT_USERNAME = "Qijie,Wang";
    private static final String CORRECT_PASSWORD = "123456";
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
                null,
                "Welcome to Douban models.Movie Management System",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );
        while(true)
        {
            String username = JOptionPane.showInputDialog(
                null,
                "Please enter your username:",
                "Login",
                JOptionPane.QUESTION_MESSAGE);

            String password = JOptionPane.showInputDialog(
                    null,
                    "Please enter your password:",
                    "Login",
                    JOptionPane.QUESTION_MESSAGE
            );

            String correctUsername = "Qijie,Wang";
            String correctPassword = "123456";

            if (username != null && username.equals(correctUsername)) {
                if (password != null && password.equals(correctPassword))
                {

                    JOptionPane.showMessageDialog(
                            null,
                            "Login successful! Welcome to use the system ~",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                }
                else
                {
                    JOptionPane.showMessageDialog(
                            null,
                            "Wrong password, please try again",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Wrong account, try please again",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        String username = JOptionPane.showInputDialog(
                null,
                "Please enter your username:",
                "Login",
                JOptionPane.QUESTION_MESSAGE
        );

        String password = JOptionPane.showInputDialog(
                null,
                "Please enter your password:",
                "Login",
                JOptionPane.QUESTION_MESSAGE
        );

        int loginResult = verifyLogin(username, password);
        showLoginResultDialog(loginResult);

        MovieManager manager = new MovieManager();
        manager.initializeSimpleMovies();
        manager.showMainMenu();
    }

    public static int verifyLogin(String inputUsername,String inputPassword){
        if (inputUsername != null && inputUsername.equals(CORRECT_USERNAME)) {
            if (inputPassword != null && inputPassword.equals(CORRECT_PASSWORD)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    public static void showLoginResultDialog(int result){
        switch (result) {
            case 0:
                JOptionPane.showMessageDialog(
                        null,
                        "Login successful! Welcome to use the system ~",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;
            case 1:
                JOptionPane.showMessageDialog(
                        null,
                        "Wrong password, please try again",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                break;
            case 2:
                JOptionPane.showMessageDialog(
                        null,
                        "Wrong account, try please again",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                break;
        }


    }

}
