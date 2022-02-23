//package com.exemple.gestion_employer1.configurationThymeleaf;
//
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//
//public class ThymeleafConfig {
//    public void contextInitialized(ServletContextEvent sce) {
//        TemplateEngine engine = templateEngine(sce.getServletContext());
//        TemplateEngineUtil.storeTemplateEngine(sce.getServletContext(), engine);
//    }
//
//    public void contextDestroyed(ServletContextEvent sce) {
//    }
//
//    private TemplateEngine templateEngine(ServletContext servletContext) {
//        TemplateEngine engine = new TemplateEngine();
//
//        engine.setTemplateResolver(templateResolver(servletContext));
//        return engine;
//    }
//
//    private ITemplateResolver templateResolver(ServletContext servletContext) {
//        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
//        resolver.setPrefix("/WEB-INF/templates/");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setTemplateMode(TemplateMode.HTML);
//        return resolver;
//    }
//}
