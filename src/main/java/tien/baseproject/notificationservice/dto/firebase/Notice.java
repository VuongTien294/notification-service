package tien.baseproject.notificationservice.dto.firebase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice implements Serializable {
    /**
     * Subject notification on firebase
     */
    private String subject;
    /**
     * Content notification on firebase
     */
    private String content;
    /**
     * url ảnh đại diện đơn hàng
     */
    private String image;
    /**
     * Map các data
     */
    private Map<String, String> data;
    /**
     * FCM registration token
     */
    private List<String> registrationTokens;

//    Ở Notice mình để 1 list của registrationTokens là FCM registration token theo đầu thiết bị,
//    tức là 1 user có thể đăng nhập vào nhiều thiết bị, mỗi thiết bị sẽ có FCM token riêng.
//    Token này sẽ do client truyền lên server
}