package com.github.mzule.kungfu.rxjava;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by CaoDongping on 5/3/16.
 */
public class RxImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView imageView = new ImageView(this);
        setContentView(imageView);

        Observable.just("https://avatars2.githubusercontent.com/u/2096572?v=3&s=460")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        try {
                            return BitmapFactory.decodeStream(new URL(s).openStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                });
    }
}
