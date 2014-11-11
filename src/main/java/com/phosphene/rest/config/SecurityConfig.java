package com.phosphene.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.session.ExpiringSession;
import org.springframework.session.SessionRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.CookieHttpSessionStrategy;

import org.springframework.session.web.http.SessionRepositoryFilter;

import com.phosphene.rest.spring.DatabaseUserDetailsService;
import com.phosphene.rest.spring.UserAccountService;


@EnableWebMvcSecurity
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@Order
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SessionRepository<? extends ExpiringSession> sessionRepository;

    @Autowired
    private UserAccountService userAccountService;
   

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        final SessionRepositoryFilter sessionRepositoryFilter = new SessionRepositoryFilter(sessionRepository);
        sessionRepositoryFilter.setHttpSessionStrategy(new HeaderHttpSessionStrategy());

        http
            .addFilterBefore(sessionRepositoryFilter, ChannelProcessingFilter.class)
            .csrf().disable();

        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/sessions").permitAll();
        

}

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
   
    @Bean
    public UserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }


}

