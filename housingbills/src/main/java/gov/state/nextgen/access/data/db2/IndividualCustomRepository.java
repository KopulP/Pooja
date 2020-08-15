package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.IndividualCustomCargo;

@Repository
public interface IndividualCustomRepository extends CrudRepository<IndividualCustomCargo, Long>{

}
