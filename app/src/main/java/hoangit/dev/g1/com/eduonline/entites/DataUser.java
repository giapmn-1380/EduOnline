package hoangit.dev.g1.com.eduonline.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUser {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("provider")
    @Expose
    private Object provider;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("uid")
    @Expose
    private Object uid;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("token")
    @Expose
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getProvider() {
        return provider;
    }

    public void setProvider(Object provider) {
        this.provider = provider;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public class Avatar {

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

        public String getBig() {
            return bigUrl;
        }

        public void setBig(String big) {
            this.bigUrl = big;
        }

        public String getStandard() {
            return standardUrl;
        }

        public void setStandard(String standard) {
            this.standardUrl = standard;
        }

        public String getThumb() {
            return thumbUrl;
        }

        public void setThumb(String thumb) {
            this.thumbUrl = thumb;
        }
    }
}
