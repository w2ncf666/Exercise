#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
typedef struct
{
	int* stunum;
	int* chos;
	float* p;
	int schoolnum;
	int allstudent;
	int chosenum;
	float distance;
}student;
getp_chos(student** s)
{
	(*s)->p = (float*)malloc(sizeof(float) * (*s)->schoolnum);
	(*s)->chos = (int*)malloc(sizeof(int) * (*s)->schoolnum);
	if (!( * s)->p)
	{
		printf("p内存初始化失败\n");
		return 0;
	}
	if (!(*s)->chos)
	{
			printf("chos内存初始化失败\n");
			return 0;
	}
	int r;
	float g;
	printf("请输入不为0随机数<=%f\n", ( * s)->distance);
	scanf("%d",&r);
	(*s)->chos[0] = (int)((*s)->stunum[0] - r) / (*s)->distance + 1;
	(*s)->p[0] = (*s)->chos[0] / (float)(*s)->chosenum;
	g = (*s)->chos[0] * (*s)->distance + r - (*s)->stunum[0];
	for (int i = 1; i < (*s)->schoolnum; i++)
	{
		(*s)->chos[i] = (int)((*s)->stunum[i] - g)/(*s)->distance+1;
		(*s)->p[i] = (*s)->chos[i] / (float)(*s)->chosenum;
		g = g + (float)((*s)->chos[i] * (*s)->distance - (*s)->stunum[i]);
	}
	return 0;
}
student* initstudent()
{
	student* s = (student*)malloc(sizeof(student));
	if (!s)
	{
		printf("s内存初始化失败\n");
		return NULL;
	}
	printf("请分别输入高校总数和抽样数.\n");
	scanf("%d%d", &s->schoolnum, &s->chosenum );
	s->stunum = (int*)malloc(sizeof(int) * s->schoolnum);
	printf("输入各高校的学生人数\n");
	s->stunum = (int*)malloc(sizeof(int) * s->schoolnum);
	if (!s->stunum)
	{
		printf("stunum内存初始化失败\n");
		return NULL;
	}
	scanf("%d%d%d%d%d%d%d%d%d%d", &s->stunum[0], &s->stunum[1], &s->stunum[2], &s->stunum[3], &s->stunum[4], &s->stunum[5], &s->stunum[6], &s->stunum[7], &s->stunum[8], &s->stunum[9]);
	s->allstudent = s->stunum[0] + s->stunum[1] + s->stunum[2] + s->stunum[3] + s->stunum[4] + s->stunum[5] + s->stunum[6] + s->stunum[7] + s->stunum[8] + s->stunum[9];
	s->distance = (float)s->allstudent / s->chosenum;
	getp_chos(&s);
	return s;
}
int main()
{
	student* s=initstudent();
	printf("被抽中的学校  学生人数  该校被抽中的概率  该校应抽取的样本数\n");
	for (int i = 1; i <= s->schoolnum; i++)
		printf("%-12d  %-8d  %-16.2f  %-18d\n", i, s->stunum[i - 1], s->p[i - 1], s->chos[i - 1]);
	free(s->chos);
	free(s->p);
	free(s->stunum);
	free(s);
	system("pause");
	return 0;
	/*int s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
	printf("请分别输入高校总数、学生总数、抽样数和随机数\n");
	
	scanf("%d%d%d%d", &schoolnum, &studentnum, &stunum, &random);
	printf("输入各高校的人数\n");
	scanf("%d%d%d%d%d%d%d%d%d%d", &s1, &s2, &s3, &s4, &s5, &s6, &s7, &s8, &s9, &s10);*/
}