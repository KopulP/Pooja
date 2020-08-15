package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppInDeductionCargo;
import gov.state.nextgen.access.business.entities.CpAppInDeductionPrimaryKey;

@Repository
public interface CpAppInDeductionRepository extends CrudRepository<CpAppInDeductionCargo, CpAppInDeductionPrimaryKey>{

}
