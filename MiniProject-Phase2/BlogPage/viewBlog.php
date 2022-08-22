<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kamal's HomePage</title>
        <link rel="stylesheet" href="../reset.css">
        <link rel="stylesheet" href="viewBlog.css">
    </head>
    <body>
    <h2 class="BlogPage">Blog Page</h2>
    <hr class="BlogPageUnderline">
        <div class="keepFixed">
            <header class="square">
                <nav>
                    <div>
                        <ul>
                            <li><a href="../FirstMainPage.html"><img class="mainPageImage" src="../ToMainPage.jpg" alt="Picture is Missing" width="6.25rem" height="8.4375rem"></a></li>
                            <li class="seperation"><a class="seperation" href="../FirstMainPage.html"><img class="Icon" src="../AboutMeIconInactive.svg" alt="Picture is Missing"><p>About Me</p></a></li>
                            <li class="seperation"><a class="seperation" href="../SkillsPage/SkillsPage.html"><img class="Icon" src="../SkillsPage/SkillsIconInactive.svg" alt="Picture is Missing"><p>Skills and Achievements</p></a></li>
                            <li class="seperation"><a class="seperation" href="../Educations/QualificationsPage.html"><img class="Icon" src="../Educations/EducationInactive.png" alt="Picture is Missing"><p>Education and Qualifications</p></a></li>
                            <li class="seperation"><a class="seperation" href="../ExperiencePage/ExperiencePage.html"><img class="Icon" src="../ExperiencePage/ExperienceInactive.png" alt="Picture is Missing"><p>Experience</p></a></li>
                            <li class="seperation"><a class="seperation" href="../Portfolio/PortfolioPage.html"><img class="Icon" src="../Portfolio/PortfolioIconInactive.svg" alt="Picture is Missing"><p>Portfolio</p></a></li>
                            <li class="seperation"><a class="seperation" href="../ContactPage/ContactPage.html"><img class="Icon" src="../ContactPage/ContactIconInactive.svg" alt="Picture is Missing"><p>Contact Me</p></a></li>
                            <li class="seperation"><a class="seperation" href="../checkIfCanPost.php"><img class="Icon" src="../BlogPage/BlogIconActive.png" alt="Picture is Missing"><p>Blog</p></a></li>
                        </ul>
                    </div>
                </nav>
            </header>
            </div>
            <a href="../LoginPage/LoginPage.html">
                <button class="buttons">Login</button>
            </a>
            <footer class="keepFixed">
                <ul>
                    <li><a><img class="arrowDown" src="../arrowDown.svg" alt="Picture is missing"></a></li>
                    <li><a href="https://www.linkedin.com/in/kamal-alfawaz-362797138"><img class="linkedIn" src="../LinkedInIcon.svg" alt="Picture is missing"></a></li>
                    <li><a href="https://github.com/Kamal-Alfawaz"><img class="gitHub" src="../github.svg" alt="Picture is missing" ></a></li>
                </ul>
                <div class="moveLine">
                    <hr>
                    <p class="copyright"><i>Copyright &copy;<br> 2022 Kamal Alfawaz</i></p>
                </div>
            </footer>
        </div>
        <?php
        include '../connection.php';
        
        $sql = "SELECT * FROM blogposts";
        $query = mysqli_query($conn, $sql);

        $array = array();

        if(mysqli_num_rows($query) > 0){
            while($row = mysqli_fetch_assoc($query)){
                $array[] = $row;
            }
        }
        $len = count($array);
        for($i = 0; $i<$len; $i++){
            for($j = 0; $j<($len-1-$i); $j++){
                if(strtotime($array[$j]['date']) < strtotime($array[$j+1]['date'])){
                    $temp = $array[$j];
                    $array[$j] = $array[$j+1];
                    $array[$j+1] = $temp;
                }
            }
        }

        foreach ($array as $q){?>
        <div class="blogs">
            <h1 class="title1"><?php echo $q['title'];?></h1>
            <h3 class="date"><?php echo "Posted on: ", $q['date'], " (UTC)"; ?></h3>
            <p class="description"><?php echo $q['description'];?><p>
        </div>
            <br>
        <?php }
        $conn -> close();
        ?>
    </body>
</html>