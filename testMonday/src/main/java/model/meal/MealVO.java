package model.meal;

public class MealVO {
	
	private int m_num;
	private String m_name;
	private Double m_weight;
	private String m_unit;
	private Double m_kcal;
	private String searchName;
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
	public String getM_unit() {
		return m_unit;
	}
	public void setM_unit(String m_unit) {
		this.m_unit = m_unit;
	}
	public Double getM_weight() {
		return m_weight;
	}
	public void setM_weight(Double m_weight) {
		this.m_weight = m_weight;
	}
	public Double getM_kcal() {
		return m_kcal;
	}
	public void setM_kcal(Double m_kcal) {
		this.m_kcal = m_kcal;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	@Override
	public String toString() {
		return "MealVO [m_num=" + m_num + ", m_name=" + m_name + ", m_weight=" + m_weight + ", m_unit=" + m_unit
				+ ", m_kcal=" + m_kcal + ", searchName=" + searchName + "]";
	}
	
	
	
}
