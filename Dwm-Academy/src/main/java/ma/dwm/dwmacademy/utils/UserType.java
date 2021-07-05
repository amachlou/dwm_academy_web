package ma.dwm.dwmacademy.utils;

public enum UserType {
	ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");
	
	private String role;
	
	private UserType(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return role;
	}
}
