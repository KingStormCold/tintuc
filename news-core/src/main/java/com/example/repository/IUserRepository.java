package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Long là kiểu dữ liệu của khóa chính
public interface IUserRepository extends JpaRepository<UserEntity,Long> {

}
