package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CompleteCook extends AbstractEvent {

    private Long id;

    public CompleteCook(Cook aggregate) {
        super(aggregate);
    }

    public CompleteCook() {
        super();
    }
}
