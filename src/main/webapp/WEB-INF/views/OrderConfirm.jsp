<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
<form action="<c:url value="/Payment"/>" method="post">
<table align="center" class="table">
<tr bgcolor="orange">
<td colspan="5"><center><h3>Your Order</h3></center></td>
<tr bgcolor="#BDBDBD">
<td>Product ID</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>


</tr>
<c:forEach items="${cartItems}" var="cartItem">
<tr bgcolor="cyan">

<td>${cartItem.productId}</td>
<td>${cartItem.productName}</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.price}</td>
<td>${cartItem.price*cartItem.quantity}</td>

</form>
</tr>
</c:forEach>
<tr bgcolor="pink">
<td colspan="4">Total Amount</td>
<td>${totalAmount}</td>

</tr>
<tr><td colspan="5">
<table width="100%">
<tr bgcolor="cyan">
<td>
<input type="radio" name="pmode" value="CD"/>Cash On Delivery
<input type="radio" name="pmode" value="CARD"/>Credit Card or Debit Card
<input type="radio" name="pmode" value="NB"/>NetBanking
</td>

</table>
</td>
</tr>
<tr bgcolor="pink">
<td colspan="3"><a href="<c:url value="/Cart"/>" class="btn btn-danger btn-block" >Edit Order</a></td>
<td colspan="2"><input type="submit" value="payment" class="btn btn-danger btn-block" ></a></td>

</tr>

</table>
</form>
</div>
