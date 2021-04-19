<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carica Libro</title>
</head>
<body>
Inserisci dati per caricare il libro:
<form action="ExecuteRicercaLibroServlet" method="post"><br>
Titolo:<input type="text" name="titoloInput"><br>
Genere:<input type="text" name="genereInput"><br>
Pagine:<input type="text" name="pagineInput"><br>
<input type="submit" value="submitValue"><br>
</form>

</body>
</html>