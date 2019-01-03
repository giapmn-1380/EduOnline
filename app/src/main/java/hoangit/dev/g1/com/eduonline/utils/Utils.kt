package hoangit.dev.g1.com.eduonline.utils

import java.text.DecimalFormat

class Utils {

    companion object {
        fun convertMoney(param: Int): String {
            return DecimalFormat("###,###").format(param)
        }
    }
}