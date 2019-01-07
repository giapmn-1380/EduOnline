package hoangit.dev.g1.com.eduonline.utils

interface IPreloadAPI {
    enum class APIStatus(val rawValue: Int) {
        INIT(0),
        DOWNLOADING(1),
        DOWNLOADED(2),
        DOWNLOAD_FAILED(3)
    }

    fun needToFeatchData() : Boolean
}