package org.comstudy21.myapp.saram;

public class SaramDto {
	private static int sequence = 0;
	private int idx;
	private String id;
	private String name;
	private String email;
	
	public SaramDto() {
		this(0, "","","");
	}

	public SaramDto(int idx, String id, String name, String email) {
		this.idx = idx;
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SaramDto [idx=" + idx + ", id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public static int nextSeq() {
		// TODO Auto-generated method stub
		return ++sequence;
	}

	@Override
	public int hashCode() {
		return idx;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SaramDto) {
			SaramDto dto = (SaramDto) obj;
			if(dto.getIdx() == idx) {
				return true;
			}
		}
		
		return false;
	}

	public void setData(SaramDto dto) {
		this.idx = dto.getIdx();
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
	}
	
}
