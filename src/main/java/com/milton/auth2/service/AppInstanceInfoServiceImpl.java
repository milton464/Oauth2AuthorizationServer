package com.milton.auth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.auth2.model.AppInstanceInfo;
import com.milton.auth2.repository.AppInstanceInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppInstanceInfoServiceImpl implements AppInstanceInfoService{

	@Autowired
	private AppInstanceInfoRepository appInstanceInfoRepository;
	
	@Override
	public AppInstanceInfo findByApiKey(String apiKey) {
		return appInstanceInfoRepository.findByApiKey(apiKey);
	}
	
}
