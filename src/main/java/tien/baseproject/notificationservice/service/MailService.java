package tien.baseproject.notificationservice.service;

import tien.baseproject.notificationservice.dto.email.MailMessageDTO;

public interface MailService {

    void send(MailMessageDTO message);
}
