package com.example.vaccinationcenter.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.example.vaccinationcenter.entities.User;


public class UserAuthenticationFilter implements Filter {
private UserRepository userRepository;
public UserAuthenticationFilter(UserRepository userRepository) {
this.userRepository = userRepository;
}
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, Filter filterChain) throws IOException, ServletException
{
boolean flag = validateToken((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
if(!flag){
return;
}
filterChain.doFilter(servletRequest,servletResponse);
}
private Set<String> servletPaths = new HashSet<>(){{
add("citizens");
add("vaccinationcenter");
add("me");
}};
private boolean validateToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
String servletPath = request.getServletPath();
System.out.println(servletPath);
String api = request.getHeader("x-api");
if(!Boolean.valueOf(api))
{
return true;
}
String authorizationHeader = request.getHeader("authorization");
if (StringUtils.isBlank(authorizationHeader)) {
System.out.println("auth token missing, so redirecting to login");
response.setStatus(302);
return false;
}
byte emailBytes[] = Base64.getDecoder().decode(authorizationHeader.getBytes(StandardCharsets.UTF_8
));
String email = new String(emailBytes);
User user = userRepository.findByEmail(email);
if (user == null) {
throw new RuntimeException("user not found with email: " + email);
}
return true;
}
@Override
public void init(FilterConfig filterConfig) throws ServletException) {
Filter.super.init(filterConfig);
}
@Override
public void destroy() {
Filter.super.destroy();
}
private String getBaseUrl(HttpServletRequest request)
{
String baseUrl = request.getScheme() + "://" + request.getServerName() +
":" + request.getServerPort() + request.getContextPath();
System.out.println(baseUrl);
return baseUrl;
}
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	
}
}