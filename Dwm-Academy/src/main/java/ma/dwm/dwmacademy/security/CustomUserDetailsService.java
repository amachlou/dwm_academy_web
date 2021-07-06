package ma.dwm.dwmacademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.IUserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findAll().get(0);// findByEmail(email);
		
//		((User) user).orElseThrow(() -> new UsernameNotFoundException("Email \""+email+"\" not found!"));
		
//		return user.map(CustomUserDetails::new).get();
		return new CustomUserDetails(user);
	}

}
