/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;
import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import play.db.jpa.*;
@Entity
public class Usuario {
    @Id
    @Constraints.Required
    public String login;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public String nombreCompleto;
    @Transient
    public Boolean esAdministrador;
    public Integer administrador;
    public Integer estado;
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date fechaCreacion;

    public static Usuario findById(String login) {
        return JPA.em().find(Usuario.class, login);
    }
    public void update(String login) {
        this.login = login;
        JPA.em().merge(this);
    }
    public void save() {
        System.out.println("Grabando nuevo usuario...");
        this.estado = new Integer(1);
        JPA.em().persist(this);
    }
    public void delete() {
        JPA.em().remove(this);
    }
    
}