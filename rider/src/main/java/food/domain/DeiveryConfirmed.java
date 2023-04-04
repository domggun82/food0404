package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeiveryConfirmed extends AbstractEvent {

    private Long id;

    public DeiveryConfirmed(Deivery aggregate) {
        super(aggregate);
    }

    public DeiveryConfirmed() {
        super();
    }
}
