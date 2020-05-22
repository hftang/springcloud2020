package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 12:28
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8802.class);
    }
}
