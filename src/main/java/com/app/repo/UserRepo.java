package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    User findByUserEmailId(String email);

    public User findById(Long id);
}
