<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
    <form method="post" action="registerDetails">
	    <center>
	    
		    <table width="50%"  cellpadding="5" cellspacing="5" align="left" frame="border">
		        <thead>
		            <tr>
		                <th colspan="2">Enter Basic Information Here</th>
		            </tr>
		        </thead>
		        <tbody>
		            <tr>
		                <td> First Name:</td>
		                <td>
		                    <input type="text" name="namereg" id="fname">
		                </td>
		            </tr>
		            <tr>
		                <td> Last Name:</td>
		                <td>
		                    <input type="text" name="namereg" id="lname">
		                </td>
		            </tr>
		            <tr>
		                <td> Username:</td>
		                <td>
		                    <input type="text" name="usernamereg">
		                </td>
		            </tr>
		            <tr>
		                <td> Email:</td>
		                <td>
		                    <input type="text" name="emailreg">
		                </td>
		            </tr>
		            <tr>
		                <td> Password:</td>
		                <td>
		                    <input type="password" name="passwordreg">
		                </td>
		            </tr>
		            <tr>
		                <td> Re-Enter Password:</td>
		                <td>
		                    <input type="password" name="repasswordreg">
		                </td>
		            </tr>
		            <tr>
		                <td> Gender:</td>
		                <td>
		                    <input type="text" name="gender">
		                </td>
		            </tr>
		            <tr>
		                <td> Age:</td>
		                <td>
		                    <input type="text" name="age">
		                </td>
		            </tr>
		            <tr><td><input type="submit" value="Save and Go to Next"></td>
		              <td><input type="reset" value="Reset"></td></tr>
		              <tr>
		                  <td colspan="2">If Already Registered!! <a href="login.jsp">Login Here</a></td>
		              </tr>
		      </tbody>
		      
		    </table>
	    </center>
    </form>
</body>
</html>