package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.UserDAO;

import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import configuration.SessionUserAttribute;

import databean.User;
import formbean.LoginForm;

/**
 * Login action to check whether user already login.
 * Also handle the register action.
 * Entry point for all other actions.
 * 
 * @author shiqing
 *
 */
public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	private UserDAO userDAO;
	
	// Init userDAO from model
	public LoginAction(Model model) {
		userDAO = model.getUserDAO();
	}
	
	@Override
	public String getActionName() {
		return "login.do";
	}
	
	@Override
	// Return the name of the jsp used to render the output
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		// User already login
		if (session.getAttribute(SessionUserAttribute.SOCIAL_PLUS_USER.getValue()) != null) {
			return "/view/welcome.jsp";  // return to welcome.do jsp
		}
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);  // set errors attribute for following page usage
		
		try {
			LoginForm loginForm = formBeanFactory.create(request);
			request.setAttribute("form", loginForm);
			
			// First time the login form is initialized
			if (!loginForm.isPresent()) {
				return "/view/login.jsp";
			}
			
			errors.addAll(loginForm.getValidationErrors());
			if (errors.size() > 0) {
				return "/view/login.jsp";
			}
			
			// Register button
			if (loginForm.getAction().equals("Register")) {
				User user = new User();
				user.setUserName(loginForm.getUserName());
				user.setPassword(loginForm.getPassword());
				userDAO.create(user);
				session.setAttribute(SessionUserAttribute.SOCIAL_PLUS_USER.getValue(), user);
				return "/view/welcome.jsp";
			}
			
			// Login button
			User user = userDAO.read(loginForm.getUserName());
			
			if (user == null) {
				errors.add("User not found.");
				return "/view/login.jsp";
			} else if (!user.getPassword().equals(loginForm.getPassword())) {
				errors.add("Invalid password.");
				return "/view/login.jsp";
			} else {
				session.setAttribute(SessionUserAttribute.SOCIAL_PLUS_USER.getValue(), user);
				return "/view/welcome.jsp";
			}
		} catch (RollbackException e) {
			if (e instanceof DuplicateKeyException) {
				errors.add("User already exist");
			} else {
				errors.add(e.getMessage());
			}
			return "/view/login.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "/view/error.jsp";
		}
	}
}
