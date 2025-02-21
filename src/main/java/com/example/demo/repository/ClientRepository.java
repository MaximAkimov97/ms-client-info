package com.example.demo.repository;

import com.example.demo.entity.ClientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE client_info SET phone = :phoneNumber WHERE id = :clientId", nativeQuery = true)
    int updatePhoneNumberByClientId(Long clientId, String phoneNumber);
}
