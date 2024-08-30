<%--
  Created by IntelliJ IDEA.
  User: aydan_3hdj63t
  Date: 8/26/2024
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="style_register.css">

</head>
<body>
<section class="container">
    <header>Update</header>
    <form action="${pageContext.request.contextPath}/UpdateServlet" method="post">
        <div class="input-box">
            <label>FIN</label>
            <input type="text" placeholder="Enter your FIN" name="FIN">
        </div>

        <div class="input-box">
            <label>New First Name</label>
            <input type="text" placeholder="Enter your first name" name="firstName">
        </div>
        <div class="input-box">
            <label>New Last Name</label>
            <input type="text" placeholder="Enter your last name" name="lastName">
        </div>



        <div class="input-box">
            <label>New Email Address</label>
            <input type="email" placeholder="Enter your email address" name="email">
        </div>

        <div style="display: flex;;">
            <div class="input-box">
                <label>New Phone Number</label>
                <input type="tel" placeholder="Enter your phone number" name="phone">
            </div>
            <div class="input-box">
                <label>New Birth Date</label>
                <input type="date" placeholder="Enter your birth date" name="birthDate">
            </div>
        </div>

        <div class="submit-button">
            <button>Submit</button>

        </div>


    </form>

</section>
</body>
</html>
