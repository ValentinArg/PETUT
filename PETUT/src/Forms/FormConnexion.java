package Forms;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import SQL.*;



public class FormConnexion {
	
	private static final String CHAMP_ID    = "connexionIdentifiant";
    private static final String CHAMP_PASS   = "connexionMotdepasse";
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String connexionUtilisateur( HttpServletRequest request ) throws Exception {
        
    	String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String identifiant = getValeurChamp( request, CHAMP_ID );
        boolean valideId;
        boolean valideMotdepasse;
        SQLConnexion sql = new SQLConnexion();
        valideId = sql.validerId(identifiant);
		if(!valideId){
			this.setErreur(CHAMP_ID, "Identifiant invalide");
			throw new Exception("Identifiant invalide");
		}
		valideMotdepasse = sql.validerMotPasse(identifiant, motDePasse);
		if(!valideMotdepasse){
			this.setErreur(CHAMP_PASS, "Mot de passe invalide");
			throw new Exception("Mot de passe invalide");
		}
        return identifiant;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

}
