package main.java.view;

import javax.swing.*;
import java.awt.*;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class SubjectModifyPanel extends JPanel {

    private int width, height;
    private OnClickListener mListener;

    JTextField tfSubjectID;
    JTextField tfSubjectName;

    public SubjectModifyPanel(int x, int y, int width, int height)
    {
        super();

        this.width = width;
        this.height = height;

        setBounds(x,y, width, height);
        setBackground(Color.WHITE);
        setLayout(null);

        initLayoutView();
    }

    private void initLayoutView()
    {
        JLabel lblStudentList = new JLabel("Chỉnh sửa môn học");
        lblStudentList.setBounds(MARGIN, MARGIN - 8, 240, LINE_HEIGHT);
        lblStudentList.setFont(new Font("Sans-serif", Font.BOLD, 18));
        lblStudentList.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblStudentList);

        JLabel lblSubjectID = new JLabel("Nhập ID môn học");
        lblSubjectID.setBounds(MARGIN, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        lblSubjectID.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSubjectID.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSubjectID);

        tfSubjectID = new JTextField();
        tfSubjectID.setBounds(MARGIN + 160, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        tfSubjectID.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        tfSubjectID.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(tfSubjectID);

        JLabel lblSubjectName = new JLabel("Nhập tên môn học");
        lblSubjectName.setBounds(MARGIN, MARGIN + 2*LINE_HEIGHT, 160, LINE_HEIGHT);
        lblSubjectName.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSubjectName.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSubjectName);

        tfSubjectName = new JTextField();
        tfSubjectName.setBounds(MARGIN + 160, MARGIN + 2*LINE_HEIGHT, 160, LINE_HEIGHT);
        tfSubjectName.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        tfSubjectName.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(tfSubjectName);
    }
}
