package TakeHome.Project.controller;

import TakeHome.Project.dto.BookingRequest;
import TakeHome.Project.dto.BookingResponse;
import TakeHome.Project.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class BookingController {
    private BookingService productBookingService;

    public BookingController(BookingService productBookingService) {
        this.productBookingService = productBookingService;
    }

    @PostMapping("/book")
    BookingResponse bookProduct( @RequestBody BookingRequest productBookingRequest){
        return productBookingService.bookProduct(productBookingRequest);
    }
}
