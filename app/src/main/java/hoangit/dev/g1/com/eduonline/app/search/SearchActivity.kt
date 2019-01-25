package hoangit.dev.g1.com.eduonline.app.search

import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.base.BaseActivity

class SearchActivity : BaseActivity() {

    override fun getLayoutID(): Int {
        return R.layout.activity_search
    }

    override fun onCreateActivity() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        closeTransition()
    }
}
