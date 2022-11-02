#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define maxn 10
typedef int weighttype;
typedef int vertex;
typedef char datatype;



typedef struct//ѭ������
{
	int front, rear;
	int maxsize;
	datatype* data;
}Qnode,*Queue;
Queue initqueue(int max)
{
	Queue A =(Queue) malloc(sizeof(Qnode));
	A->data = (datatype*)malloc(max*sizeof(datatype*));
	A->front = A->rear = 0;
	A->maxsize = max;
	return A;
}
int isfull(const Queue A)
{
	return((A->rear + 1) % A->maxsize == A->front);
}
int isempty(const Queue A)
{
	return(A->rear == A->front);
}
int Queueadd(Queue A, datatype B)
{
	if (isfull(A))
		return 0;
	else
	{
		A->data[A->rear] = B;
		A->rear = (A->rear + 1) % A->maxsize;
		return 1;
	}
}
int Queuede(Queue A,datatype*B)
{
	if (isempty(A))
		return 0;
	else
	{
		*B = A->data[A->front];
		A->front=(A->front + 1) % A->maxsize;
		return 1;
	}
}

//������

typedef struct LQnode
{
	datatype data;
	struct LQnode* next;
}LQnode,*ptrLQ;
typedef struct
{
	ptrLQ front, rear;
}LQueue,*ptrLQueue;
ptrLQueue initLQueue( )
{
	ptrLQueue A = (ptrLQueue)malloc(sizeof(LQueue));
	if (A == NULL)
		return NULL;
	A->front = A->rear =(ptrLQ) malloc(sizeof(LQnode));
	if (A->front ==NULL)
		return NULL;
	A->front->next = NULL;
	return A;
}
int Lisempty(const ptrLQueue A)
{
	if (A->front->next == NULL && A->rear->next == NULL)
		return 1;
	else
		return 0;
}
int EnLQueue(ptrLQueue A, datatype B)
{
	ptrLQ new = (ptrLQ)malloc(sizeof(LQnode));
	if (!new)
		return 0;
	new->data = B;
	new->next = NULL;
	A->rear->next = new;
	A->rear = new;
	return 1;
}
int DeLQueue(ptrLQueue A, datatype* B)
{
	if (A->front == A->rear)
		return 0;
	else
	{
		ptrLQ p;
		p = A->front->next;
		*B = p->data;
		A->front->next = p->next;
		if (A->rear == p)
			A->rear = A->front;
		free(p);
		return 1;
	}
}
DestroyQueue(ptrLQueue A)
{
	while (A->front)
	{
		A->rear = A->front->next;
		free(A->front);
		A->front = A->rear;
	}
}
ClearLQueue(ptrLQueue A)
{
	DestroyQueue(A);
	A = initLQueue();
	
}
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
	datatype D[maxn];

}Graph, * ptrgraph;
ptrgraph initGraph(int vertexnum)
{
	vertex v, w;
	ptrgraph a = (ptrgraph)malloc(sizeof(Graph));
	a->EN = 0;
	a->VN = vertexnum;
	//�ǵ�Ҫ�ж�a��ָ��
	for (v = 0; v <= vertexnum; v++)
	{
		for (w = 0; w <= vertexnum; w++)
		{
			a->G[v][w] = 0;
		}
	}
	return a;
}
ptrgraph buildG(int vn)
{
	ptrgraph B;
	ptredge C = (ptredge)malloc(sizeof(edge));
	//�ǵ�Ҫ�ж�C��ָ��
	//scanf_s("%d", &vn);
	B = initGraph(vn);
	scanf_s("%d", &B->EN);
	if (B->EN)
	{
		memset(B->G, 0, sizeof(B->G) * sizeof(char));
		for (int i = 0; i < B->EN; i++)
		{
			scanf_s("%d%d%d", &C->v1, &C->v2, &C->weight);
			B->G[C->v1][C->v2] = C->weight;
			B->G[C->v2][C->v1] = C->weight;
		}
	}
	memset(B->D, 0, sizeof(char) * 10);
	for (int i = 1; i <= vn; i++)
		scanf(" %c", &B->D[i]);
	return B;
}

