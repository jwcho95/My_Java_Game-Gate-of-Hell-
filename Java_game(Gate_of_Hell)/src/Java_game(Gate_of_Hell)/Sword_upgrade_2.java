package fourth_week_project;

public class Sword_upgrade_2 extends Sword_upgrade_1{
	String name = "������ �� ����Į����";
	
	Sword_upgrade_2(){
		this.power = super.power + 100;
		this.speed = super.speed + 60;
		this.accuracy = super.accuracy + 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("���� �ñؿ����� �Ͻ��� �����Ͽ����ϴ�.");
		
	}
}
