package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAbchsCargo;
import gov.state.nextgen.access.business.entities.CpAbchsPrimaryKey;

@Repository
public interface CpAbchsRepository extends CrudRepository<CpAbchsCargo, CpAbchsPrimaryKey>{

}
