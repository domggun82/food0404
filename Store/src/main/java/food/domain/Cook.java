package food.domain;

import food.StoreApplication;
import food.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String foodid;

    private String option;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptorreject(AcceptorrejectCommand acceptorrejectCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void start() {
        StartCook startCook = new StartCook(this);
        startCook.publishAfterCommit();
    }

    public void finish() {
        CompleteCook completeCook = new CompleteCook(this);
        completeCook.publishAfterCommit();
    }

    public static void loadOrderInfo(Ordered ordered) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
