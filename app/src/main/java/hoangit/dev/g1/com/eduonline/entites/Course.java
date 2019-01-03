package hoangit.dev.g1.com.eduonline.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Course {
    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;

    @SerializedName("rate_average")
    @Expose
    private Double rateAverage;

    @SerializedName("price")
    @Expose
    private Integer price;

    @SerializedName("percent_sale")
    @Expose
    private Integer percentSale;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("category_id")
    @Expose
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Double getRateAverage() {
        return rateAverage;
    }

    public void setRateAverage(Double rateAverage) {
        this.rateAverage = rateAverage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPercentSale() {
        return percentSale;
    }

    public void setPercentSale(Integer percentSale) {
        this.percentSale = percentSale;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
