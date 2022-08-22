<?php
session_start();
unset($_SESSION['name']);
header('location:LoginPage.html');
?>