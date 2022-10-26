#include"contact.h"


void destroy(struct sum* con)
{
	free(con->data);
	con->data = NULL;
}
checksiz(struct sum* con, int siz)
{
	if (con->count == con->siz)
	{
	
	struct contact* ptr = (struct contact*)realloc(con->data, (con->siz+2) * sizeof(struct contact));
	if (ptr != NULL)
	{
		con->data = ptr;
		con->siz += 2;
		printf("���ݳɹ���\n");
	}
	else
		printf("����ʧ�ܣ�\n");
	}
	
}
void Initcontact(struct sum*con)
{
	con->siz = 3;
	con->data = (struct contact*)malloc(con->siz * sizeof(struct contact));
	if (con->data == NULL)
		return;
	checksiz(con, con->siz);
	struct contact a={0};
	//memset(con->data, 0, sizeof(con->data));
	con->count = 0;
	FILE* p = fopen("ͨѶ¼.txt", "rb");
	if (p == NULL)
		return;
	else
	{
		while (fread(&a, sizeof(a), 1, p))
		{
			checksiz(con, con->siz);
			*((con->data)+(con->count)) = a;
			con->count++;
		}
		fclose(p);
		p = NULL;
	}
}
void addcontact(struct sum* con)
{
	checksiz(con, con->siz);
	/*if (con->count >= 1000)
		printf("ͨѶ¼������\n");*/
	/*else
	{*/
		printf("����������\n");
		scanf("%s", &con->data[con->count].name);
		printf("�������Ա�\n");
		scanf("%s", &con->data[con->count].sex);
		printf("����������\n");
		scanf("%d", &con->data[con->count].age);
		printf("�������ַ\n");
		scanf("%s", &con->data[con->count].adr);
		printf("������绰\n");
		scanf("%s", &con->data[con->count].tel);
		con->count++;
		printf("��ӳɹ���\n");
		
	/*}*/
}
void showcontact(struct sum*con)
{
	int i = 0;
	if (!con->count)
		printf("ͨѶ¼�б�Ϊ�գ�\n");
	else
	{
		printf("����  �Ա�  ����  ��ַ  �绰\n");
		for (i = 0; i < con->count; i++)
			printf("%s  %s  %d  %s  %s\n",
				con->data[i].name,
				con->data[i].sex,
				con->data[i].age,
				con->data[i].adr,
				con->data[i].tel);
	}
}
int findby_name(struct sum* con, char name[10])
{
	int i = 0;
	for (i = 0; i < con->count; i++)
		if(!strcmp(con->data[i].name, name))
			return i;
	return -1;
	}
void delcontast(struct sum* con)
{
	if (!con->count)
		printf("ͨѶ¼�б�Ϊ�գ�\n");
	else
	{
		int i = 0;
		char name[100];
		showcontact(con);
		printf("��������Ҫɾ��������\n");
		scanf("%s", name);
		int ret = findby_name(con, name);
		if (ret == -1)
			printf("�Ҳ�������ϵ�ˣ�\n");
		else
		{
			for (i = ret; i < con->count; i++)
				con->data[i] = con->data[i + 1];
			con->count--;
			printf("ɾ���ɹ�\n");
		}
	}
}
void changecontast(struct sum* con)
{
	if (!con->count)
		printf("ͨѶ¼�б�Ϊ�գ�\n");
	else
	{
		char name[10];
		showcontact(con);
		printf("�������޸ĵ�������\n");
		scanf("%s", name);
		int ret=findby_name(con,name);
		if (ret == -1)
			printf("�Ҳ�������ϵ�ˣ�\n");
		else
		{
			printf("����������\n");
			scanf("%s", &con->data[ret].name);
			printf("�������Ա�\n");
			scanf("%s", &con->data[ret].sex);
			printf("����������\n");
			scanf("%d", &con->data[ret].age);
			printf("�������ַ\n");
			scanf("%s", &con->data[ret].adr);
			printf("������绰\n");
			scanf("%s", &con->data[ret].tel);
			printf("�޸ĳɹ���\n");
		}

	}
}
void searchcontast(struct sum* con)
{
	char name[100];
	printf("������Ҫ���ҵ���ϵ��\n");
	scanf("%s", name);
	int ret = findby_name(con,name);
	if (ret == -1)
		printf("�Ҳ�������ϵ�ˣ�\n");
	else
	{
		printf("����  �Ա�  ����  ��ַ  �绰\n");
		printf("%s  %s  %d  %s  %s\n",
			con->data[ret].name,
			con->data[ret].sex,
			con->data[ret].age,
			con->data[ret].adr,
			con->data[ret].tel);
	}
}
void savecontast(struct sum* con)
{
	FILE* p = fopen("ͨѶ¼.txt", "wb");
	if (p == NULL)
		return;
	else
	{
		int i = 0;
		for (i = 0; i < con->count; i++)
		{
			fwrite(&(con->data[i]), sizeof(struct contact), 1, p);

		}
		fclose(p);
		p = NULL;
		printf("����ɹ���\n");
	}
}