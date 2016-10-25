package edu.fae.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import edu.fae.crud.service.UsuarioService;

/**
 * Configurações de segurança
 * @author robson
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	@Autowired UsuarioService usuarioService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
        	.authorizeRequests()
                .antMatchers("/api/**").authenticated() //Bloquea o acesso a /api/**
                .anyRequest().permitAll() //O restante dos requests fica liberado sem login
                
                .and()
                .exceptionHandling()
	                .authenticationEntryPoint(new AuthenticationEntryPoint() {
						@Override
						public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth)
								throws IOException, ServletException {
							response.sendError(HttpServletResponse.SC_UNAUTHORIZED);//Manda o erro 401 em caso de acesso negado
						}
					})
                .and()
                //Configuração do Form de Login
                .formLogin()
                	.failureHandler(new AuthenticationFailureHandler() {
						@Override
						public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
								AuthenticationException auth) throws IOException, ServletException {
							response.sendError(403);//Manda o erro 403, em caso de login invalido
						}
					})
                	.loginProcessingUrl("/login") //Url do serviço de Login
                	.passwordParameter("senha") //Parametro esperado para a senha
                	.usernameParameter("email") //Parametro esperado para o e-mail
                	.permitAll()
                .and()
                //Configuração do Logout
                .logout()
                .logoutUrl("/logout") //Url de Logout
                .logoutSuccessUrl("/") //Redirect após o logout
            ;   
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    		auth.userDetailsService(usuarioService);
    }
    
}