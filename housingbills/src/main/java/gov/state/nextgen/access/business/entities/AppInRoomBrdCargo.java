package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_ROOM_BRD")
public class AppInRoomBrdCargo extends AbstractCargo implements Serializable{

	/**
	 *
	 */
	
	@EmbeddedId
	private AppInRoomBrdPrimaryKey key ;
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_ROOM_BRD";

	@Transient
	boolean isDirty = false;

	

	/**
	 * returns the PrimaryKey object.
	 */

	public IPrimaryKey getPrimaryKey() {
		
		return key;
	}

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("APP_IN_ROOM_BRD: ").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (isDirty ? 1231 : 1237);
		return result;
	}

	public Map compareAttributes(final AppInRoomBrdCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
	

		return changedAttributeValue;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AppInRoomBrdCargo other = (AppInRoomBrdCargo) obj;
		
		if (isDirty != other.isDirty) {
			return false;
		}
	
		
		
		return true;
	}
}
