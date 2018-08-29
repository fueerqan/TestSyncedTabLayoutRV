package com.rizkyfadillah.testsyncedtablayoutrv

import android.content.Context
import android.support.v7.widget.GridLayoutManager

/**
 * Created by Rizky on 23/08/18.
 */
class NonScrollabelGridLayoutManager(context: Context?, spanCount: Int) : GridLayoutManager(context, spanCount) {

    override fun canScrollVertically(): Boolean {
        return false
    }

}