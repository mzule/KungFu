package com.github.mzule.kungfu.annotationenum;

import android.support.annotation.IntDef;

/**
 * Created by CaoDongping on 5/3/16.
 */
public class User {
    public static final int GENDER_MALE = 0;
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_OTHER = 2;
    private String name;
    private int gender;

    public User(String name, @Gender int gender) {
        this.name = name;
        this.gender = gender;
    }

    @IntDef({GENDER_MALE, GENDER_FEMALE, GENDER_OTHER})
    public @interface Gender {
    }
}
