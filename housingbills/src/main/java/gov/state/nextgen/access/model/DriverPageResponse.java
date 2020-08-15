package gov.state.nextgen.access.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.AbstractCargo;

public class DriverPageResponse extends PageResponse implements Serializable {

	private static final long serialVersionUID = 3502784500688333694L;
	private String clientId;
	private String appNum;
	private String caseNum;
	private Map<String, List<? extends BaseDomainObject>> pageMap = new HashMap<>();
	private Map<String, List<? extends AbstractCargo>> pageCollection = new HashMap<>();
	private int[] pageDriver;
	
	private ComponentFlags componentFlag;
	// raw map objects are being used in the EJB layer.
	private Map<Object, Object> beforeCollection;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAppNum() {
		return appNum;
	}

	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	public String getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	public Map<String, List<? extends BaseDomainObject>> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, List<? extends BaseDomainObject>> pageMap) {
		this.pageMap = pageMap;
	}

	public int[] getPageDriver() {
		return pageDriver;
	}

	public void setPageDriver(int[] pageDriver) {
		this.pageDriver = pageDriver;
	}

	public Map<Object, Object> getBeforeCollection() {
		return beforeCollection;
	}

	public void setBeforeCollection(Map<Object, Object> beforeCollection) {
		this.beforeCollection = beforeCollection;
	}

	public ComponentFlags getComponentFlag() {
		return componentFlag;
	}

	public void setComponentFlag(ComponentFlags componentFlag) {
		this.componentFlag = componentFlag;
	}

	public Map<String, List<? extends AbstractCargo>> getPageCollection() {
		return pageCollection;
	}

	public void setPageCollection(Map<String, List<? extends AbstractCargo>> pageCollection) {
		this.pageCollection = pageCollection;
	}

}
