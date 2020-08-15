package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.CpAppInMedBillsCargo;
import gov.state.nextgen.access.business.entities.CpAppInMedBillsPrimaryKey;

@Repository
public interface CpAppInMedBillsRepository extends CrudRepository<CpAppInMedBillsCargo, CpAppInMedBillsPrimaryKey>{

}
