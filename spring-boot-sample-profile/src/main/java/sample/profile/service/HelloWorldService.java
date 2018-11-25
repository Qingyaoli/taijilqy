package sample.profile.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"hello","default","dev"})
//@Profile({"hello"})
public class HelloWorldService implements MessageService {
	
	@Value("${name:World}")
	private String name;
	
	@Value("${hello:hello1}")
	private String hello;
	
	@Override
	public String getMessage() {
		return "hello"+" "+this.name;
		
	}
}
