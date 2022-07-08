package TakeHome.Project.dto;

public class BookingResponse {
    private final String productId;
    private final BookingResponseStatus bookingResponseStatus;

    public BookingResponse(String productId, BookingResponseStatus bookingResponseStatus) {
        this.productId = productId;
        this.bookingResponseStatus = bookingResponseStatus;
    }

    public enum BookingResponseStatus {
        SUCCESS, REJECTED
    }

    public String getProductId() {
        return productId;
    }

    public BookingResponseStatus getBookingResponseStatus() {
        return bookingResponseStatus;
    }
}
