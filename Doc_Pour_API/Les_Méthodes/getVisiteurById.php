<?php
include "connexion.php";

$idV = $_GET['id'];
    
try{
        $cnx = connexionPDO();
        
        $req = "SELECT * FROM visiteur WHERE id = :idV";
        $stm = $cnx->prepare($req);
        $stm->bindParam(':idV',$idV);
        $stm->execute();
        
        while ($ligne = $stm->fetch(PDO::FETCH_ASSOC)){
            $res[] = $ligne;
        }
        print(json_encode($res));
    }catch (PDOException $e){
        print "Erreur !: ". $e->getMessage();
    die();
}
 
?>

