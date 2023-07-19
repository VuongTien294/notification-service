package tien.baseproject.notificationservice.dto.email;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import tien.baseproject.notificationservice.constant.MailConstant;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailMessageDTO implements Serializable {

    @Builder.Default
    @JsonProperty("sender")
    private String sender = MailConstant.SENDER;

    private Collection<String> receivers;

    @JsonProperty("subject")
    private String subject;

    private String content;

    @JsonProperty("template")
    private String template;

    @Builder.Default
    private Map<String, Object> variables = new HashMap<>();

    @JsonGetter("variables")
    public Map<String, Object> getVariablesMap() {
        return variables;
    }

    @Builder.Default
    private List<MailAttachmentDTO> mailAttachments = Collections.emptyList();

    @Builder.Default
    @JsonProperty("html")
    private boolean html = true;

    @Builder.Default
    private Locale locale = LocaleContextHolder.getLocale();

    private String traceId;

    private int type = 0;
}
