package com.example.superclass.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.superclass.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    @Query("select s from User s where s.username=?1 and s.password=?2")
    public UserEntity findBynameAndPassword(String username,String password);
    @Query("select s from User s where s.username=?")
    public UserEntity findByName(String username);

}