package org.da1.labormanagementbackend.repos;

import org.da1.labormanagementbackend.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username);
    Optional<UserInfo> findByEmail(String email);
    Optional<UserInfo> findByEmailOrUsername(String email, String username);

}
