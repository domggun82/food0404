package food.domain;

import food.RiderApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Deivery_table")
@Data
public class Deivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    public static DeiveryRepository repository() {
        DeiveryRepository deiveryRepository = RiderApplication.applicationContext.getBean(
            DeiveryRepository.class
        );
        return deiveryRepository;
    }

    public void picjFood() {
        PickDelivery pickDelivery = new PickDelivery(this);
        pickDelivery.publishAfterCommit();
    }

    public void confirm() {
        DeiveryConfirmed deiveryConfirmed = new DeiveryConfirmed(this);
        deiveryConfirmed.publishAfterCommit();
    }

    public static void loadDeliveryInfo(StartCook startCook) {
        /** Example 1:  new item 
        Deivery deivery = new Deivery();
        repository().save(deivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(startCook.get???()).ifPresent(deivery->{
            
            deivery // do something
            repository().save(deivery);


         });
        */

    }

    public static void loadDeliveryInfo(Ordered ordered) {
        /** Example 1:  new item 
        Deivery deivery = new Deivery();
        repository().save(deivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(deivery->{
            
            deivery // do something
            repository().save(deivery);


         });
        */

    }
}
