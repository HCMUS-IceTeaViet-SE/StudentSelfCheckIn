package main.java.view;

import main.java.controller.BaseController;

import javax.swing.*;

/**
 * Created by Genius Doan on 4/14/2017.
 */
public abstract class BaseFrame extends JFrame implements BaseView {

    protected int width, height;
    Toolbar toolbar = null;

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
        setSize(width, height);
        //setLayout( new FlowLayout() );       // set the layout manager
        setLayout(null);

        //Init layout
        initLayoutView();
        initData();
    }

    @Override
    public void initLayoutView() {
        //Toolbar
        toolbar = new Toolbar(width, 96);
        add(toolbar);
    }

    @Override
    public void initData() {
    }
}
