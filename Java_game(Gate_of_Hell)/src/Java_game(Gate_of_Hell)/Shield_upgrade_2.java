package fourth_week_project;

public class Shield_upgrade_2 extends Shield_upgrade_1{
	String name = "������ ���� ���̱⽺";
	int damage = 100; // �ñر��� ����
	
	Shield_upgrade_2(){
		this.defense = super.defense + 40;
		this.speed = super.speed - 10;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("������ �ñؿ����� �� ���̾ƽ��� �����Ͽ����ϴ�.");
		System.out.println("������ "+this.damage+"��ŭ ����Ͽ����ϴ�!\n");
	}
}
