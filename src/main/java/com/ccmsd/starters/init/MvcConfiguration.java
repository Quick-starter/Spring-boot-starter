package com.ccmsd.starters.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.ccmsd.starters")
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
	@Override
    public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
    }
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setViewNames("jsp/*");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setOrder(0);
		return resolver;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver()
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(springTemplateEngine());
		String[] viewnames =
		{ "templates/*" };
		resolver.setViewNames(viewnames);
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	SpringTemplateEngine springTemplateEngine()
	{
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(servletContextTemplateResolver());
		return springTemplateEngine;
	}

	@Bean
	public ServletContextTemplateResolver servletContextTemplateResolver()
	{
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		return resolver;
	}
}