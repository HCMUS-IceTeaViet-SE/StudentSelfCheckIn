package main.java.view.Frame;

import main.java.view.Fragment.CheckInListPanel;
import main.java.view.Fragment.LeftNavigationBar;
import main.java.view.Fragment.SubjectListPanel;
import main.java.view.Fragment.SubjectModifyPanel;
import main.java.view.OnClickListener;

import javax.swing.*;


/**
 * Created by Genius Doan on 4/11/2017.
 */
public class MainFrame extends BaseFrame {
    //UI View variables
    private LeftNavigationBar leftNavigationBar;
    private SubjectListPanel subjectListPanel;
    private SubjectModifyPanel subjectModifyPanel;
    private CheckInListPanel checkInListPanel;

    //Local variables
    private int currMainPanelId = 0;


    public MainFrame() {
        this("Điểm danh - HCMUS");
    }

    public MainFrame(String title) {
        this(title, defaultWidth, defaultHeight);
    }

    public MainFrame(String title, int width, int height) {
        super(title, width, height);
        this.width = width;
        this.height = height;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mToolbar.setLoginInformationEnabled(true);
    }

    @Override
    public void initLayoutView() {
        super.initLayoutView();

        //Left navigation bar
        leftNavigationBar = new LeftNavigationBar(0, mToolbar.getHeight(), 240, height - mToolbar.getHeight());
        add(leftNavigationBar);

        //Main content
        subjectListPanel = new SubjectListPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());
        subjectModifyPanel = new SubjectModifyPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());
        checkInListPanel = new CheckInListPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());

        add(subjectListPanel);

        leftNavigationBar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int id) {
                setRightContentPanel(id);
            }
        });

        subjectListPanel.setOnButtonClickListener(new OnClickListener() {
            @Override
            public void onClick(int id) {
                setLeftNavigationBar(id);
            }
        });

        mToolbar.setOnSignButtonClickListener(new OnClickListener() {
            @Override
            public void onClick(int id) {

            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        subjectListPanel.initData();
    }


    private void setRightContentPanel(int id) {
        switch (id) {
            case LeftNavigationBar.R_ID_BTN_LIST_SUBJECT:
                if (subjectListPanel == null) {
                    subjectListPanel = new SubjectListPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_LIST_SUBJECT) {
                    //Replace
                    remove(subjectModifyPanel);
                    remove(checkInListPanel);
                    add(subjectListPanel);
                    currMainPanelId = LeftNavigationBar.R_ID_BTN_LIST_SUBJECT;
                }
                break;

            case LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT:
                if (subjectModifyPanel == null) {
                    subjectModifyPanel = new SubjectModifyPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT) {
                    //Replace
                    remove(subjectListPanel);
                    remove(checkInListPanel);
                    add(subjectModifyPanel);
                    currMainPanelId = LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT;
                }

                break;

            case LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST:
                if (checkInListPanel == null) {
                    checkInListPanel = new CheckInListPanel(leftNavigationBar.getWidth(), mToolbar.getHeight(), width - leftNavigationBar.getWidth(), height - mToolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST) {
                    //Replace
                    remove(subjectModifyPanel);
                    remove(subjectListPanel);
                    add(checkInListPanel);
                    currMainPanelId = LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST;
                }
                break;

            default:
                break;
        }

        revalidate();
        repaint();
    }

    private void setLeftNavigationBar(int id) {
        leftNavigationBar.setNavigationBarItem(id);
        currMainPanelId = id;
    }
}
