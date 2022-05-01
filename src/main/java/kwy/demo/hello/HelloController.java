package kwy.demo.hello;

import kwy.demo.hello.config.HelloConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

  @Autowired RestTemplate restTemplate;

  @Autowired HelloConfiguration configuration;

  Logger logger = LoggerFactory.getLogger(HelloController.class);

  @GetMapping("/hello")
  public String hello() {
    String url = "http://" + configuration.getName() + "/logic";
    logger.info(url);
    ResponseEntity<String> response = restTemplate.getForEntity(url,
        String.class);

    return "hello\n" + "Logic from logic-demo(" + response.getBody() + ")";
  }

  @GetMapping("/config")
  public String config() {
    String name = configuration.getName();
    logger.info(name);
    return name;
  }
}
