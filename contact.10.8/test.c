

#include"contact.h"


enum {Exit,Add,Del,Search,Change,Show,Save} choice;
void menu()
{
	printf("******************************************\n");
	printf("*******1.Add           2.Del    **********\n");
	printf("*******3.Search         4.Change *********\n");
	printf("*******5.Show          6.Save  ***********\n");
	printf("***********0.Exit    *********************\n");
}
void test()
{
	struct sum sum;
	Initcontact(&sum);//��ʼ��
	menu();	
	do
	{
		printf("������:\n");
		scanf("%d", &choice);
		switch (choice)
		{
		case Add:
			addcontact(&sum);
			break;
		case Del:
			delcontast(&sum);
			break;
		case Search:
			searchcontast(&sum);
			break;
		case Change:
			changecontast(&sum);
			break;
		case Show:
			showcontact(&sum);
			break;
		case Save:
			savecontast(&sum);
			break;
		case Exit:
			savecontast(&sum);
			destroy(&sum);
			break;
		default:
			printf("�����������������\n");
			break;
         }
	} while (choice);
}
int main()
{
	test();
	return 0;
}
