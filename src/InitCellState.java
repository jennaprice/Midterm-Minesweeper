
public enum InitCellState {
	Free,
	One,
	Two,
	Three,
	Four,
	Five,
	Six,
	Seven,
	Eight,
	Mine;
	
	private static InitCellState[] allValues = values();
	
    public static InitCellState fromOrdinal(int n) {
    	return allValues[n];
    }
    
}

