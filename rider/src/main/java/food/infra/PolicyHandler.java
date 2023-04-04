package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeiveryRepository deiveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StartCook'"
    )
    public void wheneverStartCook_LoadDeliveryInfo(
        @Payload StartCook startCook
    ) {
        StartCook event = startCook;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + startCook + "\n\n"
        );

        // Sample Logic //
        Deivery.loadDeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_LoadDeliveryInfo(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + ordered + "\n\n"
        );

        // Sample Logic //
        Deivery.loadDeliveryInfo(event);
    }
}
