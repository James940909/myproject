package model.totalmeal;

import java.util.Date;

public class TotalMealVO {
	private int t_num;
	private Date t_date;
	private String t_users;
	private Double t_daykcal;
	private Double t_userskcal;
	private String t_ox;
	
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	public String getT_users() {
		return t_users;
	}
	public void setT_users(String t_users) {
		this.t_users = t_users;
	}
	public Double getT_daykcal() {
		return t_daykcal;
	}
	public void setT_daykcal(Double t_daykcal) {
		this.t_daykcal = t_daykcal;
	}
	public Double getT_userskcal() {
		return t_userskcal;
	}
	public void setT_userskcal(Double t_userskcal) {
		this.t_userskcal = t_userskcal;
	}
	public String getT_ox() {
		return t_ox;
	}
	public void setT_ox(String t_ox) {
		this.t_ox = t_ox;
	}
	@Override
	public String toString() {
		return "TotalMealVO [t_num=" + t_num + ", t_date=" + t_date + ", t_users=" + t_users + ", t_daykcal="
				+ t_daykcal + ", t_userskcal=" + t_userskcal + ", t_ox=" + t_ox + "]";
	}
	
	
	

}
