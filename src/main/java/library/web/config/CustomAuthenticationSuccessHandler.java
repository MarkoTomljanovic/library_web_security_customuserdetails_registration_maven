package library.web.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



import library.web.entity.User;
import library.web.service.UserService;



@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	


	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		 
        if (roles.contains("ROLE_MANAGER")) {
        	response.sendRedirect(request.getContextPath() + "/loans/list");
        }else if(roles.contains("ROLE_ADMIN")) {
        	response.sendRedirect(request.getContextPath() + "/admin/page");
        }else {
        	response.sendRedirect(request.getContextPath() + "/loans/list");
        }
    }
}

