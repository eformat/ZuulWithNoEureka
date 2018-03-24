package zuulserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableZuulProxy
@RestController
public class ZuulServerApplication {
	
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(80000);
        return "timeout";
    }

    @Bean
    public FallbackProvider zuulFallbackProvider() {
        return new MyFallbackProvider();
    }
}
