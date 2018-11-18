<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<table class="table">
<tr>
<td rowspan="10">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>"/>
</td>
</tr>
<tr>
<td>Product ID</td>
<td>${product.productId}</td>
</tr>
<tr>
<td>Product Name</td>
<td>${product.productName}</td>
</tr>
<tr>
<td>Category Id</td>
<td>${product.categoryId}</td>
</tr>
<tr>
<td>Supplier ID</td>
<td>${product.supplierId}</td>
</tr>
<tr>
<td>Product Price</td>
<td>${product.price}</td>
</tr>
<tr>
<td>Stock</td>
<td>${product.stock}</td>
</tr>
<tr>
<td>Product Desc</td>
<td>${product.productDesc}</td>
</tr>
<form action="<c:url value="/addToCart/${product.productId}"/>" method="get">
<tr>
<td>Quantity</td>
<td><select name="quantity" class="from-control btn-black">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="AddToCart" class="btn btn-danger btn-block"/>
</td>
</tr>
</table>
</div>
