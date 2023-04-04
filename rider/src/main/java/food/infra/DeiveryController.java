package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/deiveries")
@Transactional
public class DeiveryController {

    @Autowired
    DeiveryRepository deiveryRepository;

    @RequestMapping(
        value = "deiveries/{id}/picjfood",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Deivery picjFood(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /deivery/picjFood  called #####");
        Optional<Deivery> optionalDeivery = deiveryRepository.findById(id);

        optionalDeivery.orElseThrow(() -> new Exception("No Entity Found"));
        Deivery deivery = optionalDeivery.get();
        deivery.picjFood();

        deiveryRepository.save(deivery);
        return deivery;
    }

    @RequestMapping(
        value = "deiveries/{id}/confirm",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Deivery confirm(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /deivery/confirm  called #####");
        Optional<Deivery> optionalDeivery = deiveryRepository.findById(id);

        optionalDeivery.orElseThrow(() -> new Exception("No Entity Found"));
        Deivery deivery = optionalDeivery.get();
        deivery.confirm();

        deiveryRepository.save(deivery);
        return deivery;
    }
}
