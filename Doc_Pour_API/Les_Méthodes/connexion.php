<?php
function connexionPDO(){
    $login = "280586";
    $mdp = "Eb22072002";
    $db = "garnierboidun_visiteurs";
    $serveur = "mysql-garnierboidun.alwaysdata.net";
    try{
        $cnx = new PDO("mysql:host=$serveur;dbname=$db",$login,$mdp);
        return $cnx;
}catch (PDOException $e){
    print "connexion à la base de données impossible";
    die();
}
}
?>


