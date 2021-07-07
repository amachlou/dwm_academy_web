package ma.dwm.dwmacademy.utils;

public enum Enum_userType {
	ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");
	
	private String role;
	
	private Enum_userType(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return role;
	}
}
