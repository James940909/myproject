package model;

public class LoginBean {
	public boolean select(String uid) {
		// input: VO��ü
		// output: VO��ü
		// ���: login. select����� ���ٸ� null�� ��ȯ��
		if(uid.equals("kim")) {
			return true;
		}
		return false;
	}
}
