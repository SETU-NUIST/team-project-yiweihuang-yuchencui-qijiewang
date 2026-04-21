package main;

import controller.MovieManager;

import javax.swing.JOptionPane;

public class Main {
    private static final String CORRECT_USERNAME = "Qijie,Wang";
    private static final String CORRECT_PASSWORD = "123456";
    private static String  username;
    private static String password;
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
                null,
                "Welcome to Douban models.Movie Management System",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );

        while(true)
        {
            username = JOptionPane.showInputDialog(
                null,
                "Please enter your username:",
                "Login",
                JOptionPane.QUESTION_MESSAGE);

            password = JOptionPane.showInputDialog(
                    null,
                    "Please enter your password:",
                    "Login",
                    JOptionPane.QUESTION_MESSAGE
            );

            String correctUsername = "Qijie,Wang";
            String correctPassword = "123456";
            if(password == null || username == null)                {
                JOptionPane.showMessageDialog(
                        null,
                        "Password and username cannot be empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            else if (password.equals(correctPassword) && username.equals(correctUsername))
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
                        "Wrong password or username, please try again",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        }

        int loginResult = verifyLogin(username, password);

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

}
