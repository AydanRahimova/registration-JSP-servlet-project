<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style_menu.css">
    <title>Document</title>
</head>
<body>
<form action="CustomerServlet" method="get">
    <section class="container">
        <header>Choose an operation</header>

        <div class="button-div">
            <button type="submit" name="option" value="view">View customers</button>
        </div>

        <div class="button-div">
            <button type="submit" name="option" value="add">Add a customer</button>
        </div>

        <div class="button-div">
            <button type="submit" name="option" value="update">Update customer</button>
        </div>


    </section>

</form>
</body>
</html>