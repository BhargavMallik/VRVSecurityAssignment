package com.spring.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JLCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { 
@Override 
protected Class<?>[] getRootConfigClasses() { 
return new Class[] { JLCWebConfig.class }; 
} 
@Override 
protected Class<?>[] getServletConfigClasses() { 
return new Class[] { JLCWebConfig.class }; 
} 
@Override 
protected String[] getServletMappings() { 
return new String[] { "/Lab81/" }; 
} 
} 
