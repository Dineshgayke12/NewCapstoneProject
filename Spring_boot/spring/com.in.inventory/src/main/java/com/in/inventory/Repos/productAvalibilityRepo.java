package com.in.inventory.Repos;

import com.in.inventory.entities.productAvalibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface productAvalibilityRepo extends JpaRepository<productAvalibility, Integer> {

//    productAvalibility findByName(String name);

    @Query("SELECT p FROM productAvalibility p WHERE LOWER(p.productName) = LOWER(:productName)")
    productAvalibility findByProductNameIgnoreCase(@Param("productName") String productName);
}
