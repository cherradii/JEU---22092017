<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jeu Hasard</title>
</head>
<body>
  <h2>  Jeu hasard !</h2>
  <form action = "controleur" method="post">
    Devinez : <input type="text" name="nombre" value="${model.nombre }"></input> <br />
    <input type="submit" value="Jouer" name="action"></input>
    <input type="submit" value="Relancer le jeu" name="action"></input>
  </form>
  <table>
   <c:forEach items="${model.historique}" var="hist">
     <tr>
      <td>Tentative ${model.tentative} : </td><td>${hist}</td>
     </tr>
   </c:forEach>
  </table>
</body>
</html>