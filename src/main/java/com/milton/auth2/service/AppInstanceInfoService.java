package com.milton.auth2.service;

import com.milton.auth2.model.AppInstanceInfo;

public interface AppInstanceInfoService {

	AppInstanceInfo findByApiKey(String apiKey);

}
