package com.example.gestionvisiteur.modele;

        import android.database.Cursor;
        import android.util.Log;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import java.util.ArrayList;
        import java.util.concurrent.ExecutionException;

public class VisiteurDAO {

    public VisiteurDAO() {
    }



    public String addVisiteur(Visiteur unVisiteur) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant d'\ajouter le visiteur
        String myUrl="https://garnierboidun.alwaysdata.net/API/ajoutVisiteur.php";
        //informations à transmettre pour effectuer l'ajout
        String params =
                "id="+unVisiteur.getIdVisiteur()+"&nom="+unVisiteur.getNom()+
                "&prenom="+unVisiteur.getPrenom()+
                "&login="+unVisiteur.getLogin()+
                "&mdp="+unVisiteur.getMdp()+
                "&adresse="+unVisiteur.getAdresse()+
                "&cp="+unVisiteur.getCp()+
                "&ville="+unVisiteur.getVille()+
                "&dateEmbauche="+unVisiteur.getDateEmbauche();
        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat",result);
        return result;
    }

    public ArrayList<Visiteur> recupVisiteur() {
        String result = "";
        String params="";
        ArrayList<Visiteur> lesVisiteurs=new ArrayList<Visiteur>();
        //adresse de l'URL de l\'API à interroger et fichier php permettant la recuperation des visiteurs
        String myUrl="https://garnierboidun.alwaysdata.net/API/getVisiteurs.php";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONArray array = new JSONArray(result);
            for(int i=0;i<array.length();i++){
                String id = array.getJSONObject(i).getString("id");
                String nom = array.getJSONObject(i).getString("nom");
                String prenom = array.getJSONObject(i).getString("prenom");
                String login = array.getJSONObject(i).getString("login");
                String mdp = array.getJSONObject(i).getString("mdp");
                String adresse = array.getJSONObject(i).getString("adresse");
                String cp = array.getJSONObject(i).getString("cp");
                String ville = array.getJSONObject(i).getString("ville");
                String dateEmbauche = array.getJSONObject(i).getString("dateEmbauche");
                lesVisiteurs.add(new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche));
            }

            //A completer afin de decoder le fichier JSON récupéré result



      } catch (JSONException e) {
        e.printStackTrace();
      }
        return lesVisiteurs;
      }

    public Visiteur recupVisiteurById(String idVisiteur) {
        String result = "";
        String params="idVisiteur=" + idVisiteur;
        Visiteur unVisiteur = null;
        //adresse de l'URL de l\'API à interroger et fichier php permettant la recuperation des visiteurs
        String myUrl="https://garnierboidun.alwaysdata.net/API/getVisiteurById.php";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {

                JSONObject object = new JSONObject(result);

                String id = object.getString("id");
                String nom = object.getString("nom");
                String prenom = object.getString("prenom");
                String login = object.getString("login");
                String mdp = object.getString("mdp");
                String adresse = object.getString("adresse");
                String cp = object.getString("cp");
                String ville = object.getString("ville");
                String dateEmbauche = object.getString("dateEmbauche");
                unVisiteur = new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche);


            //A completer afin de decoder le fichier JSON récupéré result



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return unVisiteur;
    }

    public String modifierVisiteur(Visiteur unVisiteur, String resId) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant la modification du visiteur
        String myUrl="https://garnierboidun.alwaysdata.net/API/supVisiteurById.php";
        String params =
                "id="+resId+"&nom="+unVisiteur.getNom()+
                "&prenom="+unVisiteur.getPrenom()+
                "&login="+unVisiteur.getLogin()+
                "&mdp="+unVisiteur.getMdp()+
                "&adresse="+unVisiteur.getAdresse()+
                "&cp="+unVisiteur.getCp()+
                "&ville="+unVisiteur.getVille()+
                "&dateEmbauche="+unVisiteur.getDateEmbauche();

                Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat modifié",result);
        return result;
    }


    public String suppVisiteur(String resId) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant la modification du visiteur
        String myUrl="https://garnierboidun.alwaysdata.net/API/supVisiteurById.php";
        String params =
                "id="+resId;

        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat modifié",result);
        return result;
    }




}
