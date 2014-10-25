package de.hhn.labswps.ouh.codesnippet.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.hhn.labswps.ouh.codesnippet.web.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		User securityUser = null;
		
		de.hhn.labswps.ouh.codesnippet.web.entity.User user = userRepository.findByUsername(userName); 
		
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + userName
					+ " not found");
		}else{
			securityUser = new User(user.getUsername(), user.getPassword(), user.getAuthorities());
		}
		return securityUser;
	}
}
