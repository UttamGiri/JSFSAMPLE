/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author uttamgiri32@gmail.com
 */
@ViewScoped
@Named
public class AccountViewer extends AbstractController implements Serializable {
	private static final long serialVersionUID = -4860394626358103407L;
   
	@Inject
    private AccountService accountService;
  
    public AccountService getAccountService() {
        return accountService;
    }
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    public void delete(ActionEvent event) {
        try {
            Account selected = (Account) event.getComponent().
			getAttributes().get("selected");
            accountService.delete(selected);
            setMessages(FacesMessage.SEVERITY_INFO,ResourceBundle.getBundle("/Bundle").getString("Account_Delete_Success"),null);
        } catch (Exception e) {
            displayDefaultError(e);
        }
    }


    public String edit(){
        setKeyForNextView(ResourceBundle.getBundle("/Bundle").getString("accountEditId_flash"), getEditId());
        return "editAccount?faces-redirect=true";
    }
}
