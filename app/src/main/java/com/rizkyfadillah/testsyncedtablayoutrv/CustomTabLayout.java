package com.rizkyfadillah.testsyncedtablayoutrv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * Created by Rizky on 23/08/18.
 */
public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addOnTabSelectedListener(@NonNull BaseOnTabSelectedListener listener) {
//        super.addOnTabSelectedListener(listener);
    }

}
