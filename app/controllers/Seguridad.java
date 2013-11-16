/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;
import views.html.seguridad.*;
import models.*;

public class Seguridad extends Controller {
    public static Result blank() {
        return ok(seguridad.render());
    }
    @Transactional(readOnly=true)
    public static Result newUser() {
        Form<Usuario> usuarioForm = form(Usuario.class);
        return ok(createForm.render(usuarioForm));
    }
    public static Result list() {
        return ok(seguridad.render());
    }
    public static Result login() {
        return ok(seguridad.render());
    }
    public static Result logout() {
        return ok(seguridad.render());
    }
    /**
    * Creacion de nuevo usuario
    */  
    @Transactional
    public static Result save() {
        Form<Usuario> usuarioForm = form(Usuario.class).bindFromRequest();
        System.out.println("FORMULARIO de USUARIO: " + usuarioForm);
        if(usuarioForm.hasErrors()) {
            return badRequest(createForm.render(usuarioForm));
        }
        if (usuarioForm.get().esAdministrador != null) {
            usuarioForm.get().administrador = new Integer(1);
        }
        else {
            usuarioForm.get().administrador = new Integer(0);
        }
        usuarioForm.get().save();
        flash("success", "Usuario " + usuarioForm.get().login + " ha sido creado.");
        return ok(seguridad.render());
    }
}