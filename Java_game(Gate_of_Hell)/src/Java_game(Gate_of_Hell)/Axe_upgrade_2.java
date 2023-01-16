package fourth_week_project;

public class Axe_upgrade_2 extends Axe_upgrade_1{
	String name = "전설의 도끼 몰니야";
	Axe_upgrade_2(){
		this.power = super.power + 120;
		this.speed = super.speed + 20;
		this.accuracy = super.accuracy + 20;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("도끼의 궁극오의인 라그나로크를 시전하였습니다.");
	}
}
