package TakeHome.Project.gateway;

import TakeHome.Project.dto.BookingProcessorResponse;
import TakeHome.Project.dto.BookingProcessorResponseRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookingProcessorGateway {

    private final BookingProcessorRestTemplate bookingProcessorRestTemplate = new BookingProcessorRestTemplate();
    private String baseUrl;

    public BookingProcessorGateway(@Value("${server.host}") String host, @Value("${server.port}") int port) {
        this.baseUrl = "http://" + host + ":" + port;
    }

    public BookingProcessorResponse bookProduct(String productId, int quantity) {
            final BookingProcessorResponseRequest bookingProcessorRequest = new BookingProcessorResponseRequest(productId, quantity);

        return bookingProcessorRestTemplate.postForObject(baseUrl + "/book/" + productId, bookingProcessorRequest, BookingProcessorResponse.class);
    }
}
