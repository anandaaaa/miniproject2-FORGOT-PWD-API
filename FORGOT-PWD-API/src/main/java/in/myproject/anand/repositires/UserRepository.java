package in.myproject.anand.repositires;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.myproject.anand.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable>{

	public UserEntity findByUserEmail(String email);
	
}
