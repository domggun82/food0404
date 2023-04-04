package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeiveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Deivery>> {

    @Override
    public EntityModel<Deivery> process(EntityModel<Deivery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/picjfood")
                .withRel("picjfood")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/confirm")
                .withRel("confirm")
        );

        return model;
    }
}
