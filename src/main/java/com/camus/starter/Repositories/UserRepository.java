package com.camus.starter.Repositories;

import com.camus.starter.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

}
