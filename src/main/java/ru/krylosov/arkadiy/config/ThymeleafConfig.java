package ru.krylosov.arkadiy.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

public class ThymeleafConfig {

    private final String PREFIX = "/WEB-INF/tenplates";
    private final String SUFFIX = ".html";
    private final Long CACHE = 3600000L;
    private final TemplateEngine templateEngine;

    public ThymeleafConfig(final ServletContext context) {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix(PREFIX);
        templateResolver.setSuffix(SUFFIX);
        templateResolver.setCacheTTLMs(CACHE);
        templateResolver.setCacheable(true);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public TemplateEngine getTemplateEngine(){
        return templateEngine;
    }
}
