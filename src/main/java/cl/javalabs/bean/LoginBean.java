/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cl.javalabs.bean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author javalabs
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String usuario;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {

    }

    public void ingresar(ActionEvent actionEvent) {
        if (usuario.equals("curso") && password.equals("12345")) {

            try {
                redireccionar("principal.xhtml");
            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_FATAL, "La página no existe", ""));
                e.printStackTrace();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrectos", ""));
        }
    }

    private void redireccionar(String pagina) throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(pagina);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
