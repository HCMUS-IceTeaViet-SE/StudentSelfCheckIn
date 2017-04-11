package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class SubjectListPanel extends JPanel {
    public static final int R_ID_BTN_SEARCH = 0;
    public static final int R_ID_BTN_ADD_SUBJECT = 1;

    //Views
    JTextField tfSearch;
    JButton btnSearch;
    JButton btnAddSubject;

    private int width, height;
    private OnClickListener mListener;

    public SubjectListPanel(int x, int y, int width, int height)
    {
        super();
        this.width = width;
        this.height = height;

        setBounds(x,y, width, height);
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblStudentList = new JLabel("Danh sách môn học");
        lblStudentList.setBounds(MARGIN, MARGIN, 160, 40);
        lblStudentList.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblStudentList.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblStudentList);

        JLabel lblSearch = new JLabel("Tìm kiếm môn học");
        lblSearch.setBounds(MARGIN, MARGIN + 40, 160, 40);
        lblSearch.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSearch.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSearch);

        tfSearch = new JTextField();
        tfSearch.setBounds(MARGIN + 160,MARGIN + 40, 140, LINE_HEIGHT);
        add(tfSearch);

        btnSearch = new JButton("Tìm");
        btnSearch.setBounds(MARGIN + 160 + 140, MARGIN + 40, 80, 40);
        btnSearch.setForeground(Color.WHITE);
        add(btnSearch);

        btnAddSubject = new JButton("Thêm môn học mới");
        btnAddSubject.setBounds(MARGIN + 160 + 140 + 80, MARGIN + 40, 160, 40);
        btnAddSubject.setForeground(Color.WHITE);
        add(btnAddSubject);

        //Events
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mListener.onClick(R_ID_BTN_SEARCH);
            }
        });

        btnAddSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mListener.onClick(R_ID_BTN_ADD_SUBJECT);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setOnButtonClickListener(OnClickListener listener)
    {
        this.mListener = listener;
    }
}
