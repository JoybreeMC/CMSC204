
public class Town implements Comparable<Town>{
	private String name;
	public Town(String name) {
		this.name = name;
	}
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}
	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}
	public boolean equals(Object obj){
		if(obj == null) {
			return false;
		}
		if(obj.getClass().equals(this.getClass())) {
			if(((Town) obj).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public int hashCode() {
		return name.hashCode();
	}
	public String toString() {
		return name;
	}
}
