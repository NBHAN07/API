package pojos;

public class BookingResponseBodyPojo {

    //1) Tüm keyler için private variable 'lar oluşturuyoruz.
    private Integer bookingid;
    private BookingPojo booking;

    //2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.
    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    //3) Getters ve Setters'larımızı oluşturuyoruz.


    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    //4) toString() methodumuzu oluşturuyoruz.


    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
