package gov.state.nextgen.access.data.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.AppInShltcCargo;
import gov.state.nextgen.access.business.entities.AppInShltcPrimaryKey;

@Repository
public interface AppInShltcRepository extends CrudRepository<AppInShltcCargo, AppInShltcPrimaryKey>{

}
