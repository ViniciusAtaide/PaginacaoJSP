<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body {
		text-align: center;
		
	}
	.lista {	
		margin-left: auto;
		margin-right: auto;
	}
	.pags {
		margin-left: auto;
		margin-right: auto;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Paginação com JSP</title>
</head>
<body>
	<a href="usu.do?quant=5">5 por página</a> 
	<a href="usu.do?quant=10">10 por página</a>
	<a href="usu.do?quant=15">15 por página</a>
	<br>
	<table border="1" class="lista" width="50%">
		<tr>
			<th>Nome</th>
			<th>Data Cadastro</th>
			<th>Lista de produtos</th>
		</tr>
		<c:forEach items="${requestScope.lista }" var="usu">
		<tr>
			<td>${usu.login }</td>
			<td><fmt:formatDate value="${usu.datacadastro }" pattern="dd/MM/yyyy"/></td>
			<td>
			<c:forEach items="${usu.nomeprods }" var="produto">
				${produto }, 
			</c:forEach>
			</td>
		</tr>
		</c:forEach>		
	</table>
	

	<table border="1" class="pags" width="50%">
		<tr>
			<c:choose>	
				<c:when test="${pagina != 1 }">
					<td><a href="usu.do?pagina=${pagina-1 }">Anterior</a></td>
				</c:when>
				<c:otherwise>
					<td>Anterior</td>
				</c:otherwise>
			</c:choose>
			
			<c:forEach begin="1" end="${requestScope.numpaginas }" var="i">
				<c:choose>
					<c:when test="${pagina eq i }">
						<td>${i }</td>
					</c:when>			
					<c:otherwise>
						<td><a href="usu.do?pagina=${i }">${i }</a></td>
					</c:otherwise>		
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pagina lt numpaginas  }">
					<td><a href="usu.do?pagina=${pagina+1 }">Próxima</a> </td>
				</c:when>
				<c:otherwise>
					<td>Próxima</td>
				</c:otherwise>
			</c:choose>
		</tr>	
	</table>
</body>
</html>