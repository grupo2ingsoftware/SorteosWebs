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
public class Premio {
    @Id
    @Constraints.Required
    public Integer numPremio;
//    @ManyToOne
    
    public Integer descPremio;
    public Integer codSorteo;
    public Integer cantidadPremio;
    public Integer garantiaPremio;
    public Integer valorPremio;
//    public Sorteo sorteo;
    @Constraints.Required
    public Integer numParticipante;
    public void save() {
        System.out.println("Grabando nuevo premio...");
//        if(this.sorteo.codSorteo == null) {
//            this.sorteo = null;
//        } else {
//            this.sorteo = Sorteo.findById(sorteo.codSorteo);
//        }
        JPA.em().persist(this);
    } 

}
