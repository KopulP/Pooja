package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInMedcrCargo;
import gov.state.nextgen.access.business.entities.AppInMedcrPrimaryKey;

@Repository
public interface AppInMedcrRepository extends CrudRepository<AppInMedcrCargo, AppInMedcrPrimaryKey>{

}
