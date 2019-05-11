/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author uttamgiri32@gmail.com
 */
@Named
@ViewScoped
public class AccountEditor extends AbstractController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4860394626358103407L;
	/*
     * here i used inject instead of managedproperty cause  i wanted to move all bean to cdi bean 
     * in AccountViewer too i could have used cdi bean but requirement was using  managed bean ..
     */
    @Inject
    private AccountService accountService;
    private Boolean transDateDisabled = Boolean.TRUE;
    private Account selected;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Boolean getTransDateDisabled() {
        return transDateDisabled;
    }

    public void setTransDateDisabled(Boolean transDateDisabled) {
        this.transDateDisabled = transDateDisabled;
    }

    public String save() {
        try {
            if (selected != null) {
                accountService.update(selected);
                setMessages(FacesMessage.SEVERITY_INFO, ResourceBundle.getBundle("/Bundle").getString("Account_Update_Success"), null);
            }
        } catch (Exception e) {
            displayDefaultError(e);
            return null;
        }
        return "viewAccounts.xhtml?faces-redirect=true";
    }

    public void onBalanceChange(ValueChangeEvent event) {
        setTransDateDisabled(Boolean.FALSE);
    }

    public Account getSelected() {
        return selected;
    }

    public void setSelected(Account selected) {
        this.selected = selected;
    }

    public void initToGetViewData() {
        try {
            if (!getFacesContext().isPostback()) {
                Long accountId = getKeyForNextView(ResourceBundle.getBundle("/Bundle").getString("accountEditId_flash"));
                for (Account account : getAccountService().getAccounts()) {
                    if (accountId.equals(account.getId())) {
                        setSelected(new Account(accountId, account.getName(), account.getLastTransactionDate(), account.getBalance()));
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
