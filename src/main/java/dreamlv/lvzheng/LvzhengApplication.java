package dreamlv.lvzheng;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker //启动断路器
@EnableFeignClients
public class LvzhengApplication {
    public static void main(String[] args) {
        SpringApplication.run(LvzhengApplication.class, args);
    }


}
