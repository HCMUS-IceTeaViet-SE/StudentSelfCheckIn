package main.java.view;

        import javax.swing.*;
        import javax.swing.border.Border;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * Created by Genius Doan on 4/15/2017.
 */
public class LoginFrame extends JFrame{

    JButton btnLogin;
    Toolbar toolbar;
    Container container;
    boolean isSV = true;
    JTextArea txtUserName;
    JPasswordField txtPassword;
    JButton btnChangePass;
    JLabel lblNotify;
    public LoginFrame(){

        container = this.getContentPane();
        container.setLayout(null);

        //header
        toolbar = new Toolbar(450,70);
        toolbar.setLoginInformationEnabled(false);
        toolbar.setBounds(0,0,450,50);

        JLabel lblUserName = new JLabel("Tên đăng nhập: ");
        lblUserName.setBounds(20,120,120,40);
        lblUserName.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));

        txtUserName = new JTextArea();
        txtUserName.setFont(new Font("Serif", Font.ITALIC, 18));
        txtUserName.setBounds(140,120,200,40);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        txtUserName.setBorder(border);

        JLabel lblPassword = new JLabel("Mật khẩu: ");
        lblPassword.setBounds(60,180,80,40);
        lblPassword.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));

        txtPassword.setBounds(140,180,200,40);
        txtPassword.setBorder(border);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
        btnLogin.setBounds(260,240,150,40);
        btnLogin.setBackground(new Color(127, 179, 213  ));

        btnChangePass = new JButton("Đổi mật khẩu");
        btnChangePass.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
        btnChangePass.setBounds(20,240,150,40);
        btnChangePass.setBackground(new Color(127, 179, 213  ));

        lblNotify = new JLabel("");
        lblNotify.setFont(new Font("Serif", Font.ITALIC, 16));
        lblNotify.setBounds(20,300,250,40);
        lblNotify.setForeground(Color.red);

        container.add(btnChangePass);
        container.add(lblNotify);
        container.add(btnLogin);
        container.add(txtPassword);
        container.add(lblPassword);
        container.add(txtUserName);
        container.add(lblUserName);
        container.add(toolbar);
    }

}
