/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author uttamgiri32@gmail.com
 */
@RequestScoped
@FacesValidator("com.validator.requiredCustomValidator")
public class RequiredCustomValidator implements Validator {
     
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        if (value == null) {

            FacesMessage msg =
                    new FacesMessage("validation failed.",
                    "Required");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
