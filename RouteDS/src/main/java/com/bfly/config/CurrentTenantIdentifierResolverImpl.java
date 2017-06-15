package com.bfly.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

 private static final String DEFAULT_TENANT_ID = "tenant_1";
 
 public CurrentTenantIdentifierResolverImpl() {
System.out.println("---------------------------------------------------------------");
System.out.println("---------------5. CurrentTenantIdentifierResolverImpl-------------");
System.out.println("---------------------------------------------------------------");
ConfigMonitor.instance.auditStep("5. CurrentTenantIdentifierResolverImpl");
}

 @Override
 public String resolveCurrentTenantIdentifier() {
  RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
  if (requestAttributes != null) {
   String identifier = (String) requestAttributes.getAttribute("CURRENT_TENANT_IDENTIFIER",RequestAttributes.SCOPE_REQUEST);
   if (identifier != null) {
    return identifier;
   }
  }
  return DEFAULT_TENANT_ID;
 }

 @Override
 public boolean validateExistingCurrentSessions() {
  return true;
 }
}