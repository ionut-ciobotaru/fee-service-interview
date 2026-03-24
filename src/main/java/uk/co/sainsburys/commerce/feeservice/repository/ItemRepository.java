package uk.co.sainsburys.commerce.feeservice.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sainsburys.commerce.feeservice.domain.Item;

@Repository
@Scope("prototype")
public interface ItemRepository extends CrudRepository<Item, String> {
}
