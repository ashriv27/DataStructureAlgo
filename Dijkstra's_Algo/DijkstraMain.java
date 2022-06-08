
public class DijkstraMain {

	public static void main(String[] args) {
		 Vertex vertexA = new Vertex("A");
	        Vertex vertexB = new Vertex("B");
	        Vertex vertexC = new Vertex("C");
	        Vertex vertexD = new Vertex("D");
	        Vertex vertexE = new Vertex("E");
	        Vertex vertexF = new Vertex("F");
	        
	        vertexA.addNeighbour(new Edge(10,vertexA,vertexB));
	        vertexA.addNeighbour(new Edge(15,vertexA,vertexC));
	        vertexB.addNeighbour(new Edge(12,vertexB,vertexD));
	        vertexB.addNeighbour(new Edge(15,vertexB,vertexF));
	        vertexC.addNeighbour(new Edge(10,vertexC,vertexE));
	        vertexD.addNeighbour(new Edge(2,vertexD,vertexE));
	        vertexD.addNeighbour(new Edge(1,vertexD,vertexF));
	        vertexE.addNeighbour(new Edge(5,vertexE,vertexF));
	 
	        DijkstraAlgo shortestPath = new DijkstraAlgo();
	        shortestPath.calculateShortestPath(vertexA);
	 
	        System.out.println("*******************************");
	        System.out.println("Calculating minimum distance");
	        System.out.println("*******************************");
	 
	        System.out.println("Minimum distance from A to B Node: "+vertexB.getDistance());
	        System.out.println("Minimum distance from A to C Node: "+vertexC.getDistance());
	        System.out.println("Minimum distance from A to D Node: "+vertexD.getDistance());
	        System.out.println("Minimum distance from A to E Node: "+vertexE.getDistance());
	        System.out.println("Minimum distance from A to F Node: "+vertexF.getDistance());
	 
	        System.out.println();
	        System.out.println("Shortest Paths from source to all destinations");
	        System.out.println("**********************************************");
	 
	        System.out.println("Shortest Path from A to B: "+shortestPath.getShortestPathTo(vertexB));
	        System.out.println("Shortest Path from A to C: "+shortestPath.getShortestPathTo(vertexC));
	        System.out.println("Shortest Path from A to D: "+shortestPath.getShortestPathTo(vertexD));
	        System.out.println("Shortest Path from A to E: "+shortestPath.getShortestPathTo(vertexE));
	        System.out.println("Shortest Path from A to F: "+shortestPath.getShortestPathTo(vertexF));

	}

}
