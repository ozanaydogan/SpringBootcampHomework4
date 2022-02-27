package com.innova.repository;

import com.innova.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity,Long> {


}
