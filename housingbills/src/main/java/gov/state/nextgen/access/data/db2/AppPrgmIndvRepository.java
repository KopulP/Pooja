package gov.state.nextgen.access.data.db2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.APP_PRGM_INDV_Cargo;
import gov.state.nextgen.access.business.entities.AppPrgmIndvIdentity;
import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Cargo;


@Repository
public interface AppPrgmIndvRepository extends CrudRepository<APP_PRGM_INDV_Cargo, AppPrgmIndvIdentity> {

	//List<CP_APP_SCREENER_Cargo> findById(long id);
}
