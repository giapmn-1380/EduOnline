package hoangit.dev.g1.com.eduonline.extension

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

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