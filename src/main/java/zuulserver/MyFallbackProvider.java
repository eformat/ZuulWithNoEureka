package zuulserver;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

public class MyFallbackProvider implements FallbackProvider {

    private ClientHttpResponse myResponse = new MyClientHttpResponse();

    @Override
    public String getRoute() {
        return "zuulserver";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return myResponse;
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return myResponse;
    }
}
