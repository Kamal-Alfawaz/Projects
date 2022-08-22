<?php
session_start();
if(($_SESSION['name'])){
    header('location:BlogPage/BlogPage.html');
}else{
    header('location:BlogPage/viewBlog.php');
}
?>