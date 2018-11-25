package sample.profile.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"hello","default","dev"})
public class GenericService implements MessageService {
	
	@Value("${hello:hello-generic}")
	private String hello;
	
	@Value("${name:world-generic}")
	private String name;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "generic"+this.name;
	}
}
