package com.example.repository;

import com.example.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<CommentEntity,Long> {
}
