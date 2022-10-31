
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define maxn 9999
typedef int weighttype;
typedef int vertex;
typedef char datatype;


typedef struct//��Ҫ�Ƿ������ڵ�
{
	vertex v1, v2;
	weighttype weight;
}edge, * ptredge;
typedef struct
{
	int VN;
	int EN;
	weighttype G[maxn][maxn];

}Graph, * ptrgraph;
ptrgraph initGraph(int vertexnum)
{
	vertex v, w;
	ptrgraph a = (ptrgraph)malloc(sizeof(Graph));
	//�ǵ�Ҫ�ж�a��ָ��
	for (v = 0; v < vertexnum; v++)
	{
		for (w = 0; w < vertexnum; v++)
		{
			a->G[v][w] = 0;
		}
	}
	return a;
}
ptrgraph buildG()
{
	int vn;
	ptrgraph B;
	ptredge C = (ptredge)malloc(sizeof(edge));
	//�ǵ�Ҫ�ж�C��ָ��
	scanf_s("%d", &vn);
	B = initGraph(vn);
	scanf_s("%d", &B->EN);
	if (B->EN)
	{
		scanf_s("%d%d%d", &C->v1, &C->v2, &C->weight);
		for (int i = 0; i < B->EN; i++)
		{
			B->G[C->v1][C->v2] = C->weight;
		}
	}
	return B;
}

//�������ڽӾ���
int main()
{
	printf("heheh");
	return 0;
}



//�������ڽӱ�
typedef struct
{
	int v1, v2;
	weighttype weight;
}edge1,*ptredge1;
typedef struct arcnode
{
	int adjvex;
	struct arcnode* nextarc;
	weighttype weight;
}arc,*Node;
typedef struct hnode
{
	datatype data;
	Node firstnode;
}Hnode[maxn];
typedef struct
{
	Hnode A;
	int vn;
	int en;
}Lgraph,*ptrLgraph;
ptrLgraph  initLgraph(int vn)
{
	ptrLgraph a = (ptrLgraph)malloc(sizeof(Lgraph));
	a->vn = vn;
	a->en=0;
	for (int i = 0; i < vn; i++)
		a->A[i].firstnode = NULL;
	return a;
}
insertedge(ptrLgraph Lgraph, ptredge1 a)
{
	Node new = (Node)malloc(sizeof(edge1));
	new->adjvex = a->v2;
	new->weight = a->weight;
	new->nextarc = Lgraph->A[a->v1].firstnode;
	Lgraph->A[a->v1].firstnode = new;
	/*���������ͼ
	Node new = (Node)mallol(sizeof(edge1));
	new->adjvex = a->v1;
	new->weight = a->weight;
	new->nextarc = Lgraph->A[a->v2].firstnode;
	Lgraph->A[a->v2].firstnode = new;
	��Ҫ�������*/
}

ptrLgraph buildgraph(int en)
{
	int vn;
	scanf_s("%d", &vn);//���붥����
	ptrLgraph Lgraph = (ptrLgraph)malloc(sizeof(Lgraph));
	Lgraph = initLgraph(vn);
	scanf_s("%d", &en);//�������
	if (en)
	{
		ptredge1 E = (ptredge1)malloc(sizeof(edge1));
		for (int i = 0; i < en; i++)
			scanf_s("%d%d%d",&E->v1,&E->v2,&E->weight);
		insertedge(Lgraph, E);
	}

	//���ͷ�ڵ�洢��Ϣ�Ļ���
	for (int j = 0; j < vn; j++)
	{
		scanf_s("%c", &Lgraph->A[j].data);
	}
	return Lgraph;
}