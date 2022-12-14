package com.lab.sidesafe.service;

import com.lab.sidesafe.model.DadosLogin;
import com.lab.sidesafe.model.UserModel;
import com.lab.sidesafe.repositories.UserModelRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserModelRespository userRespository;

    public UserModel findByIdUser(Long id) {

        return userRespository.findById(id).orElseThrow(
                () -> new RuntimeException()
        );

    }

    public List<UserModel> findAllUser() {
        return userRespository.findAll();
    }


    public UserModel insertNewUser(UserModel user) {
        return userRespository.save(user);
    }


    public UserModel update(Long userId, UserModel dataUser) {
        if (!userRespository.existsById(userId)) {
            return null;
        }
        dataUser.setId(userId);
        return userRespository.save(dataUser);
    }

    public void delete(Long userId) {
        try {
            UserModel user = findByIdUser(userId);
            userRespository.delete(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public UserModel autheticate(DadosLogin dadosLogin) throws Exception {
     UserModel userModel = userRespository.findByName(dadosLogin.getNome()).orElseThrow();
     if (dadosLogin.getPassword().equals(userModel.getPassword())){
         return userModel;
     }
        else {
            throw new Exception();
     }
    }
}
