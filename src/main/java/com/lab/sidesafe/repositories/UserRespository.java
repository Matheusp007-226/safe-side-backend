package com.lab.sidesafe.repositories;

import com.lab.sidesafe.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<UserModel, Long> {


    Optional<UserModel> findByName(String name);
}
