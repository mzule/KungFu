package com.github.mzule.kungfu.imageprocess;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 5/17/16.
 */
public class ColorFilterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_filter);

        Bitmap bitmap = ColorFilter.filterWhite(BitmapFactory.decodeResource(getResources(), R.drawable.genimage), 0xffffffff);

        ImageView rawImageView = (ImageView) findViewById(R.id.rawImageView);
        rawImageView.setImageResource(R.drawable.genimage);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
    }
}
