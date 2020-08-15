package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInIrweCargo;
import gov.state.nextgen.access.business.entities.AppInIrwePrimaryKey;

@Repository
public interface AppInIrweRepository extends CrudRepository<AppInIrweCargo, AppInIrwePrimaryKey>{

}
