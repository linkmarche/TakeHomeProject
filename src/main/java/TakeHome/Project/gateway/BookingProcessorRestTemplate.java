package TakeHome.Project.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import static java.util.Arrays.asList;

public class BookingProcessorRestTemplate extends RestTemplate {
    public BookingProcessorRestTemplate() {
        final ObjectMapper objectMapper = new ObjectMapper();
        setMessageConverters(asList(new MappingJackson2HttpMessageConverter(objectMapper)));

        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        httpComponentsClientHttpRequestFactory.setConnectTimeout(1000);
        httpComponentsClientHttpRequestFactory.setReadTimeout(1000);

        setRequestFactory(httpComponentsClientHttpRequestFactory);
    }
}
