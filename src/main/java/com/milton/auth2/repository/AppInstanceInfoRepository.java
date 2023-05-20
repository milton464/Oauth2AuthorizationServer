package com.milton.auth2.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.auth2.model.AppInstanceInfo;

@Repository
public interface AppInstanceInfoRepository extends JpaRepository<AppInstanceInfo, BigInteger>{

	AppInstanceInfo findByApiKey(String apiKey);

}
