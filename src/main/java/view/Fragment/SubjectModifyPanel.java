package main.java.view.Fragment;

import main.java.controller.subject.SubjectController;
import main.java.model.ClassSubject;
import main.java.model.Timetable;
import main.java.view.OnClickListener;
import net.sourceforge.jdatepicker.impl.JDatePanel_Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static main.java.view.Frame.BaseFrame.LINE_HEIGHT;
import static main.java.view.Frame.BaseFrame.MARGIN;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class SubjectModifyPanel extends JPanel {

    JTextField tfSubjectID;
    JTextField tfSubjectName;
    JDatePanel_Calendar jDatePanelStartDate;
    JDatePanel_Calendar jDatePanelEndDate;
    JComboBox<String> cbbDate;
    JComboBox<String> cbbRoom;
    SpinnerNumberModel spinnerHourModel;
    JSpinner spinnerHour;
    JSpinner spinnerMinute;
    JSpinner spinnerSecond;
    JSpinner spinnerHour2;
    JSpinner spinnerMinute2;
    JSpinner spinnerSecond2;
    JCheckBox checkBox;
    JButton btnSave;
    Date startDate;
    Date endDate;
    private int width, height;
    private OnClickListener mListener;

    public SubjectModifyPanel(int x, int y, int width, int height) {
        super();

        this.width = width;
        this.height = height;

        setBounds(x, y, width, height);
        setBackground(Color.WHITE);
        setLayout(null);

        initLayoutView();
        jDatePanelEndDate.setEnabled(false);
        jDatePanelStartDate.setEnabled(false);
        cbbDate.setEnabled(false);
        cbbRoom.setEnabled(false);
        spinnerHour.setEnabled(false);
        spinnerMinute.setEnabled(false);
        spinnerSecond.setEnabled(false);
        spinnerHour2.setEnabled(false);
        spinnerMinute2.setEnabled(false);
        spinnerSecond2.setEnabled(false);
        //Event
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    jDatePanelEndDate.setEnabled(true);
                    jDatePanelStartDate.setEnabled(true);
                    cbbDate.setEnabled(true);
                    cbbRoom.setEnabled(true);
                    spinnerHour.setEnabled(true);
                    spinnerMinute.setEnabled(true);
                    spinnerSecond.setEnabled(true);
                    spinnerHour2.setEnabled(true);
                    spinnerMinute2.setEnabled(true);
                    spinnerSecond2.setEnabled(true);
                } else {
                    jDatePanelEndDate.setEnabled(false);
                    jDatePanelStartDate.setEnabled(false);
                    cbbDate.setEnabled(false);
                    cbbRoom.setEnabled(false);
                    spinnerHour.setEnabled(false);
                    spinnerMinute.setEnabled(false);
                    spinnerSecond.setEnabled(false);
                    spinnerHour2.setEnabled(false);
                    spinnerMinute2.setEnabled(false);
                    spinnerSecond2.setEnabled(false);
                }
            }
        });


        jDatePanelEndDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDatePanelStartDate.setValue(jDatePanelStartDate.getValue());
                endDate = jDatePanelStartDate.getValue().getTime();
            }
        });

        jDatePanelStartDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDatePanelStartDate.setValue(jDatePanelStartDate.getValue());
                startDate = jDatePanelStartDate.getValue().getTime();

            }
        });


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subjectId = tfSubjectID.getText();
                String subjectName = tfSubjectName.getText();

                ClassSubject subject = new ClassSubject(subjectId, subjectName);
                SubjectController.getInstance().addNewSubject(subject);

                if (checkBox.isSelected()) {
                    Date beginTime = new Date();
                    beginTime.setHours((Integer) spinnerHour.getValue());
                    beginTime.setMinutes((Integer) spinnerMinute.getValue());
                    beginTime.setSeconds((Integer) spinnerSecond.getValue());

                    Date endTime = new Date();
                    endTime.setHours((Integer) spinnerHour2.getValue());
                    endTime.setMinutes((Integer) spinnerMinute2.getValue());
                    endTime.setSeconds((Integer) spinnerSecond2.getValue());

                    String room = cbbRoom.getSelectedItem().toString();
                    String day = cbbDate.getSelectedItem().toString();

                    Timetable timetable = new Timetable(subject, startDate, endDate, 15, day, beginTime, endTime, room);
                    SubjectController.getInstance().addNewTimeTable(timetable);
                }

            }
        });
    }

    private void initLayoutView() {
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
        lblSubjectName.setBounds(MARGIN, MARGIN + 2 * LINE_HEIGHT, 160, LINE_HEIGHT);
        lblSubjectName.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblSubjectName.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblSubjectName);

        tfSubjectName = new JTextField();
        tfSubjectName.setBounds(MARGIN + 160, MARGIN + 2 * LINE_HEIGHT, 160, LINE_HEIGHT);
        tfSubjectName.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        tfSubjectName.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(tfSubjectName);

        checkBox = new JCheckBox();
        checkBox.setBounds(MARGIN, MARGIN + 3 * LINE_HEIGHT, LINE_HEIGHT, LINE_HEIGHT);
        checkBox.setBackground(Color.WHITE);
        add(checkBox);

        JLabel lblCheckbox = new JLabel("Thêm thời khóa biểu");
        lblCheckbox.setBounds(MARGIN + LINE_HEIGHT, MARGIN + 3 * LINE_HEIGHT, 160, LINE_HEIGHT);
        lblCheckbox.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        lblCheckbox.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(lblCheckbox);

        JLabel jLabelStartDate = new JLabel("Ngày bắt đầu: ");
        jLabelStartDate.setBounds(MARGIN, MARGIN + LINE_HEIGHT * 4, 120, LINE_HEIGHT);
        jLabelStartDate.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        jLabelStartDate.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(jLabelStartDate);

        jDatePanelStartDate = new JDatePanel_Calendar();
        jDatePanelStartDate.setBounds(MARGIN + 120, MARGIN + 4 * LINE_HEIGHT, 160, 150);
        add(jDatePanelStartDate);

        JLabel jLabelEndDate = new JLabel("Ngày bắt đầu: ");
        jLabelEndDate.setBounds(MARGIN + 300, MARGIN + LINE_HEIGHT * 4, 120, LINE_HEIGHT);
        jLabelEndDate.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        jLabelEndDate.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(jLabelEndDate);

        jDatePanelEndDate = new JDatePanel_Calendar();
        jDatePanelEndDate.setBounds(MARGIN + 420, MARGIN + 4 * LINE_HEIGHT, 160, 150);
        add(jDatePanelEndDate);

        JLabel labelDay = new JLabel("Nhập thứ:");
        labelDay.setBounds(MARGIN, MARGIN + 5 * LINE_HEIGHT + 150, 120, LINE_HEIGHT);
        labelDay.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        labelDay.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(labelDay);

        cbbDate = new JComboBox<>();
        cbbDate.addItem("Thứ hai");
        cbbDate.addItem("Thứ ba");
        cbbDate.addItem("Thứ tư");
        cbbDate.addItem("Thứ năm");
        cbbDate.addItem("Thứ sáu");
        cbbDate.addItem("Thứ bảy");
        cbbDate.addItem("Chủ nhật");
        cbbDate.setBounds(MARGIN + 120, MARGIN + 5 * LINE_HEIGHT + 150, 100, LINE_HEIGHT);
        cbbDate.setBackground(new Color(247, 249, 249));
        add(cbbDate);

        JLabel labelClass = new JLabel("Nhập phòng học:");
        labelClass.setBounds(MARGIN + 300, MARGIN + 5 * LINE_HEIGHT + 150, 150, 30);
        labelClass.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        labelClass.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(labelClass);

        cbbRoom = new JComboBox<>();
        cbbRoom.addItem("C22");
        cbbRoom.addItem("C23");
        cbbRoom.addItem("C32");
        cbbRoom.addItem("C33");
        cbbRoom.addItem("C42");
        cbbRoom.addItem("C43");
        cbbRoom.addItem("E101");
        cbbRoom.addItem("E102");
        cbbRoom.addItem("E103");
        cbbRoom.addItem("E104");
        cbbRoom.addItem("E201");
        cbbRoom.addItem("E202");
        cbbRoom.addItem("E203");
        cbbRoom.addItem("E204");
        cbbRoom.addItem("E301");
        cbbRoom.addItem("E302");
        cbbRoom.addItem("E303");
        cbbRoom.addItem("E304");
        cbbRoom.addItem("E401");
        cbbRoom.addItem("E402");
        cbbRoom.addItem("E403");
        cbbRoom.addItem("E404");
        cbbRoom.addItem("F101");
        cbbRoom.addItem("F102");
        cbbRoom.addItem("F103");
        cbbRoom.addItem("F104");
        cbbRoom.addItem("F201");
        cbbRoom.addItem("F202");
        cbbRoom.addItem("F203");
        cbbRoom.addItem("F204");
        cbbRoom.addItem("F301");
        cbbRoom.addItem("F302");
        cbbRoom.addItem("F303");
        cbbRoom.addItem("F304");

        cbbRoom.setBounds(MARGIN + 450, MARGIN + 5 * LINE_HEIGHT + 150, 100, LINE_HEIGHT);
        cbbRoom.setBackground(new Color(247, 249, 249));
        add(cbbRoom);

        JLabel labelStartTime = new JLabel("Nhập Giờ bắt đầu:");
        labelStartTime.setBounds(MARGIN, MARGIN + 7 * LINE_HEIGHT + 150, 120, LINE_HEIGHT);
        labelStartTime.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        labelStartTime.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(labelStartTime);

        spinnerHourModel = new SpinnerNumberModel(0, 0, 23, 1);
        spinnerHour = new JSpinner(spinnerHourModel);
        spinnerHour.setBounds(MARGIN + 120, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerHour.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerHour);

        SpinnerNumberModel spinnerMinuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        spinnerMinute = new JSpinner(spinnerMinuteModel);
        spinnerMinute.setBounds(MARGIN + 180, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerMinute.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerMinute);

        SpinnerNumberModel spinnerSecondModel = new SpinnerNumberModel(0, 0, 59, 1);
        spinnerSecond = new JSpinner(spinnerSecondModel);
        spinnerSecond.setBounds(MARGIN + 240, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerSecond.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerSecond);

        JLabel labelEndTime = new JLabel("Nhập Giờ kết thúc:");
        labelEndTime.setBounds(MARGIN + 300, MARGIN + 7 * LINE_HEIGHT + 150, 120, LINE_HEIGHT);
        labelEndTime.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        labelEndTime.setForeground(Color.decode(Toolbar.MATERIAL_TOOLBAR_COLOR));
        add(labelEndTime);

        SpinnerNumberModel spinnerHourModel2 = new SpinnerNumberModel(0, 0, 23, 1);
        spinnerHour2 = new JSpinner(spinnerHourModel2);
        spinnerHour2.setBounds(MARGIN + 420, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerHour2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerHour2);

        SpinnerNumberModel spinnerMinuteModel2 = new SpinnerNumberModel(0, 0, 59, 1);
        spinnerMinute2 = new JSpinner(spinnerMinuteModel2);
        spinnerMinute2.setBounds(MARGIN + 480, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerMinute2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerMinute2);

        SpinnerNumberModel spinnerSecondModel2 = new SpinnerNumberModel(0, 0, 59, 1);
        spinnerSecond2 = new JSpinner(spinnerSecondModel2);
        spinnerSecond2.setBounds(MARGIN + 540, MARGIN + 7 * LINE_HEIGHT + 150, 50, LINE_HEIGHT);
        spinnerSecond2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        add(spinnerSecond2);

        btnSave = new JButton("Lưu");
        btnSave.setBounds(width - 10 * MARGIN, 3 * MARGIN, 100, 40);
        btnSave.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));

        add(btnSave);

    }
}
