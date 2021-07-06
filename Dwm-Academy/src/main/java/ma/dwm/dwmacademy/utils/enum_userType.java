package ma.dwm.dwmacademy.utils;

public enum enum_userType {
	ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");
	
	private String role;
	
	private enum_userType(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return role;
	}
}
