package prims;

import java.util.Arrays;

class PrimsAlgo {

	public void Prim(int graph[][], int nodes_num) {

//chose infinite integer value
		int inf = 9999999;
		int edgeNum; // number of edge
		// create a array to track selected vertex
		// selected will become true otherwise false
		boolean[] selected = new boolean[nodes_num];

		// set selected false initially
		Arrays.fill(selected, false);
		char[] nodeName = { 'a', 'b', 'c', 'd', 'e', 'f' };
		char minNodes1[] = new char[6];
		char minNodes2[] = new char[6];

		// initial number of edge to 0
		edgeNum = 0;

		// the number of egde in minimum spanning tree will be always less than (V -1),where V is number of nodes in graph
		// choose 0th vertex and make it true
		selected[0] = true;

		// print edge and weight
		System.out.println("Edge : Weight");

		while (edgeNum < nodes_num - 1) {
			// For every vertex in the set S, find the all adjacent vertices
			// , calculate the distance from the vertex selected in previous step.
			// if the vertex is already in the set S, discard it otherwise
			// choose another vertex nearest to selected vertex in previous.

			int min = inf;
			int x = 0; // row number
			int y = 0; // col number

			for (int i = 0; i < nodes_num; i++) {
				if (selected[i] == true) {
					for (int j = 0; j < nodes_num; j++) {
						// not in selected and there is an edge
						if (!selected[j] && graph[i][j] != 0) {
							if (min > graph[i][j]) {
								min = graph[i][j];
								x = i;
								y = j;
								System.out.println(" The " + i + " vertex is " + nodeName[i]);
								System.out.println(" Minimum node is " + nodeName[j] + " with weight " + graph[i][j]);

							}
						}
					}
				}

			}
			minNodes1[edgeNum] = nodeName[x];
			minNodes2[edgeNum] = nodeName[y];
			System.out.println(nodeName[x] + "-" + nodeName[y] + ":" + graph[x][y]);
			selected[y] = true;
			edgeNum++;

		}
		System.out.println();
		System.out.println("Minimum spanning tree from given graph is like:");
		for (int i = 0; i < minNodes1.length-1; i++) {
			System.out.print(minNodes1[i] + " -> " + minNodes2[i]+" ,");
		}
	}

	public static void main(String[] args) {
		PrimsAlgo primAlgo = new PrimsAlgo();

		// number of nodes in given graph
		int nodes_num = 6;

		// creating a 2d array according to given graph
		int[][] graph = { { 0, 4, 0, 0, 0, 2 }, { 4, 0, 6, 0, 0, 3 }, { 0, 6, 0, 3, 0, 1 }, { 0, 0, 3, 0, 2, 0 },
				{ 0, 0, 0, 2, 0, 4 }, { 2, 3, 1, 0, 4, 0 } };

		primAlgo.Prim(graph, nodes_num);

	}
}