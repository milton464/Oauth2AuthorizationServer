package com.milton.auth2.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "oauth_client_details")
@Data
public class AppClient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private BigInteger id;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "client_secret")
	private String clientSecret;

	@Column(name = "access_token_validity")
	private int accessTokenValidity;

	@Column(name = "scope")
	private String scope;

	@Column(name = "authorities")
	private String authorities;

	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;

	@Column(name = "refresh_token_validity")
	private int refreshTokenValidity;

	@Column(name = "resource_ids")
	private String resourceIds;

	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;

	@Column(name = "autoapprove")
	private String autoApprove;

	@Column(name = "additional_information")
	private String addInfo;
}
