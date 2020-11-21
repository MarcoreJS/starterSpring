package com.camus.starter.Repositories;

import com.camus.starter.Models.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
