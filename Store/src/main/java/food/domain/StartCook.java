package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StartCook extends AbstractEvent {

    private Long id;
    private String orderid;

    public StartCook(Cook aggregate) {
        super(aggregate);
    }

    public StartCook() {
        super();
    }
}
