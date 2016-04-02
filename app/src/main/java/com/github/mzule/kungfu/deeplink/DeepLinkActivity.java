package com.github.mzule.kungfu.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.airbnb.deeplinkdispatch.DeepLink;

/**
 * Created by CaoDongping on 4/2/16.
 */
@DeepLink("kungfu://deeplink")
public class DeepLinkActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("click me to router");
        textView.setPadding(20, 20, 20, 20);
        if (getIntent().getStringExtra("tip") != null) {
            textView.setText(getIntent().getStringExtra("tip"));
        } else {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("kungfu://deeplink?tip=hello+world"));
                    startActivity(intent);
                }
            });
        }
        setContentView(textView);
    }
}
