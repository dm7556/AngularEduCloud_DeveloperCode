package in.angulareducloud.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngularEduCloudApplication {

	public static void main(String[] args) {
		
		System.out.println("main--start");
		
		SpringApplication.run(AngularEduCloudApplication.class, args);
		
		System.out.println("main--End");
	}

}
