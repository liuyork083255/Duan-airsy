package liu.york;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class AirsyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirsyApplication.class, args);
	}

	@RequestMapping("/login")
	public String index(){
		return "login";
	}

}
