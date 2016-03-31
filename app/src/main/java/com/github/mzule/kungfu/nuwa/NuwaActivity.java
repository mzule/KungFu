package com.github.mzule.kungfu.nuwa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by CaoDongping on 3/31/16.
 */
public class NuwaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("女娲补天，真的可以！");
        setContentView(textView);
    }
}
