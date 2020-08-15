package gov.state.nextgen.access.business.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_JNT_OWN")
public class AppInJntOwnCargo  implements java.io.Serializable{

	@EmbeddedId
	private AppInJntOwnPrimaryKey appInJntOwnPrimaryKey;
	
	@Transient
	boolean isDirty = false;
	
	
	private String ecp_id;
	private String aset_sub_typ;
	private String jnt_indv_seq_num;
	private String jnt_own_fst_nam;
	private String jnt_own_last_nam;
	private String otsd_ind;
	private String src_app_ind;
	private String jnt_own_share;
	
	public AppInJntOwnPrimaryKey getPpInJntOwnPrimaryKey() {
		return appInJntOwnPrimaryKey;
	}
	public void setPpInJntOwnPrimaryKey(AppInJntOwnPrimaryKey ppInJntOwnPrimaryKey) {
		this.appInJntOwnPrimaryKey = ppInJntOwnPrimaryKey;
	}
	public boolean isDirty() {
		return isDirty;
	}
	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
	public String getEcp_id() {
		return ecp_id;
	}
	public void setEcp_id(String ecp_id) {
		this.ecp_id = ecp_id;
	}
	public String getAset_sub_typ() {
		return aset_sub_typ;
	}
	public void setAset_sub_typ(String aset_sub_typ) {
		this.aset_sub_typ = aset_sub_typ;
	}
	public String getJnt_indv_seq_num() {
		return jnt_indv_seq_num;
	}
	public void setJnt_indv_seq_num(String jnt_indv_seq_num) {
		this.jnt_indv_seq_num = jnt_indv_seq_num;
	}
	public String getJnt_own_fst_nam() {
		return jnt_own_fst_nam;
	}
	public void setJnt_own_fst_nam(String jnt_own_fst_nam) {
		this.jnt_own_fst_nam = jnt_own_fst_nam;
	}
	public String getJnt_own_last_nam() {
		return jnt_own_last_nam;
	}
	public void setJnt_own_last_nam(String jnt_own_last_nam) {
		this.jnt_own_last_nam = jnt_own_last_nam;
	}
	public String getOtsd_ind() {
		return otsd_ind;
	}
	public void setOtsd_ind(String otsd_ind) {
		this.otsd_ind = otsd_ind;
	}
	public String getSrc_app_ind() {
		return src_app_ind;
	}
	public void setSrc_app_ind(String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}
	public String getJnt_own_share() {
		return jnt_own_share;
	}
	public void setJnt_own_share(String jnt_own_share) {
		this.jnt_own_share = jnt_own_share;
	}

	
}
