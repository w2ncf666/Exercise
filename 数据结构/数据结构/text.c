#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define maxn 10
typedef int weighttype;
typedef int vertex;
typedef char datatype;



typedef struct//循环队列
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

//链队列

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
typedef struct//主要是方便插入节点
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
	//记得要判断a空指针
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
	//记得要判断C空指针
	//scanf_s("%d", &vn);
	B = initGraph(vn);
	scanf_s("%d", &B->EN);
	if (B->EN)
	{
		
		for (int i = 0; i < B->EN; i++)
		{
			scanf_s("%d%d%d", &C->v1, &C->v2, &C->weight);
			B->G[C->v1][C->v2] = C->weight;
			B->G[C->v2][C->v1] = C->weight;
		}
	}
	for (int i = 1; i <= vn; i++)
		scanf(" %c", &B->D[i]);
	return B;
}

//以上是邻接矩阵；
//int main()
//{
//	printf("heheh");
//	return 0;
//}



//以下是邻接表；
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
	/*如果是无向图
	Node new = (Node)mallol(sizeof(edge1));
	new->adjvex = a->v1;
	new->weight = a->weight;
	new->nextarc = Lgraph->A[a->v2].firstnode;
	Lgraph->A[a->v2].firstnode = new;
	还要再另外插*/
}

ptrLgraph buildgraph(int en)
{
	int vn;
	scanf_s("%d", &vn);//输入顶点数
	ptrLgraph Lgraph = (ptrLgraph)malloc(sizeof(Lgraph));
	Lgraph = initLgraph(vn);
	scanf_s("%d", &en);//输入边数
	if (en)
	{
		ptredge1 E = (ptredge1)malloc(sizeof(edge1));
		for (int i = 0; i < en; i++)
			scanf_s("%d%d%d",&E->v1,&E->v2,&E->weight);
		insertedge(Lgraph, E);
	}

	//如果头节点存储信息的话；
	for (int j = 0; j < vn; j++)
	{
		scanf("%c", &Lgraph->A[j].data);
	}
	return Lgraph;
}
typedef struct edge2//十字链表
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

}headnode[maxn];
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
	for (int i = 0; i < vex; i++)
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
cross_link bulidcross_link(int en)
{
	int vn;
	scanf("%d", &vn);
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
	return L;
}
int visited[maxn] = { 0 };
DFS(Graph G, int v)//深度优先遍历
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
BFS(Graph G, int v)
{

}
int main()
{
	/*datatype D[10];
		scanf("%c%c%c%c", &D[1],&D[2], &D[3], &D[4]);
	
	*/
	ptrgraph A= buildG(4);
	if (A == NULL)
		return 0;
	DFS(*A, 2);
	

}