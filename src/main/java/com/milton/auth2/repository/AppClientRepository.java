package com.milton.auth2.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.auth2.model.AppClient;

@Repository
public interface AppClientRepository extends JpaRepository<AppClient, BigInteger> {

	AppClient findByClientId(String clientId);
}
