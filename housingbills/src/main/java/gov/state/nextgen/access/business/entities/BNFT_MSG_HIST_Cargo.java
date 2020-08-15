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
public class BNFT_MSG_HIST_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_MSG_HIST";

	boolean isDirty = false;
	private java.lang.String bnft_pin_num;
	private java.lang.String cat_cd;
	private java.lang.String scat_cd;
	private java.lang.String msg_dt;
	private java.lang.String msg_seq_num;
	private java.lang.String txt_id;
	private java.lang.String msg_txt;
	private java.lang.String bnft_case_num;

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Cargo
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
		final BNFT_MSG_HIST_PrimaryKey key = new BNFT_MSG_HIST_PrimaryKey();
		key.setBnft_pin_num(getBnft_pin_num());
		key.setBnft_case_num(getBnft_case_num());
		key.setCat_cd(getCat_cd());
		key.setScat_cd(getScat_cd());
		key.setMsg_dt(getMsg_dt());
		key.setMsg_seq_num(getMsg_seq_num());
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
		return "BNFT_MSG_HIST: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_case_num=" + bnft_case_num + "," + "cat_cd=" + cat_cd + ","
				+ "scat_cd=" + scat_cd + "," + "msg_dt=" + msg_dt + "," + "msg_seq_num=" + msg_seq_num + "," + "txt_id=" + txt_id + "," + "msg_txt="
				+ msg_txt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((msg_dt == null) ? 0 : msg_dt.trim().hashCode());
		result = (prime * result) + ((msg_seq_num == null) ? 0 : msg_seq_num.trim().hashCode());
		result = (prime * result) + ((msg_txt == null) ? 0 : msg_txt.trim().hashCode());
		result = (prime * result) + ((scat_cd == null) ? 0 : scat_cd.trim().hashCode());
		result = (prime * result) + ((txt_id == null) ? 0 : txt_id.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the cat_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	/**
	 * Sets the cat_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param cat_cd
	 *            The cat_cd to set
	 */

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the scat_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_cd() {
		return scat_cd;
	}

	/**
	 * Sets the scat_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param scat_cd
	 *            The scat_cd to set
	 */

	public void setScat_cd(final java.lang.String scat_cd) {
		this.scat_cd = scat_cd;
	}

	/**
	 * Returns the msg_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMsg_dt() {
		return msg_dt;
	}

	/**
	 * Sets the msg_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param msg_dt
	 *            The msg_dt to set
	 */

	public void setMsg_dt(final java.lang.String msg_dt) {
		this.msg_dt = msg_dt;
	}

	/**
	 * Returns the msg_seq_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMsg_seq_num() {
		return msg_seq_num;
	}

	/**
	 * Sets the msg_seq_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param msg_seq_num
	 *            The msg_seq_num to set
	 */

	public void setMsg_seq_num(final java.lang.String msg_seq_num) {
		this.msg_seq_num = msg_seq_num;
	}

	/**
	 * Returns the txt_id.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getTxt_id() {
		return txt_id;
	}

	/**
	 * Sets the txt_id.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param txt_id
	 *            The txt_id to set
	 */

	public void setTxt_id(final java.lang.String txt_id) {
		this.txt_id = txt_id;
	}

	/**
	 * Returns the msg_txt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMsg_txt() {
		return msg_txt;
	}

	/**
	 * Sets the msg_txt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param msg_txt
	 *            The msg_txt to set
	 */

	public void setMsg_txt(final java.lang.String msg_txt) {
		this.msg_txt = msg_txt;
	}

	/**
	 * @return
	 */
	public java.lang.String getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * @param string
	 */
	public void setBnft_case_num(final java.lang.String string) {
		bnft_case_num = string;
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
		final BNFT_MSG_HIST_Cargo other = (BNFT_MSG_HIST_Cargo) obj;
		if (bnft_case_num == null) {
			if (other.bnft_case_num != null) {
				return false;
			}
		} else if (!bnft_case_num.equals(other.bnft_case_num)) {
			return false;
		}
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
			return false;
		}
		if (msg_dt == null) {
			if (other.msg_dt != null) {
				return false;
			}
		} else if (!msg_dt.equals(other.msg_dt)) {
			return false;
		}
		if (msg_seq_num == null) {
			if (other.msg_seq_num != null) {
				return false;
			}
		} else if (!msg_seq_num.equals(other.msg_seq_num)) {
			return false;
		}
		if (msg_txt == null) {
			if (other.msg_txt != null) {
				return false;
			}
		} else if (!msg_txt.equals(other.msg_txt)) {
			return false;
		}
		if (scat_cd == null) {
			if (other.scat_cd != null) {
				return false;
			}
		} else if (!scat_cd.equals(other.scat_cd)) {
			return false;
		}
		if (txt_id == null) {
			if (other.txt_id != null) {
				return false;
			}
		} else if (!txt_id.equals(other.txt_id)) {
			return false;
		}
		return true;
	}

}