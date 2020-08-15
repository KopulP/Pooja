package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInRoomBrdCargo;
import gov.state.nextgen.access.business.entities.AppInRoomBrdPrimaryKey;

@Repository
public interface AppInRoomBrdRepository extends CrudRepository<AppInRoomBrdCargo, AppInRoomBrdPrimaryKey>{

}
