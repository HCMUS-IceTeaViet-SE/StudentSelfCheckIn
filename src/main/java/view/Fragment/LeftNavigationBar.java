package main.java.view.Fragment;

import main.java.view.OnClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class LeftNavigationBar extends JPanel {
    public static final int R_ID_BTN_LIST_SUBJECT = 0;
    public static final int R_ID_BTN_MODIFY_SUBJECT = 1;
    public static final int R_ID_BTN_SHOW_CHECKIN_LIST = 2;

    //UI View variables
    private JButton btnListSubject;
    private JButton btnModifySubject;
    private JButton btnShowCheckInList;

    //Local variables
    private OnClickListener mListener;
    private int width, height;
    private Color selectedColor, normalColor;


    public LeftNavigationBar(int x, int y, int width, int height) {
        super();
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
        setLayout(null);

        selectedColor = Color.decode("#F57C00");
        normalColor = Color.decode("#616161");

        initContentLayout();
    }

    private void initContentLayout() {
        btnListSubject = new JButton("Xem danh sách môn học");
        btnListSubject.setBounds(0, 0, width, 64);
        btnListSubject.setForeground(Color.WHITE);
        add(btnListSubject);

        btnModifySubject = new JButton("Thêm/Chỉnh sửa môn học");
        btnModifySubject.setBounds(0, 64, width, 64);
        btnModifySubject.setForeground(Color.WHITE);
        add(btnModifySubject);

        btnShowCheckInList = new JButton("Xem kết quả điểm danh");
        btnShowCheckInList.setBounds(0, 64 + 64, width, 64);
        btnShowCheckInList.setForeground(Color.WHITE);
        add(btnShowCheckInList);

        clearColor();
        btnListSubject.setBackground(selectedColor);


        //Event
        btnListSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnListSubject.setBackground(selectedColor);
                mListener.onClick(R_ID_BTN_LIST_SUBJECT);
            }
        });

        btnShowCheckInList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnShowCheckInList.setBackground(selectedColor);
                mListener.onClick(R_ID_BTN_SHOW_CHECKIN_LIST);
            }
        });


        btnModifySubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnModifySubject.setBackground(selectedColor);
                mListener.onClick(R_ID_BTN_MODIFY_SUBJECT);
            }
        });
    }

    public void setOnClickListener(OnClickListener listener) {
        if (listener != null)
            this.mListener = listener;
        else
            System.err.println("Can not set listener for a null object!");
    }

    public void setNavigationBarItem(int id) {
        clearColor();
        switch (id) {
            case LeftNavigationBar.R_ID_BTN_LIST_SUBJECT:
                btnListSubject.setBackground(selectedColor);
                break;

            case LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT:
                btnModifySubject.setBackground(selectedColor);
                break;

            case LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST:
                btnShowCheckInList.setBackground(selectedColor);
                break;

            default:
                break;
        }

        mListener.onClick(id);
    }


    //
    private void clearColor() {
        btnListSubject.setBackground(normalColor);
        btnModifySubject.setBackground(normalColor);
        btnShowCheckInList.setBackground(normalColor);
    }
}
