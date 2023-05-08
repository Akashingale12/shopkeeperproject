package com.shopkeeperbilling.repo;

import com.shopkeeperbilling.model.UserToken;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Long> {

    @Query(value = "select * from user_token where token=:userToken",nativeQuery = true)
    Optional<UserToken> findTokenByUserToken(@Param("userToken")String userToken);
}
