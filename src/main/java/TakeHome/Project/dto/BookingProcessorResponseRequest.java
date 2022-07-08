package TakeHome.Project.dto;

public class BookingProcessorResponseRequest {
    private final String productId;
    private final int quantity;

    public BookingProcessorResponseRequest(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String productId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
