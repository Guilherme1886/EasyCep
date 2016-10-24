package android.examples.retrofitcep.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;

/**
 * Created by Guilherme on 23/10/2016.
 */

public final class Utils {


    public static void showSnack(Activity activity, String message) {


        Snackbar.make(activity.getCurrentFocus(), message, Snackbar.LENGTH_LONG).show();
    }


}
