package com.baculsoft.sample.dagger2.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public final class Commons {

    public Snackbar makeSnackbar(final View view, final String message) {
        return Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
    }

    public Toast makeToast(final Context context, final String message) {
        return Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }
}