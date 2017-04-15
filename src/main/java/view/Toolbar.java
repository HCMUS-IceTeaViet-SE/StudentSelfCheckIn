package main.java.view;

import main.java.utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class Toolbar extends JPanel {
    public static final String MATERIAL_TOOLBAR_COLOR = "#2196F2";
    public static final int R_ID_BTN_SIGNIN = 0;
    public static final int R_ID_BTN_SIGNOUT = 1;

    //UI View variables
    private JLabel lblUser;
    private JButton btnLogin;

    //Local variables
    private int defaultWidth, defaultHeight;
    private OnClickListener mListener;
    private boolean isSignedIn = false;


    public Toolbar(int defaultWidth, int defaultHeight) {
        super();
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;

        setBounds(0, 0, defaultWidth, defaultHeight);
        setBackground(Color.decode(MATERIAL_TOOLBAR_COLOR));
        setLayout(null);

        initContentLayout();

        //Add event
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSignedIn) {
                    mListener.onClick(R_ID_BTN_SIGNOUT);
                    isSignedIn = false;
                    btnLogin.setText("Đăng nhập");
                } else {
                    mListener.onClick(R_ID_BTN_SIGNIN);
                    isSignedIn = true;
                    btnLogin.setText("Đăng xuất");
                }
            }
        });
    }

    private void initContentLayout() {
        int logoSize = defaultHeight - 2 * MARGIN;
        JLabel logo = new JLabel(UIUtils.makeIcon(getClass(), "/main/res/logo.png", logoSize, logoSize));
        logo.setBounds(MARGIN, MARGIN, logoSize, logoSize);
        add(logo);

        JLabel jTitle = new JLabel("HCMUS ĐIỂM DANH");
        jTitle.setBounds(MARGIN + 80, MARGIN, 240, LINE_HEIGHT);
        jTitle.setFont(new Font("Sans-serif", Font.BOLD, 20));
        jTitle.setForeground(Color.WHITE);
        add(jTitle);

        JLabel jSubTitle = new JLabel("Version 0.1. Copyright © IceTeaViet");
        jSubTitle.setBounds(MARGIN + 80, MARGIN + LINE_HEIGHT, 240, LINE_HEIGHT - 8);
        jSubTitle.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        jSubTitle.setForeground(Color.WHITE);
        add(jSubTitle);

        lblUser = new JLabel("Xin chào, Đoàn Hiếu Tâm");
        lblUser.setBounds(defaultWidth - 160 - 2 * MARGIN, MARGIN, 160, LINE_HEIGHT);
        lblUser.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblUser.setForeground(Color.WHITE);
        add(lblUser);

        btnLogin = new JButton("Đăng nhập");
        if (isSignedIn)
            btnLogin.setText("Đăng xuất");
        btnLogin.setBounds(defaultWidth - 160 - 2 * MARGIN, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(Color.decode(MATERIAL_TOOLBAR_COLOR));
        UIUtils.setEmptyBorder(btnLogin);
        add(btnLogin);
    }

    public int getHeight() {
        return defaultHeight;
    }

    public int getWidth() {
        return defaultWidth;
    }

    public void setOnSignButtonClickListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public void setLoginInformationEnabled(boolean enabled) {
        lblUser.setVisible(enabled);
        btnLogin.setVisible(enabled);
    }
}
