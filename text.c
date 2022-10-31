
#include<stdio.h>
#include<string>
#define maxn 9999
typedef int weighttype;
typedef int vertex;


typedef struct//主要是方便插入节点
{
	vertex v1, v2;
	weighttype weight;
}edge,*ptredge;
typedef struct
{
	int VN;
	int EN;
	weighttype G[maxn][maxn];

}Graph, *ptrgraph;
ptrgraph initGraph(int vertexnum)
{
	vertex v, w;
	ptrgraph a = (ptrgraph)malloc(sizeof(Graph));
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
		scanf_s("%d", &vn);
		B=initGraph(vn);
		scanf_s("%d", B->EN);
		if (B->EN)
		{
			scanf_s("%d%d%d", C->v1, C->v2, C->weight);
			for (int i = 0; i < B->EN; i++)
			{
				B->G[C->v1][C->v2] = C->weight;
			}
		}
		return B;
}