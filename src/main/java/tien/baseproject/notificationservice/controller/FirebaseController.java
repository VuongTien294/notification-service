package tien.baseproject.notificationservice.controller;

import com.google.firebase.messaging.BatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.notificationservice.dto.firebase.Notice;
import tien.baseproject.notificationservice.service.FirebaseService;

@RestController
@RequestMapping("/firebase")
@RequiredArgsConstructor
public class FirebaseController {
//    private final FirebaseService notificationService;
//
//    @PostMapping("/send-notification")
//    public BatchResponse sendNotification(@RequestBody Notice notice){
//        return notificationService.sendNotification(notice);
//    }
}
