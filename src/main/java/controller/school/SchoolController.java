package main.java.controller.school;

import main.java.controller.BaseController;
import main.java.controller.subject.SubjectController;
import main.java.service.school.AccountService;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class SchoolController extends BaseController {
    private AccountService accountService;

    protected SchoolController() {
        accountService = new AccountService();
    }

    public static SchoolController getInstance() {
        if (instance == null)
            instance = new SchoolController();

        return (SchoolController) instance;
    }
}
