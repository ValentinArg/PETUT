package SQL;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.PreparedStatement;

public class SQLModifiercompte extends SQL{

	public SQLModifiercompte() {
		super();
	}
	
	public void setModificationByIdUtilisateur(String id_Utilisateur, HttpServletRequest request){
		try {
            this.setPreparedStatement( (PreparedStatement) this.getConnexion().prepareStatement("UPDATE Utilisateur "
            															   +"SET Adresse = ?, Code_Postal = ?, Ville = ?, Telephone = ?, Adresse_Mail = ? "
            															   +"WHERE Id_Utilisateur = ? ;") );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du preparedstatement" );
            e.printStackTrace();
        }
		try {
            this.getPreparedStatement().setString(1, request.getParameter("adresse"));
            this.getPreparedStatement().setInt(2, Integer.parseInt(request.getParameter("codepostal")));
            this.getPreparedStatement().setString(3, request.getParameter("ville"));
            this.getPreparedStatement().setInt(4, Integer.parseInt(request.getParameter("telephone")));
            this.getPreparedStatement().setString(5, request.getParameter("adressemail"));
            this.getPreparedStatement().setString(6, id_Utilisateur);
        } catch ( SQLException e ) {
            System.out.println( "erreur dans affectation du preparedstatement" );
            e.printStackTrace();
        }
		
		try {
			int statut = this.getPreparedStatement().executeUpdate();
		} catch (SQLException e) {
			System.out.println( "erreur dans execution du preparedstatement" );
			e.printStackTrace();
		}
	}
	
}
