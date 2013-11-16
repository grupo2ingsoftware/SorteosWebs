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
public class Participante {
    @Id
    @Constraints.Required
    public Integer numParticipante;
//    @ManyToOne
    public Integer codSorteo;
//    public Sorteo sorteo;
    @Constraints.Required
    public Integer numPersona;
    
    public Integer indicadorSorteado;
    public Integer indicadorGanador;
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date fechaInscripcion;
    
    public void save() {
        System.out.println("Grabando nuevo participante...");
//        if(this.sorteo.codSorteo == null) {
//            this.sorteo = null;
//        } else {
//            this.sorteo = Sorteo.findById(sorteo.codSorteo);
//        }
        JPA.em().persist(this);
    } 
    public static Map<String,String> options() {
        @SuppressWarnings("unchecked")
            List<Participante> participantes = JPA.em().createQuery("from Participante order by numParticipante").getResultList();
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Participante p: participantes) {
            options.put(p.numParticipante.toString(), p.numParticipante.toString());
        }
        return options;
    }
}
