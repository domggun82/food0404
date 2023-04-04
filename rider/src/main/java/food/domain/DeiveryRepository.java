package food.domain;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "deiveries", path = "deiveries")
public interface DeiveryRepository
    extends PagingAndSortingRepository<Deivery, Long> {}
