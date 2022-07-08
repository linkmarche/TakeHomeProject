package TakeHome.Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.client.WireMock;
import TakeHome.Project.service.BookingService;
import TakeHome.Project.dto.BookingRequest;
import TakeHome.Project.dto.BookingResponse;
import TakeHome.Project.gateway.BookingProcessorGateway;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static TakeHome.Project.dto.BookingResponse.BookingResponseStatus.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookProductSuccessTest {

	private BookingService bookingService;
	private WireMockServer wireMockServer;

	@BeforeEach
	void setup() {
		wireMockServer = new WireMockServer();
		configureFor("localhost", 8080);
		wireMockServer.start();
		
		BookingProcessorGateway bookingProcessorGateway = new BookingProcessorGateway("localhost", wireMockServer.port());

		bookingService = new BookingService(bookingProcessorGateway);
	}

	@Test
    void testCase1() {

        //given
        stubFor(any((anyUrl())).willReturn(ok()));

        //when
        BookingRequest bookingRequest = new BookingRequest("1", 1);

		BookingResponse bookingResponse = bookingService.bookProduct(bookingRequest);

        //then
        assertThat(bookingResponse.getBookingResponseStatus()).isEqualTo("SUCCESS");


        //verify
        verify(postRequestedFor(urlEqualTo("/book")));
    }


    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

}
