/*
 * Created on Jun 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package gov.state.nextgen.access.driver;

/**
 * @author connomi
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IFwDriver {

	public void initializeDriverMaps();

	public int getIndexForPageId(String driverId, String pageId);

	public String getPageAction(String driverId, String pageId);

	public String getPageId(String driverId, int index);
}
