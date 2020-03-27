package sk.tuke.fei.hasak.istimeservice.kafka;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sk.tuke.fei.hasak.istimeservice.model.SchedulledEvent;
import sk.tuke.fei.hasak.istimeservice.service.IsTimeService;

@Slf4j
@Component
public class SavedEventMessageKafkaListener {

    private final IsTimeService isTimeService;

    @Autowired
    public SavedEventMessageKafkaListener(IsTimeService isTimeService) {
        this.isTimeService = isTimeService;
    }

    @KafkaListener(topics = "${kafka.topic.saved.event.message}", groupId = "${kafka.groupId.saved.event.message}",
                    containerFactory = "kafkaListenerContainerFactory")
    public void processSavedEventMessage(@NonNull SavedEventMessage message) {
        log.info("[Is-Time-Service] received:{}", message);
        isTimeService.save(new SchedulledEvent(message.getMessageId(), message.getMessageTime()));
    }

}
