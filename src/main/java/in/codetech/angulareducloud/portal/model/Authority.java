package in.codetech.angulareducloud.portal.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	//authority
	private String athority;
	
	

	public Authority(String athority) {
		super();
		this.athority = athority;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.athority;
	}

}
