package main.java.view;

import main.java.controller.subject.SubjectController;
import main.java.model.ClassSubject;
import main.java.model.Student;
import main.java.model.StudentSubject;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import static main.java.view.MainFrame.LINE_HEIGHT;
import static main.java.view.MainFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class CheckInListPanel extends JPanel {

    //Local variables
    private int width, height;
    private OnClickListener mListener;
    DefaultTableModel tableModel;
    JScrollPane jScrollPaneAttendance;
    JTable attendanceTable;
    JComboBox<String> cbbSearch;
    JButton btnStatistic;
    JButton btnEdit;
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

        initData();

        btnStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                int selectedIndex = cbbSearch.getSelectedIndex();
                Map<Student, List<Boolean>> data = SubjectController.getInstance().getCheckInDataBySubject(String.valueOf(SubjectController.getInstance().getSubjectList().get(selectedIndex).getSubjectId()));

                for (Map.Entry<Student, List<Boolean>> entry : data.entrySet()) {
                    Student std = entry.getKey();
                    List<Boolean> value = entry.getValue();

                    Object[] row = {std.getStudentId(), value.get(0),value.get(1),value.get(2),value.get(3),value.get(4),value.get(5)
                            ,value.get(6),value.get(7),value.get(8),value.get(9),value.get(10),value.get(11)
                            ,value.get(12),value.get(13),value.get(14)};

                    tableModel.addRow(row);
                }
            }
        });
    }

    private void initData() {
        List<ClassSubject> subjectList = SubjectController.getInstance().getSubjectList();

        for (int i = 0; i < subjectList.size(); i++)
        {
            cbbSearch.addItem(subjectList.get(i).getSubjectName());
        }
    }

    private void initLayoutView()
    {
        JLabel lblStudentList = new JLabel("Kết quả điểm danh");
        lblStudentList.setBounds(MARGIN, MARGIN - 8, 240, LINE_HEIGHT);
        lblStudentList.setFont(new Font("Sans-serif", Font.BOLD, 18));
        lblStudentList.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblStudentList);

        JLabel lblSearch = new JLabel("Thống kê theo môn học");
        lblSearch.setBounds(MARGIN, MARGIN + LINE_HEIGHT, 160, LINE_HEIGHT);
        lblSearch.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSearch.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSearch);

        cbbSearch = new JComboBox<>();
        cbbSearch.setBounds(MARGIN + 160,MARGIN + LINE_HEIGHT, 300, LINE_HEIGHT);
        add(cbbSearch);

        btnStatistic = new JButton("Thống kê");
        btnStatistic.setBounds(MARGIN + 460, MARGIN + LINE_HEIGHT, 100, LINE_HEIGHT);
        btnStatistic.setForeground(Color.WHITE);
        btnStatistic.setBackground(Color.decode("#616161"));
        add(btnStatistic);

        String[] columns = new String[] {
                "MSSV", "#1", "#2","#3","#4","#5","#6","#7",
                "#8","#9","#10","#11","#12","#13","#14","#15"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
        };

        final Class[] columnClass3 = new Class[] {
                String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class
                , Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class
                , Boolean.class, Boolean.class
        };

        tableModel = new DefaultTableModel(data, columns) {

            @Override
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass3[columnIndex];
            }
        };

        attendanceTable = new JTable(tableModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                JComponent jc = (JComponent) comp;//for Custom JComponent
                if ((column == attendanceTable.getColumnCount() - 1)) {
                    //Last column
                    comp.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
                    attendanceTable.convertRowIndexToView(0);
                } else {
                    comp.setForeground(Color.BLACK);
                }
                return comp;
            }
        };

        attendanceTable.setRowHeight(LINE_HEIGHT);

        attendanceTable.setBounds(MARGIN, MARGIN + 80, width - 2*MARGIN, 240);
        attendanceTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        attendanceTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(attendanceTable);
        scrollPane.setVisible(true);
        scrollPane.setBounds(MARGIN, MARGIN + 80, width - 2*MARGIN, 300);
        add(scrollPane);

        btnEdit = new JButton("Chỉnh sửa");
        btnEdit.setBounds(width - 8*MARGIN,380 + 2*MARGIN,100,LINE_HEIGHT);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(Color.decode("#616161"));
        add(btnEdit);

    }
}
