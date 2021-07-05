package ma.dwm.dwmacademy.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.IUserRepository;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Email \""+email+"\" not found!"));
		
		return user.map(CustomUserDetails::new).get();
	}

}
