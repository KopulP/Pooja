package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.RmcInPrflCargo;
import gov.state.nextgen.access.business.entities.RmcInPrflPrimaryKey;

@Repository
public interface RmcInPrflRepository extends CrudRepository<RmcInPrflCargo, RmcInPrflPrimaryKey>{

}
