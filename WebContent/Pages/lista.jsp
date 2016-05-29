<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	 import="servlet.Magazyn"%> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="index.html" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<link rel="stylesheet" href="Pages/format.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse1</title>

</head>

<body>

	<table >
		<tr>
			<th>ID</th>
			<th>NAZWA<input id ="name1" type="text" name="nazwaSzukana" onkeypress="doClick('nazwaButton',event)"><button id="nazwaButton" style="font-size: .7em; height:20px; width:50px" onClick="filteringName()">filtering</button></td>
			<th>ILOSC</th>
			<th>CENA<br><input id= "priceFrom1" type="number" min="0.00" max="999999" name="priceFrom"><br><input id= "priceTo1" type="number" min="0.00" max= "9999999"   name = "priceTo"><br><button style="font-size: .7em; height:20px; width:50px" onClick="filteringPrice()">filtering</button></th> 
			<th>KATEGORIA<input id ="category1" type="text" name="kategoriaSzukana" onkeypress="doClick('kategoriaButton',event)"><button id ="kategoriaButton" style="font-size: .7em; height:20px; width:50px" onClick="filteringCategory()">filtering</button></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th><button id="1" onClick="sortId()">ID</button></th>
			<th><button id="1" onClick="sortNazwa()">NAZWA</button></th>
			<th><button id="1" onClick="sortIlosc()">ILOSC</button></th>
			<th><button id="1" onClick="sortCena()">CENA</button></th>
			<th><button id="1" onClick="sortKategoria()">KATEGORIA</button></th>
			<th>OPIS</th>
			<th></th>
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

function doClick(buttonId, e){
if (e.keyCode == 13){
    // Get the button the user wants to have clicked
    var btn = document.getElementById(buttonId);
    if (btn){
        btn.click();
        return false;
    }
}
}

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
	    	
	    }
	
}	
function sortId(){
	window.location.href = "SortMagazynServlet?sort=id";
}
function sortNazwa(){
	window.location.href = "SortMagazynServlet?sort=nazwa";
}
function sortIlosc(){
	window.location.href = "SortMagazynServlet?sort=ilosc";
}
function sortCena(){
	window.location.href = "SortMagazynServlet?sort=cena";
}
function sortKategoria(){
	window.location.href = "SortMagazynServlet?sort=kategoria";
}
function filteringName(){
 	var frase=document.getElementById("name1").value;
 	if (frase!=null && frase!==""){
  		window.location.href = "FilteringMagazynServlet?filtering=byname&frase="+frase;
  	}
 	else {
 	}
}
function filteringCategory(){
	var frase=document.getElementById("category1").value;
 	if (frase!=null && frase!==""){
 		window.location.href = "FilteringMagazynServlet?filtering=bycategory&frase="+frase;
 	}
	else {
	}
}


 function filteringPrice(){
	
 	var price1=document.getElementById("priceFrom1").value;
 	var price2=document.getElementById("priceTo1").value;
 	
 	var price1a=parseFloat(price1);
 	var price2a=parseFloat(price2);

 	
 	if(isNaN(price1a)&& !isNaN(price2a)){
 		var ziro = 0;
 		var price1=ziro.valueOf();
 		window.location.href = "FilteringMagazynServlet?filtering=byprice&from="+price1+"&to="+price2;
 	}
 	else if (!isNaN(price1a) && !isNaN(price2a)){
		window.location.href = "FilteringMagazynServlet?filtering=byprice&from="+price1+"&to="+price2;
	}
 	else{
		alert("Please enter price in number format!");
		}
  }
</script>
</html>