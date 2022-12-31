package com.back_end_android.back_end.repository;

import com.back_end_android.back_end.models.WhishList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WishlistRepository extends MongoRepository<WhishList,String> {

    List<WhishList> findAllByTenantAndType(String tenant, String type);
}
