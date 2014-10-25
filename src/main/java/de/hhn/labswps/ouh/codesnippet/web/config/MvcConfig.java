package de.hhn.labswps.ouh.codesnippet.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan("de.hhn.labswps.ouh.codesnippet.web")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

//	@Bean
//	public UrlBasedViewResolver setupViewResolver() {
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix("/WEB-INF/pages/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		return resolver;
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
    @Bean
    public TilesViewResolver getTilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        /*
         * tilesViewResolver.setPrefix("/WEB-INF/jsp/");
         * tilesViewResolver.setSuffix(".jsp");
         */
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
        return tilesConfigurer;
    }
    
    @Bean  
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasenames(new String[]{"i18n/labels"});
        source.setUseCodeAsDefaultMessage(true);
        return source;  
    }  
	
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

}
