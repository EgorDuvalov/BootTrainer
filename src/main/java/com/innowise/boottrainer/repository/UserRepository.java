package com.innowise.boottrainer.repository;

import com.innowise.boottrainer.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
