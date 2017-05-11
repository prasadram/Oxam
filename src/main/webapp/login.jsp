<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	
	<form action="validate.html" method="post">
	<table frame="border" align="left"  cellpadding="5" cellspacing="5">
	   <thead>
	   <tr><th><h1 align="Center" >Login Details</h1><br></thead></th></tr>
	   
	   <tbody>
	      <tr>
	          <td>Username / Email:</td>
	          <td><input type="username" name="username"/></td>
	      </tr>
	      <tr>
              <td>Password:</td>
              <td><input type="password" name="password"/></td>
          </tr>
          <tr><td colspan="2"><input type="submit" value="Login Here"/><br></td></tr> 
          <tr><td colspan="2">
                    <%
                    if(request.getAttribute("parity")!=null || request.getAttribute("error")!=null){
                      out.append(""+request.getAttribute("error"));
                    if(request.getAttribute("parity").equals("not")){
                      out.append("<a href=\"register.jsp\">Register Here</a>"); 
                    }
                    }
                    %>
                    
               </td>
          </tr>
	   </tbody>
	</table>
		 
	</form>
</body>
</html>