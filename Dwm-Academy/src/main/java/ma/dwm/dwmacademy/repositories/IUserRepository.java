package ma.dwm.dwmacademy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.utils.Enum_userType;

@RepositoryRestResource
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);
	public List<User> findByType(Enum_userType userType);

}
