package com.back_end_android.back_end.repository;

import com.back_end_android.back_end.models.ERole;
import com.back_end_android.back_end.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

