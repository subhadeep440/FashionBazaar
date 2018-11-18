<%@ include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 
<form:form action="UpdateProduct" modelAttribute="product" method="POST" enctype="multipart/form-data">
		
		<br>
		<br>
		<table align="center">
		<tr bgcolor="#BDBDBD">
				<td colspan="2"><center><h2>Edit Product</h2></center></td>
			</tr>
            <tr bgcolor="#EAA911">		
				<td>Product Name</td>
				<td><form:input path="productName"/></td>
			</tr>
			<tr bgcolor="#EAA911"> 
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr bgcolor="#EAA911">
				<td>Stock</td>
				<td><form:input path="stock"  /></td>
			</tr>
			<tr bgcolor="#EAA911">
				<td>Category</td>
				<td><form:select path="categoryId">
				<form:option value="0" label="--Select List--"/>
				<form:options items="${categoryList}"/></form:select>
				</td>
				
			</tr>
			<tr bgcolor="#EAA911">
				<td>Supplier</td>
				<td><form:input path="supplierId" /></td>
			</tr>
			<tr bgcolor="#EAA911">
				<td>Product Description</td>
				<td><form:input path="productDesc" /></td>
			</tr>
			
			<tr >
			<td>Product Image</td>
			<td><form:input type="file" path="pimage" /></td>
			</tr>
		
		<tr bgcolor="#EAA911">
				<td colspan="2"><center>
						<input type="submit" value="Update"/>
					</center></td>
			</tr>
			</table>
	</form:form>
	
	<font color="red"><h3>${errorInfo}</h3></font>
	
	</br></br></br></br>

<table align="center">
<tr bgcolor="#BDBDBD">
<td>Product ID</td>
<td>Product Name</td>
<td>Product Desc</td>
<td>Category ID</td>
<td>Supplier ID</td>
<td>Stock</td>
<td>Price</td>
<td>Image</td>

<td> Operations</td>

</tr>
<c:forEach items="${listProducts}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productDesc}</td>
<td>${product.categoryId}</td>
<td>${product.supplierId}</td>
<td>${product.stock}</td>
<td>${product.price}</td>
<td>${product.productDesc}</td>

<td>
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50" height="50"/>
</td>
<td>
<a href="<c:url value='/editProduct/${product.productId}'/>">Edit</a>/
<a href="<c:url value='/deleteProduct/${product.productId}'/>">Delete</a>
</tr>
</c:forEach>
</table>
</body>
</html>
