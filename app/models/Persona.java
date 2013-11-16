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

/**
 *
 * @author AlvaroTai
 */
@Entity
public class Persona {
    @Id
    @Constraints.Required
    public Integer numPersona;
     @Constraints.Required
    public String nombres;
     @Constraints.Required
    public String apellidos;
     @Constraints.Required
    public String docIdentidad;
    @Transient
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date fechaNacimiento;
    public String direccion;
    public static Map<String,String> options() {
        @SuppressWarnings("unchecked")
            List<Persona> personas = JPA.em().createQuery("from Persona order by nombres").getResultList();
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Persona p: personas) {
            options.put(p.numPersona.toString(), p.nombres);
        }
        return options;
    }
}
