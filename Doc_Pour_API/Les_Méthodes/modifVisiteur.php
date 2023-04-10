<?php
include "connexion.php";

$idV = $_POST['id'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$login = $_POST['login'];
$mdp = $_POST['mdp'];
$adresse = $_POST['adresse'];
$cp = $_POST['cp'];
$ville = $_POST['ville'];
$dateEmbauche = $_POST['dateEmbauche'];

try{
        $cnx = connexionPDO();
        
        $req = "UPDATE visiteur SET nom=:nom, prenom=:prenom, login=:login, mdp=:mdp, adresse=:adresse, cp=:cp, ville=:ville, dateEmbauche=:dateEmbauche WHERE id=:idV";
        $stm = $cnx->prepare($req);

        $stm->bindParam('idV', $idV);
        $stm->bindParam('nom', $nom);
        $stm->bindParam('prenom', $prenom);
        $stm->bindParam('login', $login);
        $stm->bindParam('mdp', $mdp);
        $stm->bindParam('adresse', $adresse);
        $stm->bindParam('cp', $cp);
        $stm->bindParam('ville', $ville);
        $stm->bindParam('dateEmbauche', $dateEmbauche);
        
        $resultat = $stm->execute();

        print(json_encode($resultat));
}catch (PDOException $e) {
    print"Erreur !: ". $e->getMessage();
}
 
?>

