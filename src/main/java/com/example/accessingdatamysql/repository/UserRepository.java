package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.domain.HelloMember;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<HelloMember, Long> {
}
