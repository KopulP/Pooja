package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppInIrweCargo;
import gov.state.nextgen.access.business.entities.CpAppInIrwePrimaryKey;

@Repository
public interface CpAppInIrweRepository extends CrudRepository<CpAppInIrweCargo, CpAppInIrwePrimaryKey>{

}
