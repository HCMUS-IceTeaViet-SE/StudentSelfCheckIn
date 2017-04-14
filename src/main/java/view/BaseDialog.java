package main.java.view;

import javax.swing.*;

/**
 * Created by Genius Doan on 4/14/2017.
 */
public class BaseDialog extends JDialog implements BaseView {

    protected Toolbar toolbar;
    protected int width, height;

    public BaseDialog()
    {
        this("Untitled dialog");
    }

    public BaseDialog(String title, int width, int height)
    {
        super();
        this.width = width;
        this.height = height;

        setTitle(title);
        // invoke the JFrame constructor
        setSize(width, height);
        //setLayout( new FlowLayout() );       // set the layout manager
        setLayout(null);

        //Init layout
        initLayoutView();
    }

    public BaseDialog(String title)
    {
        this(title, defaultWidth, defaultHeight);
    }


    @Override
    public void initLayoutView() {
        //Toolbar
        toolbar = new Toolbar(width, 96);
        add(toolbar);

        toolbar.setLoginInformationEnabled(false);
    }
}
