package fourth_week_project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.HashSet;
import java.awt.*;
import javax.swing.*;

public class Fourth_week_project extends Thread{
	/* 
	 ���� 
	 1. ���� ������
	 2. ���� �޼ҵ�
	 3. ���� ���࿡ ���Ǵ� �پ��� �޼ҵ�
		 
	 */
	
	
	
	
	
	/* 1. ���� ������ */
	
	/* �ý��ۿ� ���� ���� */
	static Scanner sc = new Scanner(System.in);
	static Scanner player_num = new Scanner(System.in);
	static Random rand = new Random(System.currentTimeMillis());
	static int thread_num = 1000; // ���Ǵ� �������� ����
	
	
	/* �÷��̾ ���� ���� */
	static int choice = 0; // �÷��̾��� ����
	static int skill_choice = 0; // �ڼ��� ���� ��ų ����
	static int damage = 0; // �÷��̾�� ���Ͱ� �޴� ������;
	static Character player = new Character(); // �÷��̾�
	static ArrayList<String> player_equipped_item = new ArrayList<String>(); // �÷��̾ ������ �ִ� ��� ������
	static ArrayList<String> player_potion = new ArrayList<String>(); // �÷��̾ ������ �ִ� ���� ������
	static Power_posture power_posture = new Power_posture(); // ���� �ڼ�
	static Defense_posture defense_posture = new Defense_posture(); // ��� �ڼ�
	static Speed_posture speed_posture = new Speed_posture(); // �ż� �ڼ�
	static int original_power = 0; // �ڼ� ���� �� ���ݷ�
	static int original_defense = 0; // �ڼ� ���� �� ����
	static int original_speed = 0; // �ڼ� ���� �� �ӵ�
	static int played = 0; // �ٽ� �����ϱ⸦ üũ�ϱ� ���� ����
	static boolean player_turn = true; // �÷��̾��� ���� üũ
	static boolean run = false; // �����ƴ����� Ȯ��
	static int reward = 0; // ���� �� ����
	static int event_num = 6; // �̺�Ʈ�� ����
	static boolean stage_1_clear = false; // �������� 1 Ŭ���� ����
	static boolean stage_2_clear = false; // �������� 2 Ŭ���� ����
	static String buffer = new String(); // �Է°��� �������� �޴� ����
	static boolean check_fight = false; // �������� �ƴ��� üũ
	static boolean check_finished = false; // �̾߱Ⱑ �������� Ȯ���ϰ� ������ ���Ḧ ���� ����
	static int poison_count = 0; // �� ������ ��� Ȯ��
	static int burn_count = 0; // ȭ�� ������ ��� Ȯ��
	static int ex_event_num = 0; // �̺�Ʈ �ߺ� ������ ���� ����
		
	/* ���Ϳ� ���� ���� */
	static int monster_num = 3; // ������ ����
	static Monster monster = new Monster();
	static Undead_monster undead = new Undead_monster(); // �𵥵�
	static Slime_monster slime = new Slime_monster(); // ������
	static Goblin_monster goblin = new Goblin_monster(); // ���
	static Ghost_monster ghost = new Ghost_monster(); // ��Ʈ
	static Troll_monster troll = new Troll_monster(); // Ʈ��
	static Griffin_monster griffin = new Griffin_monster(); // �׸���
	static Dragon_monster dragon = new Dragon_monster(); // �巡��
	static int help_baby_monster = 0; // ������ �����ִ� �̺�Ʈ�� ���� ���� : 0�� �⺻, 1�� ������ ��, 2�� �������� ���� ��
	static int dragon_played = 0; // ������ �ؽ�Ʈ �ӵ��� ���� ����
		
	/* ���࿡ ���� ���� */
	static boolean use_potion = false; // ���� ��뿩��
	static Hp_potion hp_potion = new Hp_potion(); // ü�� ����
	static Mp_potion mp_potion = new Mp_potion(); // ���� ����
	static Power_potion power_potion = new Power_potion(); // ���ݷ� ����
	static Defense_potion defense_potion = new Defense_potion(); // ���� ����
	static Speed_potion speed_potion = new Speed_potion(); // �ӵ� ����
	static Antidote antidote = new Antidote(); // �ص���
	static Antipyrotic antipyrotic = new Antipyrotic(); // ȭ�� ġ����
	
	/* ��� ���� ���� */
	static Sword sword = new Sword(); // �⺻ ��
	static Sword_upgrade_1 sword_upgrade_1 = new Sword_upgrade_1(); // �� ��ȭ 1�ܰ�
	static Sword_upgrade_2 sword_upgrade_2 = new Sword_upgrade_2(); // �� ��ȭ 2�ܰ�
	static Bow bow = new Bow(); // �⺻ Ȱ
	static Bow_upgrade_1 bow_upgrade_1 = new Bow_upgrade_1(); // Ȱ ��ȭ 1�ܰ�
	static Bow_upgrade_2 bow_upgrade_2 = new Bow_upgrade_2(); // Ȱ ��ȭ 2�ܰ�
	static Axe axe = new Axe(); // �⺻ ����
	static Axe_upgrade_1 axe_upgrade_1 = new Axe_upgrade_1(); // ���� ��ȭ 1�ܰ�
	static Axe_upgrade_2 axe_upgrade_2 = new Axe_upgrade_2(); // ���� ��ȭ 2�ܰ�
	static Light_armor light_armor = new Light_armor(); // �⺻ �氩
	static Light_armor_upgrade_1 light_armor_upgrade_1 = new Light_armor_upgrade_1(); // �氩 ��ȭ 1�ܰ�
	static Light_armor_upgrade_2 light_armor_upgrade_2 = new Light_armor_upgrade_2(); // �氩 ��ȭ 2�ܰ�
	static Heavy_armor heavy_armor = new Heavy_armor(); // �⺻ �߰�
	static Heavy_armor_upgrade_1 heavy_armor_upgrade_1 = new Heavy_armor_upgrade_1(); // �߰� ��ȭ 1�ܰ�
	static Heavy_armor_upgrade_2 heavy_armor_upgrade_2 = new Heavy_armor_upgrade_2(); // �߰� ��ȭ 2�ܰ�
	static Shoes shoes = new Shoes(); // �⺻ �Ź�
	static Shoes_upgrade_1 shoes_upgrade_1 = new Shoes_upgrade_1(); // �Ź� ��ȭ 1�ܰ�
	static Shoes_upgrade_2 shoes_upgrade_2 = new Shoes_upgrade_2(); // �Ź� ��ȭ 2�ܰ�
	static Shield shield = new Shield(); // �⺻ ����
	static Shield_upgrade_1 shield_upgrade_1 = new Shield_upgrade_1(); // ���� ��ȭ 1�ܰ�
	static Shield_upgrade_2 shield_upgrade_2 = new Shield_upgrade_2(); // ���� ��ȭ 2�ܰ�
	
	/* ������ ��ü ���� */
	static Monster_fight_thread[] monster_fight_thread = new Monster_fight_thread[thread_num]; // ���� ���� ������
	static Player_fight_thread[] player_fight_thread = new Player_fight_thread[thread_num]; // �÷��̾� ���� ������
	static Poison[] poison = new Poison[1000]; // �� ������
	static Burn[] burn = new Burn[1000]; // �� ������
	static int meet_monster = 0; // ���� �����带 ��� ������ ���� ����
	
	/* �̹��� ��ü ���� */
	static Base_Image castle_image = new Base_Image(); // �� �̹���
	static Undead_image undead_image = new Undead_image(); // �𵥵� �̹���
	static Slime_image slime_image = new Slime_image(); // ������ �̹���
	static Goblin_image goblin_image = new Goblin_image(); // ��� �̹���
	static Ghost_image ghost_image = new Ghost_image(); // ��Ʈ �̹���
	static Troll_image troll_image = new Troll_image(); // Ʈ�� �̹���
	static Griffin_image griffin_image = new Griffin_image(); // �׸��� �̹���
	static Dragon_image dragon_image = new Dragon_image(); // �巡�� �̹���
	static Bonfire_image bonfire_image = new Bonfire_image(); // �ε��� �̹���
	static Volcano_image volcano_image = new Volcano_image(); // ȭ�� �̹���
	static Monster_village_image monster_village_image = new Monster_village_image(); // �������� ���� �̹���
	static Hell_gate_image hell_gate_image = new Hell_gate_image(); // Ʈ�� ���� �̹���
	static Hell_gate_2_image hell_gate_2_image = new Hell_gate_2_image(); // �븻 ���� �̹���
	
	
	
	
	/* 2. ���� �޼ҵ� */
		
