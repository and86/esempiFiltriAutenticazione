package it.alfasoft.fabrizio.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {
	
	private String username;
	private String password;
	private boolean loggato;
	
	
	public LoginController(){
		loggato=false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoggato() {
		return loggato;
	}
	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}
	
	public String doLogin(){
		
		if(!this.username.equals("aaa") 
				|| !this.password.equals("aaa")){
			//se non è verificato, rimando alla pagina di login
			FacesMessage msg=new FacesMessage("User e/o pass errati!","Error message");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "Login";
					
		}
		//se è verificato mando alla pagina Home
		this.loggato=true;
		return "/portali/home?faces-redirect=true";
	}
	
	

}
