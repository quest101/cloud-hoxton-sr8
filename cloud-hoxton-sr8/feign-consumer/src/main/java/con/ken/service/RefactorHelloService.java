package con.ken.service;

import com.ken.service.HelloService1;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value="hello-service")
public interface RefactorHelloService extends HelloService1 {

}
