package by.dimaviolinit.yoshop.domain;

import java.sql.Date;

public class BlackListRecord {

	private int userId;
	private Date banStart;
	private Date banEnd;

	public BlackListRecord(int userId, Date banStart, Date banEnd) {
		super();
		this.userId = userId;
		this.banStart = banStart;
		this.banEnd = banEnd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getBanStart() {
		return banStart;
	}

	public void setBanStart(Date banStart) {
		this.banStart = banStart;
	}

	public Date getBanEnd() {
		return banEnd;
	}

	public void setBanEnd(Date banEnd) {
		this.banEnd = banEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banEnd == null) ? 0 : banEnd.hashCode());
		result = prime * result + ((banStart == null) ? 0 : banStart.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BlackListRecord other = (BlackListRecord) obj;
		if (banEnd == null) {
			if (other.banEnd != null) {
				return false;
			}
		} else if (!banEnd.equals(other.banEnd)) {
			return false;
		}
		if (banStart == null) {
			if (other.banStart != null) {
				return false;
			}
		} else if (!banStart.equals(other.banStart)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackListRecord [userId=");
		builder.append(userId);
		builder.append(", banStart=");
		builder.append(banStart);
		builder.append(", banEnd=");
		builder.append(banEnd);
		builder.append("]");
		return builder.toString();
	}

}
