package com.github.mzule.kungfu.palette;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 3/30/16.
 */
public class PaletteActivity extends Activity {
    public static Intent makeIntent(Context context) {
        return new Intent(context, PaletteActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.container);
        Palette.from(BitmapFactory.decodeResource(getResources(), R.drawable.ic_erha)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                for (Palette.Swatch swatch : palette.getSwatches()) {
                    TextView textView = new TextView(PaletteActivity.this);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    textView.setBackgroundColor(swatch.getRgb());
                    textView.setTextColor(swatch.getBodyTextColor());
                    textView.setText(String.valueOf(swatch.getPopulation()));
                    viewGroup.addView(textView);
                }
            }
        });
    }
}
