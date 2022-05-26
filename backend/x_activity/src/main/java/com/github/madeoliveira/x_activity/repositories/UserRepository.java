package com.github.madeoliveira.x_activity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.madeoliveira.x_activity.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
