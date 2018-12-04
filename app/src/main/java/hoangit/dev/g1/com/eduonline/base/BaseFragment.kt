package hoangit.dev.g1.com.eduonline.base

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hoangit.dev.g1.com.eduonline.extension.addFragment
import hoangit.dev.g1.com.eduonline.extension.replaceFragment
import hoangit.dev.g1.com.eduonline.extension.showToast

open abstract class BaseFragment : Fragment() {


    abstract fun getLayoutID(): Int
    abstract fun onViewReady(view: View)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view)
    }

    fun addFragment(rootId: Int, fragment: Fragment, isAddToBackstack: Boolean) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).addFragment(rootId, fragment, isAddToBackstack)
        }
    }

    fun replaceFragment(rootId: Int, fragment: Fragment, isAddToBackstack: Boolean) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).replaceFragment(rootId, fragment, isAddToBackstack)
        }
    }

    fun showToast(context: Context, message: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showToast(context, message)
        }
    }

}