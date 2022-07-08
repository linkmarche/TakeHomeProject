package TakeHome.Project.dto;

public class BookingRequest {
    private  String productId;
    private  int quantity;

    public BookingRequest(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}