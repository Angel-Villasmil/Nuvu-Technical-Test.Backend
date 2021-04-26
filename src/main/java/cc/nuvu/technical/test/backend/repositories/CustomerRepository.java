package cc.nuvu.technical.test.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cc.nuvu.technical.test.backend.models.CustomerModel;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

}
