package in.codetech.angulareducloud.portal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	String messge;

	public UserNotFoundException(String messge) {
		super(messge);
	}
	
}
