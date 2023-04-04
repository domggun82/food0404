package food.domain;

import food.CustomerApplication;
import food.domain.Ordered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerid;

    private String foodid;

    private String option;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void cancel() {
        CancelOrder cancelOrder = new CancelOrder(this);
        cancelOrder.publishAfterCommit();
    }

    public static void state(StartCook startCook) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(startCook.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void state(PickDelivery pickDelivery) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(pickDelivery.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
