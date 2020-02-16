package com.siva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.demo.model.Admin;

@Repository
public interface UserRepos extends JpaRepository<Admin, Long> {

}
