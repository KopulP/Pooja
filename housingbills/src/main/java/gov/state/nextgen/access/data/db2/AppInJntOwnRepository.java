package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInJntOwnCargo;
import gov.state.nextgen.access.business.entities.AppInJntOwnPrimaryKey;

@Repository
public interface AppInJntOwnRepository extends CrudRepository<AppInJntOwnCargo, AppInJntOwnPrimaryKey>{

}
