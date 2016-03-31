package com.github.mzule.kungfu.classloader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import dalvik.system.DexClassLoader;

/**
 * Created by CaoDongping on 3/30/16.
 */
public class ClassLoaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Runnable runnable = load("com.github.mzule.kungfu.classloader.ShowTip");
        if (runnable != null) {
            runnable.run();
        }
    }

    private Runnable load(String className) {
        DexClassLoader loader = new DexClassLoader("/sdcard/dynamic.apk", getCacheDir().getAbsolutePath(), null, getClassLoader());
        try {
            return (Runnable) loader.loadClass(className).getConstructor(Context.class).newInstance(this);
        } catch (Throwable e) {
            e.printStackTrace();
            Toast.makeText(ClassLoaderActivity.this, "Please copy dynamic.apk to sdcard", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
