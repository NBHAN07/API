package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    /*
    1) Tüm keyler için private variable 'lar oluşturuyoruz.
    2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.
    3) Getters ve Setters'larımızı oluşturuyoruz.
    4) toString() methodumuzu oluşturuyoruz.
     */

    //1) Tüm keyler için private variable 'lar oluşturuyoruz.
    private Integer userId;
    private String title;
    private Boolean completed;

    //2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }
    //3) Getters ve Setters'larımızı oluşturuyoruz.


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) toString() methodumuzu oluşturuyoruz.


    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }


    //Farklı key-value ikililerin uyuşmazlığını @JsonIgnoreProperties(ignoreUnknown = true)
    // anotation'ını Pojo Class'ımızın başına yazarak çözebiliriz.
}