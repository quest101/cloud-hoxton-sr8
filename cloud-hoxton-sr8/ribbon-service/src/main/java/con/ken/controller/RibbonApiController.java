package con.ken.controller;


import con.ken.utils.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ribbon")
public class RibbonApiController {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    private String userServiceUrl = "http://user-service";
//    private String userServiceUrl = "http://localhost:8084";

    @GetMapping("/getUserList")
    public Map<String, Object> getUserList() {
        return restTemplateUtils.exchange(userServiceUrl
                        + "/api/user/getUserList",
                HttpMethod.GET, null, null, null, Map.class);

    }
}
