package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppSnapExpCargo;
import gov.state.nextgen.access.business.entities.CpAppSnapExpPrimaryKey;

@Repository
public interface CpAppSnapExpRepository extends CrudRepository<CpAppSnapExpCargo, CpAppSnapExpPrimaryKey>{

}
