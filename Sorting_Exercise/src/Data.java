public class Data {
	int comparisons;
	int exchanges;
	
	public Data(int comparisons, int exchanges) {
		this.comparisons = comparisons;
		this.exchanges = exchanges;
	}
	
	public String toString() {
		return "# of Comparisons:" + this.comparisons + "\n# of Exchanges: " + this.exchanges;
	}

}
