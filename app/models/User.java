
package models;
import com.google.gson.JsonObject;
import javax.persistence.Entity;
import play.data.validation.Unique;
import play.db.jpa.Model;
import play.mvc.Scope;


/**
 * 
 
 * @author Sara Rodriguez Soto
 * @author Erika Navarro 
 * @author Tania Aranda Lopez
 * 
 */
@Entity
public class User extends Model {

    @Unique
    public String user;

    @Unique
    public String email;

    public String password;

    public boolean admin;

    public static void facebookOAuthCallback(JsonObject data){
        String id = data.get("id").getAsString();
        User user = User.find("byUser", id).first();
        if(user == null){
            user = new User();
            user.user = id;
            user.insert();
        }
        Scope.Session.current().put("username", user.user);
    }

}



