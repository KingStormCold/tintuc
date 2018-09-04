package com.example.repository;

import com.example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewRepository extends JpaRepository<NewEntity,Long> {
}
