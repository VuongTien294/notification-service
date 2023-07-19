package tien.baseproject.notificationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.util.Properties;

import static org.thymeleaf.templatemode.TemplateMode.HTML;

@Configuration
public class MailConfig {
    @Value("${smtp.username-smtp}")
    private String username;

    @Value("${smtp.password-smtp}")
    private String password;

    @Value("${smtp.host-smtp}")
    private String host;

    @Value("${smtp.port-smtp}")
    private String port;

    @Bean
    @Primary
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setPrefix("classpath:/templates/html/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode(HTML);
        springResourceTemplateResolver.setCharacterEncoding("UTF-8");
        return springResourceTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(MessageSource messageSource,
                                               SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setMessageSource(messageSource);
        springTemplateEngine.setTemplateResolver(templateResolver);
        return springTemplateEngine;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));

        mailSender.setUsername("vuongtien.dina@gmail.com");
        mailSender.setPassword(password);

        Properties prop = mailSender.getJavaMailProperties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", port);
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.ssl.checkserveridentity", true);

        return mailSender;
    }
}
