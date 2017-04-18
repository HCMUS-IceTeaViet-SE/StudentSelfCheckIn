package main.java.view.Frame;

import main.java.view.BaseView;
import main.java.view.Fragment.Toolbar;

import javax.swing.*;


/**
 * Created by Genius Doan on 4/14/2017.
 */
public abstract class BaseFrame extends JFrame implements BaseView {
    public static final int MARGIN_TOP = 80;
    public static final int MARGIN = 16;
    public static final int LINE_HEIGHT = 32;

    protected int width, height;
    protected Toolbar mToolbar = null;

    protected BaseFrame() {
        this("Untitled Frame");
    }

    protected BaseFrame(String title) {
        this(title, defaultWidth, defaultHeight);
    }

    protected BaseFrame(String title, int width, int height) {
        super(title);
        this.width = width;
        this.height = height;

        // invoke the JFrame constructor
        setSize(width + MARGIN, height + MARGIN);
        //setLayout( new FlowLayout() );       // set the layout manager
        setLayout(null);

        //Init layout
        initLayoutView();
        initData();
    }

    @Override
    public void initLayoutView() {
        //Toolbar
        mToolbar = new Toolbar(width, 96);
        add(mToolbar);
    }

    @Override
    public void initData() {
    }
}
