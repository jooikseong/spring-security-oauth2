package com.MyBlog.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyBlog.project.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
