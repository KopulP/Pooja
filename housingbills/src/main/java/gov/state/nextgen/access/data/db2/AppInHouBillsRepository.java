package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInHouBillsCargo;
import gov.state.nextgen.access.business.entities.AppInHouBillsPrimaryKey;

@Repository
public interface AppInHouBillsRepository extends CrudRepository<AppInHouBillsCargo, AppInHouBillsPrimaryKey>{

}
