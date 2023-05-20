package com.milton.auth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.milton.auth2.model.AppClient;
import com.milton.auth2.model.AppClientDetail;
import com.milton.auth2.repository.AppClientRepository;

@Service
public class AppClientDetailService implements ClientDetailsService {

	@Autowired
	private AppClientRepository appClientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		AppClient appClient = appClientRepository.findByClientId(clientId);
		if (appClient == null) {
			throw new ClientRegistrationException(clientId + " not found");
		}

		return new AppClientDetail(appClient);
	}
}
