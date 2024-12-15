import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	private ArrayList<Road> roads = new ArrayList<Road>();
	private ArrayList<Town> towns = new ArrayList<Town>();
	private ArrayList<DijkstrasNode> distance = new ArrayList<DijkstrasNode>();
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		for(int i = 0; i < roads.size();i++) {
			if(roads.get(i).contains(destinationVertex)&& roads.get(i).contains(sourceVertex)) {
				return roads.get(i);
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)throws IllegalArgumentException, NullPointerException {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		boolean source = false;
		boolean destination = false;
		for(int i = 0; i < towns.size();i++) { 
			if(towns.get(i).equals(sourceVertex)) {
				source = true;
			}
			if(towns.get(i).equals(destinationVertex)) {
				destination = true;
			}
		}
		if(!source&&!destination)  {
			throw new IllegalArgumentException();
		}
		Road road = new Road(sourceVertex, destinationVertex,weight, description);
		roads.add(road);
		return road;
	}

	@Override
	public boolean addVertex(Town v) {
		for(int i = 0; i < towns.size();i++) {
			if(towns.get(i).equals(v)) {
				return false;
			}
		}
		towns.add(v);
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(int i = 0; i < roads.size();i++) {
			if(roads.get(i).getDestination().equals(destinationVertex)&& roads.get(i).getSource().equals(sourceVertex)) {
				return true;
			}
			if(roads.get(i).getDestination().equals(sourceVertex) && roads.get(i).getSource().equals(destinationVertex)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for(int i = 0; i < towns.size();i++) {
			if(towns.get(i).equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> set = new HashSet<>();
		for(int i = 0; i < roads.size();i++) {
			set.add(roads.get(i));
		}
		return set;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> set = new HashSet<>();
		for(int i = 0; i < roads.size();i++) {
			if(roads.get(i).contains(vertex)) {
				set.add(roads.get(i));
			}
			
		}
		return set;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = new Road(sourceVertex,destinationVertex,weight,description);
		for(int i = 0; i < roads.size();i++) {
			if(roads.get(i).equals(road)) {
				roads.remove(i);
				return road;
			}
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		boolean removed = false;
		for(int i = 0; i < towns.size();i++) {
			if(towns.get(i).equals(v)) {
				towns.remove(i);
				removed = true;
			}
		}
		if(removed) {
			for(int i = 0; i < roads.size(); i++) {
				if(roads.get(i).contains(v)) {
					roads.remove(i);
				}
			}
		}
		return removed;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> set = new HashSet<>();
		for(int i = 0; i < towns.size();i++) {
			set.add(towns.get(i));
		}
		return set;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		ArrayList<String> path = new ArrayList<String>();
		this.dijkstraShortestPath(sourceVertex);
		Town currentTown = destinationVertex;
		boolean searching = true;
		Road connection = null;
		while(searching) {
			for(int i = 0; i< distance.size();i++) {
				if(distance.get(i).getTown().equals(currentTown)) {
					ArrayList<Road> connections = new ArrayList<Road>(this.edgesOf(currentTown));
					for(int j = 0; j < connections.size();j++) {
						if(connections.get(j).contains(distance.get(i).getPrevTown())) {
							connection = connections.get(j);
						}
					}
					if(connection == null) {
						return null;
					}
					path.add(0,distance.get(i).getPrevTown().toString() + " via " + connection.toString() + " to " + currentTown.toString() + " " + connection.getWeight() + " mi" );
					currentTown = distance.get(i).getPrevTown();
					break;
				}
			
			}
			
			if(currentTown.equals(sourceVertex)) {
				searching = false;
			}
		}
		return path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		distance = new ArrayList<DijkstrasNode>();
		ArrayList<Town> unvisited = new ArrayList<Town>();
		ArrayList<Town> visited = new ArrayList<Town>();
		Town nullTown = new Town("");
		for(int i = 0; i < towns.size();i++) {
			unvisited.add(towns.get(i));
			if(!(towns.get(i).equals(sourceVertex))) {
				distance.add(new DijkstrasNode(towns.get(i),2147483646, nullTown));
			}
		}
		boolean compleate = false;
		DijkstrasNode currentNode = new DijkstrasNode(sourceVertex, 0, nullTown);
		distance.add(currentNode);
		while(!compleate) {
			visited.add(currentNode.getTown());
			unvisited.remove(currentNode.getTown());
			ArrayList<Road> a = new ArrayList<Road>(this.edgesOf(currentNode.getTown()));
			for(int i = 0; i< a.size(); i++) {
				for(int j = 0; j< distance.size();j++) {
					if(distance.get(j).getTown().equals(a.get(i).getDestination())||distance.get(j).getTown().equals(a.get(i).getSource())) {
						if(distance.get(j).getDistance() > currentNode.getDistance() + a.get(i).getWeight()) {
							distance.get(j).setDistance(a.get(i).getWeight()+ currentNode.getDistance());
							distance.get(j).setPrevTown(currentNode.getTown());
						}
					}
				}
				
			}
			
			DijkstrasNode shortest = new DijkstrasNode(nullTown,2147483647,nullTown );
			for(int i = 0; i< distance.size();i++) {
				if(distance.get(i).getDistance() < shortest.getDistance()) {
					if(unvisited.contains(distance.get(i).getTown())) {
						shortest = distance.get(i);
					}
					
				}
			}
			
			currentNode = shortest;
			
			
			
			if(unvisited.size() <= 0) {
				compleate = true;
			}
			
		}
	}
	private class DijkstrasNode{
		public Town town;
		public Town prevTown;
		public int distance;
		private DijkstrasNode(Town t, int distance, Town p) {
			town = t;
			prevTown = p;
			this.distance = distance;
		}
		public void setPrevTown(Town p) {
			prevTown = p;
		}
		public void setDistance(int d) {
			distance = d;
		}
		public Town getTown() {
			return town;
		}
		public Town getPrevTown() {
			return prevTown;
		}
		public int getDistance() {
			return distance;
		}
		
	}

}
