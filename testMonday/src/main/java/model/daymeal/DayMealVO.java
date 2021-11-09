package model.daymeal;

public class DayMealVO {
	private int d_num;
	private String d_date;
	private String d_name;
	private String d_category;
	private Double d_weight;
	private Double d_userskcal;
	private int d_users;
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public String getD_category() {
		return d_category;
	}
	public void setD_category(String d_category) {
		this.d_category = d_category;
	}
	public Double getD_weight() {
		return d_weight;
	}
	public void setD_weight(Double d_weight) {
		this.d_weight = d_weight;
	}
	public Double getD_userskcal() {
		return d_userskcal;
	}
	public void setD_userskcal(Double d_userskcal) {
		this.d_userskcal = d_userskcal;
	}
	public int getD_users() {
		return d_users;
	}
	public void setD_users(int d_users) {
		this.d_users = d_users;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	@Override
	public String toString() {
		return "DayMealVO [d_num=" + d_num + ", d_date=" + d_date + ", d_name=" + d_name + ", d_category=" + d_category
				+ ", d_weight=" + d_weight + ", d_userskcal=" + d_userskcal + ", d_users=" + d_users + "]";
	}
	
	
	
	
	
	
	
	
}
