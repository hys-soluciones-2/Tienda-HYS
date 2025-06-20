
package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Hugo
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    //Configuramos un interceptor para 
    //poder cambiar de idioma de manera dinamica
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        //Se especifica cual es el parametro para cambiar de lenguaje
        var lci = new LocaleChangeInterceptor();
        //Especificamos cual es el parametro para cambiar de lenguaje
        lci.setParamName("lang");
        return lci;
    }
    //Por ultimo se registra el interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        //utilizamos el metodo add.. para registrar el interceptor
        registro.addInterceptor(localeChangeInterceptor());
    }
    
}
