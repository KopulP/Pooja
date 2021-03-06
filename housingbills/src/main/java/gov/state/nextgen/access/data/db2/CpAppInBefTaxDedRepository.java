package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppInBefTaxDedCargo;
import gov.state.nextgen.access.business.entities.CpAppInBefTaxDedPrimaryKey;

@Repository
public interface CpAppInBefTaxDedRepository extends CrudRepository<CpAppInBefTaxDedCargo, CpAppInBefTaxDedPrimaryKey>{

}
