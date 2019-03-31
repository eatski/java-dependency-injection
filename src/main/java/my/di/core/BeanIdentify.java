package my.di.core;

public class BeanIdentify {
	
	public BeanIdentify(String specify, String type) {
		this.specify = specify;
		this.type = type;
	}
	
	private String specify;
	private String type;

	public String getSpecify() {
		return specify;
	}
	public String getType() {
		return type;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specify == null) ? 0 : specify.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BeanIdentify other = (BeanIdentify) obj;
		if (specify == null) {
			if (other.specify != null)
				return false;
		} else if (!specify.equals(other.specify))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
