package gov.state.nextgen.access.data.db2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.state.nextgen.access.business.entities.Player;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

	List<Player> findById(long id);
}
