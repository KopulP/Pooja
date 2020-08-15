/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Jul 20 16:08:52 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_CASE_ADR_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_CASE_ADR";

	boolean isDirty = false;
	private java.lang.String bnft_case_num;
	private java.lang.String adr_typ;
	private java.lang.String apt_adr;
	private java.lang.String city_adr;
	private java.lang.String cntc_fst_nam;
	private java.lang.String cntc_last_nam;
	private java.lang.String cntc_mid_init;
	private java.lang.String dir_adr;
	private java.lang.String l2_adr;
	private java.lang.String cntc_phn_num;
	private java.lang.String qdrt_adr;
	private java.lang.String st_num_adr;
	private java.lang.String st_rurl_adr;
	private java.lang.String st_adr;
	private java.lang.String sfx_adr;
	private java.lang.String unit_adr;
	private java.lang.String updt_dt;
	private java.lang.String zip_adr;
	private java.lang.String cnty_num;
	private java.lang.String cntc_fax_num;
	// added a new varibale for self service by ganig
	private java.lang.String email;

	// Added a Variables to Display the Address Dwelling type,Street Fraction By
	// Kumar Karuppanan on 06/26/2009 for the Defect # BRGUS00169975.

	private java.lang.String addr_dwelling_type_cd;
	private java.lang.String addr_st_num_frac;
	private java.lang.String addr_care_of_line;
	private java.lang.String office_num;
	private java.lang.String office_name;
	private java.lang.String emp_id;
	private java.lang.String org_name;

	// Added New variable for BRGUS00169975 End

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final BNFT_CASE_ADR_PrimaryKey key = new BNFT_CASE_ADR_PrimaryKey();
		key.setBnft_case_num(getBnft_case_num());
		key.setAdr_typ(getAdr_typ());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "BNFT_CASE_ADR: " + "bnft_case_num=" + bnft_case_num + "," + "adr_typ=" + adr_typ + "," + "apt_adr=" + apt_adr + "," + "city_adr="
				+ city_adr + "," + "cntc_fst_nam=" + cntc_fst_nam + "," + "cntc_last_nam=" + cntc_last_nam + "," + "cntc_mid_init=" + cntc_mid_init
				+ "," + "dir_adr=" + dir_adr + "," + "l2_adr=" + l2_adr + "," + "cntc_phn_num=" + cntc_phn_num + "," + "cntc_fax_num=" + cntc_fax_num
				+ "," + "qdrt_adr=" + qdrt_adr + "," + "st_num_adr=" + st_num_adr + "," + "st_rurl_adr=" + st_rurl_adr + "," + "st_adr=" + st_adr
				+ "," + "sfx_adr=" + sfx_adr + "," + "unit_adr=" + unit_adr + "," + "updt_dt=" + updt_dt + "," + "zip_adr=" + zip_adr + ","
				+ "cnty_num=" + cnty_num + "," + "email=" + email + ",addr_dwelling_type_cd=" + addr_dwelling_type_cd + ",addr_st_num_frac="
				+ addr_st_num_frac + ",addr_care_of_line=" + addr_care_of_line + ",office_num=" + office_num + ",office_name=" + office_name
				+ ",emp_id=" + emp_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((addr_care_of_line == null) ? 0 : addr_care_of_line.trim().hashCode());
		result = (prime * result) + ((addr_dwelling_type_cd == null) ? 0 : addr_dwelling_type_cd.trim().hashCode());
		result = (prime * result) + ((addr_st_num_frac == null) ? 0 : addr_st_num_frac.trim().hashCode());
		result = (prime * result) + ((adr_typ == null) ? 0 : adr_typ.trim().hashCode());
		result = (prime * result) + ((apt_adr == null) ? 0 : apt_adr.trim().hashCode());
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((city_adr == null) ? 0 : city_adr.trim().hashCode());
		result = (prime * result) + ((cntc_fax_num == null) ? 0 : cntc_fax_num.trim().hashCode());
		result = (prime * result) + ((cntc_fst_nam == null) ? 0 : cntc_fst_nam.trim().hashCode());
		result = (prime * result) + ((cntc_last_nam == null) ? 0 : cntc_last_nam.trim().hashCode());
		result = (prime * result) + ((cntc_mid_init == null) ? 0 : cntc_mid_init.trim().hashCode());
		result = (prime * result) + ((cntc_phn_num == null) ? 0 : cntc_phn_num.trim().hashCode());
		result = (prime * result) + ((cnty_num == null) ? 0 : cnty_num.trim().hashCode());
		result = (prime * result) + ((dir_adr == null) ? 0 : dir_adr.trim().hashCode());
		result = (prime * result) + ((email == null) ? 0 : email.trim().hashCode());
		result = (prime * result) + ((emp_id == null) ? 0 : emp_id.trim().hashCode());
		result = (prime * result) + ((l2_adr == null) ? 0 : l2_adr.trim().hashCode());
		result = (prime * result) + ((office_name == null) ? 0 : office_name.trim().hashCode());
		result = (prime * result) + ((office_num == null) ? 0 : office_num.trim().hashCode());
		result = (prime * result) + ((org_name == null) ? 0 : org_name.trim().hashCode());
		result = (prime * result) + ((qdrt_adr == null) ? 0 : qdrt_adr.trim().hashCode());
		result = (prime * result) + ((sfx_adr == null) ? 0 : sfx_adr.trim().hashCode());
		result = (prime * result) + ((st_adr == null) ? 0 : st_adr.trim().hashCode());
		result = (prime * result) + ((st_num_adr == null) ? 0 : st_num_adr.trim().hashCode());
		result = (prime * result) + ((st_rurl_adr == null) ? 0 : st_rurl_adr.trim().hashCode());
		result = (prime * result) + ((unit_adr == null) ? 0 : unit_adr.trim().hashCode());
		result = (prime * result) + ((updt_dt == null) ? 0 : updt_dt.trim().hashCode());
		result = (prime * result) + ((zip_adr == null) ? 0 : zip_adr.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_case_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * Sets the bnft_case_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param bnft_case_num
	 *            The bnft_case_num to set
	 */

	public void setBnft_case_num(final java.lang.String bnft_case_num) {
		this.bnft_case_num = bnft_case_num;
	}

	/**
	 * Returns the adr_typ.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getAdr_typ() {
		return adr_typ;
	}

	/**
	 * Sets the adr_typ.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param adr_typ
	 *            The adr_typ to set
	 */

	public void setAdr_typ(final java.lang.String adr_typ) {
		this.adr_typ = adr_typ;
	}

	/**
	 * Returns the apt_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getApt_adr() {
		return apt_adr;
	}

	/**
	 * Sets the apt_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param apt_adr
	 *            The apt_adr to set
	 */

	public void setApt_adr(final java.lang.String apt_adr) {
		this.apt_adr = apt_adr;
	}

	/**
	 * Returns the city_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCity_adr() {
		return city_adr;
	}

	/**
	 * Sets the city_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param city_adr
	 *            The city_adr to set
	 */

	public void setCity_adr(final java.lang.String city_adr) {
		this.city_adr = city_adr;
	}

	/**
	 * Returns the cntc_fst_nam.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCntc_fst_nam() {
		return cntc_fst_nam;
	}

	/**
	 * Sets the cntc_fst_nam.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cntc_fst_nam
	 *            The cntc_fst_nam to set
	 */

	public void setCntc_fst_nam(final java.lang.String cntc_fst_nam) {
		this.cntc_fst_nam = cntc_fst_nam;
	}

	/**
	 * Returns the cntc_last_nam.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCntc_last_nam() {
		return cntc_last_nam;
	}

	/**
	 * Sets the cntc_last_nam.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cntc_last_nam
	 *            The cntc_last_nam to set
	 */

	public void setCntc_last_nam(final java.lang.String cntc_last_nam) {
		this.cntc_last_nam = cntc_last_nam;
	}

	/**
	 * Returns the cntc_mid_init.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCntc_mid_init() {
		return cntc_mid_init;
	}

	/**
	 * Sets the cntc_mid_init.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cntc_mid_init
	 *            The cntc_mid_init to set
	 */

	public void setCntc_mid_init(final java.lang.String cntc_mid_init) {
		this.cntc_mid_init = cntc_mid_init;
	}

	/**
	 * Returns the dir_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getDir_adr() {
		return dir_adr;
	}

	/**
	 * Sets the dir_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param dir_adr
	 *            The dir_adr to set
	 */

	public void setDir_adr(final java.lang.String dir_adr) {
		this.dir_adr = dir_adr;
	}

	/**
	 * Returns the l2_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getL2_adr() {
		return l2_adr;
	}

	/**
	 * Sets the l2_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param l2_adr
	 *            The l2_adr to set
	 */

	public void setL2_adr(final java.lang.String l2_adr) {
		this.l2_adr = l2_adr;
	}

	/**
	 * Returns the cntc_phn_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCntc_phn_num() {
		return cntc_phn_num;
	}

	/**
	 * Sets the cntc_phn_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cntc_phn_num
	 *            The cntc_phn_num to set
	 */

	public void setCntc_phn_num(final java.lang.String cntc_phn_num) {
		this.cntc_phn_num = cntc_phn_num;
	}

	/**
	 * Returns the qdrt_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getQdrt_adr() {
		return qdrt_adr;
	}

	/**
	 * Sets the qdrt_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param qdrt_adr
	 *            The qdrt_adr to set
	 */

	public void setQdrt_adr(final java.lang.String qdrt_adr) {
		this.qdrt_adr = qdrt_adr;
	}

	/**
	 * Returns the st_num_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSt_num_adr() {
		return st_num_adr;
	}

	/**
	 * Sets the st_num_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param st_num_adr
	 *            The st_num_adr to set
	 */

	public void setSt_num_adr(final java.lang.String st_num_adr) {
		this.st_num_adr = st_num_adr;
	}

	/**
	 * Returns the st_rurl_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSt_rurl_adr() {
		return st_rurl_adr;
	}

	/**
	 * Sets the st_rurl_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param st_rurl_adr
	 *            The st_rurl_adr to set
	 */

	public void setSt_rurl_adr(final java.lang.String st_rurl_adr) {
		this.st_rurl_adr = st_rurl_adr;
	}

	/**
	 * Returns the st_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSt_adr() {
		return st_adr;
	}

	/**
	 * Sets the st_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param st_adr
	 *            The st_adr to set
	 */

	public void setSt_adr(final java.lang.String st_adr) {
		this.st_adr = st_adr;
	}

	/**
	 * Returns the sfx_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSfx_adr() {
		return sfx_adr;
	}

	/**
	 * Sets the sfx_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param sfx_adr
	 *            The sfx_adr to set
	 */

	public void setSfx_adr(final java.lang.String sfx_adr) {
		this.sfx_adr = sfx_adr;
	}

	/**
	 * Returns the unit_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getUnit_adr() {
		return unit_adr;
	}

	/**
	 * Sets the unit_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param unit_adr
	 *            The unit_adr to set
	 */

	public void setUnit_adr(final java.lang.String unit_adr) {
		this.unit_adr = unit_adr;
	}

	/**
	 * Returns the updt_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * Sets the updt_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param updt_dt
	 *            The updt_dt to set
	 */

	public void setUpdt_dt(final java.lang.String updt_dt) {
		this.updt_dt = updt_dt;
	}

	/**
	 * Returns the zip_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getZip_adr() {
		return zip_adr;
	}

	/**
	 * Sets the zip_adr.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param zip_adr
	 *            The zip_adr to set
	 */

	public void setZip_adr(final java.lang.String zip_adr) {
		this.zip_adr = zip_adr;
	}

	/**
	 * Returns the cnty_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCnty_num() {
		return cnty_num;
	}

	/**
	 * Sets the cnty_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cnty_num
	 *            The cnty_num to set
	 */

	public void setCnty_num(final java.lang.String cnty_num) {
		this.cnty_num = cnty_num;
	}

	/**
	 * Returns the email.
	 *
	 * Creation Date May 8 2009
	 * @return java.lang.String
	 */

	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * Creation Date May 8 2009
	 * @param email
	 *            The email to set
	 */

	public void setEmail(final java.lang.String email) {
		this.email = email;
	}

	/**
	 * @return the addr_care_of_line
	 */
	public java.lang.String getAddr_care_of_line() {
		return addr_care_of_line;
	}

	/**
	 * @param addr_care_of_line
	 *            the addr_care_of_line to set
	 */
	public void setAddr_care_of_line(final java.lang.String addr_care_of_line) {
		this.addr_care_of_line = addr_care_of_line;
	}

	/**
	 * @return the addr_dwelling_type_cd
	 */
	public java.lang.String getAddr_dwelling_type_cd() {
		return addr_dwelling_type_cd;
	}

	/**
	 * @param addr_dwelling_type_cd
	 *            the addr_dwelling_type_cd to set
	 */
	public void setAddr_dwelling_type_cd(final java.lang.String addr_dwelling_type_cd) {
		this.addr_dwelling_type_cd = addr_dwelling_type_cd;
	}

	/**
	 * @return the addr_st_num_frac
	 */
	public java.lang.String getAddr_st_num_frac() {
		return addr_st_num_frac;
	}

	/**
	 * @param addr_st_num_frac
	 *            the addr_st_num_frac to set
	 */
	public void setAddr_st_num_frac(final java.lang.String addr_st_num_frac) {
		this.addr_st_num_frac = addr_st_num_frac;
	}

	/**
	 * @return the emp_id
	 */
	public java.lang.String getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id
	 *            the emp_id to set
	 */
	public void setEmp_id(final java.lang.String emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the office_name
	 */
	public java.lang.String getOffice_name() {
		return office_name;
	}

	/**
	 * @param office_name
	 *            the office_name to set
	 */
	public void setOffice_name(final java.lang.String office_name) {
		this.office_name = office_name;
	}

	/**
	 * @return the office_num
	 */
	public java.lang.String getOffice_num() {
		return office_num;
	}

	/**
	 * @param office_num
	 *            the office_num to set
	 */
	public void setOffice_num(final java.lang.String office_num) {
		this.office_num = office_num;
	}

	public BNFT_CASE_ADR_Cargo cloneCargoResults() {
		final BNFT_CASE_ADR_Cargo rescargo = new BNFT_CASE_ADR_Cargo();
		rescargo.setBnft_case_num(getBnft_case_num());
		rescargo.setAdr_typ(getAdr_typ());
		rescargo.setApt_adr(getApt_adr());
		rescargo.setCity_adr(getCity_adr());
		rescargo.setCntc_fst_nam(getCntc_fst_nam());
		rescargo.setCntc_last_nam(getCntc_last_nam());
		rescargo.setCntc_mid_init(getCntc_mid_init());
		rescargo.setDir_adr(getDir_adr());
		rescargo.setL2_adr(getL2_adr());
		rescargo.setCntc_phn_num(getCntc_phn_num());
		rescargo.setCntc_fax_num(getCntc_fax_num());
		rescargo.setQdrt_adr(getQdrt_adr());
		rescargo.setSt_num_adr(getSt_num_adr());
		rescargo.setSt_rurl_adr(getSt_rurl_adr());
		rescargo.setSt_adr(getSt_adr());
		rescargo.setSfx_adr(getSfx_adr());
		rescargo.setUnit_adr(getUnit_adr());
		rescargo.setUpdt_dt(getUpdt_dt());
		rescargo.setZip_adr(getZip_adr());
		rescargo.setCnty_num(getCnty_num());
		rescargo.setRowAction(getRowAction());
		rescargo.setUser(getUser());
		rescargo.setDirty(isDirty());
		rescargo.setEmail(getEmail());
		rescargo.setAddr_dwelling_type_cd(getAddr_dwelling_type_cd());
		rescargo.setAddr_st_num_frac(getAddr_st_num_frac());
		rescargo.setAddr_care_of_line(getAddr_care_of_line());
		rescargo.setOffice_num(getOffice_num());
		rescargo.setOffice_name(getOffice_name());
		rescargo.setEmp_id(getEmp_id());
		rescargo.setOrg_name(getOrg_name());
		return rescargo;

	}

	/**
	 * @return
	 */
	public java.lang.String getCntc_fax_num() {
		return cntc_fax_num;
	}

	/**
	 * @param string
	 */
	public void setCntc_fax_num(final java.lang.String string) {
		cntc_fax_num = string;
	}

	public java.lang.String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(final java.lang.String org_name) {
		this.org_name = org_name;
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
		final BNFT_CASE_ADR_Cargo other = (BNFT_CASE_ADR_Cargo) obj;
		if (addr_care_of_line == null) {
			if (other.addr_care_of_line != null) {
				return false;
			}
		} else if (!addr_care_of_line.equals(other.addr_care_of_line)) {
			return false;
		}
		if (addr_dwelling_type_cd == null) {
			if (other.addr_dwelling_type_cd != null) {
				return false;
			}
		} else if (!addr_dwelling_type_cd.equals(other.addr_dwelling_type_cd)) {
			return false;
		}
		if (addr_st_num_frac == null) {
			if (other.addr_st_num_frac != null) {
				return false;
			}
		} else if (!addr_st_num_frac.equals(other.addr_st_num_frac)) {
			return false;
		}
		if (adr_typ == null) {
			if (other.adr_typ != null) {
				return false;
			}
		} else if (!adr_typ.equals(other.adr_typ)) {
			return false;
		}
		if (apt_adr == null) {
			if (other.apt_adr != null) {
				return false;
			}
		} else if (!apt_adr.equals(other.apt_adr)) {
			return false;
		}
		if (bnft_case_num == null) {
			if (other.bnft_case_num != null) {
				return false;
			}
		} else if (!bnft_case_num.equals(other.bnft_case_num)) {
			return false;
		}
		if (city_adr == null) {
			if (other.city_adr != null) {
				return false;
			}
		} else if (!city_adr.equals(other.city_adr)) {
			return false;
		}
		if (cntc_fax_num == null) {
			if (other.cntc_fax_num != null) {
				return false;
			}
		} else if (!cntc_fax_num.equals(other.cntc_fax_num)) {
			return false;
		}
		if (cntc_fst_nam == null) {
			if (other.cntc_fst_nam != null) {
				return false;
			}
		} else if (!cntc_fst_nam.equals(other.cntc_fst_nam)) {
			return false;
		}
		if (cntc_last_nam == null) {
			if (other.cntc_last_nam != null) {
				return false;
			}
		} else if (!cntc_last_nam.equals(other.cntc_last_nam)) {
			return false;
		}
		if (cntc_mid_init == null) {
			if (other.cntc_mid_init != null) {
				return false;
			}
		} else if (!cntc_mid_init.equals(other.cntc_mid_init)) {
			return false;
		}
		if (cntc_phn_num == null) {
			if (other.cntc_phn_num != null) {
				return false;
			}
		} else if (!cntc_phn_num.equals(other.cntc_phn_num)) {
			return false;
		}
		if (cnty_num == null) {
			if (other.cnty_num != null) {
				return false;
			}
		} else if (!cnty_num.equals(other.cnty_num)) {
			return false;
		}
		if (dir_adr == null) {
			if (other.dir_adr != null) {
				return false;
			}
		} else if (!dir_adr.equals(other.dir_adr)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (emp_id == null) {
			if (other.emp_id != null) {
				return false;
			}
		} else if (!emp_id.equals(other.emp_id)) {
			return false;
		}
		if (l2_adr == null) {
			if (other.l2_adr != null) {
				return false;
			}
		} else if (!l2_adr.equals(other.l2_adr)) {
			return false;
		}
		if (office_name == null) {
			if (other.office_name != null) {
				return false;
			}
		} else if (!office_name.equals(other.office_name)) {
			return false;
		}
		if (office_num == null) {
			if (other.office_num != null) {
				return false;
			}
		} else if (!office_num.equals(other.office_num)) {
			return false;
		}
		if (org_name == null) {
			if (other.org_name != null) {
				return false;
			}
		} else if (!org_name.equals(other.org_name)) {
			return false;
		}
		if (qdrt_adr == null) {
			if (other.qdrt_adr != null) {
				return false;
			}
		} else if (!qdrt_adr.equals(other.qdrt_adr)) {
			return false;
		}
		if (sfx_adr == null) {
			if (other.sfx_adr != null) {
				return false;
			}
		} else if (!sfx_adr.equals(other.sfx_adr)) {
			return false;
		}
		if (st_adr == null) {
			if (other.st_adr != null) {
				return false;
			}
		} else if (!st_adr.equals(other.st_adr)) {
			return false;
		}
		if (st_num_adr == null) {
			if (other.st_num_adr != null) {
				return false;
			}
		} else if (!st_num_adr.equals(other.st_num_adr)) {
			return false;
		}
		if (st_rurl_adr == null) {
			if (other.st_rurl_adr != null) {
				return false;
			}
		} else if (!st_rurl_adr.equals(other.st_rurl_adr)) {
			return false;
		}
		if (unit_adr == null) {
			if (other.unit_adr != null) {
				return false;
			}
		} else if (!unit_adr.equals(other.unit_adr)) {
			return false;
		}
		if (updt_dt == null) {
			if (other.updt_dt != null) {
				return false;
			}
		} else if (!updt_dt.equals(other.updt_dt)) {
			return false;
		}
		if (zip_adr == null) {
			if (other.zip_adr != null) {
				return false;
			}
		} else if (!zip_adr.equals(other.zip_adr)) {
			return false;
		}
		return true;
	}

}