package com.ccmsd.starters.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ccmsd.starters.init.ServerProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController
{

	@Autowired
	private ServerProperties serverProperties;

	@RequestMapping("/hello")
	public String index()
	{
		return serverProperties.toString();
	}

}