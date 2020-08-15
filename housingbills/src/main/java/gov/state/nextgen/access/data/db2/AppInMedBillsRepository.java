package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInMedBillsCargo;
import gov.state.nextgen.access.business.entities.AppInMedBillsPrimaryKey;

@Repository
public interface AppInMedBillsRepository extends CrudRepository<AppInMedBillsCargo, AppInMedBillsPrimaryKey>{

}
