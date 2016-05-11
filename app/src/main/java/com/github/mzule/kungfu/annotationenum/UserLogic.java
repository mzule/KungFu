package com.github.mzule.kungfu.annotationenum;

/**
 * Created by CaoDongping on 5/3/16.
 */
public class UserLogic {
    public void create() {
        // User user = new User("mzule", 2);// warning error
        User user = new User("mzule", User.GENDER_MALE);
    }
}