	public static void main(String[] args) {
		castle_image.setVisible(true);
		
		/* ���� ���丮 */
		System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
		System.out.println();
		make_slow(2);
		System.out.println("�� �ձ��� �־���.");
		make_slow(0);
		System.out.println("�ձ��� ���κ��� �� ���Ͽ� �ִ� ���� ��Ű�� ��ƿԾ���.");
		make_slow(0);
		System.out.println("��� ������ �� �ȿ� ���� ���� ������ �� �ȿ� ������ �ִ����� ������.");
		make_slow(0);
		System.out.println("���� �ձ� ���� �������� ��Ͽ� ������ �� ���� ������ ������ �ձ��� ������ ���̶�� ��ϵǾ����� ���̴�.\n");
		make_slow(0);
		System.out.println("�� �ձ����� �پ ���μ� �پ ���� ����� ����� �� ������ �����޾� �� ���� ��Ű��� ���� �ް� ���� �ϰ� �־���.");
		make_slow(0);
		System.out.println("�׷��� �Ź� �پ ������ ������ ����� �ñ��� ������� ���� �����ٴ� �˸����� ����� ���̷��� �Ͽ���.");
		make_slow(0);
		System.out.println("��Ű� ����� ���ϵ��� �׵��� �� ���� ���ð� �������� ���� �׷��� ������ ���Ҵ�.\n");
		make_slow(0);
		System.out.println("���� �̻��� ������ ���̶�� �����ߴ� ������� ���� ���� ���� � �ǹ����� ������.");
		make_slow(0);
		System.out.println("���� ������ ���� �� �ȿ� ����ִ� �������� ���� ������ ������ �����ߴ�.");
		make_slow(0);
		System.out.println("�������� ���� ������ ���ͼ� ��ġ�´�� �л��� �ϱ� �����ߴ�.");
		make_slow(0);
		System.out.println("�� �ȿ��� �������� �߰ſ� ���⿡ ���������� ������ �� ����� ���� �ݾƺ����� ����ߴ�.\n");
		make_slow(0);
		System.out.println("���� �ȿ��� ������ �ٶ� ������ ������ �ʾҰ� �ٶ��� ���� ���� ���� �ü��� �������� �� �ָ� �ٶ��� ���մ� ���� �־���.");
		make_slow(0);
		System.out.println("����� �� ������ ���ְ� ���� �ݱ�� ����Ͽ���.");
		make_slow(2);
		System.out.println();
		System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
		make_slow(0);
		castle_image.setVisible(false);
		player_potion.add(hp_potion.name);
		LoopStart: while(true) {
			/* ������ �����ϴ� ������ */
			while(true) {
				if(played == 0) {
					System.out.println("������ �����Ͻðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
					
				}else {
					player_init();
					System.out.println("������ �ٽ� �����Ͻðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
				}
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.println("����� �������� õõ�� �����ϴ�.\n");
					make_slow(0);
					if(played == 0) { // 1ȸ��
						while(true) {
							System.out.print("�÷��̾��� �̸��� �Է����ּ���(���� ���� �Է����ּ���): ");
							player.name = sc.next();
							buffer = sc.nextLine();
							if(player.name.length() > 5) {
								System.out.println("�̸��� �ʹ� ��ϴ�. �ٽ� �Է����ּ���.\n");
								continue;
							}else break;
						}
					}else if(played == 1){ // 2ȸ��
						System.out.println("���� ������ ���ϰ��� �ϴ� �ɷ�ġ�� �� �� ��ȭ�� �� �ֽ��ϴ�.");
						make_slow(2);
						System.out.println("������ �ɷ�ġ�� 50�� �ö󰩴ϴ�.");
						make_slow(2);
						System.out.println("� �ɷ�ġ�� ��ȭ�Ͻ� �ǰ���?\n[1. ���ݷ�]\n[2. ����]\n[3. �ӵ�]\n[4. ��ȭ���� �ʴ´�.]");
						choice = sc.nextInt();
						if(choice == 1) {
							System.out.println("=====================");
							System.out.println("���ݷ��� ��ȭ�Ǿ����ϴ�.");
							System.out.println("=====================\n");
							player.plus_power += 50;
						}else if(choice == 2) {
							System.out.println("=====================");
							System.out.println("������ ��ȭ�Ǿ����ϴ�.");
							System.out.println("=====================\n");
							player.plus_defense += 50;
						}else if(choice == 3) {
							System.out.println("=====================");
							System.out.println("�ӵ��� ��ȭ�Ǿ����ϴ�.");
							System.out.println("=====================\n");
							player.plus_speed += 50;
						}else {
							System.out.println("=====================");
							System.out.println("�ƹ��͵� ��ȭ���� �ʾҽ��ϴ�.");
							System.out.println("=====================\n");
						}
					}else { // ��ȸ��
						System.out.println("���ϰ��� �ϴ� �ɷ�ġ�� �� �� ��ȭ�� �� �ֽ��ϴ�.");
						make_slow(2);
						System.out.println("� �ɷ�ġ�� ��ȭ�Ͻ� �ǰ���?\n[1. ���ݷ�]\n[2. ����]\n[3. �ӵ�]\n[4. ��ȭ���� �ʴ´�.]");
						choice = sc.nextInt();
						if(choice == 1) {
							System.out.println("���ݷ��� ��ȭ�Ǿ����ϴ�.\n");
							player.plus_power += 50;
						}else if(choice == 2) {
							System.out.println("������ ��ȭ�Ǿ����ϴ�.\n");
							player.plus_defense += 50;
						}else if(choice == 3) {
							System.out.println("�ӵ��� ��ȭ�Ǿ����ϴ�.\n");
							player.plus_speed += 50;
						}else {
							System.out.println("�ƹ��͵� ��ȭ���� �ʾҽ��ϴ�.\n");
						}
					}
					break;
				}else if(choice == 2) {
					System.out.println("������ �������� ���� �ӵ��� �ձ��� �����ذ��� �׷��� �ձ��� ����Ͽ����ϴ�.");
					make_slow(0);
					System.out.println("\"����� �ձ��� �鼺���� �׿���...\"");
					make_slow(0);
					System.out.println("The End");
					System.exit(0);
				}else {
					System.out.print("�׷� �������� �����ϴ�.\n\n");
					continue;
				}
			}
			System.out.println();
			player.power = 10 + player.plus_power;
			player.defense = 10 + player.plus_defense;
			player.speed = 10 + player.plus_speed;
			
			make_slow(1);
			check_status();
			make_slow(1);
			
			/* Ʃ�丮�� */
			System.out.println();
			if(played == 0) {
				System.out.println("����� ���ݺ��� �� 3���� ���������� Ŭ�����ؾ��մϴ�.");
				make_slow(1);
				System.out.println("ĳ���Ϳ��Դ� 3������ �ڼ��� �ֽ��ϴ�.");
				make_slow(1);
				System.out.println("�ڼ��� ���� ��ų, ���ݷ�, ���� �׸��� �ӵ��� �޶����ϴ�.");
				make_slow(1);
				System.out.println("�˸��� �ڼ��� �̿��ؼ� ���� ����ġ����.\n");
				make_slow(1);
			}
			played++;
			
			while(true) {
				System.out.println("����� �ൿ�� �������ּ���.\n[1. ��� �����ϱ�]  [2. ����ϱ�]");
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.println("������� �����ϰڽ��ϴ�.\n");
					make_slow(2);
					System.out.println("����Ͻ� ���⸦ �������ּ���.\n[1. ��]  [2. Ȱ]  [3. ����]  [4. �������� �ʴ´�.]");
					choice = sc.nextInt();
					if(choice == 1) { // �� ����
						System.out.println("==============================");
						System.out.println(sword.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						sword.equipped = true;
						player_equipped_item.add(0,sword.name);
						player.power += sword.power;
						player.speed += sword.speed;
						player.weight += sword.weight;
						player.equiped_weapon_power = sword.power;
						player.equiped_weapon_speed = sword.speed;
						player.equiped_weapon_weight = sword.weight;
					}else if(choice == 2) { // Ȱ ����
						System.out.println("==============================");
						System.out.println(bow.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						bow.equipped = true;
						player_equipped_item.add(0,bow.name);
						player.power += bow.power;
						player.speed += bow.speed;
						player.weight += bow.weight;
						player.equiped_weapon_power = bow.power;
						player.equiped_weapon_speed = bow.speed;
						player.equiped_weapon_weight = bow.weight;
					}else if(choice == 3) { // ���� ����
						System.out.println("==============================");
						System.out.println(axe.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						axe.equipped = true;
						player_equipped_item.add(0,axe.name);
						player.power += axe.power;
						player.speed += axe.speed;
						player.weight += axe.weight;
						player.equiped_weapon_power = axe.power;
						player.equiped_weapon_speed = axe.speed;
						player.equiped_weapon_weight = axe.weight;
					}else {
						System.out.println("==============================");
						System.out.println("�ƹ� ���⵵ �������� �ʾҽ��ϴ�.");
						System.out.println("==============================\n");
						player_equipped_item.add(0, "���� ����");
					}
					make_slow(2);
					System.out.println("���� �����ϰڽ��ϴ�.\n");
					make_slow(2);
					System.out.println("����Ͻ� ���� �������ּ���.\n[1. �氩]  [2. �߰�]  [3. �������� �ʴ´�.]");
					choice = sc.nextInt();
					if(choice == 1) { // �氩 ����
						System.out.println("==============================");
						System.out.println(light_armor.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						light_armor.equipped = true;
						player_equipped_item.add(1,light_armor.name);
						player.defense += light_armor.defense;
						player.speed += light_armor.speed;
						player.weight += light_armor.weight;
						player.equiped_armor_defense = light_armor.defense;
						player.equiped_armor_speed = light_armor.speed;
						player.equiped_armor_weight = light_armor.weight;
					}else if(choice == 2) { // �߰� ����
						System.out.println("==============================");
						System.out.println(heavy_armor.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						heavy_armor.equipped = true;
						player_equipped_item.add(1, heavy_armor.name);
						player.defense += heavy_armor.defense;
						player.speed += heavy_armor.speed;
						player.weight += heavy_armor.weight;
						player.equiped_armor_defense = heavy_armor.defense;
						player.equiped_armor_speed = heavy_armor.speed;
						player.equiped_armor_weight = heavy_armor.weight;
					}else {
						System.out.println("==============================");
						System.out.println("�ƹ� ���� �������� �ʾҽ��ϴ�.");
						System.out.println("==============================\n");
						player_equipped_item.add(1, "���� ����");
					}
					make_slow(2);
					System.out.println("�Ź��� �����Ͻðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
					choice = sc.nextInt();
					if(choice == 1) { // �Ź� ����
						System.out.println("==============================");
						System.out.println(shoes.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						shoes.equipped = true;
						player_equipped_item.add(2, shoes.name);
						player.speed += shoes.speed;
						player.weight += shoes.weight;
						player.equiped_shoes_speed = shoes.speed;
						player.equiped_shoes_weight = shoes.weight;
					}else {
						System.out.println("==============================");
						System.out.println("����� �Ź߾��� �����ϱ�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						player_equipped_item.add(2, "�Ź� ����");
					}
					make_slow(2);
					System.out.println("���������� ���и� �������� �������ּ���.\n[1. ��]  [2. �ƴϿ�]");
					choice = sc.nextInt();
					if(choice == 1) { // ���� ����
						System.out.println("==============================");
						System.out.println(shield.name+"�� �����Ͽ����ϴ�.");
						System.out.println("==============================\n");
						shield.equipped = true;
						player_equipped_item.add(3, shield.name);
						player.equipped_shield = true;
						player.defense += shield.defense;
						player.speed += shield.speed;
						player.weight += shield.weight;
						player.equiped_shield_defense = shield.defense;
						player.equiped_shield_speed = shield.speed;
						player.equiped_shield_weight = shield.weight;
					}else {
						System.out.println("==============================");
						System.out.println("����� ���о��� �����ϱ�� �����߽��ϴ�.");
						System.out.println("==============================\n");
						player_equipped_item.add(3, "���� ����");
					}
					make_slow(1);
					System.out.println("��� ������ ��ģ ����� �������� ���� ������ ���ư����ϴ�.\n");
					break;
				}else {
					System.out.println("����� �������� ���� ������ ���ư����ϴ�.\n");
					break;
				}
			}
			make_slow(0);
			loading();
			make_slow(0);
			
			/* 1 �������� */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			make_slow(1);
			stage_break_time();
			
			
			
			/* 2 �������� */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			make_slow(1);
			stage_break_time();
			
			
			
			/* 3 �������� */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("����� ������ ���ư��� �� ���� ���߽��ϴ�.");
				make_slow(2);
				System.out.println("�׾�� �� ������ ����� ������ ���� ���� �ð��� ���� ���� �������� �ǵ����־����ϴ�.\n");
				make_slow(0);
				continue LoopStart;
			}else {
				check_finished = true;
				if(help_baby_monster == 1) {
					for(int i = 0; i < 50; i++) {
						System.out.println();
					}
					make_slow(0);
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
					make_slow(2);
					System.out.println("���� ���� ���� ����� ������ ������ ���Ϸ��� �� �� �Ʊ� �����־��� ���� �������� ��� ���� ���θ��ҽ��ϴ�.");
					make_slow(0);
					System.out.println("�Ʊ� �����־��� �������� �� ���� �������̾������ϴ�.");
					make_slow(0);
					System.out.println("���� ������� ���� ��õ��� �� �� ���� ���� ��ȭ�� �ϱ� �����߽��ϴ�.");
					make_slow(0);
					System.out.println("��ȭ�� ������ ���� ��� ����� �ٶ󺸴ٰ� ���� ���̸� ���縦 ǥ�߽��ϴ�.");
					make_slow(0);
					System.out.println("�׿� ���ÿ� ���� �ٶ��� ����Ű�� ���� ���߾����ϴ�.");
					make_slow(0);
					System.out.println("���� �ٶ��� ������ ��ȣ õ�簡 ����� ������ ������ �Խ��ϴ�.");
					make_slow(0);
					System.out.println("õ��� �뿡�� ������ ���� �ݰ� �� �̻� ������ �������� ���� ������ ���ϰ� �ش޶�� ��Ź�Ͽ����ϴ�.");
					make_slow(0);
					System.out.println("õ���� ���� �˾Ƶ��� ���� �����̴��� �׵�� �Բ� ������ ������ �����ϴ�.");
					make_slow(0);
					System.out.println("�� �տ��� ���� ������ ���� ũ�� ��� ¢���� ������ �� ���� �������� �������� ������ �����߽��ϴ�.");
					make_slow(0);
					System.out.println("����� �뿡�� ������ �λ縦 �� �� ���� �ݾҽ��ϴ�.");
					make_slow(0);
					hell_gate_image.setVisible(true);
					System.out.println("���� �����ڸ��� ��������鼭 ��������Ƚ��ϴ�.");
					make_slow(0);
					System.out.println("�� ��� �ҽ��� ���Ϸ� �տ��� ������ �� ���� ������� �̹� ��� �������� �׾���Ƚ��ϴ�.");
					make_slow(0);
					System.out.println("�� �ȿ����� ��Ÿ��� ��Ƴ��ұ⿡ �ձ��� ȥ���� �������Ѿ��߰� �Ǹ��ϰ� �س������ϴ�.");
					make_slow(0);
					System.out.println("�鼺���� �̷� ����� �ߴ��Ͽ� ���ο� ������ �÷Ƚ��ϴ�.");
					make_slow(0);
					System.out.println("�ձ��� �����μ� �ձ��� ��ȭ�Ӱ� �ٽ����� ���� ���� ����� �ӹ��Դϴ�.\n");
					make_slow(2);
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
					make_slow(0);
					System.out.println("True End");
					System.exit(0);
				}else {
					for(int i = 0; i < 50; i++) {
						System.out.println();
					}
					make_slow(0);
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
					make_slow(2);
					System.out.println("���� ���� ���� ����� ������ �������� ������ �������ϴ�.");
					make_slow(0);
					System.out.println("�� �Ҹ��� ������ ������ �����߰� ���� �̳� ȭ���� ��� ������ ���������ϴ�.");
					make_slow(0);
					System.out.println("���� ������� ȭ���� ���δ� �ż� �ٶ����� ������� õ���� ��ȣ ���� õõ�� ��������ϴ�.");
					make_slow(0);
					System.out.println("����� õ���� ��ȣ�� ������� ���� ���ѷ� ���������� ���ư����ϴ�.");
					make_slow(0);
					System.out.println("�׸��� ���� ���� �ݾҽ��ϴ�.");
					make_slow(0);
					hell_gate_2_image.setVisible(true);
					System.out.println("���� ������ ���� �����ִ� ���ڵ��� ���� ���鼭 \"ö��\"�Ҹ��� �������ϴ�.");
					make_slow(0);
					System.out.println("�� ���� �������� �� ���� ���ذ� �־����� �ձ��� ������� �������� ��κ� �����Ͽ����ϴ�.");
					make_slow(0);
					System.out.println("����� �տ��� �� ��� ��ǵ��� �����Ͽ��� ���� �� �ڵ��� ó���Ϸ� �Ͽ����ϴ�.");
					make_slow(0);
					System.out.println("�׷��� �̹� �׵��� ������ ���� �����鿡 ���� �׾��־����ϴ�.");
					make_slow(0);
					System.out.println("���� ���� �ݾ��� �Ϳ� �������ϸ� ��ſ��� ����Ͽ� ���� ������ ���� ��Ź�Ͽ����ϴ�.");
					make_slow(0);
					System.out.println("�׷��� ����� ���õ� ���� ��ŵ�ϴ�.");
					make_slow(0);
					System.out.println("�� ���� ���� �ٽ� �������� �𸣸�...\n");
					make_slow(2);
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
					make_slow(0);
					System.out.println("The End");
					System.exit(0);
				}
			}
			break;
		}
	}
	
	
	
	
	
	/* 3. ���� ���࿡ ���Ǵ� �پ��� �޼ҵ� */
	
	public static void player_init() { // �÷��̾��� ������ �ʱ�ȭ���ִ� �޼ҵ�
		player.health = 100;
		player.mana = 100;
		player.weight = 0;
		player.equipped_shield = false;
		player.money = 0;
		player_equipped_item.clear();
		player_potion.clear();
		player_potion.add(hp_potion.name);
		stage_1_clear = false;
		stage_2_clear = false;
		sword.equipped = false;
		sword_upgrade_1.equipped = false;
		sword_upgrade_2.equipped = false;
		bow.equipped = false;
		bow_upgrade_1.equipped = false;
		bow_upgrade_2.equipped = false;
		axe.equipped = false;
		axe_upgrade_1.equipped = false;
		axe_upgrade_2.equipped = false;
		light_armor.equipped = false;
		light_armor_upgrade_1.equipped = false;
		light_armor_upgrade_2.equipped = false;
		heavy_armor.equipped = false;
		heavy_armor_upgrade_1.equipped = false;
		heavy_armor_upgrade_2.equipped = false;
		shoes.equipped = false;
		shoes_upgrade_1.equipped = false;
		shoes_upgrade_2.equipped = false;
		shield.equipped = false;
		shield_upgrade_1.equipped = false;
		shield_upgrade_2.equipped = false;
		help_baby_monster = 0;
		player.ultimate_weapon = "����";
		player.ultimate_count = 1;
		ex_event_num = 0;
	}
	
	
	
	public static void choice_posture() { // �ڼ� ���� �޼ҵ�
		original_power = player.power;
		original_defense = player.defense;
		original_speed = player.speed;
		
		while(true) {
			System.out.println("=========================================");
			System.out.println();
			System.out.println("�ڼ��� �������ּ���.\n\n[1. ���� �ڼ� : ���ݷ��� ���������ִ� �ڼ�]\n[2. ��� �ڼ� : �޴� �������� �ٿ��ִ� �ڼ�]\n[3. �ż� �ڼ� : �ൿ �ӵ��� �����ִ� �ڼ�]");
			System.out.println();
			System.out.println("=========================================");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("==================================");
				System.out.println(power_posture.name+"�� �����Ͽ����ϴ�.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = power_posture.name;
				break;
			}else if(choice == 2) {
				System.out.println("==================================");
				System.out.println(defense_posture.name+"�� �����Ͽ����ϴ�.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = defense_posture.name;
				break;
			}else if(choice == 3) {
				System.out.println("==================================");
				System.out.println(speed_posture.name+"�� �����Ͽ����ϴ�.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = speed_posture.name;
				break;
			}else if(choice == 1004) { // ġƮ
				System.out.println("==================================");
				System.out.println("������ �����Ͽ����ϴ�.");
				System.out.println("==================================\n");
				player.posture_now = "����";
				break;
			}else 
				System.out.println("�׷� �ڼ��� �����ϴ�.\n");
		}
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void change_posture(int posture_num) { // �ڼ��� ���� ������ �ִ� �޼ҵ�
		switch(posture_num) {
		case 1: // ���� �ڼ�
			player.power += power_posture.power_plus;
			player.defense -= power_posture.defense_minus;
			player.speed -= power_posture.speed_minus;
			if(player.defense <= 0)
				player.defense = 0;
			if(player.speed <= 0)
				player.speed = 0;
			break;
		case 2: // ��� �ڼ�
			player.power -= defense_posture.power_minus;
			player.defense += defense_posture.defense_plus;
			player.speed -= defense_posture.speed_minus;
			if(player.power <= 0)
				player.power = 0;
			if(player.speed <= 0)
				player.speed = 0;
			break;
		case 1004: // ġƮ
			player.power = 1000;
			player.defense = 1000;
			player.speed = 1000;
			break;
		default: // �ż� �ڼ�
			player.power -= speed_posture.power_minus;
			player.defense -= speed_posture.defense_minus;
			player.speed += speed_posture.speed_plus;
			if(player.defense <= 0)
				player.defense = 0;
			if(player.power <= 0)
				player.power = 0;
			break;
		}
	}
	

	

	public static void return_posture() { // �ڼ��� �ǵ����� �޼ҵ�
		player.power = original_power;
		player.defense = original_defense;
		player.speed = original_speed;
	}

	

	
	public static void unequip_item(int num) { // ��� �����ϴ� �޼ҵ�
		if(num == 0) {
			player_equipped_item.remove(num);
			player.power -= player.equiped_weapon_power;
			player.speed -= player.equiped_weapon_speed;
			player.weight -= player.equiped_weapon_weight;
		}else if(num == 1) {
			player_equipped_item.remove(num);
			player.defense -= player.equiped_armor_defense;
			player.speed -= player.equiped_armor_speed;
			player.weight -= player.equiped_armor_weight;
		}else if(num == 2) {
			player_equipped_item.remove(num);
			player.speed -= player.equiped_shoes_speed;
			player.weight -= player.equiped_shoes_weight;
		}else {
			player_equipped_item.remove(num);
			player.defense -= player.equiped_shield_defense;
			player.speed -= player.equiped_shield_speed;
			player.weight -= player.equiped_shield_weight;
		}
	}
	


	public static void use_skill(int skill_num) { // �ڼ� ��ų�� ����ϴ� �޼ҵ�
		switch(skill_num) {
		case 1:
			player.mana -= 20;
			damage = player.power * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+power_posture.name+"�� ��ų�� �Ŀ� ������ ����߽��ϴ�.]\n");
			break;
		case 2:
			player.mana -= 20;
			damage = player.defense * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+defense_posture.name+"�� ��ų�� �ٵ� ������ ����߽��ϴ�.]\n");
			break;
		default:
			player.mana -= 20;
			damage = player.speed * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+speed_posture.name+"�� ��ų�� ���� ������ ����߽��ϴ�.]\n");
			break;
		}
	}
	


	public static void check_status() { // ���� ���¸� üũ���ִ� �޼ҵ�
		System.out.println("---------------- ���� ���� ----------------");
		player.status();
		System.out.print("���� ������ �ִ� ���: ");
		for(int i = 0; i < player_equipped_item.size(); i++) {
			System.out.print(player_equipped_item.get(i));
			if(i != player_equipped_item.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		Collections.sort(player_potion);
		System.out.print("���� ������ �ִ� ����: ");
		for(int i = 0; i < player_potion.size(); i++) {
			System.out.print(player_potion.get(i));
			if(i != player_potion.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
	}
	


	public static void event_or_fight(int num) { // ������������ �̺�Ʈ�� ������ ������
		if(stage_2_clear&&stage_1_clear) { // 3 ��������
			make_slow(1);
			choice_monster(rand.nextInt(monster_num)+1);
			fight();
		}else {
			if(num == 1) { // �̺�Ʈ
				make_slow(1);
				event(rand.nextInt(event_num)+1);
			}else { // ���Ϳ� ����
				make_slow(1);
				choice_monster(rand.nextInt(monster_num)+1);
				fight();
			}
		}
	}
	
	
	
	public static void choice_monster(int monster_num) { // ���� ���� �޼ҵ�
		int speed = 0;
		if(stage_2_clear&&stage_1_clear) {
			if(dragon_played >= 1) {
				speed = 2;
			}
			dragon_played++;
			make_slow(speed);
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println("�١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١�\n");
			System.out.println("                " + dragon.name+"\n");
			System.out.println("�١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١١�");
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�\n");
			dragon_image.setVisible(true);
			make_slow(speed);
			System.out.println("õ���� ��ȣ�� ������ �ٶ����� ���ĳ����ٺ��� ����� ȭ�� ����⿡ �����ϰ� �Ǿ����ϴ�.");
			make_slow(speed);
			System.out.println("�� ������ �������� ���� ���ϰ� �ϴ� ���� �ٶ��� ����Ű�� �־����ϴ�.");
			make_slow(speed);
			System.out.println("���� ũ��� �ָ��� �� ���ʹ� �ٸ��� �ʹ����� �ǽ��ϴ�.");
			make_slow(speed);
			System.out.println("�׷����� ����� ������ �� �������ϴ�.");
			make_slow(speed);
			System.out.println("���� ���� ���Ѵٸ� �ձ��� ����� ���� ���� �� ���� �����Դϴ�.");
			make_slow(speed);
			System.out.println("�е����� ũ�⿡ �η����� ���� ���α� ���������� �ڼ��� ���ٵ�� ���� �ٶ󺸾ҽ��ϴ�.");
			make_slow(speed);
			System.out.println("�� ���� õ���� ��ȣ�� ������ ���� �������� �����ϴ��� ����� ���� �ձ��� �����Ͽ����ϴ�.");
			make_slow(speed);
			System.out.println("���� ��鸮�� �ʴ� ������ ����� �ٶ󺸸� �̳� ������ �����߽��ϴ�.\n");
			make_slow(speed);
			dragon_image.setVisible(false);
			monster.name = dragon.name;
			monster.health = dragon.health;
			monster.max_health = dragon.max_health;
			monster.power = dragon.power;
			monster.defense = dragon.defense;
			monster.speed = dragon.speed;
			monster.accuracy = dragon.accuracy;
			monster.money = dragon.money;
		}else if(stage_1_clear) {
			if(monster_num == 1) { // ��Ʈ
				System.out.println(ghost.name+"�� �������ϴ�.\n");
				ghost_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + ghost.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				ghost_image.setVisible(false);
				monster.name = ghost.name;
				monster.health = ghost.health;
				monster.max_health = ghost.max_health;
				monster.power = ghost.power;
				monster.defense = ghost.defense;
				monster.speed = ghost.speed;
				monster.accuracy = ghost.accuracy;
				monster.money = ghost.money;
			}else if(monster_num == 2) { // Ʈ��
				System.out.println(troll.name+"�� �������ϴ�.\n");
				troll_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + troll.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				troll_image.setVisible(false);
				monster.name = troll.name;
				monster.health = troll.health;
				monster.max_health = troll.max_health;
				monster.power = troll.power;
				monster.defense = troll.defense;
				monster.speed = troll.speed;
				monster.accuracy = troll.accuracy;
				monster.money = troll.money;
			}else { // �׸���
				System.out.println(griffin.name+"�� �������ϴ�.\n");
				griffin_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + griffin.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				griffin_image.setVisible(false);
				monster.name = griffin.name;
				monster.health = griffin.health;
				monster.max_health = griffin.max_health;
				monster.power = griffin.power;
				monster.defense = griffin.defense;
				monster.speed = griffin.speed;
				monster.accuracy = griffin.accuracy;
				monster.money = griffin.money;
			}
		}else {
			if(monster_num == 1) { // �𵥵�
				System.out.println(undead.name+"�� �������ϴ�.\n");
				undead_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + undead.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				undead_image.setVisible(false);
				monster.name = undead.name;
				monster.health = undead.health;
				monster.max_health = undead.max_health;
				monster.power = undead.power;
				monster.defense = undead.defense;
				monster.speed = undead.speed;
				monster.accuracy = undead.accuracy;
				monster.money = undead.money;
			}else if(monster_num == 2) { // ���
				System.out.println(goblin.name+"�� �������ϴ�.\n");
				goblin_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + goblin.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				goblin_image.setVisible(false);
				monster.name = goblin.name;
				monster.health = goblin.health;
				monster.max_health = goblin.max_health;
				monster.power = goblin.power;
				monster.defense = goblin.defense;
				monster.speed = goblin.speed;
				monster.accuracy = goblin.accuracy;
				monster.money = goblin.money;
			}else { // ������
				System.out.println(slime.name+"�� �������ϴ�.\n");
				slime_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println();
				System.out.println("                             " + slime.name);
				System.out.println();
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				slime_image.setVisible(false);
				monster.name = slime.name;
				monster.health = slime.health;
				monster.max_health = slime.max_health;
				monster.power = slime.power;
				monster.defense = slime.defense;
				monster.speed = slime.speed;
				monster.accuracy = slime.accuracy;
				monster.money = slime.money;
			}
		}
		
		if(help_baby_monster == 2) { // ������ ���� �̺�Ʈ�� ���� ���� ����
			monster.power += 20;
		}
	}

	


	public static void choice_potion(String potion_name) { // ���� ���� �޼ҵ�
		if(potion_name.equals(hp_potion.name)) { // ü�� ����
			use_potion = true;
			if(player.health + hp_potion.hp >= 100)
				player.health = 100;
			else player.health += hp_potion.hp;
			player_potion.remove(hp_potion.name);
			player.weight -= hp_potion.weight;
			System.out.println(hp_potion.name+"�� ����߽��ϴ�.");
			System.out.println("ü���� "+hp_potion.hp+"��ŭ ȸ���Ǿ����ϴ�.\n");
		}else if(potion_name.equals(mp_potion.name)) { // ���� ����
			use_potion = true;
			if(player.mana + mp_potion.mp >= 100)
				player.mana = 100;
			else player.mana += mp_potion.mp;
			player_potion.remove(mp_potion.name);
			player.weight -= mp_potion.weight;
			System.out.println(mp_potion.name+"�� ����߽��ϴ�.");
			System.out.println("������ "+mp_potion.mp+"��ŭ ȸ���Ǿ����ϴ�.\n");
		}else if(potion_name.equals(power_potion.name)) { // ���ݷ� ����
			use_potion = true;
			player.power += power_potion.power;
			player_potion.remove(power_potion.name);
			player.weight -= power_potion.weight;
			System.out.println(power_potion.name+"�� ����߽��ϴ�.");
			System.out.println("���ݷ��� "+power_potion.power+" ����߽��ϴ�.\n");
		}else if(potion_name.equals(defense_potion.name)) { // ���� ����
			use_potion = true;
			player.defense += defense_potion.defense;
			player_potion.remove(defense_potion.name);
			player.weight -= defense_potion.weight;
			System.out.println(defense_potion.name+"�� ����߽��ϴ�.");
			System.out.println("������ "+defense_potion.defense+" ����߽��ϴ�.\n");
		}else if(potion_name.equals(speed_potion.name)) { // �ӵ� ����
			use_potion = true;
			player.speed += speed_potion.speed;
			player_potion.remove(speed_potion.name);
			player.weight -= speed_potion.weight;
			System.out.println(speed_potion.name+"�� ����߽��ϴ�.");
			System.out.println("�ӵ��� "+speed_potion.speed+" ����߽��ϴ�.\n");
		}else {
			System.out.println("�׷� ������ �����ϴ�.");
		}
	}
	
	
	
		
	public static void fight() { // ����
		choice_posture();
		change_posture(choice);
		if(player_potion.isEmpty() == false) {
			while(true) {
				System.out.print("���� ������ �ִ� ����: ");
				for(int i = 0; i < player_potion.size(); i++) {
					System.out.print(player_potion.get(i));
					if(i != player_potion.size() - 1)
						System.out.print(", ");
				}
				System.out.println();
				System.out.println("���� �� ����Ͻ� ������ �������ּ���.");
				HashSet<String> potion_list_temp = new HashSet<String>(player_potion); // ���� ���ý� �ߺ� ���Ÿ� ���� ����
				ArrayList<String> potion_list = new ArrayList<String>(potion_list_temp);
				Collections.sort(potion_list);
				
				for(int i = 0; i < potion_list.size(); i++) {
					System.out.println("["+(i+1)+". "+potion_list.get(i)+"]");
				}
				System.out.println("[0. �׸��ϱ�]");
				choice = sc.nextInt();
				if(choice == 0) {
					System.out.println();
					break;
				}else if(choice <= potion_list.size()) {
					choice_potion(potion_list.get(choice - 1));
					continue;
				}
				else {
					System.out.println("������ �ٽ� �������ּ���.\n"); 
					continue;
				}
			}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		monster_fight_thread[meet_monster] = new Monster_fight_thread();
		player_fight_thread[meet_monster] = new Player_fight_thread();
		check_fight = true;
		monster_fight_thread[meet_monster].start();
		player_fight_thread[meet_monster].start();
		
		try {
			monster_fight_thread[meet_monster].join();
		}catch(Exception e) {
				e.printStackTrace();
		}

		if(monster.health <= 0) {
			if(monster.name.equals(dragon.name)) {
				make_slow(2);
				System.out.println(monster.name+"��(��) �׾����ϴ�.\n");
			}else {
				reward = rand.nextInt(monster.money) + 1;
				make_slow(2);
				System.out.println(monster.name+"��(��) �׾����ϴ�.");
				make_slow(2);
				System.out.println("�������� ��ȭ "+reward+"���� ������ϴ�.\n");
				player.money += reward;
			}
		}
		check_fight = false;
		meet_monster++;
		return_posture();
		if(monster.name.equals(dragon.name) && monster.health <= 0) {
			check_finished = true;
		}
		monster.health = monster.max_health;
		run = false;
		if(player.burned && player_potion.contains(antipyrotic.name) && check_finished == false) {
			System.out.println("ȭ�� ġ������ ����ұ��? \n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("["+antipyrotic.name+"�� ����Ͽ����ϴ�.]\n");
				player_potion.remove(antipyrotic.name);
				player.burned = false;
			}
		}else if(player.posioned && player_potion.contains(antidote.name) && check_finished == false) {
			System.out.println("�ص����� ����ұ��? \n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("["+antidote.name+"�� ����Ͽ����ϴ�.]\n");
				player_potion.remove(antidote.name);
				player.posioned = false;
			}
		}
		make_slow(1);
	}
	
	
	
	
	public static void player_fight() { // �÷��̾��� ���� �ൿ
		int can_run = 40; // ����ĥ �� �ִ� Ȯ��
		while(true) {
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?");
			System.out.println("1. �����ϱ�\n2. ��ų ����ϱ�(���� 20 �Ҹ�)\n3. ���� ����ϱ�\n4. ����ġ��");
			choice = sc.nextInt();
			if(choice == 1) {
					System.out.println(monster.name+"��(��) �����߽��ϴ�.\n");
					damage = player.power - monster.defense;
					if(damage < 0) {
						damage = 1;
						monster.health -= damage;
					}
					else monster.health -= damage;
					System.out.println(monster.name+"���� "+damage+"��ŭ�� ���ظ� �������ϴ�.\n");
					player_turn = false;
					break;
				
			}else if(choice == 2) {
				System.out.println("��ų�� �������ּ���.");
				if(player.equipped_shield) { // ���и� ������ ���
					System.out.println("1. ���� ��ų (���� 10 �Ҹ�)");
					System.out.println("2. �ڼ� ��ų (���� 20 �Ҹ�)");
					if((sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1) {
						System.out.println("3. �ñر�(���� 30 �Ҹ�, �� �� ���� ��� �����մϴ�.)");
					}
					System.out.println("0. �ڷ�");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice == 3 && (sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1){ // �ñر� ���
						if(player.mana < 30) {
							System.out.println("��ų�� ����� ������ �����մϴ�.\n");
							continue;
						}else {
							if(shield_upgrade_2.equipped) { // ������ �ñر� ����
								System.out.println("�ñر⸦ �������ּ���.\n1. ������ �ñر�\n2. ������ �ñر�\n0. �ڷ�");
								choice = sc.nextInt();
								if(choice == 0) {
									System.out.println();
									continue;
								}else if(choice == 1) { // ������ �ñر�
									if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // ���� �ñر�
										sword_upgrade_2.skill();
										System.out.println(monster.name+"���� "+sword_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
										monster.health -= sword_upgrade_2.skill_damage;
									}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // Ȱ�� �ñر�
										bow_upgrade_2.skill();
										System.out.println(monster.name+"���� "+bow_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
										monster.health -= bow_upgrade_2.skill_damage;
									}else { // ������ �ñر�
										axe_upgrade_2.skill();
										System.out.println(monster.name+"���� "+axe_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
										monster.health -= axe_upgrade_2.skill_damage;
									}
									player.mana -= 30;
									player.ultimate_count--;
									player_turn = false;
									break;
								}else { // ������ �ñر�
									shield_upgrade_2.skill();
									player.defense += shield_upgrade_2.damage;
									player.mana -= 30;
									player.ultimate_count--;
									player_turn = false;
									break;
								}
							}else { // ���д� ��ȭ 2�ܰ谡 �ƴ� ���
								if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // ���� �ñر�
									sword_upgrade_2.skill();
									System.out.println(monster.name+"���� "+sword_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
									monster.health -= sword_upgrade_2.skill_damage;
								}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // Ȱ�� �ñر�
									bow_upgrade_2.skill();
									System.out.println(monster.name+"���� "+bow_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
									monster.health -= bow_upgrade_2.skill_damage;
								}else { // ������ �ñر�
									axe_upgrade_2.skill();
									System.out.println(monster.name+"���� "+axe_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
									monster.health -= axe_upgrade_2.skill_damage;
								}
								player.mana -= 30;
								player.ultimate_count--;
								player_turn = false;
								break;
							}
						}
					}else if(choice == 1) {
						if(player.mana < 10) {
							System.out.println("��ų�� ����� ������ �����մϴ�.\n");
							continue;
						}else {
							
						}
					}else if(choice == 2){
						if(player.mana < 20) {
							System.out.println("��ų�� ����� ������ �����մϴ�.\n");
							continue;
						}else {
								use_skill(skill_choice);
								player_turn = false;
								break;
							
						}
					}else {
						System.out.println("��ų�� �ٽ� �������ֽʽÿ�.\n");
						continue;
					}
				}else {
					System.out.println("1. �ڼ� ��ų (���� 20 �Ҹ�)");
					if((sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1) {
						System.out.println("2. �ñر�(���� 30 �Ҹ�, �� �� ���� ��� �����մϴ�.)");
					}
					System.out.println("0. �ڷ�");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice == 2 && (sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped) && player.ultimate_count == 1) { // �ñر� ���
						if(player.mana < 30) {
							System.out.println("��ų�� ����� ������ �����մϴ�.\n");
							continue;
						}else {
							if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // ���� �ñر�
								sword_upgrade_2.skill();
								System.out.println(monster.name+"���� "+sword_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
								monster.health -= sword_upgrade_2.skill_damage;
							}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // Ȱ�� �ñر�
								bow_upgrade_2.skill();
								System.out.println(monster.name+"���� "+bow_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
								monster.health -= bow_upgrade_2.skill_damage;
							}else { // ������ �ñر�
								axe_upgrade_2.skill();
								System.out.println(monster.name+"���� "+axe_upgrade_2.skill_damage+"��ŭ�� ���ظ� �������ϴ�!\n");
								monster.health -= axe_upgrade_2.skill_damage;
							}
							player.mana -= 30;
							player.ultimate_count--;
							player_turn = false;
							break;
						}
					}else if(choice == 1) {
						if(player.mana < 20) {
							System.out.println("��ų�� ����� ������ �����մϴ�.\n");
							continue;
						}else {
								use_skill(skill_choice);
								player_turn = false;
								break;
							
						}
					}else {
						System.out.println("��ų�� �ٽ� �������ֽʽÿ�.\n");
						continue;
					}
				}
			}else if(choice == 3) { // ���� ����ϱ�
				if(player_potion.size() == 0) {
					System.out.println("���� ������ �ִ� ������ �����ϴ�.\n");
					continue;
				}else {
					System.out.print("���� ������ �ִ� ����: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("����ϰ� ���� ������ �������ּ���.");
					
					HashSet<String> potion_list_temp = new HashSet<String>(player_potion); // ���� ���ý� �ߺ� ���Ÿ� ���� ����
					ArrayList<String> potion_list = new ArrayList<String>(potion_list_temp);
					Collections.sort(potion_list);
					
					for(int i = 0; i < potion_list.size(); i++) {
						System.out.println((i+1)+". "+potion_list.get(i));
					}
					System.out.println("0. �ڷ�");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice <= potion_list.size())
						choice_potion(potion_list.get(choice - 1));
					else {
						System.out.println("������ �ٽ� �������ּ���.\n"); 
						continue;
					}
					
					if(use_potion) {
						use_potion = false;
						player_turn = false;
						break;
					}else continue;
					
				}
			}else {
				if(monster.name.equals(dragon.name)) {
					System.out.println("����ġ���� �ڷ� ���Ƽ� ���� ���� �߿� ���ϰ� �¾ҽ��ϴ�.");
					System.out.println("ü���� 99��ŭ ���������ϴ�.\n");
					player.health -= 99;
					if(player.health < 0) {
						player.health = 0;
						break;
					}
					continue;
				}else if(rand.nextInt(100) >= can_run) {
					System.out.println(monster.name+"(��)�κ��� �����ƽ��ϴ�.\n");
					run = true;
					break;
				}else {
					System.out.println("����ġ�� ���߽��ϴ�.\n");
					player_turn = false;
					break;
				}
			}
		}
	}
	
	
	
	
	public static void monster_fight() { // ������ ���� �ൿ
		if(rand.nextInt(100) < monster.accuracy) {
			if(rand.nextInt(100) < monster.skill_persent) { // ���Ͱ� ��ų�� ���
				monster_skill(monster.name);
			}else { // ������ �Ϲ� ����
				damage = monster.power - player.defense;
				if(damage < 0) {
					damage = 1;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(monster.name + "��(��) �����߽��ϴ�.");
				System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
			}
		}else {
			System.out.println(monster.name + "�� ������ ���������ϴ�.\n");
		}
		player_turn = true;
	}
	
	
	
	
	public static void monster_skill(String monster_name) { // ���� ��ų
		int skill_num = 0; // �巡���� ��ų ������ ���� ����
		
		if(monster_name.equals(undead.name)) { // �𵥵�
			undead.skill();
			damage = undead.power/2*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
		}else if(monster_name.equals(slime.name)) { // ������
			slime.skill();
			damage = 10;
			monster.defense += damage;
			System.out.println(slime.name+"�� ������ "+damage+" �����߽��ϴ�.\n");
		}else if(monster_name.equals(goblin.name)) { // ���
			goblin.skill();
			damage = monster.speed/4*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
		}else if(monster_name.equals(ghost.name)) { // ��Ʈ
			ghost.skill();
			damage = player.power/2;
			player.health -= damage;
			System.out.println(ghost.name+"���� Ȧ���� �ڱ� �ڽ��� �����߽��ϴ�.\n");
		}else if(monster_name.equals(troll.name)) { // Ʈ��
			troll.skill();
			damage = monster.defense/4*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
		}else if(monster_name.equals(griffin.name)) { // �׸���
			griffin.skill();
			damage = monster.speed - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
		}else { // �巡��
			skill_num = rand.nextInt(2) + 1;
			if(skill_num == 1) {
				dragon.skill_1();
				damage = monster.power/2*(rand.nextInt(3)+1) - player.defense;
				if(damage < 0) {
					damage = 2;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
			}else {
				dragon.skill_2();
				damage = (monster.power + monster.speed) / (rand.nextInt(3)+1) - player.defense;
				if(damage < 0) {
					damage = 2;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.\n");
			}
		}
	}
	
	
	
	
	public static void print_fight() { // ���� ��Ȳ�� ������
		/*if(player_turn) {
			if(player.health < 0) {
				player.health = 0;
			}
			if(monster.health < 0) {
				monster.health = 0;
			}
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println();
			System.out.printf("���� ��: %s\n", player.name);
			System.out.printf("���� ��:                                                   %s\n", monster.name);
			System.out.println();
			System.out.printf("ü��: %3d / 100                                     ü��: %3d / %3d\n", player.health, monster.health, monster.max_health);
			System.out.printf("����: %3d / 100\n", player.mana);
			System.out.printf("���ݷ�: %3d                                        ���ݷ�: %3d\n", player.power, monster.power);
			System.out.printf("����: %3d                                        ����: %3d\n", player.defense, monster.defense);
			System.out.printf("�ӵ�:  %3d                                         �ӵ�: %3d\n", player.speed, monster.speed);
			System.out.println("���� �ڼ�: "+player.posture_now);
			System.out.println();
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println();			
		}else {
			if(player.health < 0) {
				player.health = 0;
			}
			if(monster.health < 0) {
				monster.health = 0;
			}
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println();
			System.out.printf("���� ��:                                                   %s\n", monster.name);
			System.out.printf("���� ��: %s\n", player.name);
			System.out.println();
			System.out.printf("ü��: %3d / 100                                     ü��: %3d / %3d\n", player.health, monster.health, monster.max_health);
			System.out.printf("����: %3d / 100\n", player.mana);
			System.out.printf("���ݷ�: %3d                                        ���ݷ�: %3d\n", player.power, monster.power);
			System.out.printf("����: %3d                                        ����: %3d\n", player.defense, monster.defense);
			System.out.printf("�ӵ�:  %3d                                         �ӵ�: %3d\n", player.speed, monster.speed);
			System.out.println("���� �ڼ�: "+player.posture_now);
			System.out.println();
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println();
		}*/
		
		if(player.health < 0) {
			player.health = 0;
		}
		if(monster.health < 0) {
			monster.health = 0;
		}
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("<"+player.name+">");
		System.out.print("ü��: ");
		for(int i = 0; i < player.health/10; i++) {
			System.out.print("�� ");
		}
		System.out.printf(" (%d / 100)", player.health);
		System.out.println();
		System.out.print("����: ");
		for(int i = 0; i < player.mana/20; i++) {
			System.out.print("�� ");
		}
		System.out.printf(" (%d / 100)", player.mana);
		System.out.println();
		System.out.println("���� �ڼ�: "+player.posture_now);
		System.out.print("���� ������ �ִ� ���: ");
		for(int i = 0; i < player_equipped_item.size(); i++) {
			System.out.print(player_equipped_item.get(i));
			if(i != player_equipped_item.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		Collections.sort(player_potion);
		System.out.print("���� ������ �ִ� ����: ");
		for(int i = 0; i < player_potion.size(); i++) {
			System.out.print(player_potion.get(i));
			if(i != player_potion.size() - 1)
				System.out.print(", ");
		}
		System.out.println("\n");
		System.out.println("<"+monster.name+">");
		System.out.print("ü��: ");
		for(int i = 0; i < monster.health/20; i++) {
			System.out.print("�� ");
		}
		System.out.printf(" (%d / %d)\n\n", monster.health, monster.max_health);
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("�÷��̾��� �ൿ�� ������ Ÿ�ֿ̹� ��������.\n[1. �����ϱ�], [2. ��ų ����ϱ�], [3. ȸ���ϱ�], [4. ����], [5. ü�� ���� �Ա�], [6. ���� ���� �Ա�], [7. �ص��� �� ȭ�� ġ���� �Ա�]\n");
	}
	
	
	
	public static void event(int num) { // �̺�Ʈ
		int random_num = 0; // ����� ���� ���� ����
		
		make_slow(1);
		if(num == 1 && ex_event_num != 1) { // ������ ��ü �̺�Ʈ
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("����� ���� �� ������� ������� �ο��� ������� ���ʱ����� �߰��Ͽ����ϴ�.");
			make_slow(2);
			System.out.println("Ȳ���� ���� ��� ���� �귯�����淡 ����� ���� ���� �ٰ������ϴ�.");
			make_slow(2);
			System.out.println("����Ե� ���� �귯������ ���� ��� ������ ��ü ���� �����ִ� ������ �� ��ü�����ϴ�.");
			make_slow(2);
			System.out.println("������ �� ��ü�� ������ ���� �������� ����� �����ֱ⸦ �ٶ�� �ֽ��ϴ�.");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("���ðڽ��ϱ�? \n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) { // ������ ��ü �̺�Ʈ
				random_num = rand.nextInt(10)+1;
				if(random_num < 5) { // ���� ���
					System.out.println("������ ��ü�� ����Ų ����� ������ ���� ���� ���� ���������ϴ�.");
					make_slow(2);
					System.out.println("����� ü�°� ������ ����á���ϴ�.\n");
					make_slow(1);
					player.health = 100;
					player.mana = 100;
				}else {
					System.out.println("������ ��ü�� ����Ų ����� �� �ȿ��� �����ΰ� �߸��Ǵ� ���� �������ϴ�.");
					make_slow(2);
					System.out.println("���ο��ϸ鼭 �������� �� �� �ָ��� ���� �ִ� ���� �������� ����� �������ϴ�.");
					make_slow(2);
					System.out.println("����� ü���� 20�� �پ������ϴ�.\n");
					make_slow(1);
					player.health -= 20;
				}
			}else {
				System.out.println("\'���������� �𸣴� ��ü�� �Ժη� ���ø� �ȵ���.\'");
				make_slow(2);
				System.out.println("�̷��� ������ ����� ��ü���� ������ ���� �����ϰ� �ٽ� ������ ���ư����ϴ�.\n");
				make_slow(1);
			}
			ex_event_num = 1;
		}else if(num == 2 && ex_event_num != 2) { // ���ƿ� �� �̺�Ʈ
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("���� ���� ���ư��� �� ���ڱ� ������ ���� ���ƿ� �Ӹ��� ������ϴ�.");
			make_slow(2);
			System.out.println("�� �׷��� ���絥 ���� ������ ���� ���ƿ��� ¥���� �ö�Խ��ϴ�.");
			make_slow(2);
			System.out.println("ȭ�� �� ����� ���� ���ƿ� ������ �Ѿư��� ����� �Ͽ����ϴ�. ");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("�Ѿư��ðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				System.out.println("���� ���ƿ� ������ �޷����� �� �ֺ����� �������� Ƣ��� ������ �Ͽ����ϴ�.");
				make_slow(2);
				System.out.println("�ƹ����� ������ ���� �� �����ϴ�.");
				make_slow(2);
				if(random_num < 30) {
					System.out.println("���۽����� ���������� ������ �ο� ����� �������� ��� �����ƽ��ϴ�.");
					make_slow(2);
					System.out.println("�������� �������� ������ ��� ����� �˾Ƴ������ϴ�.");
					make_slow(2);
					System.out.println("������ 50 �����߽��ϴ�.\n");
					make_slow(1);
					player.defense += 50;
				}else {
					System.out.println("������ ���� ���� �ܿ� �����ƽ��ϴ�.");
					make_slow(2);
					System.out.println("������ ����ġ�� ���� ū �λ��� �Ծ����ϴ�.");
					make_slow(2);
					System.out.println("ü���� 30 �پ����ϴ�.\n");
					make_slow(1);
					player.health -= 30;
				}
			}else {
				System.out.println("\"� ���� �ٶ��� ������ϴµ� �̷� ���� �Ű澵 �� ����.\"");
				make_slow(2);
				System.out.println("�ö���� ȭ�� ���� ���� �ٶ󺸸� ���ư����ϴ�.\n");
				make_slow(1);
			}
			ex_event_num = 2;
		}else if(num == 3 && ex_event_num != 3){ // �������� ����
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("��Ÿ�� �ִ� ������ �� �տ� ���Դϴ�.");
			make_slow(2);
			System.out.println("������ �ٰ����� �������� �ƹ��� ���� �� �����ϴ�.");
			make_slow(2);
			System.out.println("����� Ȥ�ó� ������ ������ ���� ������ �Ͽ� ���� ������ �ѷ����ҽ��ϴ�.");
			make_slow(2);
			System.out.println("�쿬�� �� ���� ������ ���غ��̴� ���ڰ� �־����ϴ�.");
			make_slow(2);
			System.out.println("���ڸ� ���� ���� ���� ���� �� �����ϴ�.");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("���ڸ� ���ðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("���ڸ� õõ�� ����� �ȿ��� �� ���� ��ȭ�� �־����ϴ�.");
					make_slow(2);
					System.out.println("���� ������� ��ȭ���� �ָӴϿ� �־����ϴ�.");
					make_slow(2);
					System.out.println("��ȭ 100���� ������ϴ�.\n");
					make_slow(1);
					player.money += 100;
				}else if(random_num < 90) {
					System.out.println("���ڸ� ���� �������� �ƹ��� ���ǵ� �������ϴ�.");
					make_slow(2);
					System.out.println("�Ǹ��� �������� ������ �������ϴ�.\n");
					make_slow(1);
				}else {
					System.out.println("���ڸ� õõ�� ����� �ȿ� ����Ǿ� �ִ� ���ְ� ���Խ��ϴ�.");
					make_slow(2);
					System.out.println("���ֿ� ���� ����� ���뽺���� �����ɾҽ��ϴ�.");
					make_slow(2);
					System.out.println("���ݷ�, ����, �ӵ��� ���� 10�� �پ��ϴ�.\n");
					make_slow(1);
					player.power -= 10;
					player.defense -= 10;
					player.speed -= 10;
					if(player.power < 0)
						player.power = 0;
					if(player.defense < 0)
						player.defense = 0;
					if(player.speed < 0)
						player.speed = 0;
				}
			}else {
				System.out.println("������ ���������� ���� �ǵ��� �ʴ� ���� ���� ���̶� �Ǵ��߽��ϴ�.");
				make_slow(2);
				System.out.println("���ڸ� �������ΰ� ������ ���Խ��ϴ�.\n");
				make_slow(1);
			}
			ex_event_num = 3;
		}else if(num == 4 && ex_event_num != 4) { // ������ ��
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("������ �ɾ�� ����� �谡 �������� �����߽��ϴ�.");
			make_slow(2);
			System.out.println("���� ���� ���� �ѷ����ٰ� �� �ָ� ��ó�� ���̴� ���� �־ �ٰ������ϴ�.");
			make_slow(2);
			System.out.println("���� ũ�Ⱑ ����˰� ���� ũ�� ���� ������� ��� �ִ� ������ ���� ������ ���� �� �����ϴ�.");
			make_slow(2);
			System.out.println("������ ���̶� � ���� �������� �𸨴ϴ�.");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("���� �������?\n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("������ ���̶� ������ �ϸ鼭 �丮�� �ߴµ� ���� ������ �ʾҽ��ϴ�.");
					make_slow(2);
					System.out.println("�׷��� �������� �ʾ� ���� ���������� �� ���� ������ ��� ���� ���� ���� ���س������ϴ�.");
					make_slow(2);
					System.out.println("������ �Կ�� ���� ����� ������ �������� ������ ������ ���� �������ϴ�.");
					make_slow(2);
					System.out.println("������ 20 �پ��ϴ�.\n");
					make_slow(1);
					player.mana -= 20;
					if(player.mana < 0)
						player.mana = 0;	
				}else {
					System.out.println("������ ���̶� ������ �ϸ鼭 �丮�� �ߴµ� ���� ������ �������� �����鼭 ������ �游������ ���� �������ϴ�.");
					make_slow(2);
					System.out.println("������ ���� á���ϴ�.\n");
					make_slow(1);
					player.mana = 100;
				}
			}else {
				random_num = rand.nextInt(100);
				System.out.println("� ���� �������� �𸣱⿡ ���� �ʰ� ����ġ��� �Ͽ����ϴ�.");
				make_slow(2);
				if(random_num < 80) {
					System.out.println("��⸦ �޷��� ���ؼ� ü���� 10 ���������ϴ�.\n");
					player.health -= 10;
				}else {
					System.out.println("�谡 ���� �ָӴϸ� �������� ���� ���� ������ �־ �װ����� ��⸦ �޷����ϴ�.\n");
				}
				make_slow(1);
			}
			ex_event_num = 4;
		}else if(num == 5 && help_baby_monster == 0) { // ������ ���� �̺�Ʈ
			random_num = rand.nextInt(50)+1;
			System.out.println("���� ������ �������ϴ�.");
			make_slow(1);
			while(true) {
				System.out.println("�ڼ��� �������ּ���.\n\n[1. ���� �ڼ� : ���ݷ��� ���������ִ� �ڼ�]\n[2. ��� �ڼ� : �޴� �������� �ٿ��ִ� �ڼ�]\n[3. �ż� �ڼ� : �ൿ �ӵ��� �����ִ� �ڼ�]\n[4. �ڼ��� ������ �ʱ�]");
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.printf("����� %s�� ���ϰ� ������ ���� ������ �׿����ϴ�.\n", power_posture.name);
					make_slow(2);
					System.out.println("���� ������ �׾����ϴ�.");
					make_slow(2);
					System.out.println("�������� ��ȭ "+random_num+"���� ������ϴ�.");
					make_slow(2);
					System.out.println("���� ������ �������� ��� �������� �г��Ͽ����ϴ�.");
					make_slow(2);
					System.out.println("������ ��� �������� ���ݷ��� 20�� �����ϴ�.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 2) {
					System.out.printf("����� %s�� ���ϰ� õõ�� ���� ������ �׿����ϴ�.\n", defense_posture.name);
					make_slow(2);
					System.out.println("���� ������ �׾����ϴ�.");
					make_slow(2);
					System.out.println("�������� ��ȭ "+random_num+"���� ������ϴ�.");
					make_slow(2);
					System.out.println("���� ������ �������� ��� �������� �г��Ͽ����ϴ�.");
					make_slow(2);
					System.out.println("������ ��� �������� ���ݷ��� 20�� �����ϴ�.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 3) {
					System.out.printf("����� %s�� ���ϰ� ������ ���� ������ �׿����ϴ�.\n", speed_posture.name);
					make_slow(2);
					System.out.println("���� ������ �׾����ϴ�.");
					make_slow(2);
					System.out.println("�������� ��ȭ "+random_num+"���� ������ϴ�.");
					make_slow(2);
					System.out.println("���� ������ �������� ��� �������� �г��Ͽ����ϴ�.");
					make_slow(2);
					System.out.println("������ ��� �������� ���ݷ��� 20�� �����ϴ�.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 4) {
					System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
					System.out.println();
					make_slow(2);
					System.out.println("�ڼ��� ������ �ʰ� ������ ���� ���� ������ �ٶ󺸴� �� ������ ��ġ �ڽ��� �������� ���� �ൿ�� �Ͽ����ϴ�.");
					make_slow(2);
					System.out.println("�� �ൿ�� �ſ� ���غ��� ����� ������ ���� ���ҽ��ϴ�.");
					make_slow(2);
					System.out.println("������ ������ ������ �־��� ���� ������ ũ��� ������� ���ƺ��̴� ������ �ƽ��ƽ��ϰ� �Ŵ޷� �־����ϴ�.");
					make_slow(2);
					System.out.println("������ ���ʹ޶�� ���� ǥ���� ���� �־����ϴ�.");
					System.out.println();
					System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
					make_slow(1);
					System.out.println("�����ٱ��?\n[1. ��]  [2. �ƴϿ�]");
					choice = sc.nextInt();
					make_slow(2);
					if(choice == 1) {
						System.out.println("\"�� ������ �����ϸ� ���� ���� ������� ���� �� �־�.\"");
						make_slow(2);
						System.out.println("\"�׷��ٰ� �ܸ��� ���� ����.\"");
						make_slow(2);
						System.out.println("����� ������ �Ŵ޷� �ִ� ������ �����־����ϴ�.");
						make_slow(2);
						System.out.println("���� �������� ���ٴ� ���� �ൿ�� �ϸ� �� �ָ� ��������ϴ�.");
						make_slow(2);
						System.out.println("���� ������ �������� ���� ������ ��ұ⿡ �ӵ��� 30 �ö����ϴ�.\n");
						make_slow(1);
						player.speed += 30;
						help_baby_monster = 1;
						break;
					}else {
						System.out.println("\"�� ������ �����ϸ� ���� ���� ������� ���� �� �־�.\"");
						make_slow(2);
						System.out.println("��Ȳ�� ��Ÿ������� ����� �ձ��� �̷��� ���ؼ� �ڵ��Ƽ����ϴ�.");
						make_slow(2);
						System.out.println("���� ������ �������� ��� �������� �г��Ͽ����ϴ�.");
						make_slow(2);
						System.out.println("������ ��� �������� ���ݷ��� 20�� �����ϴ�.\n");
						make_slow(1);
						help_baby_monster = 2;
						break;
					}
				}else {
					System.out.println("�ٽ� �������ּ���.\n");
					continue;
				}
			}
		}else if(num == 6 && ex_event_num != 6) { // �� ��ȯ �̺�Ʈ
			random_num = rand.nextInt(100);
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("������ ��ϵ��� ���� ���� ���ĳ����� �ִ� ���");
			make_slow(2);
			System.out.println("�ʹ��� ������ ���� �ſ� ������ �����߽��ϴ�.");
			make_slow(2);
			System.out.println("������ ���� �̹� �������� �����Դϴ�.");
			make_slow(2);
			System.out.println("�� ���� �� �̻� ���ư���� ����� �մϴ�.");
			make_slow(2);
			System.out.println("�׷� ����� ��� �������簡 �������� �� ��ȯ������ �������ϴ�.");
			make_slow(2);
			System.out.println("����� ���� �� �� �ƴ� ������ �� ��ȯ�� ��ü ��ȭ�ۿ� ������ ������ �����մϴ�.");
			make_slow(2);
			System.out.println("�׷��� ���� ���� ������ ��� ���� ��ȯ�ϴ� ������ �õ��غ���� �߽��ϴ�.");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("�󸶸�ŭ�� ���� ��ȯ�ұ��?\n[1. ����]  [2. �ݸ�]  [3. ��ȯ���� �ʴ´�.]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("���� ���� ��ȯ�� ����� ���� ���ð� ������ ���Ƚ��ϴ�.");
				make_slow(2);
				System.out.println("� �� �� ������ �����غ��� �̶�� ��ȸ�� �������� �׷��� ���� ���� �Ϳ� �����߽��ϴ�.");
				make_slow(2);
				System.out.println("������ �����鼭 ü���� 50��ŭ ȸ���Ǿ����ϴ�.");
				make_slow(2);
				System.out.println("�׷��� �̼��� �������� ���� ��ȯ�ϸ鼭 ������ ���� ����ع��Ƚ��ϴ�.\n");
				make_slow(1);
				player.health += 50;
				player.mana = 0;
				if(player.health > 100)
					player.health = 100;
			}else if(choice == 2) {
				if(random_num < 50) {
					System.out.println("���� �� ���� ��ȯ�� ����� ���� ���ð� ������ ���Ƚ��ϴ�.");
					make_slow(2);
					System.out.println("� �� �� ������ �����غ��� �̶�� ��ȸ�� �������� �׷��� ���� ���� �Ϳ� �����߽��ϴ�.");
					make_slow(2);
					System.out.println("������ �����鼭 ü���� 50��ŭ ȸ���Ǿ����ϴ�.");
					make_slow(2);
					System.out.println("�׸��� ���� ��ȯ�ϸ鼭 ������ 20��ŭ �Ҹ�Ǿ����ϴ�.\n");
					make_slow(1);
					player.health += 50;
					player.mana -= 20;
					if(player.health > 100)
						player.health = 100;
					if(player.mana < 0)
						player.mana = 0;
				}else {
					System.out.println("���� �� ���� ��ȯ�� ����� ���� ���ð� ������ ���Ƚ��ϴ�.");
					make_slow(2);
					System.out.println("� �� �� ������ �����غ��� �̶�� ��ȸ�� �������� �׷��� ���� ���� �Ϳ� �����߽��ϴ�.");
					make_slow(2);
					System.out.println("�׷��� �̼��� �������� ���� ��ȯ�ϸ鼭 ������ ���� ����ع��Ƚ��ϴ�.\n");
					make_slow(1);
					player.mana = 0;
				}
			}else {
				System.out.println("���ŷ����� ��Ƽ��� �� ����� ������ ������ �ɾ���ϴ�.");
				make_slow(2);
				System.out.println("�׷����� ���ŷ����δ� �Ѱ谡 �ֽ��ϴ�.");
				make_slow(2);
				System.out.println("�ؽ��� �������� ���� ü���� 50��ŭ �������ϴ�.");
				make_slow(1);
				player.health -= 50;
				if(player.health < 0)
					player.health = 0;
			}
			ex_event_num = 6;
		}else { // �������� ����
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			System.out.println();
			make_slow(2);
			System.out.println("��Ÿ�� �ִ� ������ �� �տ� ���Դϴ�.");
			make_slow(2);
			System.out.println("������ �ٰ����� �������� �ƹ��� ���� �� �����ϴ�.");
			make_slow(2);
			System.out.println("����� Ȥ�ó� ������ ������ ���� ������ �Ͽ� ���� ������ �ѷ����ҽ��ϴ�.");
			make_slow(2);
			System.out.println("�쿬�� �� ���� ������ ���غ��̴� ���ڰ� �־����ϴ�.");
			make_slow(2);
			System.out.println("���ڸ� ���� ���� ���� ���� �� �����ϴ�.");
			make_slow(2);
			System.out.println();
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(1);
			System.out.println("���ڸ� ���ðڽ��ϱ�?\n[1. ��]  [2. �ƴϿ�]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("���ڸ� õõ�� ����� �ȿ��� �� ���� ��ȭ�� �־����ϴ�.");
					make_slow(2);
					System.out.println("���� ������� ��ȭ���� �ָӴϿ� �־����ϴ�.");
					make_slow(2);
					System.out.println("��ȭ 100���� ������ϴ�.\n");
					make_slow(1);
					player.money += 100;
				}else if(random_num < 90) {
					System.out.println("���ڸ� ���� �������� �ƹ��� ���ǵ� �������ϴ�.");
					make_slow(2);
					System.out.println("�Ǹ��� �������� ������ �������ϴ�.\n");
					make_slow(1);
				}else {
					System.out.println("���ڸ� õõ�� ����� �ȿ� ����Ǿ� �ִ� ���ְ� ���Խ��ϴ�.");
					make_slow(2);
					System.out.println("���ֿ� ���� ����� ���뽺���� �����ɾҽ��ϴ�.");
					make_slow(2);
					System.out.println("���ݷ�, ����, �ӵ��� ���� 10�� �پ��ϴ�.\n");
					make_slow(1);
					player.power -= 10;
					player.defense -= 10;
					player.speed -= 10;
					if(player.power < 0)
						player.power = 0;
					if(player.defense < 0)
						player.defense = 0;
					if(player.speed < 0)
						player.speed = 0;
				}
			}else {
				System.out.println("������ ���������� ���� �ǵ��� �ʴ� ���� ���� ���̶� �Ǵ��߽��ϴ�.");
				make_slow(2);
				System.out.println("���ڸ� �������ΰ� ������ ���Խ��ϴ�.\n");
				make_slow(1);
			}
		}
	}
	
	
	
	public static void stage_break_time() { // �������� �߰� �ܰ�
		if(stage_1_clear) { // �� ��° �޽Ľð�
			make_slow(2);
			System.out.println("=================================");
			make_slow(2);
			System.out.println("2 ���������� Ŭ�����ϼ̽��ϴ�.");
			make_slow(2);
			System.out.println("Ŭ���� �������� ü�� ������ �߰��Ǿ����ϴ�.");
			make_slow(2);
			player_potion.add(hp_potion.name);
			System.out.println("=================================\n");
			make_slow(0);
			loading();
			make_slow(2);
			System.out.println("�ޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡ�\n");
			stage_2_clear = true;
			make_slow(2);
			volcano_image.setVisible(true);
			System.out.println("������ �ɾ�� ����� ȭ�꿡������ �Ҿ���� ���� �ٶ��� ���� �߱Ⱑ ��������ϴ�.");
			make_slow(0);
			System.out.println("�뿡�� ������ ������ �������� �ٶ��� �ʹ� ���ؼ� ������ ���ư� �� �������ϴ�.");
			make_slow(0);
			System.out.println("����� �ϴ� �� ���� �ֺ��� �ִ� ������ �� �ٶ��� ���������⸦ ��ٸ���� �߽��ϴ�.");
			make_slow(0);
			System.out.println("�� �� ���� �� �ʿ��� ���� ���� ��Ҹ��� ����Խ��ϴ�.");
			make_slow(0);
			System.out.println("\"���� ����� ��ȣõ���Դϴ�. ���� ���� ���ؼ� ������ �帮���� ������� �Խ��ϴ�.\"");
			make_slow(0);
			System.out.println("\"�� �տ������ʹ� �� �̻� ���͵帱 �� �����ϴ�. ������ �غ� �ܴ��� �Ͻñ� �ٶ��ϴ�.\"\n");
			make_slow(2);
			System.out.println("�ޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡ�");
			System.out.println();
			make_slow(0);
			volcano_image.setVisible(false);
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?(�ѹ� �����ϸ� �ǵ��ư� �� �����ϴ�.)");
			System.out.println("[1. ��ȭ�ϱ�]  [2. ������� �̿��ϱ�]  [3. �޽��ϱ�]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("-------------------------------------------------------------\n");
				make_slow(2);
				System.out.println("\"���� ���� ��� ���� ��ƺξ� ��� ��ȭ���ѵ帮�ڽ��ϴ�.\"");
				make_slow(0);
				System.out.println("��ȣõ��� ����� ��� �ٶ󺸸� ���� ���� �����߽��ϴ�.");
				make_slow(0);
				System.out.println("�� ���� õ���� ������ ���� ���� �վ��� ������ ����� ���α� �����߽��ϴ�.\n");
				make_slow(2);
				System.out.println("-------------------------------------------------------------");
				System.out.println();
				make_slow(0);
				upgrade_weapon();
			}else if(choice == 2) {
				System.out.println("��ȣõ��� ������ ���� ���� �����߽��ϴ�.");
				make_slow(2);
				System.out.println("�׿� �Բ� ���� ���ǵ��� �� �տ� ��Ÿ�����ϴ�.");
				make_slow(2);
				System.out.println("\"��¥�� �帮�� ������ �ٸ� ���� ������ �Ͻ������� �����̵� ��Ų ���̱⿡ ������ ���� �����ϼž� �մϴ�.\"");
				make_slow(2);
				System.out.println("������ ������ ������ ���� ���� �Ƹ� �������� ������ ��������ε� �ʹ�.\n");
				make_slow(1);
				while(true) {
					System.out.println("--------------------------------------");
					System.out.println("    ���                           ����   ");
					System.out.printf("1. %s                       %3d��\n", mp_potion.name, mp_potion.money);
					System.out.printf("2. %s                         %3d��\n", antidote.name, antidote.money);
					System.out.printf("3. %s                     %3d��\n", antipyrotic.name, antipyrotic.money);
					System.out.printf("4. %s                      %3d��\n", power_potion.name, power_potion.money);
					System.out.printf("5. %s                      %3d��\n", defense_potion.name, defense_potion.money);
					System.out.printf("6. %s                       %3d��\n", speed_potion.name, speed_potion.money);
					System.out.println("--------------------------------------");
					System.out.println("���� ������ �ִ� ��ȭ: "+player.money+"��");
					System.out.println("���� ����: "+player.weight+" / 100");
					Collections.sort(player_potion);
					System.out.print("���� ������ �ִ� ����: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("� ������ �����Ͻðڽ��ϱ�? (�׸� �ν÷��� 0�� �����ּ���)");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println("\"�� ������ �������.\"");
						make_slow(2);
						System.out.println("��������� ���Խ��ϴ�.\n");
						make_slow(2);
						break;
					}else if(choice <= 3) {
						if(player.money < 50) {
							System.out.println("������ ������ ��ȭ�� �����մϴ�.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("�� �̻� ���ſ��� �� �� �����ϴ�.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else if(choice <= 6){
						if(player.money < 100) {
							System.out.println("������ ������ ��ȭ�� �����մϴ�.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("�� �̻� ���ſ��� �� �� �����ϴ�.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else {
						System.out.println("��ȣ�� �ٽ� �Է����ּ���.\n");
						continue;
					}
				}
			}else {
				System.out.println("��ȣõ��� ����� �ٶ󺸸� ���� ���� �����߽��ϴ�.");
				make_slow(2);
				System.out.println("õ���� ������ �վ��� ������ ������ ���� ����� ���α� �����߰� �̳� ���� ��� ��ó�� ȸ���Ǵ� ���� �������ϴ�.");
				make_slow(2);
				System.out.println("ü�°� ������ ���� á���ϴ�.\n");
				player.health = 100;
				player.mana = 100;
				make_slow(1);
			}
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�\n");
			make_slow(2);
			System.out.println("��� �غ� ����ġ�� ���� ���� ������ ���� õ�簡 ����� ����ҽ��ϴ�.");
			make_slow(0);
			System.out.println("\"�̴�� ���ٸ� ���� �ٶ� ������ ������ ���ư� �� ���� ���Դϴ�.\"");
			make_slow(0);
			System.out.println("\"���� �ٶ��� ���� ��ȣ�� �帮�ڽ��ϴ�.\"");
			make_slow(0);
			System.out.println("õ���� ��ȣ�� ����� ���δ��� �ֺ��� �ٶ����� ����� ���ذ��� �����߽��ϴ�.");
			make_slow(0);
			System.out.println("\"���� ��Ƽ���� �������� �̰� ���� �ּ��Դϴ�. �ε� �¸��Ͻñ� ���ϴ�.\"");
			make_slow(0);
			System.out.println("���� ��ģ õ��� �̳� ������� ����� ������ ������ ���� �������� �뿡�� ���ư����ϴ�.\n");
			make_slow(2);
			System.out.println("�ޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡޡ�");
			make_slow(0);
			loading();
			make_slow(0);
		}else { // ù ��° �޽Ľð�
			make_slow(2);
			System.out.println("=================================");
			make_slow(2);
			System.out.println("1 ���������� Ŭ�����ϼ̽��ϴ�.");
			make_slow(2);
			System.out.println("Ŭ���� �������� ü�� ������ �߰��Ǿ����ϴ�.");
			make_slow(2);
			player_potion.add(hp_potion.name);
			System.out.println("=================================\n");
			make_slow(0);
			loading();
			make_slow(2);
			System.out.println("�ޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡ�\n");
			stage_1_clear = true;
			make_slow(2);
			monster_village_image.setVisible(true);
			System.out.println("����� ��� �տ� �������� ������ ��Ÿ�����ϴ�.");
			make_slow(0);
			System.out.println("����ϸ� ������ �ٰ����� ����Ե� ������ ���̿� �� ���İ� �־����ϴ�.");
			make_slow(0);
			System.out.println("�׳�� ����� �����Ϸ��� �������� ���缼��� �̷��� ���߽��ϴ�.");
			make_slow(0);
			System.out.println("\"���� �ִ� �������� �� �ٶ��� ���մ� �� ������ �Ҹ��� ����. �״밡 ���� �����شٸ� �츮�� �ּ��� ���� �����ְڳ�\"\n");
			make_slow(2);
			System.out.println("�ޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡߡޡ�");
			make_slow(1);
			monster_village_image.setVisible(false);
			System.out.println();
			System.out.println("����� �̰����� �� ������ �ൿ�� ������ �� �ֽ��ϴ�.");
			make_slow(2);
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?(�ѹ� �����ϸ� �ǵ��ư� �� �����ϴ�.)");
			make_slow(2);
			System.out.println("[1. ��ȭ�ϱ�]  [2. ������� �̿��ϱ�]  [3. �޽��ϱ�]");
			
			choice = sc.nextInt();
			make_slow(1);
			System.out.println();
			if(choice == 1) {
				System.out.println("-------------------------------------------------------------\n");
				make_slow(2);
				System.out.println("��� ��ȭ�ϰ����ϴ� ����� ���Ŀ��� ���尣�� ��ġ�� ����ҽ��ϴ�.");
				make_slow(2);
				System.out.println("���İ� �˷��� ���� ������ ���� �ϳ��� ������ ��ġ�� �ε��� �ִ� ���� ���ҽ��ϴ�.");
				make_slow(2);
				System.out.println("������ �ٰ����� �� �� ���� ���� ����� �ϴ��� ��� �޶�� ���� ���о����ϴ�.");
				make_slow(2);
				System.out.println("���� ������������ ������ �޸� ����� ��� ��� �ǳ��ֱ�� �Ͽ����ϴ�.\n");
				make_slow(2);
				System.out.println("-------------------------------------------------------------");
				System.out.println();
				upgrade_weapon();
			}else if(choice == 2) {
				System.out.println("������ �������� ������ �ִ� ��������� �����߽��ϴ�.");
				make_slow(1);
				while(true) {
					System.out.println("--------------------------------------");
					System.out.println("    ���                           ����   ");
					System.out.printf("1. %s                       %3d��\n", mp_potion.name, mp_potion.money);
					System.out.printf("2. %s                         %3d��\n", antidote.name, antidote.money);
					System.out.printf("3. %s                     %3d��\n", antipyrotic.name, antipyrotic.money);
					System.out.printf("4. %s                      %3d��\n", power_potion.name, power_potion.money);
					System.out.printf("5. %s                      %3d��\n", defense_potion.name, defense_potion.money);
					System.out.printf("6. %s                       %3d��\n", speed_potion.name, speed_potion.money);
					System.out.println("--------------------------------------");
					System.out.println("���� ������ �ִ� ��ȭ: "+player.money+"��");
					System.out.println("���� ����: "+player.weight+" / 100");
					Collections.sort(player_potion);
					System.out.print("���� ������ �ִ� ����: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("� ������ �����Ͻðڽ��ϱ�? (�׸� �ν÷��� 0�� �����ּ���)");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println("\"�� ������ �������.\"");
						make_slow(2);
						System.out.println("��������� ���Խ��ϴ�.\n");
						make_slow(2);
						break;
					}else if(choice <= 3) {
						if(player.money < 50) {
							System.out.println("������ ������ ��ȭ�� �����մϴ�.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("�� �̻� ���ſ��� �� �� �����ϴ�.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else if(choice <= 6){
						if(player.money < 100) {
							System.out.println("������ ������ ��ȭ�� �����մϴ�.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("�� �̻� ���ſ��� �� �� �����ϴ�.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else {
						System.out.println("��ȣ�� �ٽ� �Է����ּ���.\n");
						continue;
					}
				}
			}else {
				System.out.println("�ʹ��� ����ߴ� ����� ������ �ִ� �������� ����� �Ͽ����ϴ�.");
				make_slow(2);
				System.out.println("ü�°� ������ ���� á���ϴ�.\n");
				make_slow(1);
				player.health = 100;
				player.mana = 100;
			}
			System.out.println("�������� ��� ���� ��ģ ����� �ٽ� ���� ���ؼ� ���ư����ϴ�.\n");
			make_slow(0);
			loading();
			make_slow(0);
		}
	}

	
	
	public static void upgrade_weapon() { // ���� ��ȭ
		ArrayList<String> upgrade_list = new ArrayList<String>();
		int upgrade_count = 0; // ��ȭ ���� Ƚ��
		int item_num = 5; // ��� ��ȣ (0�� ����, 1�� ��, 2�� �Ź�, 3�� ����)
		
		if(sword.equipped || bow.equipped || axe.equipped)
			upgrade_list.add("����");
		
		if(light_armor.equipped || heavy_armor.equipped)
			upgrade_list.add("��");
		
		if(shoes.equipped)
			upgrade_list.add("�Ź�");
		
		if(shield.equipped)
			upgrade_list.add("����");
		
		upgrade_count = upgrade_list.size() - 1;
		if(upgrade_count <= 0)
			upgrade_count = 1;
		
		if(upgrade_list.size() > 0) {
			while(true) {
				if(upgrade_count > 0) {
					System.out.printf("��ȭ�� �� �ִ� Ƚ���� %d�� ���ҽ��ϴ�.\n", upgrade_count);
					System.out.println("� ��� ��ȭ�Ͻðڽ��ϱ�?");
					for(int i = 0; i < upgrade_list.size(); i++) {
						System.out.printf("[%d. %s]\n", i+1, upgrade_list.get(i));
					}
					System.out.println("0. �׸��д�.");
					choice = sc.nextInt();
				}else {
					System.out.println("��ȭ Ƚ���� ��� ����Ͽ����ϴ�.\n");
					make_slow(2);
					System.out.println("��ȭ�� ��Ĩ�ϴ�.\n");
					make_slow(1);
					upgrade_list.clear();
					break;
				}
				
				if(choice == 0) {
					System.out.println("��ȭ�� ��� ���ƽ��ϴ�.\n");
					make_slow(1);
					upgrade_list.clear();
					break;
				}else if(choice <= upgrade_list.size()){
					if(upgrade_list.get(choice - 1).equals("����")){ // ���� ��ȭ
						System.out.println("���⸦ ��ȭ�մϴ�.");
						System.out.println("\"�ҵ� �ҵ� �ҵ� �ҵ�\"");
						make_slow(2);
						upgrade_list.remove("����");
						item_num = 0;
						if(sword.equipped) { // �� ��ȭ
							if(sword_upgrade_1.equipped) { // �� ��ȭ 1�ܰ踦 ��ȭ
								System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", sword_upgrade_1.name, sword_upgrade_2.name);
								player.ultimate_weapon = sword_upgrade_2.name;
								unequip_item(item_num);
								sword_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,sword_upgrade_2.name);
								player.power += sword_upgrade_2.power;
								player.speed += sword_upgrade_2.speed;
								player.weight += sword_upgrade_2.weight;
								player.equiped_weapon_power = sword_upgrade_2.power;
								player.equiped_weapon_speed = sword_upgrade_2.speed;
								player.equiped_weapon_weight = sword_upgrade_2.weight;
								upgrade_count--;
							}else { // �⺻ �� ��ȭ
								System.out.printf("[%s�� %s���� ��ȭ�Ǿ����ϴ�.]\n\n", sword.name, sword_upgrade_1.name);
								unequip_item(item_num);
								sword_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,sword_upgrade_1.name);
								player.power += sword_upgrade_1.power;
								player.speed += sword_upgrade_1.speed;
								player.weight += sword_upgrade_1.weight;
								player.equiped_weapon_power = sword_upgrade_1.power;
								player.equiped_weapon_speed = sword_upgrade_1.speed;
								player.equiped_weapon_weight = sword_upgrade_1.weight;
								upgrade_count--;
							}
						}else if(bow.equipped) { // Ȱ ��ȭ
							if(bow_upgrade_1.equipped) { // Ȱ 1�ܰ� ��ȭ�� ��ȭ
								System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", bow_upgrade_1.name, bow_upgrade_2.name);
								player.ultimate_weapon = bow_upgrade_2.name;
								unequip_item(item_num);
								bow_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,bow_upgrade_2.name);
								player.power += bow_upgrade_2.power;
								player.speed += bow_upgrade_2.speed;
								player.weight += bow_upgrade_2.weight;
								player.equiped_weapon_power = bow_upgrade_2.power;
								player.equiped_weapon_speed = bow_upgrade_2.speed;
								player.equiped_weapon_weight = bow_upgrade_2.weight;
								upgrade_count--;
							}else { // �⺻ Ȱ ��ȭ
								System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", bow.name, bow_upgrade_1.name);
								unequip_item(item_num);
								bow_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,bow_upgrade_1.name);
								player.power += bow_upgrade_1.power;
								player.speed += bow_upgrade_1.speed;
								player.weight += bow_upgrade_1.weight;
								player.equiped_weapon_power = bow_upgrade_1.power;
								player.equiped_weapon_speed = bow_upgrade_1.speed;
								player.equiped_weapon_weight = bow_upgrade_1.weight;
								upgrade_count--;
							}
						}else { // ���� ��ȭ
							if(axe_upgrade_1.equipped) { // ���� 1�ܰ踦 ��ȭ
								System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", axe_upgrade_1.name, axe_upgrade_2.name);
								player.ultimate_weapon = axe_upgrade_2.name;
								unequip_item(item_num);
								axe_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,axe_upgrade_2.name);
								player.power += axe_upgrade_2.power;
								player.speed += axe_upgrade_2.speed;
								player.weight += axe_upgrade_2.weight;
								player.equiped_weapon_power = axe_upgrade_2.power;
								player.equiped_weapon_speed = axe_upgrade_2.speed;
								player.equiped_weapon_weight = axe_upgrade_2.weight;
								upgrade_count--;
							}else { // �⺻ ���� ��ȭ
								System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", axe.name, axe_upgrade_1.name);
								unequip_item(item_num);
								axe_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,axe_upgrade_1.name);
								player.power += axe_upgrade_1.power;
								player.speed += axe_upgrade_1.speed;
								player.weight += axe_upgrade_1.weight;
								player.equiped_weapon_power = axe_upgrade_1.power;
								player.equiped_weapon_speed = axe_upgrade_1.speed;
								player.equiped_weapon_weight = axe_upgrade_1.weight;
								upgrade_count--;
							}
						}
						
					}else if(upgrade_list.get(choice - 1).equals("��")) { // �� ��ȭ
						System.out.println("���� ��ȭ�մϴ�.");
						System.out.println("\"�ҵ� �ҵ� �ҵ� �ҵ�\"");
						make_slow(2);
						upgrade_list.remove("��");
						item_num = 1;
						if(light_armor.equipped) { // �氩 ����
							if(light_armor_upgrade_1.equipped) { // �氩 1�ܰ踦 ��ȭ
								System.out.printf("[%s�� %s���� ��ȭ�Ǿ����ϴ�.]\n\n", light_armor_upgrade_1.name, light_armor_upgrade_2.name);
								unequip_item(item_num);
								light_armor_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,light_armor_upgrade_2.name);
								player.defense += light_armor_upgrade_2.defense;
								player.speed += light_armor_upgrade_2.speed;
								player.weight += light_armor_upgrade_2.weight;
								player.equiped_armor_defense = light_armor_upgrade_2.defense;
								player.equiped_armor_speed = light_armor_upgrade_2.speed;
								player.equiped_armor_weight = light_armor_upgrade_2.weight;
								upgrade_count--;
							}else { // �⺻ �氩 ��ȭ
								System.out.printf("[%s�� %s���� ��ȭ�Ǿ����ϴ�.]\n\n", light_armor.name, light_armor_upgrade_1.name);
								unequip_item(item_num);
								light_armor_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,light_armor_upgrade_1.name);
								player.defense += light_armor_upgrade_1.defense;
								player.speed += light_armor_upgrade_1.speed;
								player.weight += light_armor_upgrade_1.weight;
								player.equiped_armor_defense = light_armor_upgrade_1.defense;
								player.equiped_armor_speed = light_armor_upgrade_1.speed;
								player.equiped_armor_weight = light_armor_upgrade_1.weight;
								upgrade_count--;
							}
						}else { // �߰� ����
							if(heavy_armor_upgrade_1.equipped) { // �߰� 1�ܰ踦 ��ȭ
								System.out.printf("[%s�� %s���� ��ȭ�Ǿ����ϴ�.]\n\n", heavy_armor_upgrade_1.name, heavy_armor_upgrade_2.name);
								unequip_item(item_num);
								heavy_armor_upgrade_2.equipped = true;
								player_equipped_item.add(item_num, heavy_armor_upgrade_2.name);
								player.defense += heavy_armor_upgrade_2.defense;
								player.speed += heavy_armor_upgrade_2.speed;
								player.weight += heavy_armor_upgrade_2.weight;
								player.equiped_armor_defense = heavy_armor_upgrade_2.defense;
								player.equiped_armor_speed = heavy_armor_upgrade_2.speed;
								player.equiped_armor_weight = heavy_armor_upgrade_2.weight;
								upgrade_count--;
							}else { // �⺻ �߰� ��ȭ
								System.out.printf("[%s�� %s���� ��ȭ�Ǿ����ϴ�.]\n\n", heavy_armor.name, heavy_armor_upgrade_1.name);
								unequip_item(item_num);
								heavy_armor_upgrade_1.equipped = true;
								player_equipped_item.add(item_num, heavy_armor_upgrade_1.name);
								player.defense += heavy_armor_upgrade_1.defense;
								player.speed += heavy_armor_upgrade_1.speed;
								player.weight += heavy_armor_upgrade_1.weight;
								player.equiped_armor_defense = heavy_armor_upgrade_1.defense;
								player.equiped_armor_speed = heavy_armor_upgrade_1.speed;
								player.equiped_armor_weight = heavy_armor_upgrade_1.weight;
								upgrade_count--;
							}
						}
					}else if(upgrade_list.get(choice - 1).equals("�Ź�")) { // �Ź� ��ȭ
						System.out.println("�Ź��� ��ȭ�մϴ�.");
						System.out.println("\"�ҵ� �ҵ� �ҵ� �ҵ�\"");
						make_slow(2);
						upgrade_list.remove("�Ź�");
						item_num = 2;
						if(shoes_upgrade_1.equipped) { // �Ź� 1�ܰ踦 ��ȭ
							System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", shoes_upgrade_1.name, shoes_upgrade_2.name);
							unequip_item(item_num);
							shoes_upgrade_2.equipped = true;
							player_equipped_item.add(item_num, shoes_upgrade_2.name);
							player.speed += shoes_upgrade_2.speed;
							player.weight += shoes_upgrade_2.weight;
							player.equiped_shoes_speed = shoes_upgrade_2.speed;
							player.equiped_shoes_weight = shoes_upgrade_2.weight;
							upgrade_count--;
						}else { // �⺻ �Ź� ��ȭ
							System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", shoes.name, shoes_upgrade_1.name);
							unequip_item(item_num);
							shoes_upgrade_1.equipped = true;
							player_equipped_item.add(item_num, shoes_upgrade_1.name);
							player.speed += shoes_upgrade_1.speed;
							player.weight += shoes_upgrade_1.weight;
							player.equiped_shoes_speed = shoes_upgrade_1.speed;
							player.equiped_shoes_weight = shoes_upgrade_1.weight;
							upgrade_count--;
						}
						
					}else if(upgrade_list.get(choice - 1).equals("����")) { // ���� ��ȭ
						System.out.println("���и� ��ȭ�մϴ�.");
						System.out.println("\"�ҵ� �ҵ� �ҵ� �ҵ�\"");
						make_slow(2);
						upgrade_list.remove("����");
						item_num = 3;
						if(shield_upgrade_1.equipped) { // ���� 1�ܰ踦 ��ȭ
							System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", shield_upgrade_1.name, shield_upgrade_2.name);
							unequip_item(item_num);
							shield_upgrade_2.equipped = true;
							player_equipped_item.add(item_num, shield_upgrade_2.name);
							player.defense += shield_upgrade_2.defense;
							player.speed += shield_upgrade_2.speed;
							player.weight += shield_upgrade_2.weight;
							player.equiped_shield_defense = shield_upgrade_2.defense;
							player.equiped_shield_speed = shield_upgrade_2.speed;
							player.equiped_shield_weight = shield_upgrade_2.weight;
							upgrade_count--;
						}else { // �⺻ ���и� ��ȭ
							System.out.printf("[%s�� %s�� ��ȭ�Ǿ����ϴ�.]\n\n", shield.name, shield_upgrade_1.name);
							unequip_item(item_num);
							shield_upgrade_1.equipped = true;
							player_equipped_item.add(item_num, shield_upgrade_1.name);
							player.defense += shield_upgrade_1.defense;
							player.speed += shield_upgrade_1.speed;
							player.weight += shield_upgrade_1.weight;
							player.equiped_shield_defense = shield_upgrade_1.defense;
							player.equiped_shield_speed = shield_upgrade_1.speed;
							player.equiped_shield_weight = shield_upgrade_1.weight;
							upgrade_count--;
						}
					}else {
						System.out.println("�׷� ���� �����ϴ�.\n");
						continue;
					}
				}else {
					System.out.println("�ٽ� �������ּ���.\n");
					continue;
				}
			}
		}else {
			System.out.println("��ȭ�� �Ϸ��� ������ ��ȭ�� �� �ִ� ��� �����ϴ�.");
			make_slow(2);
			System.out.println("��ȭ�� ��Ĩ�ϴ�.\n");
			make_slow(1);
		}
		
	}

	
	
	public static void buy_potion(int num) { // ���� ����
		if(num == 1) { // ���� ���� ����
			System.out.println("["+mp_potion.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(mp_potion.name);
			player.money -= mp_potion.money;
			player.weight += mp_potion.weight;
		}else if(num == 2) { // �ص��� ����
			System.out.println("["+antidote.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(antidote.name);
			player.money -= antidote.money;
			player.weight += antidote.weight;
		}else if(num ==3) { // ȭ�� ġ���� ����
			System.out.println("["+antipyrotic.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(antipyrotic.name);
			player.money -= antipyrotic.money;
			player.weight += antipyrotic.weight;
		}else if(num == 4) { // ���ݷ� ���� ����
			System.out.println("["+power_potion.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(power_potion.name);
			player.money -= power_potion.money;
			player.weight += power_potion.weight;
		}else if(num == 5) { // ���� ���� ����
			System.out.println("["+defense_potion.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(defense_potion.name);
			player.money -= defense_potion.money;
			player.weight += defense_potion.weight;
		}else { // �ӵ� ���� ����
			System.out.println("["+speed_potion.name+"�� �����߽��ϴ�.]\n");
			player_potion.add(speed_potion.name);
			player.money -= speed_potion.money;
			player.weight += speed_potion.weight;
		}
	}
		
	
	
	public static boolean check_dead() { // ĳ������ ������ Ȯ��
		if(player.health <= 0)
			return true;
		else return false;
	}
	
	
	
	public static void make_slow(int num) { // �ӵ��� �����ִ� �޼ҵ�
		if(num == 0) { // ���丮 �ӵ�
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				
			}
		}else if(num == 1) { // �Ϲ����� �ӵ�
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				
			}
		}else { // �������� ���� �ӵ�
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}

	
			
	static class Player_fight_thread extends Thread{ // �÷��̾� ���� ������
		private int choice = 0;
		int speed = player.speed*2;
		
		public void run() {
			try {
				if(speed > 1000) {
					speed = 1000;
				}
				while(player.health > 0 && monster.health > 0 && check_fight) {
					choice = player_num.nextInt();
					if(check_fight == false) {
						if(choice == 1) {
							System.out.println("���� ������ �����մϴ�.\n��� �Ͻ÷��� 1�� �����ּ���.\n������ �����̶� �׸� �ν÷��� �ٸ� ���ڸ� �����ּ���.");
							break;
						}else {
							System.out.println("������ �������� ���� �ӵ��� �ձ��� �����ذ��� �׷��� �ձ��� ����Ͽ����ϴ�.");
							make_slow(0);
							System.out.println("\"����� �ձ��� �鼺���� �׿���...\"");
							make_slow(0);
							System.out.println("The End");
							System.exit(0);
						}
					}
					if(choice == 1) { // �����ϱ�
						if(monster.health < 0 || player.health < 0) 
							break;
						System.out.println("["+monster.name+"��(��) �����߽��ϴ�.]\n");
						damage = player.power - monster.defense;
						if(damage < 0) {
							damage = 5;
							monster.health -= damage;
						}
						else monster.health -= damage;
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0)
							break;
					}else if(choice == 2) { // ��ų ���
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player.mana >= 20) {
							use_skill(skill_choice);
							Thread.sleep(3000 - speed);
						}else {
							System.out.println("[��ų�� ����� ������ �����ϴ�.]\n");
							Thread.sleep(1000 - speed);
						}
						if(monster.health < 0 || player.health < 0)
							break;
					}else if(choice == 3) { // ȸ��
						if(monster.health < 0 || player.health < 0) 
							break;
						System.out.println("[ȸ�� ������ ���߽��ϴ�.]\n");
						Thread.sleep(2000);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 5) { // ü�� ���� ���
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(hp_potion.name)) {
							System.out.println("["+hp_potion.name + "�� ����Ͽ����ϴ�.]\n");
							player_potion.remove(hp_potion.name);
							player.health += hp_potion.hp;
							if(player.health > 100)
								player.health = 100;
						}else System.out.println("["+hp_potion.name + "�� �����ϴ�.]\n");
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 6) { // ���� ���� ���
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(mp_potion.name)) {
							System.out.println("["+mp_potion.name+"�� ����Ͽ����ϴ�.]\n");
							player_potion.remove(mp_potion.name);
							player.mana += mp_potion.mp;
							if(player.mana > 100)
								player.mana = 100;
						}else System.out.println("["+mp_potion.name + "�� �����ϴ�.]\n");
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 7) { // �ص��� �� ȭ�� ġ����
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(antidote.name) && player.posioned) { // �ص���
							System.out.println("["+antidote.name+"�� ����Ͽ����ϴ�.]\n");
							player_potion.remove(antidote.name);
							player.posioned = false;
						}else if(player_potion.contains(antipyrotic.name) && player.burned) { // ȭ�� ġ����
							System.out.println("["+antipyrotic.name+"�� ����Ͽ����ϴ�.]\n");
							player_potion.remove(antipyrotic.name);
							player.burned = false;
						}else if(player.posioned) {
							if(player_potion.contains(antidote.name))
								System.out.println("[�ٽ� ������ּ���.]\n");
							else System.out.println("["+antidote.name+"�� �����ϴ�.]\n");
						}else if(player.burned) {
							if(player_potion.contains(antipyrotic.name))
								System.out.println("[�ٽ� ������ּ���.]\n");
							else System.out.println("["+antipyrotic.name+"�� �����ϴ�.]\n");
						}else {
							System.out.println("[������ ����� �ʿ䰡 �����ϴ�.]\n");
						}
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else{
						if(choice == 4 && player.equipped_shield) {
							if(monster.health < 0 || player.health < 0) 
								break;
							System.out.println("[���и� ��� ���ҽ��ϴ�.]\n");
							Thread.sleep(3000);
							if(monster.health < 0 || player.health < 0)
								break;
						}else if(choice == 4){
							if(monster.health < 0 || player.health < 0)
								break;
							System.out.println("[���а� �����ϴ�.]\n");
							Thread.sleep(1000 - speed);
							if(monster.health < 0 || player.health < 0)
								break;
						}
					}
					choice = 0;
					Thread.sleep(1000);
					if(monster.health < 0 || player.health < 0)
						break;
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	
	
	static class Monster_fight_thread extends Thread{ // ���� ���� ������
		int random_num = 0;
		int ex_pattern_num = 0; // ���� �ߺ��� ���̱� ���� ����
		
		public void run() {
			try {
					print_fight();
					Thread.sleep(10000);
					while(monster.health > 0 && player.health > 0) {
						random_num = rand.nextInt(100);
						if(monster.name.equals(undead.name)) { // �𵥵�
							if(random_num < 20 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �����⸦ ����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 7; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 60 && ex_pattern_num != 2){ // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ��⸦ ����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �޷���ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(goblin.name)) { // ���
							if(random_num < 20 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �����⸦ ����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 80 && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� Į�� �ֵθ��ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}	
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� Į�� �������ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(slime.name)){ // ������
							if(random_num < 40 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 80 && player.posioned == false && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ���� �Ѹ��ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("���� �ߵ��Ǿ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
									player.posioned = true;
									poison[poison_count] = new Poison();
									poison[poison_count].start();
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ���� ��Ǯ���� ���ƿɴϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 8; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(ghost.name)) { // ��Ʈ
							if(random_num < 10 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ��ȥ�� ���� ���ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 40 && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� Ȧ���⸦ ����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �⸦ ��� �����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 6; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(troll.name)) { // Ʈ��
							if(random_num < 20 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ��⸦ �����մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 50 && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ���� ���� �����ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 7; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �ָ��� �ֵθ��ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(griffin.name)) { // �׸���
							if(random_num < 20 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �ٶ��� ����ŵ�ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 50 && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �θ��� �δϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �޹߱����� �մϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else { // �巡��
							if(monster.health/monster.max_health * 100 <= 30) { // ü���� 30���� ����
								random_num -= 20;
							}
							if(random_num < 10 && ex_pattern_num != 1) { // ���� 1
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �����ҷ� �ֺ��� ���Դϴ�.");
								System.out.println("������ �ִ� ������κ��� �ö���� �߰ſ� ������� ���̴��� ȸ������ ����Ű�� ���ƿԽ��ϴ�.");
								System.out.println("�߰ſ� ���⿡ ���� ��Ƴ��� �� �����ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(3000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 40 && player.burned == false && ex_pattern_num != 2) { // ���� 2
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ���� ���ս��ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("ȭ���� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
									player.burned = true;
									burn[burn_count] = new Burn();
									burn[burn_count].start();
								}
								ex_pattern_num = 2;
							}else if(random_num < 60 && ex_pattern_num != 3) { // ���� 3
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� �ٶ�Į���� �����ϴ�.");
								System.out.println("�ֺ��� �ٶ����� ������ �Ҵ��� Į���� ���ؼ� ���ƿԽ��ϴ�.");
								System.out.println("õ���� ��ȣ�� �հ� �ٶ��� ���Ƶ��ɴϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(3000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 5; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}else { // �⺻ ����
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								System.out.println(monster.name + "�� ������ �ֵθ��ϴ�.");
								System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("���� �ð� : %d��\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���߽��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println("������ ���ҽ��ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�");
									System.out.println(damage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
									System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡܡ�\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 4;
							}
						}
						print_fight();
						Thread.sleep(2000);
						if(monster.health < 0 || player.health < 0)
							player_fight_thread[meet_monster].interrupt();
					}
			}catch(Exception e) {
				Thread.interrupted();
			}
		}
	}
	
	
	
	static class Poison extends Thread{ // �� ������
		public void run() {
			try {
				Thread.sleep(2000);
				for(int i = 0; i < 10; i++) {
					if(player.posioned == false) {
						System.out.println("                                    (���� ġ���Ǿ����ϴ�.)");
						break;
					}
					System.out.println("                                    (�� ������ �ǰ� 1�� �پ��ϴ�.)");
					player.health -= 1;
					Thread.sleep(3000);
					if(player.health <= 0) {
						player.posioned = false;
						break;
					}
				}
				poison_count += 1;
				player.posioned = false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	static class Burn extends Thread{ // ȭ�� ������

		public void run() {
			try {
				Thread.sleep(2000);
				for(int i = 0; i < 10; i++) {
					if(check_finished)
						break;
					if(player.burned == false) {
						System.out.println("                                    (ȭ���� ġ���Ǿ����ϴ�.)");
						break;
					}
					System.out.println("                                    (ȭ�� ������ �ǰ� 2�� �پ��ϴ�.)");
					player.health -= 2;
					Thread.sleep(3000);
					if(player.health <= 0) {
						player.burned = false;
						break;
					}
				}
				burn_count += 1;
				player.burned = false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	static public void loading() { // �ε�
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("�ε��� [                                      ]");
		bonfire_image.setVisible(true);
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("�ε��� [���������                              ]");
		try {
			Thread.sleep(1500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("�ε��� [�������������������                    ]");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("�ε��� [���������������������������������      ]");
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("�ε��� [���������������������������������������]");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		bonfire_image.setVisible(false);
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
