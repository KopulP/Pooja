package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInUtilcCargo;
import gov.state.nextgen.access.business.entities.AppInUtilcPrimaryKey;

@Repository
public interface AppInUtilcRepository extends CrudRepository<AppInUtilcCargo, AppInUtilcPrimaryKey>{

}
