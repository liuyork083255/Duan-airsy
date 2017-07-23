package liu.york;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
	public String login(){
		return "login";
	}

	@RequestMapping("/signout")
	public String signout(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "login";
	}

}
