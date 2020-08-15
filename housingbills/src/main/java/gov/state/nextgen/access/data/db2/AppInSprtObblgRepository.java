package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInSprtObblgCargo;
import gov.state.nextgen.access.business.entities.AppInSprtOblgPrimaryKey;

@Repository
public interface AppInSprtObblgRepository extends CrudRepository<AppInSprtObblgCargo, AppInSprtOblgPrimaryKey>{

}
