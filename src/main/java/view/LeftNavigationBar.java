package main.java.view;

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

    private JButton btnListSubject;
    private JButton btnModifySubject;
    private JButton btnShowCheckInList;

    private OnClickListener mListener;
    int width;

    public LeftNavigationBar(int x, int y, int width, int height)
    {
        super();
        this.width = width;
        setBounds(x, y, width, height);
        setLayout(null);

        initContentLayout();
    }

    private void initContentLayout() {
        btnListSubject = new JButton("Xem danh sách môn học");
        btnListSubject.setBounds(0,0, width, 64);
        btnListSubject.setForeground(Color.WHITE);
        add(btnListSubject);

        btnModifySubject = new JButton("Thêm/Chỉnh sửa môn học");
        btnModifySubject.setBounds(0,64, width, 64);
        btnModifySubject.setForeground(Color.WHITE);
        add(btnModifySubject);

        btnShowCheckInList = new JButton("Xem kết quả điểm danh");
        btnShowCheckInList.setBounds(0,64+64, width, 64);
        btnShowCheckInList.setForeground(Color.WHITE);
        add(btnShowCheckInList);

        clearColor();


        //Event
        btnListSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnListSubject.setBackground(Color.ORANGE);
                mListener.onClick(R_ID_BTN_LIST_SUBJECT);
            }
        });

        btnShowCheckInList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnShowCheckInList.setBackground(Color.ORANGE);
                mListener.onClick(R_ID_BTN_SHOW_CHECKIN_LIST);
            }
        });


        btnModifySubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearColor();
                btnModifySubject.setBackground(Color.ORANGE);
                mListener.onClick(R_ID_BTN_MODIFY_SUBJECT);
            }
        });
    }

    public void setOnClickListener(OnClickListener listener)
    {
        if (listener != null)
            this.mListener = listener;
        else
            System.err.println("Can not set listener for a null object!");
    }

    private void clearColor()
    {
        btnListSubject.setBackground(Color.DARK_GRAY);
        btnModifySubject.setBackground(Color.DARK_GRAY);
        btnShowCheckInList.setBackground(Color.DARK_GRAY);
    }
}
