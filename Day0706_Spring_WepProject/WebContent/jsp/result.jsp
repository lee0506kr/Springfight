<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert("<%=request.getAttribute("msg") %>");
	location.href="<%=request.getAttribute("url") %>";
</script>