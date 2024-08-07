package in.angulareducloud.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.angulareducloud.portal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	

}
