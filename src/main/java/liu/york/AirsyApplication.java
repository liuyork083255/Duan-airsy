package liu.york;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableTransactionManagement
@ComponentScan(basePackages = "liu.york.*")
@SpringBootApplication
public class AirsyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirsyApplication.class, args);
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}


	@RequestMapping("/")
	public String index(){
		return "login";
	}

	@RequestMapping("/signout")
	public String signout(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "login";
	}

}
