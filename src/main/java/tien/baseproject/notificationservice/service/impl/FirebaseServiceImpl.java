package tien.baseproject.notificationservice.service.impl;

import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tien.baseproject.notificationservice.dto.firebase.Notice;
import tien.baseproject.notificationservice.service.FirebaseService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FirebaseServiceImpl implements FirebaseService {
//    private final FirebaseMessaging firebaseMessaging;

//    @Override
//    public BatchResponse sendNotification(Notice notice) {
//        List<String> registrationTokens=notice.getRegistrationTokens();
//        Notification notification = Notification.builder()
//                .setTitle(notice.getSubject())
//                .setBody(notice.getContent())
//                .setImage(notice.getImage())
//                .build();
//
//        MulticastMessage message = MulticastMessage.builder()
//                .addAllTokens(registrationTokens)
//                .setNotification(notification)
//                .putAllData(notice.getData())
//                .build();
//
//        BatchResponse batchResponse = null;
//        try {
//            batchResponse = firebaseMessaging.sendMulticast(message);
//        } catch (FirebaseMessagingException e) {
//            log.info("Firebase error {}", e.getMessage());
//        }
//        if (batchResponse.getFailureCount() > 0) {
//            List<SendResponse> responses = batchResponse.getResponses();
//            List<String> failedTokens = new ArrayList<>();
//            for (int i = 0; i < responses.size(); i++) {
//                if (!responses.get(i).isSuccessful()) {
//                    failedTokens.add(registrationTokens.get(i));
//                }
//            }
//            log.info("List of tokens that caused failures: " + failedTokens);
//        }
//        return batchResponse;
//    }
}
