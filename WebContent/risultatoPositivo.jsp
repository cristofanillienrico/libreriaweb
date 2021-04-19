<%@page import="it.prova.libreriaweb.model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trovato</title>
</head>
<body>
Il libro che cerchi è:<br>
<% Libro libroInPagine=(Libro)request.getAttribute("libro-attribute"); %>
Titolo:<%= libroInPagine.getTitolo()%><br>
Genere:<%= libroInPagine.getGenere()%><br>
Pagine:<%= libroInPagine.getPagine() %><br>
<a href="caricaLibro.jsp">home</a>

</body>
</html>