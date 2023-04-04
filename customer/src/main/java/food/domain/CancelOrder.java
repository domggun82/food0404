package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CancelOrder extends AbstractEvent {

    private Long id;

    public CancelOrder(Order aggregate) {
        super(aggregate);
    }

    public CancelOrder() {
        super();
    }
}
