package main.java.view.Dialog;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Genius Doan on 4/14/2017.
 */
public class ManageStudentDialog extends BaseDialog {

    //Local variables
    JTable tblStudent;
    JScrollPane jScrollStudentList;
    JComboBox<String> cbbSubjectList;
    JButton btnCheck;
    JButton btnCreateNew;
    JButton btnImport;
    JButton btnAddCheckList;
    //UI View variables


    public ManageStudentDialog() {
        super();
    }

    public ManageStudentDialog(String title) {
        this(title, defaultWidth - 200, defaultHeight + 100);
    }

    public ManageStudentDialog(String title, int width, int height) {
        super(title, width, height);

        JLabel jLabelChooseSubject = new JLabel("Chọn môn học:");
        jLabelChooseSubject.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        jLabelChooseSubject.setBounds(16, 120, 200, 30);
        jLabelChooseSubject.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jLabelChooseSubject);

        cbbSubjectList = new JComboBox<>();
        cbbSubjectList.setBackground(new Color(247, 249, 249));
        cbbSubjectList.setBounds(216, 120, 400, 30);
        add(cbbSubjectList);

        btnCheck = new JButton("Check từ list");
        btnCheck.setBackground(new Color(0, 151, 167));
        btnCheck.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        btnCheck.setBounds(16, 170, 200, 40);
        add(btnCheck);

        btnCreateNew = new JButton("Tạo SV mới");
        btnCreateNew.setBackground(new Color(77, 208, 225));
        btnCreateNew.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        btnCreateNew.setBounds(232, 170, 200, 40);
        add(btnCreateNew);

        btnImport = new JButton("Import từ CSV");
        btnImport.setBackground(new Color(144, 202, 249));
        btnImport.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        btnImport.setBounds(448, 170, 200, 40);
        add(btnImport);

        //headers for the table
        String[] columns = new String[]{
                "Mã số sinh viên", "Tên sinh viên", "Lớp", "Chọn"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][]{
        };

        final Class[] columnClass2 = new Class[]{
                String.class, String.class, String.class, Boolean.class
        };


        //create table model with data
        DefaultTableModel model2 = new DefaultTableModel(data, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3)
                    return true;
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass2[columnIndex];
            }
        };

        tblStudent = new JTable(model2);
        tblStudent.setRowHeight(30);
        tblStudent.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));

        jScrollStudentList = new JScrollPane(tblStudent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollStudentList.setBounds(16, 230, 650, 300);
        add(jScrollStudentList);


        btnAddCheckList = new JButton("Thêm");
        btnAddCheckList.setBounds(260, 550, 100, 40);
        btnAddCheckList.setForeground(new Color(41, 128, 185));
        add(btnAddCheckList);
        //Add view
    }
}
