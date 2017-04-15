package main.java.view;

import main.java.controller.subject.SubjectController;
import main.java.model.ClassSubject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class SubjectListPanel extends JPanel {
    public static final int R_ID_BTN_SEARCH = 0;
    public static final int R_ID_BTN_ADD_SUBJECT = 1;

    //UI View variables
    JTextField tfSearch;
    JButton btnSearch;
    JButton btnAddSubject;
    DefaultTableModel tableModel;
    JTable subjectTable;

    //Local variables
    private int width, height;
    private OnClickListener mListener;


    public SubjectListPanel(int x, int y, int width, int height) {
        super();
        this.width = width;
        this.height = height;

        setBounds(x, y, width, height);
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblStudentList = new JLabel("Danh sách môn học");
        lblStudentList.setBounds(MARGIN, MARGIN - 8, 240, LINE_HEIGHT);
        lblStudentList.setFont(new Font("Sans-serif", Font.BOLD, 18));
        lblStudentList.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblStudentList);

        JLabel lblSearch = new JLabel("Tìm kiếm môn học");
        lblSearch.setBounds(MARGIN, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        lblSearch.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSearch.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSearch);

        tfSearch = new JTextField();
        tfSearch.setBounds(MARGIN + 160, MARGIN + LINE_HEIGHT, 140, LINE_HEIGHT);
        add(tfSearch);

        btnSearch = new JButton("Tìm");
        btnSearch.setBounds(MARGIN + 160 + 140, MARGIN + LINE_HEIGHT, 80, LINE_HEIGHT);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(Color.decode("#616161"));
        add(btnSearch);

        btnAddSubject = new JButton("Thêm môn học mới");
        btnAddSubject.setBounds(MARGIN + 160 + 140 + 80, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        btnAddSubject.setForeground(Color.WHITE);
        btnAddSubject.setBackground(Color.decode("#F57C00"));
        add(btnAddSubject);


        //Table manage subject
        tableModel = new DefaultTableModel(SubjectController.getColumnNames(), 5);
        subjectTable = new JTable(tableModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                JComponent jc = (JComponent) comp;//for Custom JComponent
                if ((column == subjectTable.getColumnCount() - 1)) {
                    //Last column
                    comp.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
                    subjectTable.convertRowIndexToView(0);
                } else {
                    comp.setForeground(Color.BLACK);
                }
                return comp;
            }
        };

        subjectTable.setBounds(MARGIN, MARGIN + 80, width - 2 * MARGIN, 240);
        subjectTable.setPreferredScrollableViewportSize(new Dimension(450, 63));
        subjectTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(subjectTable);
        scrollPane.setVisible(true);
        scrollPane.setBounds(MARGIN, MARGIN + 80, width - 2 * MARGIN, 240);
        add(scrollPane);

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


        subjectTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JTable target = (JTable) e.getSource();
                if (target.getSelectedColumn() == target.getColumnCount() - 1) {
                    //Click the last column'
                    //Show new frame
                    ManageStudentDialog dialog = new ManageStudentDialog("Student list of " + target.getSelectedRow());
                    dialog.setModal(true);
                    dialog.setVisible(true);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setOnButtonClickListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public void initData() {
        tableModel.setRowCount(0);
        List<ClassSubject> subjectList = SubjectController.getInstance().getSubjectList();

        for (int i = 0; i < subjectList.size(); i++)
        {
            ClassSubject subject = subjectList.get(i);
            String[] row = {subject.getSubjectId(), subject.getSubjectName(), String.valueOf(SubjectController.getInstance().getStudentList(subject.getSubjectId()).size())};
            tableModel.addRow(row);
        }
    }
}
