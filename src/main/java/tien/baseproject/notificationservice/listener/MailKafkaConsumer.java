package tien.baseproject.notificationservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tien.baseproject.notificationservice.dto.email.MailMessageDTO;

import javax.mail.internet.MimeMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailKafkaConsumer {
    private final SendMailProcessor processor;

    @KafkaListener(topics = "${kafka.email-topic}", groupId = "${kafka.email-group}", containerFactory = "emailKafkaListenerContainerFactory")
    public void receiveMessage(MailMessageDTO mailDTO) {
        log.info("Kafka Received message Content: [{}]", mailDTO);
        try {
            MimeMessage mimeMessage = this.processor.buildMimeMessage(mailDTO);
            this.processor.send(mimeMessage);
            log.info("Kafka Sent message: [{}]", mailDTO.getTraceId());
        } catch (Exception e) {
            log.error("Kafka Error when sending mail: " + mailDTO.getTraceId() + ", ex: "  + e, e);
        }
    }
}
