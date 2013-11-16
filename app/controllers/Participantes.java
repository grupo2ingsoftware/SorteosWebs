/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import play.*;
import play.mvc.*;
import views.html.participantes.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;
import models.*;
public class Participantes extends Controller {
    public static Result blank() {
        return ok(participantes.render());
    }
    @Transactional(readOnly=true)
    public static Result newParticipante() {
        Form<Participante> participanteForm = form(Participante.class);
        return ok(createForm.render(participanteForm));
    }
    @Transactional
    public static Result save() {
        Form<Participante> participanteForm = form(Participante.class).bindFromRequest();
        System.out.println("FORMULARIO de PARTICIPANTE: " + participanteForm);
        if(participanteForm.hasErrors()) {
            return badRequest(createForm.render(participanteForm));
        }
        participanteForm.get().save();
        flash("success", "Participante " + participanteForm.get().numParticipante + " ha sido creado.");
        return ok(participantes.render());
    }
}