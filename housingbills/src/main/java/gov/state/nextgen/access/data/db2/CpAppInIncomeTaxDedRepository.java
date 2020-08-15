package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppInIncomeTaxDedCargo;
import gov.state.nextgen.access.business.entities.CpAppInIncomeTaxDedPrimaryKey;

@Repository
public interface CpAppInIncomeTaxDedRepository extends CrudRepository<CpAppInIncomeTaxDedCargo, CpAppInIncomeTaxDedPrimaryKey>{

}
