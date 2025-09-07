package waterpunch.tool.tool.messeage;

/**
 * @author maguro027
 */
public abstract class ColoredText {

	private static final String RED = "\u001B[31m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";

	public static String setRED(String str) {
		return RED + str + RESET;
	}

	public static String setYELLOW(String str) {
		return YELLOW + str + RESET;
	}

	public static String setBLUE(String str) {
		return BLUE + str + RESET;
	}

	public static String setGREEN(String str) {
		return GREEN + str + RESET;
	}
}
