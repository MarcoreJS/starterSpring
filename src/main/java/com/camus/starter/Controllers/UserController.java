package com.camus.starter.Controllers;


import com.camus.starter.Models.Cart;
import com.camus.starter.Models.User;
import com.camus.starter.Repositories.CartRepository;
import com.camus.starter.Repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @PostMapping(path = "/users/add")
    User createUser(@RequestBody User user) {
        Cart cart = new Cart();
        cart.setTotalPrice(0.0);
        cart.setDiscount(0.0);
        user.setCart(cart);
        return userRepository.save(user);
    }

    @PutMapping(path = "/users/{id}")
    Optional<User> updateUser(@PathVariable Integer id, @RequestBody User requestedUser) {
        /*User user = userRepository.findById(id).get();
        user.setName(requestedUser.getName());
        user.setEmail(requestedUser.getEmail());
        return userRepository.save(user);*/

        return userRepository.findById(id).map(user -> {
            user.setName(requestedUser.getName());
            user.setEmail(requestedUser.getEmail());

            return userRepository.save(user);
        });
    }

    /*@DeleteMapping(path = "/users/{id}")
    String deleteUser(@PathVariable Integer id) {
        try {
            userRepository.delete(userRepository.findById(id).get());
        } catch (HttpClientErrorException.NotFound e) {
            return "Not found";
        }
        return "Successfully deleted";
    }*/

    @DeleteMapping(path = "/users/{id}")
    Optional<User> deleteUser(@PathVariable Integer id) {
        return userRepository.findById(id).map(user -> {
           user.setActive(0);
           user.getCart().setActive(0);

           return userRepository.save(user);
        });
    }



    @GetMapping(path = "/users")
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/findByName/{name}")
    List<User> getUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

}
