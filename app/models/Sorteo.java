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
public class Sorteo {
    @Id
    @Constraints.Required
    public Integer codSorteo;
//    @Constraints.Required
    public String nomSorteo;
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date fechaIniRegParticipante; 
    public Date fechaFinRegParticipante;  
    public String estadoSorteo;
    public String metodoSorteo;
    public Date fechaSorteo;       
    
    public static Sorteo findById(Integer codSorteo) {
        return JPA.em().find(Sorteo.class, codSorteo);
    }
    
    public static Map<String,String> options() {
        @SuppressWarnings("unchecked")
            List<Sorteo> sorteos = JPA.em().createQuery("from Sorteo order by nomSorteo").getResultList();
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Sorteo s: sorteos) {
            options.put(s.codSorteo.toString(), s.nomSorteo);
        }
        return options;
    }
    
    public void update(Integer codSorteo) {
        this.codSorteo = codSorteo;
        JPA.em().merge(this);
    }
    public void save() {
        System.out.println("Grabando nuevo sorteo...");
        System.out.println(nomSorteo);
        this.estadoSorteo = new String("activo");
        
        JPA.em().persist(this);
    }
    public void delete() {
        JPA.em().remove(this);
    }
    
}