//�������ڽӾ���
//int main()
//{
//	printf("heheh");
//	return 0;
//}



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
		scanf("%c", &Lgraph->A[j].data);
	}
	return Lgraph;
}
typedef struct edge2//ʮ������
{
	int v1, v2;
	weighttype weight;
}edge2,*ptredge2;
typedef struct corss_link
{
	int tailvex, headvex;
	struct corss_link* hlink, *tlink;
	weighttype weight;
}cross_node,*ptrN;
typedef struct
{
	datatype data;
	ptrN firstin, firstout;

}*ptrnode,headnode[maxn];
typedef struct
{
	int vn, en;
	headnode G;
}cross_link1,*cross_link;
cross_link initcross_link(int vex)
{
	cross_link L = (cross_link)malloc(sizeof(cross_link1));
	L->en = 0;
	L->vn = vex;
	for (int i = 1; i <= vex; i++)
	{
		L->G[i].firstin = L->G[i].firstout = NULL;
	}
	return L;
}
insertedge2(cross_link L,ptredge2 e)
{
	ptrN new = (ptrN)malloc(sizeof(cross_node));
	new->headvex = e->v2;
	new->tailvex = e->v1;
	new->weight = e->weight;
	new->hlink = L->G[e->v2].firstin;
	L->G[e->v2].firstin = new;
	new->tlink = L->G[e->v1].firstout;
	L->G[e->v1].firstout = new;
	
}
cross_link bulidcross_link(int vn)
{
	int en;
	//scanf("%d", &vn);
	cross_link L = initcross_link(vn);
	scanf("%d", &L->en);
	if (L->en)
	{
		ptredge2 E2=(ptredge2)malloc(sizeof(edge2));
		for (int j = 0; j <L->en; j++)
		{
			scanf("%d%d%d", &E2->v1, &E2->v2, &E2->weight);
			insertedge2(L, E2);
		}
		
	}
	for (int i = 1; i <= vn; i++)
		scanf(" %c", &L->G[i].data);
	return L;
}
int visited[maxn] = { 0 };
DFS(Graph G, int v)//������ȱ���
{
	int w = 0;
	visited[v] = 1;
	printf("%c\n", G.D[v]);
	for (; w <= G.VN; w++)
	{
		if (G.G[v][w] && (!visited[w]))
			DFS(G, w);
	}
}
int getvex(Graph G,datatype a)
{
	int i = 0;
	while (a != G.D[i])
		i++;
	return i;
}
int getvex2(Graph G, int v, weighttype a)
{
	int i = 0, j = 0;
	while (a != G.G[v][i])
		i++;
	if (i == G.VN)
		return 0;
	j=i+1;
	while (G.G[v][j] == 0 && j - G.VN)
		j++;
	if (G.G[v][j] == 0)
		return 0;
	else
		return j;
}
BFS1(Graph G, int v)//���ڽӾ���Ĺ����������
{
	ptrLQueue Q = initLQueue();
	EnLQueue(Q, G.D[v]);
	visited[v] = 1;
	int w = 0;
	char i;
	
		while (!Lisempty(Q))
		{
			 DeLQueue(Q, &i);
			printf("%c\n", i);
			v=getvex(G,i);
			for (w = 1; w <= G.VN&&w>0; w = getvex2(G, v, G.G[v][w]))
			{
				if (!visited[w] && G.G[v][w])
				{
					EnLQueue(Q, G.D[w]);
					visited[w] = 1;
				}	
			}
		}
}
ptrnode get1(cross_link1 G, datatype i, ptrN* p )
{
	int j = 0;
	while ( i!=G.G[j].data)
		j++;
	if (G.G[j].firstout == NULL)
		return;
	else
	*p=G.G[j].firstout;
}
BFS2(cross_link1 G, int v)
{
	char i;
	ptrLQueue Q = initLQueue();
	EnLQueue(Q, G.G[v].data);
	visited[v] = 1;
	while (!Lisempty(Q))
	{
		DeLQueue(Q, &i);
		printf("%c\n", i);
		ptrN p=NULL;
		 get1(G, i,&p);
		while (p != NULL)
		{
			if (!visited[p->headvex])
			{
				EnLQueue(Q, G.G[p->headvex].data);
				visited[p->headvex] = 1;
			}
			p = p->tlink;
		}
	}
	for (int j = 1; j <= G.vn; j++)
		if (!visited[j])
			BFS2(G, j);
}
int main()
{
	/*datatype D[10];
		scanf("%c%c%c%c", &D[1],&D[2], &D[3], &D[4]);
	
	*/
	/*ptrgraph A= buildG(8);
	if (A == NULL)
		return 0;
	BFS1(*A, 1);*/
	cross_link B = bulidcross_link(4);
	if (B == NULL)
		return 0;
	BFS2(*B, 2);

}