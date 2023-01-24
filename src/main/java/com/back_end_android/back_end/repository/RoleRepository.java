package com.back_end_android.back_end.repository;

import com.back_end_android.back_end.models.ERole;
import com.back_end_android.back_end.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

