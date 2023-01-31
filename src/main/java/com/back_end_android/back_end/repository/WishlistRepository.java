package com.back_end_android.back_end.repository;

import com.back_end_android.back_end.models.WhishList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WishlistRepository extends MongoRepository<WhishList,String> {

    List<WhishList> findAllByTenantAndType(String tenant, String type);

    @Query("{'$and': [{'type': ?2},{'tenant': ?3},{'countryCode': ?0},{'steamId': ?1 }]}")
    WhishList findGame(String countryCode, int steamID, String type, String tenant);


    @Query("{'$and': [{'type': ?1},{'tenant': ?2},{'steamId': ?0 }]}")
    WhishList findGame( int steamID, String type, String tenant);

}
