package fourth_week_project;

public class Sword_upgrade_2 extends Sword_upgrade_1{
	String name = "전설의 검 엑스칼리버";
	
	Sword_upgrade_2(){
		this.power = super.power + 100;
		this.speed = super.speed + 60;
		this.accuracy = super.accuracy + 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("검의 궁극오의인 일심을 시전하였습니다.");
		
	}
}
