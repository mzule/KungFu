package com.github.mzule.kungfu.imageprocess;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;

/**
 * Created by CaoDongping on 5/17/16.
 */
public class ColorFilter {

    public static Bitmap filterWhite(Bitmap src, @ColorInt int textColor) {
        int threshold = 0x22;
        int width = src.getWidth();
        int height = src.getHeight();
        int[] pixels = new int[width * height];
        src.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < pixels.length; i++) {
            int r = (0x00ff0000 & pixels[i]) >> 16;
            int g = (0x0000ff00 & pixels[i]) >> 8;
            int b = 0x000000ff & pixels[i];
            if (Math.abs(r - 0xff) <= threshold && Math.abs(g - 0xff) <= threshold && Math.abs(b - 0xff) <= threshold) {
                pixels[i] = 0x00000000;
            } else {
                pixels[i] = textColor;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        src.recycle();
        return bitmap;
    }
}
