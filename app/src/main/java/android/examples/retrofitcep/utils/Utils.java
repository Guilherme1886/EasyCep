package android.examples.retrofitcep.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Guilherme on 23/10/2016.
 */

public final class Utils {


    public static void showSnack(Activity activity, String message) {


        Snackbar.make(activity.getCurrentFocus(), message, Snackbar.LENGTH_LONG).show();
    }

    public static void hideKeyboard(Activity activity) {

        View keyboard = activity.getCurrentFocus();

        if (keyboard != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(keyboard.getWindowToken(), 0);
        }

    }


}
