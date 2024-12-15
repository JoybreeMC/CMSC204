import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph map = new Graph();
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town town_1 = new Town(town1);
		Town town_2 = new Town(town2);
		try {
			map.addEdge(town_1, town_2, weight, roadName);
			return true;
		}catch (NullPointerException e) {
			return false;
		}catch(IllegalArgumentException a) {
			return false;
		}
		
		
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town town_1 = new Town(town1);
		Town town_2 = new Town(town2);
		if(map.containsEdge(town_1, town_2)) {
			return map.getEdge(town_1, town_2).toString();
		}
		return null;
	}

	@Override
	public boolean addTown(String v) {
		Town town_1 = new Town(v);
		return map.addVertex(town_1);
	}

	@Override
	public Town getTown(String name) {
		Town town = new Town(name);
		if(map.containsVertex(town)) {
			return town;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v);
		return map.containsVertex(town);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town town_1 = new Town(town1);
		Town town_2 = new Town(town2);
		return map.containsEdge(town_1, town_2);
	}

	@Override
	public ArrayList<String> allRoads() {	
		ArrayList<Road> roads = new ArrayList<Road>(map.edgeSet());
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i< roads.size();i++) {
			names.add(roads.get(i).toString());
		}
		Collections.sort(names);
		return names;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town town_1 = new Town(town1);
		Town town_2 = new Town(town2);
		if(map.removeEdge(town_1, town_2, 1, road) != null) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteTown(String v) {
		Town town_1 = new Town(v);
		return map.removeVertex(town_1);
	}

	@Override
	public ArrayList<String> allTowns() {	
			ArrayList<Town> towns = new ArrayList<Town>(map.vertexSet());
			ArrayList<String> names = new ArrayList<String>();
			for(int i = 0; i< towns.size();i++) {
				names.add(towns.get(i).toString());
			}
			Collections.sort(names);
			return names;
	}

	@Override//Interface says to return null value if no path exists but junit test wants empty arraylist so it is returning an empty arraylist follwing junit test
	public ArrayList<String> getPath(String town1, String town2) {
		Town town_1 = new Town(town1);
		Town town_2 = new Town(town2);
		if(map.shortestPath(town_1, town_2) == null) {
			return new ArrayList<String>();
		}
		return map.shortestPath(town_1, town_2);
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		Scanner scan = new Scanner(selectedFile);
		String line = "";
		String[] arr;
		String road = "";
		String roadName = "";
		int weight = 0;
		String source = "";
		String destination = "";
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			arr = line.split(";");
			road = arr[0];
			source = arr[1];
			destination = arr[2];
			arr = road.split(",");
			roadName = arr[0];
			weight = Integer.parseInt(arr[1]);
			Town town_1 = new Town(source);
			Town town_2 = new Town(destination);
			map.addVertex(town_1);
			map.addVertex(town_2);
			map.addEdge(town_1, town_2, weight, roadName);
		}
		
		
		
	}

}
