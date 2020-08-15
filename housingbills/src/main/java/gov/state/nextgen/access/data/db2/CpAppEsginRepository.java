package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppEsgginPrimaryKey;
import gov.state.nextgen.access.business.entities.CpAppEsginCargo;

@Repository
public interface CpAppEsginRepository extends CrudRepository<CpAppEsginCargo, CpAppEsgginPrimaryKey>{

}
