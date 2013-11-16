/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import play.*;
import play.mvc.*;
import views.html.sorteos.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;
import models.*;
public class Sorteos extends Controller {
    public static Result blank() {
        return ok(sorteos.render());
    }
    @Transactional(readOnly=true)
    public static Result newSorteo() {
        Form<Sorteo> sorteoForm = form(Sorteo.class);
        return ok(createForm.render(sorteoForm));
    }
    public static Result list() {
        
        return ok(sorteos.render());
    }
    
    @Transactional
    public static Result save() {
        Form<Sorteo> sorteoForm = form(Sorteo.class).bindFromRequest();
        System.out.println("FORMULARIO de SORTEO: " + sorteoForm);
        if(sorteoForm.hasErrors()) {
            return badRequest(createForm.render(sorteoForm));
        }
        sorteoForm.get().save();
        flash("success", "Sorteo " + sorteoForm.get().codSorteo + " ha sido creado.");
        return ok(sorteos.render());
    }
}