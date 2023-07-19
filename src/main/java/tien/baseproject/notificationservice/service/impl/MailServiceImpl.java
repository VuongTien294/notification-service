package tien.baseproject.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tien.baseproject.notificationservice.dto.email.MailMessageDTO;
import tien.baseproject.notificationservice.listener.SendMailProcessor;
import tien.baseproject.notificationservice.service.MailService;

import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {
    private final SendMailProcessor processor;

    @Override
    public void send(MailMessageDTO mailDTO) {
        try {
            MimeMessage mimeMessage = this.processor.buildMimeMessage(mailDTO);
            this.processor.send(mimeMessage);
            log.info("Kafka Sent message: [{}]", mailDTO.getTraceId());
        } catch (Exception e) {
            log.error("Kafka Error when sending mail: " + mailDTO.getTraceId() + ", ex: "  + e, e);
        }
    }
}
