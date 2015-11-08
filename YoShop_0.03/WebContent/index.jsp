<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/jsp-decorator.tld" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<decorator:decorate filename="template.jsp">
		<decorator:content placeholder='title'>Yo Shop</decorator:content>
        <decorator:content placeholder="content">
        	<h2>Insert title here</h2>
        	<c:out value="${'<tag> , &'}" default="deftest" /> 
        </decorator:content>        
</decorator:decorate>