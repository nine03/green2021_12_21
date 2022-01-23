package org.comstudy21.saram.model;

import java.util.Objects;

public class SaramDto { // bin
	   private int no;
	   private String id;
	   private String name;
	   private int age;
	   
	   public SaramDto() { // 생성자 오버로딩
	      this(0,"","",0);
	   }

	   public SaramDto(int no, String id, String name, int age) {
	      this.no = no;
	      this.id = id;
	      this.name = name;
	      this.age = age;
	   }

	   public int getNo() {
	      return no;
	   }

	   public void setNo(int no) {
	      this.no = no;
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

	   public int getAge() {
	      return age;
	   }

	   public void setAge(int age) {
	      this.age = age;
	   }

	   @Override
	   public String toString() {
	      return String.format("%-4d%-10s%-15s%-10d",no,id,name,age);
	   }

	   @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + no;
	      return result;
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      SaramDto other = (SaramDto) obj;
	      if (no != other.no)
	         return false;
	      return true;
	   }
	}