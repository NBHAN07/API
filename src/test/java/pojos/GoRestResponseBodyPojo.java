package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponseBodyPojo {

    //1) Tüm keyler için private variable 'lar oluşturuyoruz.
    private Object meta;
    private GoRestDataPojo data;

    //2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.


    public GoRestResponseBodyPojo(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;

    }

    public GoRestResponseBodyPojo() {
    }

    //3) Getters ve Setters'larımızı oluşturuyoruz.


    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    //4) toString() methodumuzu oluşturuyoruz.


    @Override
    public String toString() {
        return "GoRestResponseBodyPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}