package mx.com.gm.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults()) // forma moderna y recomendada
//                .build();
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("{noop}123")
                        .roles("ADMIN", "USER")
                        .build(),
                User.withUsername("user")
                        .password("{noop}123")
                        .roles("USER")
                        .build()
        );
    }

    //_____________________Clase 667__________________________________
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/login", "/resources/**").permitAll() // Permitir acceso a login y recursos estáticos
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar/**").hasRole("ADMIN") // Restricción de acceso por rol
                .requestMatchers("/").hasAnyRole("USER", "ADMIN") // Acceso a usuarios autenticados
                .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación

                )
                .formLogin(formLogin -> formLogin
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/", true) // Redirigir después del login exitoso
                .permitAll() // Permitir acceso al formulario de login
                )
                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/errores/403")
                );
        return http.build();
    }

}
