package fourth_week_project;

public class Bow_upgrade_2 extends Bow_upgrade_1{
	String name = "������ Ȱ �ƽ�Ʈ��";
	
	
	Bow_upgrade_2(){
		this.power = super.power + 80;
		this.speed = super.speed + 80;
		this.accuracy = super.accuracy + 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("Ȱ�� �ñؿ����� �Ϲ߹����� �����Ͽ����ϴ�.");
	}
}
