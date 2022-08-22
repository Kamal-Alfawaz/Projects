<?php
    session_start();
    if(!($_SESSION['name'])){
        header('location:../FirstMainPage.html');
    }else{
        include 'E:\xampp\htdocs\MiniProject-Phase2\connection.php';

        $title=$_POST['title'];
        $description=$_POST['description'];
        $sTitle=mysqli_real_escape_string($conn,$title);
        $sDescription=mysqli_real_escape_string($conn,$description);

        date_default_timezone_set("Europe/London");
        $datePosted = date("Y-m-d H:i:s");

        $PostBlog= "INSERT INTO blogposts (title, description, date) VALUES ('$sTitle','$sDescription', '$datePosted')";
        mysqli_query($conn,$PostBlog);
        header('location:viewBlog.php');
    }
?>