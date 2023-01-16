package fourth_week_project;

public class Shield_upgrade_2 extends Shield_upgrade_1{
	String name = "전설의 방패 아이기스";
	int damage = 100; // 궁극기의 버프
	
	Shield_upgrade_2(){
		this.defense = super.defense + 40;
		this.speed = super.speed - 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("방패의 궁극오의인 로 아이아스를 시전하였습니다.");
		System.out.println("방어력이 "+this.damage+"만큼 상승하였습니다!\n");
	}
}
