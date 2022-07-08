package TakeHome.Project.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingProcessorResponse {
    private final String productId;
    private final int quantity;

    @JsonCreator
    public BookingProcessorResponse(@JsonProperty("productId") String productId, @JsonProperty("quantity") int quantity) {

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
