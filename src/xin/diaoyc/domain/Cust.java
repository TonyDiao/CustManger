package xin.diaoyc.domain;

import java.sql.Date;

public class Cust {
	//�ͻ����
	private int id;
	//�ͻ�����
	private String name;
	//�ͻ��Ա�
	private String gender;
	//�ͻ�����
	private Date birthday;
	//�ͻ��绰����
	private String cellphone;
	//�ͻ��ʼ�
	private String email;
	//�ͻ�����
	private String preference;
	//�ͻ�����
	private String type;
	//�ͻ���ע
	private String description;
	public Cust(int id, String name, String gender, Date birthday, String cellphone, String email, String preference,
			String type, String description) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.cellphone = cellphone;
		this.email = email;
		this.preference = preference;
		this.type = type;
		this.description = description;
	}
	public Cust() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
