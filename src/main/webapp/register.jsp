<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="style_register.css">
  <title>Document</title>
</head>
<body>
<section class="container">
  <header>Registration</header>
  <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    <div class="input-box">
      <label>First Name</label>
      <input type="text" placeholder="Enter your first name" name="firstName">
    </div>
    <div class="input-box">
      <label>Last Name</label>
      <input type="text" placeholder="Enter your last name" name="lastName">
    </div>

    <div class="input-box">
      <label>Email Address</label>
      <input type="email" placeholder="Enter your email address" name="email">
    </div>



    <div style="display: flex;;">
      <div class="input-box">
        <label>Phone Number</label>
        <input type="tel" placeholder="Enter your phone number" name="phone">
      </div>
      <div class="input-box">
        <label>Birth Date</label>
        <input type="date" placeholder="Enter your birth date" name="birthDate">
      </div>
    </div>

    <div class="input-box">
      <label>FIN</label>
      <input type="text" placeholder="Enter your FIN" name="FIN">
    </div>

    <div class="submit-button">
      <button type="submit" name="submit-button" >Submit</button>

    </div>



  </form>

</section>
</body>
</html>