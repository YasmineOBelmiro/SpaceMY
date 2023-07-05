package controller;

import view.Login;
/**
 * 
 * @author Yasmine.if
 *
 */
public class App {
/**
 * Lancamentp da aplicação
 * @param args
 */
	public static void main(String[] args) {
		LoginController c = new LoginController(new Login());
		c.initView();
		
	}

}
