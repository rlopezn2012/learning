package facturadb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

  @RequestMapping("/ejemplo")
  public String index(String nombre) {
	 
    return "Greetings from Spring Boot!" + nombre;
  }

}