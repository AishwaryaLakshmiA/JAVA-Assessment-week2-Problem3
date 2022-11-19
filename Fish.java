package Problem3;

import java.util.Random;

public class Fish{
	private String gender;
	private int fishId;
	public Fish(String gender, int fishId) {
		super();
		this.gender = gender;
		this.fishId = fishId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getFishId() {
		return fishId;
	}
	public void setFishId(int fishId) {
		this.fishId = fishId;
	}
	@Override
	public String toString() {
		return "Fish [gender=" + gender + ", fishId=" + fishId + "]";
	}
	
}
