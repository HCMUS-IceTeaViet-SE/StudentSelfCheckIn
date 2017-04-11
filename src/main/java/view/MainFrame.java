package main.java.view;

import main.java.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class MainFrame extends JFrame{

    private int defaultWidth = 800;
    private int defaultHeight = 540;
    public static final int MARGIN_TOP = 80;
    public static final int MARGIN = 16;
    public static final int LINE_HEIGHT = 32;

    //Views
    private Toolbar toolbar;
    private LeftNavigationBar leftNavigationBar;
    private SubjectListPanel subjectListPanel;
    private SubjectModifyPanel subjectModifyPanel;
    private CheckInListPanel checkInListPanel;

    //Local variables
    private int currMainPanelId = 0;


    public MainFrame()
    {
        super();
    }

    public MainFrame(String title)
    {
        super(title);
        // invoke the JFrame constructor
        setSize( defaultWidth, defaultHeight );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setLayout( new FlowLayout() );       // set the layout manager
        setLayout(null);


        //Init layout
        initLayout();
    }

    private void initLayout() {
        //Toolbar
        toolbar = new Toolbar(defaultWidth, 80);
        add(toolbar);

        //Left navigation bar
        leftNavigationBar = new LeftNavigationBar(0, toolbar.getHeight(), 240, defaultHeight - toolbar.getHeight());
        add(leftNavigationBar);

        //Main content
        subjectListPanel = new SubjectListPanel(240,toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());
        add(subjectListPanel);

        subjectModifyPanel = new SubjectModifyPanel(240, toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());
        checkInListPanel = new CheckInListPanel(240,toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());

        leftNavigationBar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int id) {
                setRightContentPanel(id);
            }
        });

        subjectListPanel.setOnButtonClickListener(new OnClickListener() {
            @Override
            public void onClick(int id) {
                System.out.println(id);
            }
        });
    }


    private void setRightContentPanel(int id) {
        switch (id) {
            case LeftNavigationBar.R_ID_BTN_LIST_SUBJECT:
                if (subjectListPanel == null) {
                    subjectListPanel = new SubjectListPanel(240,toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_LIST_SUBJECT) {
                    //Replace
                    remove(subjectModifyPanel);
                    remove(checkInListPanel);
                    add(subjectListPanel);
                }
                break;

            case LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT:
                if (subjectModifyPanel == null) {
                    subjectModifyPanel = new SubjectModifyPanel(240, toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_MODIFY_SUBJECT) {
                    //Replace
                    remove(subjectListPanel);
                    remove(checkInListPanel);
                    add(subjectModifyPanel);
                }

                break;

            case LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST:
                if (checkInListPanel == null) {
                    checkInListPanel = new CheckInListPanel(240,toolbar.getHeight(), defaultWidth - 240, defaultHeight - toolbar.getHeight());
                }
                if (currMainPanelId != LeftNavigationBar.R_ID_BTN_SHOW_CHECKIN_LIST) {
                    //Replace
                    remove(subjectModifyPanel);
                    remove(subjectListPanel);
                    add(checkInListPanel);
                }
                break;

            default:
                break;
        }

        revalidate();
        repaint();
    }
}
