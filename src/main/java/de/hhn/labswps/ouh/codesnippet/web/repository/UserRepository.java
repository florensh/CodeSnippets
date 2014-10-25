package de.hhn.labswps.ouh.codesnippet.web.repository;

import org.springframework.data.repository.CrudRepository;

import de.hhn.labswps.ouh.codesnippet.web.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
    User findByUsername(String u);

}
