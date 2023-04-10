<?php
include "connexion.php";

try {
    $cnx = connexionPDO();
    $req = $cnx->prepare("SELECT * FROM visiteur");
    $req->execute();

    while ($ligne = $req->fetch(PDO::FETCH_ASSOC)){
      $res[] = $ligne;
    }
    print(json_encode($res));

    } catch(PDOException $e){
    print "Erreur !: ". $e->getMessage();
    die();
    }
?>
