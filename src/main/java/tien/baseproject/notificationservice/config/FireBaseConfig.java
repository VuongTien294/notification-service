package tien.baseproject.notificationservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tien.baseproject.notificationservice.config.properties.FirebaseProperties;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FireBaseConfig {
    private final FirebaseProperties firebaseProperties;

//    @Bean
//    FirebaseMessaging firebaseMessaging() throws IOException {
//        GoogleCredentials googleCredentials=GoogleCredentials
//                .fromStream(new FileInputStream(firebaseProperties.getGoogleCredentials()));
//        FirebaseOptions firebaseOptions = FirebaseOptions
//                .builder()
//                .setCredentials(googleCredentials)
//                .build();
//        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
//        return FirebaseMessaging.getInstance(app);
//    }

//Trước khi bắt đầu thì mọi người tạo tài khoản trên FCM console nhé, thao tác rất đơn giản.
// Thao tác xong thì tạo project, vào Project settings -> Service accounts, click Generate
// new private key, trình duyệt sẽ tự động download 1 file json service account.
// Mọi người lưu vào directory của mình để cấu hình nhé
}
