package model;

public class DataBeanTest {
	
	private String[] menu= {"아메리카노","카페라떼","카푸치노"};
	private int[] price= {2000,3000,4000};
	private int[] cnt= {0,1,2,3,4,5};
	public String[] getMenu() {
		return menu;
	}
	public int[] getPrice() {
		return price;
	}
	public int[] getCnt() {
		return cnt;
	}
	
	public int total(String name, int cnt) {
		int total=0;
		for(int i=0;i<menu.length;i++) {
			if(menu[i].equals(name)) {
				total=price[i]*cnt;
			}
		}
		return total;
		
	}
	
}
