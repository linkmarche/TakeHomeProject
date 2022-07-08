package TakeHome.Project.service;


import TakeHome.Project.dto.*;
import TakeHome.Project.gateway.BookingProcessorGateway;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingProcessorGateway bookingProcessorGateway;

    public BookingService(BookingProcessorGateway bookingProcessorGateway) {
        this.bookingProcessorGateway = bookingProcessorGateway;
    }

    public BookingResponse bookProduct(final BookingRequest bookingRequest) {
        
        final BookingProcessorResponse bookingProcessorResponse = bookingProcessorGateway.bookProduct(bookingRequest.getProductId(), bookingRequest.getQuantity());
         
        if(bookingProcessorResponse.getQuantity() >= bookingRequest.getQuantity()) {
            return new BookingResponse(bookingRequest.getProductId(), BookingResponse.BookingResponseStatus.SUCCESS);
        }
        else {
            return new BookingResponse(bookingRequest.getProductId(), BookingResponse.BookingResponseStatus.REJECTED);
        }
    }
}