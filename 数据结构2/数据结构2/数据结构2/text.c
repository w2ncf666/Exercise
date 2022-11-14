#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define maxn 12
#define STACK_SIZE 100
#define ADDSIZE 10
#define LIST_SIZE 100
typedef int weighttype;
typedef int vertex;
typedef char datatype;



typedef struct//ѭ������
{
	int front, rear;
	int maxsize;
	datatype* data;
}Qnode, * Queue;
Queue initqueue(int max)
{
	Queue A = (Queue)malloc(sizeof(Qnode));
	A->data = (datatype*)malloc(max * sizeof(datatype*));
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
int Queuede(Queue A, datatype* B)
{
	if (isempty(A))
		return 0;
	else
	{
		*B = A->data[A->front];
		A->front = (A->front + 1) % A->maxsize;
		return 1;
	}
}

//������

typedef struct LQnode
{
	datatype data;
	struct LQnode* next;
}LQnode, * ptrLQ;
typedef struct
{
	ptrLQ front, rear;
}LQueue, * ptrLQueue;
ptrLQueue initLQueue()
{
	ptrLQueue A = (ptrLQueue)malloc(sizeof(LQueue));
	if (A == NULL)
		return NULL;
	A->front = A->rear = (ptrLQ)malloc(sizeof(LQnode));
	if (A->front == NULL)
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
	edge E[maxn * (maxn - 1) / 2];
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
insertE(ptrgraph G, ptredge C)
{

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
}edge1, * ptredge1;
typedef struct arcnode
{
	int adjvex;
	struct arcnode* nextarc;
	weighttype weight;
}arc, * Node;
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
}Lgraph, * ptrLgraph;
ptrLgraph  initLgraph(int vn)
{
	ptrLgraph a = (ptrLgraph)malloc(sizeof(Lgraph));
	a->vn = vn;
	a->en = 0;
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
			scanf_s("%d%d%d", &E->v1, &E->v2, &E->weight);
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
}edge2, * ptredge2;
typedef struct corss_link
{
	int tailvex, headvex;
	struct corss_link* hlink, * tlink;
	weighttype weight;
}cross_node, * ptrN;
typedef struct
{
	datatype data;
	ptrN firstin, firstout;

}*ptrnode, headnode[maxn];
typedef struct
{
	int vn, en;
	headnode G;
}cross_link1, * cross_link;
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
insertedge2(cross_link L, ptredge2 e)
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
		ptredge2 E2 = (ptredge2)malloc(sizeof(edge2));
		for (int j = 0; j < L->en; j++)
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
int getvex(Graph G, datatype a)
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
	j = i + 1;
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
		v = getvex(G, i);
		for (w = 1; w <= G.VN && w > 0; w = getvex2(G, v, G.G[v][w]))
		{
			if (!visited[w] && G.G[v][w])
			{
				EnLQueue(Q, G.D[w]);
				visited[w] = 1;
			}
		}
	}
}
ptrnode get1(cross_link1 G, datatype i, ptrN* p)
{
	int j = 0;
	while (i != G.G[j].data)
		j++;
	if (G.G[j].firstout == NULL)
		return;
	else
		*p = G.G[j].firstout;
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
		ptrN p = NULL;
		get1(G, i, &p);
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
typedef struct
{
	int a, b;
	weighttype weight;
}side[maxn * (maxn - 1) / 2];
Kruskal(Graph G)//��³˹�����㷨
{
	int set[maxn] = { 0 };
	int num = 0;//���б�����
	int k;//��¼λ��
	side se;//������
	for (int i = 1; i <= G.VN; i++)
		for (int j = 1 + 1; j <= G.VN; j++)
			if (G.G[i][j] > 0)
			{
				k = num;
				while (k > 0 && G.G[i][j] < se[k].weight)
				{
					se[k + 1] = se[k];
					k--;
				}
				se[k + 1].a = i;
				se[k + 1].b = j;
				se[k + 1].weight = G.G[i][j];
				num++;
			}
	k = 0; int i = 1; int sb;
	for (; i <= G.VN; i++)
		set[i] = i;
	while (k < G.VN - 1)
	{
		if (set[se[i].b] != set[se[i].a])
		{
			printf("%c--%c", G.D[se[i].a], G.D[se[i].b]);
			sb = set[se[i].a];
			for (i = 1; i <= G.VN; i++)//��set����������ͬ�ļ���Ȼ����se[i].b����һ����Ϊ�����кܶ����������Ҫѭ���ң����ҵ�һ��ʱ��
				if (set[i] == sb)
				{
					set[se[i].b] = set[i];
					break;
				}
			k++;
		}
		i++;
	}
}
typedef struct
{
	int adjvex;
	weighttype lowcost;
}mincost[maxn];
int mininum(Graph G, mincost a)
{
	int k = 0;
	for (int i = 1; i <= G.VN; i++)
		if (!a[i].lowcost)
			k = i;
	for (int j = k + 1; j <= G.VN; j++)
		if (a[j].lowcost && a[k].lowcost > a[j].lowcost)
			k = j;
	return k;
}
minispantree_prim(Graph G, int v)
{
	int k;
	mincost cost;
	for (int i = 1; i <= G.VN; i++)
		if (i != v)
		{
			cost[i].adjvex = v;
			cost[i].lowcost = G.G[v][i];
		}
	cost[v].lowcost = 0;
	for (int i = 1; i < G.VN; i++)
	{
		k = mininum(G, cost);
		cost[k].lowcost = 0;
		printf("%d--%d\n", cost[k].adjvex, k);
		for (int j = 1; j <= G.VN; i++)
			if (G.G[k][j] < cost[i].lowcost)
			{
				cost[j].adjvex = k;
				cost[j].lowcost = G.G[k][j];
			}
	}

}
typedef struct
{
	int adjex;
	weighttype length;
}p[maxn];
weighttype getpath(p paths, int VN, int* j)
{
	int z = 1, a = 1;
	weighttype w = 0;
	while (!paths[z].length && z <= VN)
		z++;
	for (a = z + 1; a <= VN; a++)
		if (!paths[a].length && paths[a].length < paths[z].length)
			z = a;
	w = paths[z].length;
	*j = z;
}
shortpath(Graph G, int start)
{
	int j = 0; int visited[10] = { 0 }; int i = 1;
	weighttype path[maxn] = { 0 };//Դ�㵽�����㣨�±꣩�ľ��룬0Ϊ�޷�����Ѿ��ҵ���
	p paths = { 0 };//�����ҵ�
	for (i = 1; i <= G.VN; i++)
		if (G.G[start][i])
		{
			paths[i].length = G.G[start][i];	//�ҵ�һ�������¾��룬�´���ѭ������С
			paths[i].adjex = i;
		}
	weighttype p = getpath(paths, G.VN, &j);
	path[j] = p;
	visited[j] = 1;
	for (i = 1; i <= G.VN; i++)
	{
		p = getpath(paths, G.VN, &j);
		path[j] = p;
		visited[j] = 1;

		for (i = 1; i <= G.VN; i++)
			if (!visited[i] && G.G[j][i] && path[i] > p + G.G[j][i])
				path[i] = p + G.G[j][i];
	}
}
Floyd(Graph G)//���������㷨����Ҫ������forѭ����ÿ����ײ�ѭ���Ҳ���ڵ������·����Ȼ���޸�
//����ѭ����������ǲ���Ľڵ㣬�м���ǳ����ڵ㣬��������Ŀ�ĵؽڵ�
{
	for (int u = 1; u <= G.VN; u++)
		for (int v = 1; v <= G.VN; v++)
			for (int w = 1; w <= G.VN; w++)
				if (G.G[v][u] + G.G[u][w] < G.G[v][w])//��ҪԤ���ж�v-u��u-w�Ƿ���·��
					;//������С·��v-wΪv-u-w;
				//����ڵ�Ҳû�£���Ϊ������for��u����һһ����ÿ���ڵ㡣
}
typedef struct
{
	int* base, * top;
	int stacksize;
	int nowsize;
}sqstack;
initstack(sqstack* S)
{
	S->base = (int*)malloc(sizeof(int) * STACK_SIZE);
	S->base = S->top;
	S->nowsize = STACK_SIZE;
}
int stackfull(const sqstack* s)
{
	if (s->top - s->base == s->nowsize)
		return 1;
	else
		return 0;
}
int stackempty(const sqstack* s)
{
	if (s->top - s->base == s->base)
		return 1;
	else
		return 0;
}
pushstack(sqstack* s, int d)
{
	if (stackfull)
	{
		s->base = (int*)realloc(s->base, (s->nowsize + ADDSIZE * sizeof(int)));//��Ҫ�ж��Ƿ����ʧ�ܣ������ʼ��Ҳ��һ��
		s->nowsize += ADDSIZE;
	}
	*s->top = d;
	s->top++;
	s->nowsize++;
}
popstack(sqstack* s, int* d)
{
	if (stackempty)
		return;
	s->top--;
	*d = *s->top;
}
destroystack(sqstack* s)
{
	free(s->base);
	s->base = s->top = NULL;
	s->nowsize = 0;
}
clearstack(sqstack* s)
{
	s->top = s->base;
	s->nowsize = 0;
}
findindegree(Lgraph G, int indegree[])
{
	int i = 1;
	Node p;
	for (i = 1; i <= G.vn; i++)
		indegree[i] = 0;
	for (i = 1; i <= G.vn; i++)
	{
		p = G.A[i].firstnode;
		while (p)
		{
			indegree[i]++;//��ʵ��pָ��Ľڵ����һ���ڵ㣬������Ʋ���
			p++;
		}
	}
}
toplogicalsort(Lgraph G)
{
	//��ʼ��ջ��Ȼ��������������ȣ���ջͬʱ��ȥ1�����������������Ϊ0������ջ��
	//�����ӡ����ջ����ţ���Ϊ��������
	//����л�·������ɵ���������Ķ���������ԭʼ��Ŀ������ʾ����������
	/*�ؼ�·�����⼴��������������ϼ�һ������ջ�����������ʱ��*/
}
typedef struct
{
	int* a;
	int sizeused;
	int sizemax;
}list;
initList(list* L)
{
	L->a = (int*)malloc(sizeof(int) * LIST_SIZE);
	if (!L->a)
		return
		L->sizeused = 0;
	L->sizemax = LIST_SIZE;
}Listinsert(list* L, int i, int data)
{
	if (i<1 || i>L->sizeused + 1)//λ�÷Ƿ�
		return;
	if (L->sizeused >= L->sizemax)
	{
		L->a = realloc(L->a, sizeof(int) * ADDSIZE + L->sizemax);
		L->sizemax += ADDSIZE;
	}
	int* q = L->a + i - 1;
	for (int* p = L->a + L->sizeused - 1; p >= q; p--)
		*(p + 1) = *p;
	*q = data;
	L->sizeused++;
	/*�����ʾ��
	int q=i-1;
	for()
	p=sizeused-1+1
	a[p+1]=a[p];
	a[q]=data;*/
}
Listdel(list* L, int i, int* data)
{
	if (i<1 || i>L->sizeused)//λ�÷Ƿ�
		return;
	int* p = L->a + i - 1;
	for (; p <= L->sizeused - 1; p++)
		*p = *(p + 1);
	L->sizeused--;
}
typedef struct poly
{
	float coef;//ϵ��
	int expon;//ָ��
	struct poly* next;
}poly;
attatch(float coef, int expon, poly** C)
{
	poly* temp = (poly*)malloc(sizeof(poly));
	temp->coef = coef;
	temp->expon = expon;
	temp->next = (*C)->next;
	(*C)->next = temp;
	*C = temp;


}
poly* polygather(const poly* A, const poly* B)//����ʽ�洢�ṹ�洢һԪ����ʽ���ϲ�
{
	poly* rear = (poly*)malloc(sizeof(poly));
	rear->next = NULL;
	rear->coef = rear->expon = 0;
	poly* front = rear;
	while (A && B)
	{
		if (A->expon < B->expon)
		{
			attatch(A->coef, A->expon, &rear);
			A = A->next;
		}
		else if (A->expon > B->expon)
		{
			attatch(B->coef, B->expon, &rear);
			B = B->next;
		}
		else
		{
			attatch(A->coef + B->coef, A->expon + B->expon, &rear);
			A = A->next; B = B->next;
		}
		while (A)
		{
			attatch(A->coef, A->expon, &rear);
			A = A->next;
		}
		while (B)
		{
			attatch(B->coef, B->expon, &rear);
			B = B->next;
		}
	}
	poly* temp = front;
	front = front->next;
	free(temp);
	return front;
}
poly* polymutiply(poly* a, poly* b)//һԪ����ʽ�����
{
	poly* rear = (poly*)malloc(sizeof(poly));
	rear->next = NULL;
	rear->coef = rear->expon = 0;
	while (a)
	{
		poly* temp = (poly*)malloc(sizeof(poly));
		poly* front = temp;
		while (b)
		{
			attatch(a->coef * b->coef, a->expon + b->expon, &temp);
			b = b->next;
		}
		a = a->next;
		rear = polygather(rear, front);
		free(front);
		temp = front = NULL;
	}
	return rear;
}
checkmarry()
{
	sqstack* q = (sqstack*)malloc(sizeof(sqstack));
	initstack(q);
	char ch[80], * p;
	printf("��������֤������\n");
	gets(ch);
	p = ch;
	int d;
	while (p)
	{
		switch (*p)
		{
		case'(':
		case'{':
		case'[':pushstack(q, *p);
			p++;
			break;
		case')':
		case'}':
		case']':if (stackempty)
			popstack(q, &d);
			//if()�ж��Ƿ�ƥ������ƥ���++����break����ƥ���return
			//ջ�յĻ�Ҳ�ǲ�ƥ��
		default:p++;
		}
	}
}
void move(char a, int n, char z)
{
	static int c = 0;
	printf("��%d������%d���̴�%c�ᵽ%c\n", ++c, n, a, z);
}
void hanoi(int n, char x, char y, char z)
{
	if (n == 1)
		move(x, n, z);
	else
	{
		hanoi(n - 1, x, z, y);
		move(x, n, z);
		hanoi(n - 1, y, x, z);
	}
}
//������˳������Ϊ�����ʾ
typedef struct BiTNode
{
	datatype data;
	struct BiTNode* lchild, * rchild;
}*BiTree,BiTNode;//�������Ķ�������洢
typedef struct TriTNode
{
	datatype data;
	struct TriTNode* lchild, * rchild;
	struct TriTNode* parent;
}*TriTree,TriTNode;//��������
preOrdertraverse(BiTree t)//�������������
{
	if (t)
	{
		printf("%c", t->data);
		preOrdertraverse(t->lchild);
		preOrdertraverse(t->rchild);
	}
}
//����������ͺ������ֻ���м��˳��ͬ�������ʸ��ڵ��ʱ����ͬ��ÿ�ζ��Ǿ������Σ����ֱ��ǵ�һ�ڶ������η��ʡ�
int BiTreeDepth(BiTree t)
{
	int i, j;
	if (!t)
		return 0;
	i = BiTreeDepth(t->lchild);
	j = BiTreeDepth(t->rchild);
	return i > j ? i+1 : j+1;//�ݹ��㷨�������������Ĳ�����ֵ��i��j��Ȼ���ټ�1��
}
BiTNode* CreatBiTNode(datatype data, BiTNode* lchild, BiTNode* rchild)
{//���ں�����������������ƣ�Ҳ�������������½�������
	BiTNode* new = (BiTNode*)malloc(sizeof(BiTNode));
	if (!new)
		return NULL;
	new->data = data;
	new->lchild = lchild;
	new->rchild = rchild;
	return new;
}
BiTree CopyBiTree2(BiTree t)//�����������������
{
	BiTNode* lchild, * rchild;
	if (!t)
		return NULL;
	lchild = CopyBiTree2(t->lchild);
	rchild = CopyBiTree2(t->rchild);
	BiTNode* node = (BiTNode*)malloc(sizeof(BiTNode));
	node = CreatBiTNode(t->data, lchild, rchild);
	return node;
}
BiTree CopyBiTree(BiTree t)//����ݹ鸴�ƶ�����
{
	if (!t)
		return NULL;
	BiTNode* node = (BiTNode*)malloc(sizeof(BiTNode));
	if (!node)
		return NULL;
	node->data = t->data;
	node->lchild = CopyBiTree(t->lchild);
	node->rchild = CopyBiTree(t->rchild);
	return node;
}
typedef enum{Link,Thread}PointerTag;//ö������
typedef struct BiThrNode//����������
{
	datatype data;
	struct BiThrNode* lchild, *rchild;
	PointerTag ltag, rtag;
}BiThrNode,*BiThrTree;
BiThrNode* pre;
Inthreading(BiThrTree p)
{
	if (!p)
	{
		Inthreading(p->lchild);
		if (!p->lchild)
		{
			p->ltag = Link;
			p->rchild = pre;
		}
		if (!pre->rchild)
		{
			pre->rchild = Link;
			pre->rchild = p;
		}
		pre = p;
		Inthreading(p->rchild);
	}
}
InOrderThreading(BiThrTree t)
{
	BiThrNode* node = (BiThrNode*)malloc(sizeof(BiThrNode));
	if (node)
		return;
	node->ltag = Link;
	node->lchild = t;
	node->rtag = Thread;
	node->rchild = node;
	if (!t)
	{
		node->ltag = Thread;
		node->lchild = node;
		return;
	}
	pre = node;
	Inthreading(t);
	node->rchild->rchild = pre;
	pre->rchild = node;
	pre->rchild = Link;
}
Inordertraverse(BiThrTree t)//t�Ѿ��Ǵ�ͷ�ڵ�ģ�ͷ�ڵ�������Ǻ�����ָ���һ����㣬t�����һ���ڵ���Һ���ָ���̣���Ϊͷ��㣬
                           //t����������ĵ�һ������������ָ��ͷ��㣬��ǰ��ָ����
{
	BiThrNode* h = t->lchild;
	while (h != t)
	{
		while (h->ltag == Link)
			h = h->lchild;
		printf("%c", h->data);
		while (h->rtag == Thread&&h->rchild!=t)
		{
			h = h->rchild;
			printf("%c", h->data);
		}
		h = h->rchild;
	}
}
typedef struct ptnode
{
	datatype data;
	int parent;
}ptnode;
typedef struct
{
	ptnode a[100];
	int root, count;
}ptree;//˫�ױ�ʾ��
typedef struct cdnode
{
	int child;
	struct cdnode* d;
}cdnode;
typedef struct
{
	datatype data;//���ɼ���˫�׵�λ�ã��Դ˱�ʾ����˫�ױ�ʾ����
	cdnode* firstchild;
}cdbox;
typedef struct
{
	cdbox d[100];
	int count, root;
}cdtree;//���ӱ�ʾ��
typedef struct brcdnode
{
	datatype data;
	struct brcdnode* firstchild, * nextbr;
}brcdnode;//�����ֵܱ�ʾ��
typedef struct
{
	unsigned int weight;
	unsigned int parent, lchild, rchild;
}HTNode,*HuffmanTree;
typedef char** HuffmanCode;
int min2(HuffmanTree t, int i)
{
	int j, flag;
	int min = t[1].weight;
	for (j = 1; j <= i; j++)
		if (!t[j].parent && t[j].weight < min)
		{
			min = t[j].weight;
			flag = j;
		}
	t[flag].parent = 1;
}
select(HuffmanTree t, int i,int* s1, int* s2)
{
	s1 = min2(t, i);
	s2 = min2(t, i);
}
creatHuffnan(HuffmanTree t,int n,weighttype weight[],HuffmanCode code)//����������,������������ַ��Ĺ���������
{//n��Ҷ�ӽ���Ӧn����������ַ���
	int m,i,j,f,s1,s2;
	if (n <= 1)
		return;
	m = 2 * n - 1;
	t = (HuffmanTree*)malloc(sizeof(HTNode) * (m + 1));
	if (!t)
		return;
	for (i = 1; i <= n; i++)
	{
		t[i].weight = weight[i - 1];
		t[i].lchild = 0;
		t[i].rchild = 0;
		t[i].parent = 0;
	}
	for (i = n + 1; i <= m; i++)
	{
		select(t,i-1, &s1, &s2);
		t[i].lchild = s1;
		t[i].rchild = s2;
		t[s1].parent = t[s2].parent = i;
		t[i].weight = t[s1].weight + t[s2].weight;
	}
	code = (HuffmanCode)malloc(sizeof(char*) * (n + 1));//����n+1�������Ÿ����ַ��Ĺ����������ַ������׵�ַ���䱾���൱�ڶ�λ���顣
	char* cd = (char*)malloc(sizeof(char) * n);
	cd[n - 1] = '\0';
	for (i = 1; i <= n; i++)
	{
		int start = n - 1;
		for (j = i, f = t[j].parent; f != 0; f = t[f].parent)
			if (t[f].lchild ==f )
				cd[--start] = '0';
			else
				cd[--start] = '1';
		code[i] = (char*)malloc(sizeof(char) * (n - start));
		strcpy(code[i], &cd[start]);
	}
	free(cd);
	cd = NULL;
}
typedef struct
{
	datatype* data;
	int length;
}sstable;
int search1(sstable* s,datatype key)//���ڱ���˳�����
{
	int i;
	s->data[0] = key;//�ڱ�
	for (i = s->length; s->data[i] == key; i--);
	return i;//��i=0ʱ�����Ҳ�������ʾ����ʧ�ܡ���i��=0ʱ����key��data���±ꡣ
}
int search2(sstable* s, datatype key)//�۰���ң����ֲ��ң���
{
	int left = 1, right = s->length, mid;
	while (left <= right)
	{
		mid = (left + right) / 2;
		if (key = s->data[mid])
			return mid;
		else if (key > s->data[mid])
			left = mid + 1;
		else
			right = mid - 1;
	}
	return 0;//����ʧ��
}
typedef struct BSTNode//�����������Ĵ洢
{
	datatype data;
	struct BSTNode* lchild, * rchild;
}BSTNode,*BSTree;
BSTNode* searchBST(BSTree t, datatype key)//�����������Ĳ��ҡ�
{
	if (!t || key == t->data)
		return t;
	else if (key > t->data)
		return searchBST(t->rchild, key);
	else
		return searchBST(t->lchild, key);
}
BSTNode* searchBST2(BSTree t, datatype key,BSTNode*f)//��϶����������Ĳ��Ҳ��������
{
	if (!t)//�ҵ�Ҷ�ӽ�㣬�����ص�ַ
		return f;
	else if (key == t->data)//ԭ���������������Ѿ��д�����Ľ�㣬���ؿ�ָ��
		return NULL;
	else if (key > t->data)
		return searchBST2(t->rchild, key,t);
	else
		return searchBST2(t->lchild, key,t);
}
BSTree InsertBST(BSTree t, datatype data)//�����������Ĳ��Ҳ��������
{
	BSTNode* p = searchBST2(t, data, NULL);
	if (!p)//���ԭ���������������Ѿ��д�����Ľ�㣬p�ǿ�ָ�룬ֱ�ӷ���t��1��
		return t;
	else//ԭ������������û�д�����Ľ�㣨1��
	{
		BSTNode* s = (BSTNode*)malloc(sizeof(BSTNode));//���ɴ�����Ľ��
		if (!s)
			return NULL;
		s->data = data;
		s->lchild = s->rchild = NULL;
		if (!t)//���վ�ֱ�Ӳ��ڸ���㣨2��
			t = s;
		else//���ǿգ�2��
		{
			if (data > p->data)//�������������������
				p->rchild = s;
			else//�������������������
				p->lchild = s;
		}
		return t;
	}
}
delete(BSTree* t, datatype data)//ɾ������Ȼ���ܵ���ԭƽ�������ʧ�⣬��Ҫ���µ���
{//������ɾ����㲢�ҳ���ƽ�������
	BSTNode* p = *t, * s;
	if (!(*t)->lchild)
	{
		*t = (*t)->rchild;
		free(p);
	}
	else if (!(*t)->rchild)
	{
		*t = (*t)->lchild;
		free(p);
	}
	else//�Ҵ�ɾ������ǰ��
	{
		s = (*t)->lchild;
		while (s->rchild)
			s = s->rchild;
		p->data = s->data;
		if (s->lchild)
			s = s->lchild;
		free(s);	
	}
	/*�Ҵ�ɾ�����ĺ��
	else
	s = (*t)->rchild;
		while (s->lchild)
			s = s->lchild;
		p->data = s->data;
		if (s->rchild)
			s = s->rchild;
		free(s);
	*/
}
BSTree DeleteBST(BSTree t, datatype data)//�����Ƕ�λ��ɾ���Ľ��
{
	if (!t)
		return NULL;
	if (data == t->data)
		delete(&t, data);
	else if (data > t->data)
		DeleteBST(&t->rchild, data);
	else
		DeleteBST(&t->lchild, data);
	return t;
}
InsertSort(int arr[],int length)//ֱ�Ӳ���������ڱ�
{
	int i,j;
	for (i = 2; i <= length; i++)
	{
		if (arr[i] > arr[i - 1])
			continue;
		arr[0] = arr[i];
		j = i - 1;
		while (arr[0] < arr[j])
		{
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = arr[0];
	}
}
BInsertSort(int arr[], int length)//�۰��������
{
	int i, j,low,high,mid;
	for (i = 2; i <= length; i++)
	{
		arr[0] = arr[i];
		low = 1;
		high = i - 1;
		while (low <= high)
		{
			mid = (low + high) / 2;
			if (arr[0] >= arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		for (j = i - 1; j >= high + 1; j--)
			arr[j + 1] = arr[j];
		arr[j + 1] = arr[0];
	}
}
ShellInsertSort(int arr[],int length, int dk[], int t)//ϣ������
{
	int i, j,k;
	for (i = 0; i < t; i++)
	{
		for (j = 1 + dk[i]; j <= length; j++)
		{
			if (arr[j] > arr[j - dk[i]])
				continue;
			arr[0] = arr[j];
			k = j;
			for (k -= dk[i]; k > 0 && arr[0] < arr[k]; k -= dk[i])
				arr[k + dk[i]] = arr[k];
			arr[k + dk[i]] = arr[0];
		}
		for (int i = 1; i <= length; i++)
			printf("%d ", arr[i]);
		printf("\n");
	}
}
bubble_sort(int arr[], int length)//ð������
{
	int temp,flag=1;
	for (int i = 0; i < length - 1&&flag; i++)
	{
		flag = 0;
		for (int j = 1; j <= length - 1 - i; j++)
			if (arr[j] > arr[j + 1])
			{
				temp = arr[j];
				arr[j] = arr[j + 1]; arr[j + 1] = temp;
				flag = 1;
			}
	}
}
int Partition(int arr[], int low, int high)//������
{
	arr[0] = arr[low];
	while (low < high)
	{
		while (arr[high] >= arr[0] && low < high)
			high--;
		arr[low] = arr[high];
		while (arr[low] <= arr[0] && low < high)
			low++;
		arr[high] = arr[low];
	}
	arr[high] = arr[0];
	return high;
}
my_qsort(int arr[], int start, int end)//��������ݹ��㷨
{
	if (start < end)
	{
		int pivotloc = Partition(arr, start, end);
		my_qsort(arr, start, pivotloc - 1);
		my_qsort(arr, pivotloc + 1, end);
	}
}
int getmin(int arr[],int start,int length)
{
	int j,k=start;
	int min = arr[start];
	for (j = start + 1; j <= length; j++)
		if (arr[j] < min)
		{
			min = arr[j];
			k = j;
		}
	return k;
}
selectsort(int arr[], int length)//�ǽ���λ�ã�����ֱ�Ӹ��ǣ���ΪҪ��ԭ�������Դ洢�ṹ�м�������Сֵ
{
	int min,temp;
	for (int i = 1; i <= length; i++)
	{
		min = getmin(arr, i, length);
		if (min != i)
		{
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}
heapadjust(int arr[], int start, int end,int length)//�ѵ���
{
	int j;
	arr[0] = arr[start];
	for(j=start*2;j<=length;j*=2)
	{
		if (j<length &&arr[j] > arr[j + 1])
			j++;
		if (arr[0] < arr[j])
			break;
		arr[start] = arr[j];//�����ڴ˽����滻��������Ϊһ���õ������������Ԫ�ض��Ǻܴ������ģ���ʱ�����滻���˷Ѵ���ʱ��Ϳռ�
		start = j;            //��start��סj��λ�þͿ����ˣ��൱��һֱ�Ѻ��ӽڵ�����Ų������˴�����arr[start]�����γɴ�С������
	}
	arr[start] = arr[0];//���ڴ˽�arr[0]��ֵ���ϼ��ɡ�
}
heapsort(int arr[],int length)//������     �����������С���Ѿͻ��������������������Ѿ�����������
{
	int i;
	for (i = length / 2; i > 0; i--)//��Ҷ�ӽ��ĸ���㿪ʼ������ʼ��
		heapadjust(arr, i, length,length);
	for (i = length; i > 1; i--)
	{
		arr[0] = arr[1];
		arr[1] = arr[i];
		arr[i] = arr[0];
		heapadjust(arr, 1, i - 1, i - 1);
	}
}
Merge(int source[], int dest[], int i, int m, int n)
{
	int k,l;
	for (k = i, l = m + 1; i <= m && l <= n; i++)
		if (source[i] <= source[l])
			dest[k++] = source[i];
		else
			dest[k++] = source[l];
	while (i <= m)
		dest[k++] = source[i++];
	while (l <= n)
		dest[k++] = source[l++];
}
Msort(int random[], int sorted[],int start,int end)
{
	if (start == end)
		sorted[start] = random[start];
	else
	{
		int temp[100] = { 0 };
		int mid = (start + end) / 2;
		Msort(random, temp, start, mid);
		Msort(random, temp, mid + 1, end);
		Merge(temp, sorted, start, mid, end);
	}
}
int main()
{
	/*datatype D[10];
		scanf("%c%c%c%c", &D[1],&D[2], &D[3], &D[4]);

	*/
	/*ptrgraph A = buildG(6);
	if (A == NULL)
		return 0;
	shortpath(*A, 1);*/
	//Kruskal(*A);
	/*BFS1(*A, 1);*/
	/*cross_link B = bulidcross_link(4);
	if (B == NULL)
		return 0;
	BFS2(*B, 2);*/
	/*int n = 0;
	printf("3�����ֱ�Ϊa��b��c����a�ᵽc������������");
	scanf("%d", &n);
	hanoi(n, 'a', 'b','c');*/
	int arr[5] = { 0,5,7,2,3, };
	int srr[5]={0};
	//int arr[10] = { 0,2,5,3,10,7,6,3,5,8 };
	//int dk[10] = { 0 };
	Msort(arr,srr,1,4);
	//int a[5] = { 0,6,8,2,3};
	//int b[5];
	//Merge(arr, dk, 1, 2,4);
	for (int i = 1; i <= 4; i++)
		printf("%d ",srr[i]);
	return 0;
}