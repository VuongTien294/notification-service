package tien.baseproject.notificationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import tien.baseproject.notificationservice.dto.email.MailMessageDTO;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Value(value = "${kafka.servers-config}")
    private String serversConfig;

    @Value(value = "${kafka.email-group}")
    private String emailGroupId;

    @Value(value = "${kafka.email-topic}")
    private String emailTopicName;

    @Bean
    public ConsumerFactory<String, MailMessageDTO> emailConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getBaseProperties(),
                new StringDeserializer(),
                new JsonDeserializer<>(MailMessageDTO.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MailMessageDTO> emailKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MailMessageDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(emailConsumerFactory());
        return factory;
    }

    //Tạo 1 topic cho kafka
    @Bean
    public NewTopic emailTopic() {
        return new NewTopic(emailTopicName, 3, (short) 2);
    }

    //Tùy vào bài toán thì ta đặt số partition khác nhau.Càng nhiều partition thì số message xử lí càng nhiều
    //nhưng sẽ kéo theo latency, availability, config,....Nến để từ 3 đến 10 là hợp lí

    //Tham số còn lại là số lượng nhân bản (Bao nhiêu broker thì bấy nhiêu replica)

    Map<String, Object> getBaseProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                serversConfig);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                emailGroupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "90000");
        return props;
    }


}
