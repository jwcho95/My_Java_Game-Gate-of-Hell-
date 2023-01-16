package fourth_week_project;

public class Light_armor_upgrade_2 extends Light_armor_upgrade_1{
	String name = "네메아의 사자 가죽";
	Light_armor_upgrade_2(){
		this.defense = super.defense + 80;
		this.speed = super.speed + 40;
		this.weight = super.weight;
	}
}
