<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
	<h1>Spring Security</h1>
	
	<ul>
		<li><a href="/spring/index.do">Index</a></li>
		
		<sec:authorize access="hasRole('ROLE_MEMBER')">
			<li><a href="/spring/member/member.do">Member</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/spring/admin/admin.do">Admin</a></li>
		</sec:authorize>
		
		<sec:authorize access="isAnonymous()">
			<li><a href="/spring/auth/login.do">Login</a></li>
			<li><a href="/spring/auth/register.do">Register</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li><a href="/spring/auth/info.do">Info</a></li>
			<li><a href="/spring/auth/logout.do">Logout</a></li>
		</sec:authorize>
	</ul>
</header>