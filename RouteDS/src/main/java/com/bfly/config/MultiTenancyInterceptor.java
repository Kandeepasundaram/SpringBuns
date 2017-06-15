package com.bfly.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

	public MultiTenancyInterceptor() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("-----------------------6. MultiTenancyInterceptor-----------------");
		System.out.println("---------------------------------------------------------------");
		ConfigMonitor.instance.auditStep("6. MultiTenancyInterceptor");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String tenantid = req.getParameter("tenantid");
		System.out.println("tenantid :::: " + tenantid);
		/*
		 * Map<String, Object> pathVars = (Map<String, Object>) req
		 * .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		 * 
		 * if (pathVars.containsKey("tenantid")) {
		 * req.setAttribute("CURRENT_TENANT_IDENTIFIER",
		 * pathVars.get("tenantid")); }
		 */
		if (StringUtils.isNotEmpty(tenantid)) {
			req.setAttribute("CURRENT_TENANT_IDENTIFIER", tenantid);
		}
		return true;
	}

}