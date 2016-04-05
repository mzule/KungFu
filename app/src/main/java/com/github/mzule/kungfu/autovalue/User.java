package com.github.mzule.kungfu.autovalue;

import com.google.auto.value.AutoValue;

/**
 * Created by CaoDongping on 4/5/16.
 */
@AutoValue
public abstract class User {
    public static final int MALE = 1;
    public static final int FEMALE = 2;

    public static Builder builder() {
        return new AutoValue_User.Builder().createTime(System.currentTimeMillis());
    }

    public abstract String id();

    public abstract String name();

    public abstract String avatar();

    public abstract int gender();

    public abstract long createTime();

    public abstract int fansCount();

    public abstract int topicCount();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Builder avatar(String avatar);

        public abstract Builder gender(int gender);

        public abstract Builder createTime(long createTime);

        public abstract Builder fansCount(int fansCount);

        public abstract Builder topicCount(int topicCount);

        abstract User autoBuild();

        public User build() {
            User user = autoBuild();
            if (user.gender() != MALE && user.gender() != FEMALE) {
                throw new IllegalStateException("Unknown gender");
            }
            return user;
        }
    }
}
