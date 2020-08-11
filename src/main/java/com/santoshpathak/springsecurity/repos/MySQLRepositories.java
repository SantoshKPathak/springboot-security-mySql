/**
 * 
 */
package com.santoshpathak.springsecurity.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santoshpathak.springsecurity.domain.Users;

/**
 * @author santoshpathak
 *
 */
@Repository
public interface MySQLRepositories extends JpaRepository<Users, Long>{

	Optional<Users> findByUsername(String username);
}
