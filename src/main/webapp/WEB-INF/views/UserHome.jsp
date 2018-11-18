<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
<div class="row">
<c:forEach items="${listProducts}" var="product">

<div class="col-sm-4 col-md-4">
<a href="productDesc/${product.productId }" class="thumbnail">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="100" height="150" alt="Generic thumbnil">
</a>
<p>
Product Name:${product.productName}
Product Price:${product.price}
</p>
</div>
</c:forEach>
</div>
</div>
