/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import gov.state.nextgen.access.exceptions.FwException;

/**
 * @author balasan
 *
 */
public abstract class FwAbstractWebServiceCargo implements Serializable, Cloneable, ICargoWS {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String cargoName;
	private FwException feException;

	/**
	 * FwAbstractWebServiceCargo is used to represent common behaviors of a
	 * ValueObject in the Framework
	 */
	public FwAbstractWebServiceCargo() {
		super();
	}

	/**
	 * Insert the method's description here. Creation date: (03/09/2004 4:19:22
	 * PM)
	 *
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Insert the method's description here. Creation date: (03/09/2004 4:19:22
	 * PM)
	 *
	 */
	@Override
	public java.lang.String getUser() {
		return user;
	}

	/**
	 * Insert the method's description here. Creation date: (03/09/2004 4:19:22
	 * PM)
	 *
	 */
	@Override
	public void setUser(final java.lang.String newUser) {
		user = newUser;
	}

	/**
	 * Insert the method's description here. Creation date: (03/09/2004 4:19:22
	 * PM)
	 *
	 */
	public String getCargoName() {
		return cargoName;
	}

	/**
	 * Insert the method's description here. Creation date: (03/09/2004 4:19:22
	 * PM)
	 *
	 */
	public void setCargoName(final java.lang.String cName) {
		cargoName = cName;
	}

	public abstract String getPackage();

	/**
	 * Returns the dirty. Creation date: (03/09/2004 4:19:22 PM)
	 */
	@Override
	public boolean isDirty() {
		return false;
	}

	/**
	 * Sets the dirty. Creation date: (03/09/2004 4:19:22 PM)
	 */
	@Override
	public void setDirty(final boolean dirty) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see gov.state.nextgen.framework.business.entities.ICargo#getPrimaryKey()
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gov.state.nextgen.framework.business.entities.ICargo#setSimulation(char)
	 */
	public void setSimulation(final char aSimulation) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see gov.state.nextgen.framework.business.entities.ICargo#getSimulation()
	 */
	public char getSimulation() {
		return 0;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	@Override
	public FwException getFeException() {
		return feException;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setFeException(final FwException exception) {
		feException = exception;
	}

	@Override
	public String getRowAction() {
		return null;
	}
}