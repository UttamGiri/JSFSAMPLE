/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author uttamgiri32@gmail.com
 */
public class AbstractController {
   
 private Long editId;

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }

   
    public void setMessages(Severity severity, String message, String message1) {
        getFacesContext().addMessage(null, new FacesMessage(severity, message, message1));
        flash();
    }

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void displayDefaultError(Exception e) {
        getFacesContext().addMessage(e.getMessage(), new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/Bundle").getString("Error_Occured"), null));
        flash();
    }

    public void flash() {
        getFacesContext().getExternalContext().getFlash().setKeepMessages(true);
    }

    public void setKeyForNextView(String key, Long value) {
        getFacesContext().getExternalContext().getFlash().put(key, value);

    }

    public Long getKeyForNextView(String key) {
        Object keyObject = getFacesContext().getExternalContext().getFlash().get(key);
        return (Long)keyObject;

    }
}
