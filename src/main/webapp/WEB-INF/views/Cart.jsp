<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<table align="center" class="table">
<tr bgcolor="#BDBDBD">
<td>Product ID</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
<td> Operations</td>

</tr>
<c:forEach items="${cartItems}" var="cartItem">
<tr bgcolor="cyan">
<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
<td>${cartItem.productId}</td>
<td>${cartItem.productName}</td>
<td><input type="text" value="${cartItem.quantity }" name="quantity"/></td>
<td>${cartItem.price}</td>
<td>${cartItem.price*cartItem.quantity}</td>

<td>
<input type="submit" value="Update" class="btn btn-success btn-block"/>
<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId }"/>" class="btn btn-danger btn-block" >DELETE</a>
</td>

</form>
</tr>
</c:forEach>
<tr bgcolor="pink">
<td colspan="4">Total Amount</td>
<td colspan="2">${totalAmount}</td>

</tr>
<tr bgcolor="pink">
<td colspan="4"><a href="<c:url value="/UserHome"/>" class="btn btn-danger btn-block" >Continue Shopping</a></td>
<td colspan="2"><a href="<c:url value="/Checkout"/>" class="btn btn-danger btn-block" >CheckOut</a></td>

</tr>

</table>
</div>
