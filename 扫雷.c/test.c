#include"game.h" 
//void game() {
//	char mine[AZ][SZ] = { 0 };
//	char show[AZ][SZ] = { 0 };
//	init(show, AZ, SZ,'*');
//	init(mine, AZ, SZ, '0');
//	 //SetMine(mine,AZ,SZ);
//	print(show, AZ, SZ);
//}
void game()
{
	printf("ɨ��\n");
	printf("��Ϸ�����Կո��������������꣬��������Ϊ��Χ������\n");
	//�׵���Ϣ�洢
	//1. ���úõ��׵���Ϣ
	char mine[ROWS][COLS] = { 0 };// 11 * 11
	//2. �Ų�����׵���Ϣ
	char show[ROWS][COLS] = { 0 };
	////��ʼ��
	///*InitBoard(mine, ROWS, COLS, '0');
	//InitBoard(show, ROWS, COLS, '*');*/
	////��ӡ����
	////DisplayBoard(mine, ROW, COL);
	init(show, AZQ, SZQ, '*');
	init(mine, AZQ, SZQ, '0');
	print(show, AZ, SZ);
	////������
	/*getmine(mine, AZ, SZ);*/
	SetMine(mine, AZ, SZ);
	FindMine(mine,show ,AZ, SZ);
	//DisplayBoard(mine, ROW, COL);
	//ɨ��
	/*FindMine(mine, show, ROW, COL);*/
	
}
void menu() {
	printf("******************************\n");
	printf("*****1.play  0.exit***********\n");
	printf("******************************\n");
}
void test() {
	/*srand((unsigned int)time(NULL));*/
	int input = 0;
	do {
		
		menu();
		scanf_s("%d", &input);
		
		switch (input) {
		case 1:game(); 
			break;
	
		case 0:printf("�˳���Ϸ\n");
			break;
		default:printf("�����������������\n");
			break;
		}
	} while (input);
}
//do
//{
//	menu();
//	printf("��ѡ��:>");
//	scanf_s("%d", &input);
//	switch (input)
//	{
//	case 1:
//		game();
//		break;
//	case 0:
//		printf("�˳���Ϸ\n");
//		break;
//	default:
//		printf("ѡ�����,����ѡ��!\n");
//		break;
//	}
//} while (input);
//}
int main() {
test();
	return 0;
}