package hoangit.dev.g1.com.eduonline.app.tutorial

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.home.HomeActivity
import hoangit.dev.g1.com.eduonline.base.BaseFragment
import hoangit.dev.g1.com.eduonline.utils.ConfigApp
import java.lang.Exception

class TutorialPageFragment : BaseFragment(), View.OnClickListener {

    lateinit var btnSkipTutorial: Button
    lateinit var imvTutorialPage: ImageView

    var isLastPage: Boolean = false
    var resourceID: Int = 0

    companion object {
        fun newInstance(resource: Int, isLastPage: Boolean): TutorialPageFragment {
            return TutorialPageFragment().apply {
                init(resource, isLastPage)
            }
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_tutorial_page
    }

    override fun onViewReady(view: View) {
        btnSkipTutorial = view.findViewById<Button>(R.id.btn_skip_tutorial)
        btnSkipTutorial.setOnClickListener(this)
        if (isLastPage) {
            btnSkipTutorial.visibility = View.VISIBLE
        }

        imvTutorialPage = view.findViewById(R.id.imv_tutorial_page)
        context.let {
            Picasso.get().load(resourceID).into(imvTutorialPage, object : Callback {
                override fun onSuccess() {
                    Log.d("GiapMN", "picasso onSuccess")
                }

                override fun onError(e: Exception?) {
                    Log.d("GiapMN", "onError ${e!!.message}")
                }
            })
        }
    }

    fun init(resource: Int, isLastPage: Boolean) {
        this.isLastPage = isLastPage
        this.resourceID = resource
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_skip_tutorial -> {
                var intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
                ConfigApp.getInstances().setFirstOpenApp(false)
            }
        }
    }
}