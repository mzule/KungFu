package com.github.mzule.kungfu.design;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CaoDongping on 5/24/16.
 */
public class TextButtonBehavior extends CoordinatorLayout.Behavior {

    public TextButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = dependency.getTranslationY();
        child.setTranslationY(-dependency.getMeasuredHeight() + translationY);
        return true;
    }
}
