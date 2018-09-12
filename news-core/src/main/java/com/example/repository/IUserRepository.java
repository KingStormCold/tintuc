package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Long là kiểu dữ liệu của khóa chính
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findOneByUserName(String userName);
}
