package com.ccmsd.starters.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "server")
@Configuration("application")
public class ServerProperties
{

	private String email;

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "ServerProperties{" + "email='" + email + '\'';
	}
}