package main.java.controller;

import com.sun.xml.internal.bind.v2.model.core.ID;
import main.java.service.BaseService;

import java.io.Serializable;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public abstract class BaseController implements Serializable {
    protected static BaseController instance = null;
}
