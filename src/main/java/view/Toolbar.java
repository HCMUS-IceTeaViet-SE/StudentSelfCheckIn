package main.java.view;

import main.java.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class Toolbar extends JPanel {
    public static final String MATERIAL_TOOLBAR_COLOR = "#2196F2";

    private JLabel lblUser;
    private JButton btnLogin;

    private int defaultWidth, defaultHeight;

    public Toolbar(int defaultWidth, int defaultHeight) {
        super();
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;

        setBounds(0, 0, defaultWidth, defaultHeight);
        setBackground(Color.decode(MATERIAL_TOOLBAR_COLOR));
        setLayout(null);

        initContentLayout();
    }

    private void initContentLayout() {
        JLabel logo = new JLabel(UIUtils.makeIcon(getClass(), "/main/res/logo.png", 48,48));
        logo.setBounds(MARGIN, MARGIN, 48,48);
        add(logo);

        JLabel jTitle = new JLabel("CHƯƠNG TRÌNH ĐIỂM DANH");
        jTitle.setBounds(MARGIN + 56, MARGIN, 240, LINE_HEIGHT);
        jTitle.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        jTitle.setForeground(Color.WHITE);
        add(jTitle);

        lblUser = new JLabel("Xin chào, Đoàn Hiếu Tâm");
        lblUser.setBounds(defaultWidth - 240, MARGIN, 240, LINE_HEIGHT);
        lblUser.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblUser.setForeground(Color.WHITE);
        add(lblUser);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(defaultWidth - 240, MARGIN + LINE_HEIGHT, 240,16);
        add(btnLogin);
    }

    public int getHeight()
    {
        return defaultHeight;
    }

    public int getWidth()
    {
        return defaultWidth;
    }
}
