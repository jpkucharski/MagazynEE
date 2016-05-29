<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	 import="servlet.Magazyn"%> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table,th,td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align:center;
	font-family: Verdana,Arial,sans-serif;
	font-size: .9em;
}

tr,td {
	padding: 5px;

}
</style>
</head>

<body>
	<table style="width: 100%">
		
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
				<td>${ nazwaWSrodku.getId()}</td>
				<td>${ nazwaWSrodku.getNazwa()}</td>
				<td>${ nazwaWSrodku.getIlosc()}</td>
				<td>${ nazwaWSrodku.getCena()}</td>
				<td>${ nazwaWSrodku.getKategoria()}</td>
				<td>${ nazwaWSrodku.getOpis()}</td>
 				<td><button id="1" onClick="klikniecie(${ nazwaWSrodku.getId()})">DELETE</button></td>
 				<td><button id="1" onClick="edycja(${ nazwaWSrodku.getId()})">EDIT</button></td>  
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">
function klikniecie(id){	
	
	    if (confirm("Are you sure?") == true) {
 	    	window.location.href = "DeleteServlet?id="+id;
	    	
	    } 
	    else {
	    	
	       }
}
function edycja(id){
	 if (confirm("Are you sure?") == true) {
	    	window.location.href = "EditServlet?id="+id;
	    	
	 } 
	    else {
	    	alert(id);
	    }
	
}	
</script>
</html>