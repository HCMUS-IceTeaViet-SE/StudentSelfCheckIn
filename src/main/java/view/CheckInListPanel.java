package main.java.view;

import javax.swing.*;
import java.awt.*;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class CheckInListPanel extends JPanel {

    //Local variables
    private int width, height;
    private OnClickListener mListener;

    //UI View variables

    public CheckInListPanel(int x, int y, int width, int height)
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
        JLabel lblStudentList = new JLabel("Kết quả điểm danh");
        lblStudentList.setBounds(MARGIN, MARGIN - 8, 240, LINE_HEIGHT);
        lblStudentList.setFont(new Font("Sans-serif", Font.BOLD, 18));
        lblStudentList.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblStudentList);
    }
}
