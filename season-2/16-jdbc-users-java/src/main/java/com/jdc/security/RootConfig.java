package com.jdc.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@ComponentScan("com.jdc.security.services")
public class RootConfig extends WebSecurityConfigurerAdapter{


}
