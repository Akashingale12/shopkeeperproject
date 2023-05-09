package com.shopkeeperbilling.repo;

import com.shopkeeperbilling.model.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper,Long> {
    @Query(value = "select * from shopkeeper where email=:shopkeeperEmail",nativeQuery = true)
    Optional<Shopkeeper> findShopkeeperByEmail(@Param("shopkeeperEmail") String shopkeeperEmail);
}
