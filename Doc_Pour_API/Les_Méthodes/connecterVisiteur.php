<?php
include "connexion.php";

$login = $_GET['login'];
$mdp = $_GET['mdp'];

try {
    $cnx = connexionPDO();

    $req = "SELECT * FROM visiteur WHERE login = :login AND mdp = :mdp";
    $stm = $cnx->prepare($req);

    $stm->bindParam(':login', $login);
    $stm->bindParam(':mdp', $mdp);

    $stm->execute();

    while ($ligne = $stm->fetch(PDO::FETCH_ASSOC)){
        $resultat[] = $ligne;
    }
    
    print(json_encode($resultat));
} catch (PDOException $e) {
    print "Erreur !: " . $e->getMessage();
}
