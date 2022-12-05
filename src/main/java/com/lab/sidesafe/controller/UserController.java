package com.lab.sidesafe.controller;

import com.lab.sidesafe.model.DadosLogin;
import com.lab.sidesafe.model.UserModel;
import com.lab.sidesafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> findByIdUser(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByIdUser(userId));

    }

    /*@PreAuthorize("hastole('ROLE_USER')")*/
    @PostMapping("/create")
    public ResponseEntity<UserModel> insertNewUser(@RequestBody UserModel user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insertNewUser(user));
    }

    @PutMapping("/update/{userId}/{dataUser}")
    public ResponseEntity<UserModel> updateuser(@PathVariable Long userId, @RequestBody UserModel dataUser ){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(userId, dataUser));
    }

    @DeleteMapping("/delete/{userId}")
    public void  deleteUser(@PathVariable Long userId){
        userService.delete(userId);

    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> autheticate(@RequestBody DadosLogin dadosLogin) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body( userService.autheticate(dadosLogin));
    }


}
