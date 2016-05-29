<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	 import="servlet.Magazyn"%> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="index.html" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Pages/format.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<div>
	<table>
		<tr>
			<th>ID</th>
			<th>NAZWA</th>
			<th>ILOSC</th>
			<th>CENA</th>
			<th>KAREGORIA</th>
			<th>OPIS</th>
			<th></th>
		</tr>
		
			<c:forEach var="nazwaWSrodku" items="${lista}">
			<tr>
			<form name="input" action= "/MagazynEE/EditServlet" method="post">
			
				
 				<td><input id="id" type="hidden"	name="idZamiana" value="${ nazwaWSrodku.getId()}">
				${ nazwaWSrodku.getId()}</td>
				<td><input id="nazwa" type="text"	name="nazwaZamiana" value="${ nazwaWSrodku.getNazwa()}"></td>
				<td><input id="ilosc" type="text"	name="iloscZamiana" value="${ nazwaWSrodku.getIlosc()}"></td>
				<td><input id="cena" type="text"	name="cenaZamiana" value="${ nazwaWSrodku.getCena()}"></td>
				
				<td>
				<select name="kategoriaZamiana" >
					<option value="${ nazwaWSrodku.getKategoria()}">${ nazwaWSrodku.getKategoria()}</option>
					<option value="metalowe">Metalowe</option>
  					<option value="drewniane">Drewniane</option>
					<option value="gumowe" selected="true">Gumowe</option>
  					<option value="kompozyt">Kompozyt</option>
				</select>
				</td>
				<td><input id="opis" type="text"	name="opisZamiana" value="${ nazwaWSrodku.getOpis()}"></td>
				
				
 				<td><input type="submit" value= "SAVE"></td> 
 				</form> 
			</tr>
		</c:forEach>
		
		
	</table>
</body>
<script type="text/javascript">

function save(id){
	 if (confirm("Are you sure?") == true) {
		alert(id);
	    	//window.location.href = "EditServlet?id="+id;
	    	
	 } 
	    else {
	    	
	    }
	
}	
</script>
</html>