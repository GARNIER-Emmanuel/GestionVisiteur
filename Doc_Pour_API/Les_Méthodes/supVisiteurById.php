<?php
include "connexion.php";

$idV = $_POST['id'];
    
try{
        $cnx = connexionPDO();
        
        $req = "DELETE FROM visiteur WHERE id = :idV";
        $stm = $cnx->prepare($req);
        $stm->bindParam(':idV',$idV);
        $stm->execute();
        
        print(json_encode($res));
        
        print " visiteur supprimé !";
    }catch (PDOException $e){
        print "Erreur !: ". $e->getMessage();
    die();
}
 
?>

