package android.examples.retrofitcep.utils

import android.app.Activity
import android.content.Context
import android.examples.retrofitcep.rest.ApiClient
import android.examples.retrofitcep.rest.ApiInterface
import android.support.design.widget.Snackbar
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by Guilherme on 23/10/2016.
 */

object Utils {

    var apiService = ApiClient.getClient()?.create(ApiInterface::class.java)


    fun showSnack(view: View, message: String) {

        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    fun hideKeyboard(activity: Activity) {

        val keyboard = activity.currentFocus

        if (keyboard != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(keyboard.windowToken, 0)
        }

    }


}
