<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
    <h1>Edit Profile</h1>
    <form action="UpdateProfileController" method="POST">
      
        <input type="text" name="firstName" id="firstName" placeholder="Firstname">
        <br><br>
      
        <input type="text" name="lastName" id="lastName" placeholder="LastName">
        <br><br>
        
        <input type="password" name="password" id="password" placeholder="Password">
        <br><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
