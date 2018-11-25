package sample.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.profile.service.MessageService;

@SpringBootApplication
public class SpringBootSampleProfileApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleProfileApplication.class, args);
	}

	@Autowired
	private MessageService helloWorldService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.helloWorldService.getMessage());
	}
}
