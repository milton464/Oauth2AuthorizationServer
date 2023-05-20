package com.milton.auth2.controller;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milton.auth2.config.BearerTokenWrapper;
import com.milton.auth2.dto.AppClientDto;
import com.milton.auth2.model.AppClient;
import com.milton.auth2.model.AppInstanceInfo;
import com.milton.auth2.repository.AppClientRepository;
import com.milton.auth2.service.AppInstanceInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/client")
public class AppClientController {

	@Autowired
	private AppInstanceInfoService appInstanceInfoService;
	
	@Autowired
	private AppClientRepository appClientRepository;
	
	@Autowired
	private BearerTokenWrapper bearerTokenWrapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody AppClientDto appClientDto) {
		JSONObject response = new JSONObject();

		AppInstanceInfo appInstanceInfo = null;

		String token = bearerTokenWrapper.getToken();
		System.out.println("token: " + token);
		if (StringUtils.isBlank(token)) {
			response.put("message", "Authorization property is empty");
			response.put("success", false);
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		}

		appInstanceInfo = appInstanceInfoService.findByApiKey(token);

		if (appInstanceInfo == null) {
			response.put("message", "Resource can't be accessed with invalid key");
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		}

		log.info("appInstanceInfo: "+appInstanceInfo);
		AppClient appClient = new AppClient();
		appClient.setClientId(appClientDto.getClientId());
		appClient.setClientSecret(appClientDto.getClientSecret());
		appClient.setScope("read,write");
		appClient.setAuthorizedGrantTypes("password,refresh_token,client_credentials,authorization_code");
		appClient.setAuthorities("ROLE_CLIENT");
		appClient.setClientSecret(passwordEncoder.encode(appClientDto.getClientSecret()));
		appClient.setResourceIds(appClientDto.getResourceIds());
		
		AppClient client = appClientRepository.findByClientId(appClientDto.getClientId());
		log.info("appClient: "+appClient);
		if(client != null) {
			response.put("message", "unable to insert client id already exists");
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		}
		appClientRepository.save(appClient);
		response.put("data", new JSONObject(appClientDto));
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}
}
