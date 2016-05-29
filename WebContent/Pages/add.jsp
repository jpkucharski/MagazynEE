<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- 	 import="servlet.Magazyn"%> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="index.html" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="format.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding_Formular</title>
</head>
<body>
	<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>ILOSC</th>
				<th>CENA</th>
				<th>KATEGORIA</th>
				<th>OPIS</th>
				<th></th>
			</tr>
			<tr>
				<form name="input" onsubmit="return funkcja()" action="/MagazynEE/AddServlet" method="post">
				<td>Will be given automaticly.</td>
				<td><input id="nazwa" type="text" name="nazwaWprowadzana"></td>
				<td><input id="ilosc" type="text" name="iloscWprowadzana"></td>
				<td><input id="cena" type="text" name="cenaWprowadzana"></td>
				<td><select id ="kategoriaW" name="kategoriaWprowadzana">
						<option value="metalowe">Metal</option>
						<option value="drewniane">Wooden</option>
						<option value="gumowe">Rubber</option>
						<option value="kompozyt">Composite</option>
				</select></td>
				<td><input id="opis" type="text" name="opisWprowadzana"></td>
				<td><input type="submit" value="SAVE"></td>
			</tr>
			</form>
	</table>
</body>
<script>
function funkcja(){
	 var nazwaWprowadzana = document.forms["input"]["nazwa"].value;
	    if (nazwaWprowadzana==null || nazwaWprowadzana=="") {
	        alert("Plase enter the name!");
	        return false;
	    }
	    var iloscWprowadzana = document.forms["input"]["ilosc"].value;
	   	 if (iloscWprowadzana != parseInt(iloscWprowadzana)){
       				 alert("Quantity is not a number!");
       				return false;
	   	 }
       	else{
       		if (iloscWprowadzana==null || iloscWprowadzana=="") {
    	        alert("Plase enter the quantity!");
    	        return false;
       		}   
       		else{
    	    }  
       	} 
		
	    var cenaWprowadzana = document.forms["input"]["cena"].value;
	     if (cenaWprowadzana==null || cenaWprowadzana=="") {
	        alert("Plase enter the price!");
	        return false;
	    }
	    else{
	    	var regEx = /^\d{1,5}\.\d{1,2}$/;
	    	bValid = document.input.cenaWprowadzana.value.match(regEx);
	    	 if(!bValid){  
		          alert("Incorrect format! example:123.00");  
		          return false;           
		        }
	    	
	    }

	    var kategoriaWprowadzana = document.forms["input"]["kategoriaW"].value;
	    if (kategoriaWprowadzana==null || kategoriaWprowadzana=="") {
	        alert("Plase choose the category!");
	        return false;
	    }    
}
</script>
</html>