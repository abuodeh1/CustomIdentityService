package ltrc.CustomIdentityService;

import javax.sql.DataSource;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
@EnableProcessApplication("CustomIdentityService")
public class CamundaApplication{

	@Autowired
	DataSource dataSource;

	public static void main(String... args) {
		SpringApplication.run(CamundaApplication.class, args);

	}
}
