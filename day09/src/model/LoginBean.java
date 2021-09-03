package model;

public class LoginBean {
	public boolean select(String uid) {
		// input: VO객체
		// output: VO객체
		// 기능: login. select결과가 없다면 null이 반환됨
		if(uid.equals("kim")) {
			return true;
		}
		return false;
	}
}
