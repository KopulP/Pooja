package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInDcECargo;
import gov.state.nextgen.access.business.entities.AppInDcEPrimaryKey;

@Repository
public interface AppInDcERepository extends CrudRepository<AppInDcECargo, AppInDcEPrimaryKey>{

}
