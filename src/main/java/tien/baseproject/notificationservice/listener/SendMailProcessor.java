package tien.baseproject.notificationservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import static java.nio.charset.StandardCharsets.UTF_8;
import tien.baseproject.notificationservice.config.properties.MailProperties;
import tien.baseproject.notificationservice.dto.email.MailMessageDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.stream.Streams;
import tien.baseproject.notificationservice.service.impl.TemplateServiceImpl;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendMailProcessor {
    private final JavaMailSender javaMailSender;

    private final TemplateServiceImpl templateService;

    private final MailProperties mailProperties;

//    @Qualifier("restTemplateWithBalancer")
//    private final RestTemplate restTemplateWithBalancer;

    @SneakyThrows
    public void send(MimeMessage message) {
        log.info("SendMail to: {}, {}", message.getAllRecipients(), message.getContent()
                .toString().replace("\n", "")
                .replace("\r", ""));
        javaMailSender.send(message);
    }

    public MimeMessage buildMimeMessage(MailMessageDTO message) throws IOException, MessagingException {
        Assert.notEmpty(message.getReceivers(), "Receiver must not be null");
        if (message.getTemplate() != null) {
            message.setContent(templateService.buildContent(
                    message.getTemplate(),
                    message.getVariablesMap(),
                    message.isHtml(),
                    message.getLocale())
            );
        }

        message.setSubject(null == message.getSubject() ? "Alert Email" : message.getSubject());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, UTF_8.name());
        helper.setFrom(mailProperties.getMailFrom(), message.getSender());

        if (message.getReceivers().size() > 0) {
            helper.setTo(getEmailByUserId(message, new ArrayList<>(message.getReceivers())).toArray(new String[0]));
        }
        helper.setSubject(message.getSubject());
        helper.setText(message.getContent(), message.isHtml());

        if (CollectionUtils.isNotEmpty(message.getMailAttachments())) {
            Streams.stream(message.getMailAttachments())
                    .forEach(mailAttachment -> helper.addAttachment(mailAttachment.getName(),
                            new ByteArrayResource(mailAttachment.getData())));
        }
        return mimeMessage;
    }

    private List<String> getEmailByUserId(MailMessageDTO message, List<String> receiverIds) {
        return prepareReceiver(receiverIds, message);
    }

    private List<String> prepareReceiver(List<String> rawReceivers, MailMessageDTO message) {
        log.info("receivers: {}", rawReceivers);
        List<String> receiverIds = rawReceivers.stream().filter(s -> !s.contains("@"))
                .collect(Collectors.toList());
        rawReceivers.removeAll(receiverIds);
        return  rawReceivers;
    }


}
