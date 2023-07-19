package tien.baseproject.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.notificationservice.dto.email.MailMessageDTO;
import tien.baseproject.notificationservice.service.MailService;

@RestController
@RequestMapping("/test-send-mail")
@RequiredArgsConstructor
public class TestSendMailController {
    private final MailService mailService;

    @PostMapping()
    public void sendNotification(@RequestBody MailMessageDTO mailMessageDTO){
        mailService.send(mailMessageDTO);
    }
}
