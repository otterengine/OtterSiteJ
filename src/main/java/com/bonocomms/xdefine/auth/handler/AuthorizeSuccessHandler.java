package com.bonocomms.xdefine.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.bonocomms.xdefine.base.XFSecurity;

public class AuthorizeSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {

	private XFSecurity security;

	public XFSecurity getSecurity() {
		return security;
	}

	public void setSecurity(XFSecurity security) {
		this.security = security;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		if (security != null) {
			security.onAuthenticationSuccess(request, response, authentication);
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}