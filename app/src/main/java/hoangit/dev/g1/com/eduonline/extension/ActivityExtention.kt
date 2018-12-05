package hoangit.dev.g1.com.eduonline.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import hoangit.dev.g1.com.eduonline.R

fun AppCompatActivity.replaceFragment(rootID: Int, fragment: Fragment, isAddToBackStack: Boolean) {
    if (isAddToBackStack) {
        supportFragmentManager.beginTransaction()
            .replace(rootID, fragment, fragment::class.simpleName)
            .addToBackStack(fragment::class.simpleName)
            .commit()
    } else {
        supportFragmentManager.beginTransaction()
            .replace(rootID, fragment, fragment::class.simpleName)
            .commit()
    }
}

fun AppCompatActivity.addFragment(rootID: Int, fragment: Fragment, isAddToBackStack: Boolean) {
    if (isAddToBackStack) {
        supportFragmentManager.beginTransaction()
            .add(rootID, fragment, fragment::class.simpleName)
            .addToBackStack(fragment::class.simpleName)
            .commit()
    } else {
        supportFragmentManager.beginTransaction()
            .add(rootID, fragment, fragment::class.simpleName)
            .commit()
    }
}

fun AppCompatActivity.popBack() {
    if (supportFragmentManager.backStackEntryCount > 0) {
        if (supportFragmentManager.popBackStackImmediate()) {
            Log.d("popBack", "popBackStackImmediate, success")
        } else {
            Log.d("popBack", "popBackStackImmediate, fail")
        }
    } else {
        finish()
    }
}

fun AppCompatActivity.showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showSnackBar(message: String){
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
}

fun AppCompatActivity.startActivityWithTransition(intent: Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
}

fun AppCompatActivity.closeKeyboard(view: View? = null) {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (view != null) {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
        return
    }
    val v = currentFocus ?: View(this)
    imm.hideSoftInputFromWindow(v.windowToken, 0)
}