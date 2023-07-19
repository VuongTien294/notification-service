package tien.baseproject.notificationservice.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mail.setting.constant", ignoreUnknownFields = false)
@Getter
@Setter
public class MailProperties {
    private String mailFrom;
}
