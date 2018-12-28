package hoangit.dev.g1.com.eduonline.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("big_url")
    @Expose
    private String bigUrl;
    @SerializedName("standard_url")
    @Expose
    private String standardUrl;
    @SerializedName("thumb_url")
    @Expose
    private String thumbUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBigUrl() {
        return bigUrl;
    }

    public void setBigUrl(String bigUrl) {
        this.bigUrl = bigUrl;
    }

    public String getStandardUrl() {
        return standardUrl;
    }

    public void setStandardUrl(String standardUrl) {
        this.standardUrl = standardUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
