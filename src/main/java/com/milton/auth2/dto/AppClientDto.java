package com.milton.auth2.dto;

import java.math.BigInteger;

import lombok.Data;

@Data
public class AppClientDto {

	private BigInteger id;

	private String clientId;

	private String clientSecret;

	private int accessTokenValidity;

	private String scope;

	private String authorities;

	private String authorizedGrantTypes;

	private int refreshTokenValidity;

	private String resourceIds;

	private String webServerRedirectUri;

	private String autoApprove;

	private String addInfo;
}
