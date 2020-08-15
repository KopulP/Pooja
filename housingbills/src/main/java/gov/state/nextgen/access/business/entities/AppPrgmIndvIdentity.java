package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AppPrgmIndvIdentity implements Serializable{
	
	private String app_num;
	private String indv_seq_num;
	private String src_app_ind;
	
	public AppPrgmIndvIdentity() {
		
	}
	
	public AppPrgmIndvIdentity(String app_num, String indv_seq_num, String src_app_ind) {
		this.app_num = app_num;
		this.indv_seq_num = indv_seq_num;
		this.src_app_ind = src_app_ind;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((app_num == null) ? 0 : app_num.hashCode());
		result = prime * result + ((indv_seq_num == null) ? 0 : indv_seq_num.hashCode());
		result = prime * result + ((src_app_ind == null) ? 0 : src_app_ind.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppPrgmIndvIdentity other = (AppPrgmIndvIdentity) obj;
		if (app_num == null) {
			if (other.app_num != null)
				return false;
		} else if (!app_num.equals(other.app_num))
			return false;
		if (indv_seq_num == null) {
			if (other.indv_seq_num != null)
				return false;
		} else if (!indv_seq_num.equals(other.indv_seq_num))
			return false;
		if (src_app_ind == null) {
			if (other.src_app_ind != null)
				return false;
		} else if (!src_app_ind.equals(other.src_app_ind))
			return false;
		return true;
	}
	public String getApp_num() {
		return app_num;
	}
	public void setApp_num(String app_num) {
		this.app_num = app_num;
	}
	public String getIndv_seq_num() {
		return indv_seq_num;
	}
	public void setIndv_seq_num(String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}
	public String getSrc_app_ind() {
		return src_app_ind;
	}
	public void setSrc_app_ind(String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}
	
	

}
