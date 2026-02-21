package com.bobax.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bobax.user_service.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByEnabledTrue();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query(value = """
            SELECT r.name
            FROM user_roles ur
            JOIN roles r ON r.id = ur.role_id
            WHERE ur.user_id = :userId
        """, nativeQuery = true)
        List<String> findRoleNamesByUserId(@Param("userId") Long userId);
    }