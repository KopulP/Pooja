package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppIndvCargo;
import gov.state.nextgen.access.business.entities.AppIndvPrimaryKey;

@Repository
public interface AppIndvRepository extends CrudRepository<AppIndvCargo, AppIndvPrimaryKey>{

}
