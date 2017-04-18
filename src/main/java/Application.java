package main.java;


import main.java.view.Frame.LoginFrame;

import javax.swing.*;


/**
 * Created by Genius Doan on 4/11/2017.
 */
public class Application {
    public static void main(final String[] args) throws Exception {
        LoginFrame layout = new LoginFrame("Đăng nhập", 450, 400);
        layout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        layout.setVisible(true);
    }
}