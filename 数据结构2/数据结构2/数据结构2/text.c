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



typedef struct//循环队列
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

//链队列

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
	edge E[maxn * (maxn - 1) / 2];
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
insertE(ptrgraph G, ptredge C)
{

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
			scanf_s("%d%d%d", &E->v1, &E->v2, &E->weight);
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
BFS1(Graph G, int v)//用邻接矩阵的广度搜索遍历
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
Kruskal(Graph G)//克鲁斯卡尔算法
{
	int set[maxn] = { 0 };
	int num = 0;//已有边数量
	int k;//记录位置
	side se;//边数组
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
			for (i = 1; i <= G.VN; i++)//找set里面所有相同的集合然后都与se[i].b并在一起，因为可能有很多个，所以需要循环找，并且第一次时候
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
	weighttype path[maxn] = { 0 };//源点到除各点（下标）的距离，0为无法到达。已经找到的
	p paths = { 0 };//正在找的
	for (i = 1; i <= G.VN; i++)
		if (G.G[start][i])
		{
			paths[i].length = G.G[start][i];	//找到一个，更新距离，下次再循环找最小
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
Floyd(Graph G)//弗洛伊德算法，主要是三层for循环，每次最底层循环找插入节点后的最短路劲，然后修改
//三层循环中最外层是插入的节点，中间层是出发节点，最内曾是目的地节点
{
	for (int u = 1; u <= G.VN; u++)
		for (int v = 1; v <= G.VN; v++)
			for (int w = 1; w <= G.VN; w++)
				if (G.G[v][u] + G.G[u][w] < G.G[v][w])//还要预先判断v-u和u-w是否有路径
					;//更新最小路径v-w为v-u-w;
				//多个节点也没事，因为最外层的for（u）会一一尝试每个节点。
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
		s->base = (int*)realloc(s->base, (s->nowsize + ADDSIZE * sizeof(int)));//都要判断是否分配失败，上面初始化也是一样
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
			indegree[i]++;//其实是p指向的节点的下一个节点，当初设计不好
			p++;
		}
	}
}
toplogicalsort(Lgraph G)
{
	//初始化栈，然后求各个顶点的入度，入栈同时减去1入度数，如果有新入度为0，再入栈。
	//逐个打印出出栈的序号，作为拓扑排序。
	//如果有回路（即完成的拓扑排序的顶点数少于原始数目），提示非拓扑序列
	/*关键路径问题即在拓扑排序基础上加一个拓扑栈和最早和最晚时间*/
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
	if (i<1 || i>L->sizeused + 1)//位置非法
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
	/*数组表示：
	int q=i-1;
	for()
	p=sizeused-1+1
	a[p+1]=a[p];
	a[q]=data;*/
}
Listdel(list* L, int i, int* data)
{
	if (i<1 || i>L->sizeused)//位置非法
		return;
	int* p = L->a + i - 1;
	for (; p <= L->sizeused - 1; p++)
		*p = *(p + 1);
	L->sizeused--;
}
typedef struct poly
{
	float coef;//系数
	int expon;//指数
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
poly* polygather(const poly* A, const poly* B)//用链式存储结构存储一元多项式并合并
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
poly* polymutiply(poly* a, poly* b)//一元多项式的相乘
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
	printf("请输入验证的括号\n");
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
			//if()判断是否匹配括号匹配就++并且break；不匹配就return
			//栈空的话也是不匹配
		default:p++;
		}
	}
}
void move(char a, int n, char z)
{
	static int c = 0;
	printf("第%d步，把%d号盘从%c搬到%c\n", ++c, n, a, z);
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
//二叉树顺序链表即为数组表示
typedef struct BiTNode
{
	datatype data;
	struct BiTNode* lchild, * rchild;
}*BiTree,BiTNode;//二叉树的二叉链表存储
typedef struct TriTNode
{
	datatype data;
	struct TriTNode* lchild, * rchild;
	struct TriTNode* parent;
}*TriTree,TriTNode;//三叉链表
preOrdertraverse(BiTree t)//先序遍历二叉树
{
	if (t)
	{
		printf("%c", t->data);
		preOrdertraverse(t->lchild);
		preOrdertraverse(t->rchild);
	}
}
//中中序遍历和后序遍历只是中间的顺序不同，即访问根节点的时机不同，每次都是经过三次，但分别是第一第二第三次访问。
int BiTreeDepth(BiTree t)
{
	int i, j;
	if (!t)
		return 0;
	i = BiTreeDepth(t->lchild);
	j = BiTreeDepth(t->rchild);
	return i > j ? i+1 : j+1;//递归算法，求左右子树的层数赋值给i和j，然后再加1；
}
BiTNode* CreatBiTNode(datatype data, BiTNode* lchild, BiTNode* rchild)
{//用于后序遍历二叉树来复制，也可以用来构造新建二叉树
	BiTNode* new = (BiTNode*)malloc(sizeof(BiTNode));
	if (!new)
		return NULL;
	new->data = data;
	new->lchild = lchild;
	new->rchild = rchild;
	return new;
}
BiTree CopyBiTree2(BiTree t)//后序遍历二叉树复制
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
BiTree CopyBiTree(BiTree t)//先序递归复制二叉树
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
typedef enum{Link,Thread}PointerTag;//枚举类型
typedef struct BiThrNode//线索二叉树
{
	datatype data;
	struct BiThrNode* lchild, *rchild;
	PointerTag ltag, rtag;
}BiThrnode,*BiThrTree;
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
	int n = 0;
	printf("3个塔分别为a，b，c，从a搬到c，输入盘数：");
	scanf("%d", &n);
	hanoi(n, 'a', 'b','c');
}