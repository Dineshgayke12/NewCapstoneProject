package com.in.inventory.Repos;

import com.in.inventory.entities.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface productRepo extends JpaRepository<products, Integer> {


}
