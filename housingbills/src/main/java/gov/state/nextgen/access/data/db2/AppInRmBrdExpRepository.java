package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInRmBrdExpCargo;
import gov.state.nextgen.access.business.entities.AppInRmBrdExpPrimaryKey;

@Repository
public interface AppInRmBrdExpRepository extends CrudRepository<AppInRmBrdExpCargo, AppInRmBrdExpPrimaryKey>{

}
