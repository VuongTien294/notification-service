package tien.baseproject.notificationservice.dto.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailAttachmentDTO implements Serializable {

  private String name;
  private byte[] data;
}
