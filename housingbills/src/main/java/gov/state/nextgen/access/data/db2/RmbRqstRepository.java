package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.RmbRqstCargo;
import gov.state.nextgen.access.business.entities.RmbRqstPrimaryKey;

@Repository
public interface RmbRqstRepository extends CrudRepository<RmbRqstCargo, RmbRqstPrimaryKey>{

}
