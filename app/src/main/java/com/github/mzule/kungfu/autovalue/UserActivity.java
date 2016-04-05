package com.github.mzule.kungfu.autovalue;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by CaoDongping on 4/5/16.
 */
public class UserActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .name("jason cao")
                .avatar("http://c.hiphotos.baidu.com/image/h%3D300/sign=e11ae3db0e23dd543e73a168e108b3df/50da81cb39dbb6fd786f7a990e24ab18972b375c.jpg")
                .fansCount(12)
                .gender(User.MALE)
                .topicCount(21)
                .build();
        TextView tv = new TextView(this);
        tv.setText(user.toString());
        setContentView(tv);
    }
}
