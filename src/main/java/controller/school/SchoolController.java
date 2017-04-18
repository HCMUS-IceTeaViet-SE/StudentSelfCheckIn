package main.java.controller.school;

import main.java.model.Account;
import main.java.service.school.AccountService;
import main.java.utils.Md5Utils;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class SchoolController {
    protected static SchoolController instance = null;
    private AccountService accountService;

    protected SchoolController() {
        accountService = new AccountService();
    }

    public static SchoolController getInstance() {
        if (instance == null)
            instance = new SchoolController();

        return instance;
    }

    public boolean isValidCredential(String usename, String password) {
        Account acc = accountService.findOne(usename);

        if (acc != null) {
            if (acc.getIsTheFisrtTime()) {
                acc.setPassWrd(Md5Utils.encryptMD5(password));
                accountService.save(acc);
                return true;
            }

            if (Md5Utils.encryptMD5(password).equals(acc.getPassWrd())) {
                return true;
            }
        }
        return false;
    }
}
