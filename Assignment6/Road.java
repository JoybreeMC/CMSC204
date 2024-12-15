
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		weight = degrees;
		this.name = name;
	}
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		weight = 1;
		this.name = name;
	}
	@Override
	public int compareTo(Road o) {
		return name.compareTo(o.getName());
	}
	public boolean contains(Town town) {
		if(source.equals(town) || destination.equals(town)) {
			return true;
		}
		return false;
	}
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			if(((Road)obj).getDestination().equals(destination) || ((Road)obj).getDestination().equals(source)) {
				if(((Road)obj).getSource().equals(destination) || ((Road)obj).getSource().equals(source)) {
					return true;
				}
			}
		}
		return false;
	}
	public Town getDestination() {
		return destination;
	}
	public String getName() {
		return name;
	}
	public Town getSource() {
		return source;
	}
	public int getWeight() {
		return weight;
	}
	public String toString() {
		return name;
	}

}
