package ma.dwm.dwmacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.utils.UserType;

@RepositoryRestResource
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByType(UserType userType);

}
