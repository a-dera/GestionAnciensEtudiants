/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author DERA
 */
public class GestionDip {
    
    // declarations des variables
    private String nom, prenom, filiereL,filiereM, matricule, email, lieuResidence, posteActuel,lieuTravail,sexe,telephone;
    private float noteSoutenanceL, noteSoutenanceM; 
    private int promotionAnnee, anneeObtentionL, anneeObtentionM, promYear;
    private int detientLicence, detientMaster, possedeL, possedeTravail, possedeM;

    //constructeur
    public GestionDip(int promYear, String nom,String prenom,String filiereL,String filiereM,String matricule,String email,String lieuResidence,String posteActuel,String lieuTravail,String sexe, String telephone,float noteSoutenanceL, float noteSoutenanceM, int promotionAnnee, int anneeObtentionL, int anneeObtentionM, int detientLicence, int detientMaster, int possedeL, int possedeTravail, int possedeM){
            this.nom = nom;
            this.prenom = prenom;
            this.sexe = sexe;
            this.filiereL = filiereL;
            this.filiereM = filiereM;
            this.matricule = matricule;
            this.email = email ;
            this.lieuResidence = lieuResidence;
            this.posteActuel= posteActuel;
            this.lieuTravail = lieuTravail;
            this.noteSoutenanceL = noteSoutenanceL;
            this.noteSoutenanceM = noteSoutenanceM;
            this.anneeObtentionL = anneeObtentionL;
            this.anneeObtentionM = anneeObtentionM;
            this.telephone = telephone;
            this.detientLicence = detientLicence;
            this.detientMaster = detientMaster;
            this.promotionAnnee = promotionAnnee;
           this.promYear = promYear;
            this.possedeL = possedeL;
            this.possedeM = possedeM;
            this.possedeTravail = possedeTravail;

    }
    public GestionDip(){
    }
    

    //accesseur
    public String getNom(){
            return nom;
    }
    public int getPromYear(){
            return promYear;
    }

    public String getPrenom(){
            return prenom;
    }
    
    public String getSexe(){
            return sexe;
    }

    public String getFiliereL(){
            return filiereL;
    }
    public String getFiliereM(){
            return filiereM;
    }

    public String getMatricule(){
            return matricule;
    }

    public String getEmail(){
            return email;
    }
    public String getLieuResidence(){
            return lieuResidence;
    }

    public String getPosteActuel(){
            return posteActuel;
    }

    public String getLieuTravail(){
            return lieuTravail;
    }

    public float getNoteSoutenanceL(){
            return noteSoutenanceL;
    }

    public float getNoteSoutenanceM(){
            return noteSoutenanceM;
    }
    
    public int getAnneeObtentionM(){
            return anneeObtentionM;
    }
    
    public int getAnneeObtentionL(){
            return anneeObtentionL;
    }
    
    public int getPromotionAnnee(){
            return promotionAnnee;
    }

    public String getTelephone(){
            return telephone;
    }

    public int getDetientLicence(){
            return detientLicence;
    }

    public int getDetientMaster(){
            return detientMaster;
    }
    public int getPossedeL(){
            return possedeL;
    }
    public int getPossedeM(){
            return possedeM;
    }
    public int getPossedeTravail(){
            return possedeTravail;
    }


    // mutateurs
    public void setNom( String nom){
            this.nom = nom;
    }

    public void setPrenom(String prenom){
            this.prenom = prenom;
    }
    
    public void setSexe(String sexe){
            this.sexe= sexe;
    }
    public void setPromYear(int promYear){
            this.promYear= promYear;
    }
            
    public void setFiliereL(String filiereL){
            this.filiereL = filiereL;
    }
    public void setFiliereM(String filiereM){
            this.filiereM = filiereM;
    }
    
    public void setMatricule(String matricule){
           this.matricule = matricule;
    }
    public void setEmail(String email){
            this.email = email ;
    }

    public void setLieuResidence(String lieuResidence){
            this.lieuResidence = lieuResidence;
    }
    public void setPosteActuel(String posteActuel){
            this.posteActuel = posteActuel;
    }

    public void setLieuTravail(String lieuTravail){
           this.lieuTravail = lieuTravail;
    }
    public void setPromotionAnnee(int promotionAnnee){
            this.promotionAnnee = promotionAnnee;
    }
            
    public void setNoteSoutenanceL(float noteSoutenanceL){
            this.noteSoutenanceL = noteSoutenanceL;
    }
    public void setNoteSoutenanceM(float noteSoutenanceM){
           this.noteSoutenanceM = noteSoutenanceM;
    }
  
    public void setAnneeObtentionL(int anneeObtentionL){
            this.anneeObtentionL = anneeObtentionL;
    }
    
    public void setAnneeObtentionM(int anneeObtentionM){
            this.anneeObtentionM = anneeObtentionM;
    }
    
    public void setTelephone(String telephone){
            this.telephone = telephone;
    }
    
    public void setDetientLicence(int detientLicence){
            this.detientLicence = detientLicence;
    }
    
    public void setPossedeL(int possedeL){
            this.possedeL = possedeL;
    }
    public void setDetientMaster(int detientMaster){
            this.detientMaster = detientMaster;
    }
    public void setPossedeM(int possedeM){
            this.possedeM = possedeM;
    }
    public void setPossedeTravail(int possedeTravail){
            this.possedeTravail = possedeTravail;
    }

    
}
