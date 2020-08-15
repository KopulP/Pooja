package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppAuthRepCargo;
import gov.state.nextgen.access.business.entities.CpAppAuthRepPrimaryKey;

@Repository
public interface CpAppAuthRepRepository extends CrudRepository<CpAppAuthRepCargo, CpAppAuthRepPrimaryKey>{

}
