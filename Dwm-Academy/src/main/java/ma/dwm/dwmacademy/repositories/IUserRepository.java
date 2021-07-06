package ma.dwm.dwmacademy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.utils.enum_userType;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);
	public List<User> findByType(enum_userType userType);

}
