package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PickDelivery extends AbstractEvent {

    private Long id;
    private String orderid;

    public PickDelivery(Deivery aggregate) {
        super(aggregate);
    }

    public PickDelivery() {
        super();
    }
}
