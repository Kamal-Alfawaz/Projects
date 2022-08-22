<?php
session_start();
include 'E:\xampp\htdocs\MiniProject-Phase2\connection.php';
$email=$_POST['email'];
$password=$_POST['password'];
$sEmail=mysqli_real_escape_string($conn,$email);
$sPass=mysqli_real_escape_string($conn,$password);

$query="SELECT * From logindetails where email='$sEmail' and password='$sPass'";
$result=mysqli_query($conn,$query);
if(mysqli_num_rows($result)==1){

    $queryName = mysqli_query($conn, "SELECT name FROM logindetails WHERE email = '$email'");
    $result = mysqli_fetch_array($queryName);

    $_SESSION['name'] = $result;
    header('location:../BlogPage/BlogPage.html');
}else{
    header('location:LoginPage.html');
}
?>