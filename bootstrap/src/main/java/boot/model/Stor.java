package boot.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity(name="stores")
public class Stor implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stor_id")
	private int storId;
	@Column(name="stor_name", length=50)
	private String storName;
	@Column(length=50)
	private String state;
	@Column(name="stor_address")
	private String storAddress;
	@Column(length=50)
	private String city;
	
	public Stor() {
	this(0,"","","","");
	}

	public Stor(int storId, String storName, String state, String storAddress, String city) {
		super();
		this.storId = storId;
		this.storName = storName;
		this.state = state;
		this.storAddress = storAddress;
		this.city = city;
	}

	public int getStorId() {
		return storId;
	}

	public void setStorId(int storId) {
		this.storId = storId;
	}

	public String getStorName() {
		return storName;
	}

	public void setStorName(String storName) {
		this.storName = storName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStorAddress() {
		return storAddress;
	}

	public void setStorAddress(String storAddress) {
		this.storAddress = storAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Stor [storId=" + storId + ", storName=" + storName + ", state=" + state + ", storAddress=" + storAddress
				+ ", city=" + city + "]";
	}
	
	
	

}
