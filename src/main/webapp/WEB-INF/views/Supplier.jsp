<%@ include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3 align="center">Supplier page</h3>
<form action="InsertSupplier" method="post">
<table align="center">
<tr bgcolor="pink"><td colspan="2"><center>Supplier Details</center></td></tr>
<tr>
<td>Supplier Addr</td>
<td><input type="text" name="supaddr" id="supaddr"/></td>
</tr>
<tr bgcolor="pink">
<td>Supplier Name</td>
<td>
<textarea name="supname" id="supname"></textarea></td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="INSERT"/></center>
</td>
</tr>
</table>
</form>
<table align="center">
<tr bgcolor="pink">
<td>Supplier ID</td>
<td>Supplier Addr</td>
<td>Supplier Name</td>
<td>Operation</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr>
<td>${supplier.supplierId}</td>
<td>${supplier.supplierAddr}</td>
<td>${supplier.supplierName}</td>
<td>
<a href="<c:url value='/editSupplier/${supplier.supplierId}'/>">Edit</a>/
<a href="<c:url value='/deleteSupplier/${supplier.supplierId}'/>">Delete</a>
</tr>
</c:forEach>
</table>
</body>
</html>