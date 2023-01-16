package fourth_week_project;

public class Bow_upgrade_2 extends Bow_upgrade_1{
	String name = "전설의 활 아스트라";
	
	
	Bow_upgrade_2(){
		this.power = super.power + 80;
		this.speed = super.speed + 80;
		this.accuracy = super.accuracy + 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("활의 궁극오의인 일발백중을 시전하였습니다.");
	}
}
