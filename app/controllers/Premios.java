/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import play.*;
import play.mvc.*;
import views.html.premios.*;
import views.html.sorteos.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;
import models.*;
/**
 *
 * @author AlvaroTai
 */
public class Premios extends Controller {
    
    @Transactional(readOnly=true)
    public static Result newPremio() {
        Form<Premio> premioForm = form(Premio.class);
        return ok(createForm2.render(premioForm));
    }
    public static Result blank() {
        return ok(sorteos.render());
    }
    @Transactional
    public static Result save() {
        Form<Premio> premioForm = form(Premio.class).bindFromRequest();
        System.out.println("FORMULARIO de Premios: " + premioForm);
        if(premioForm.hasErrors()) {
            return badRequest(createForm2.render(premioForm));
        }
        premioForm.get().save();
        flash("success", "Premio " + premioForm.get().numPremio + " ha sido creado.");
        return ok(sorteos.render());
    }

}
