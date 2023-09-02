package br.com.fiap.challange.exeptions;

public class ChallangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ChallangeException() {
		super();
	}

	public ChallangeException(String... args) {
		super(formatArgs(args));
	}

	private static String formatArgs(String... args) {
		if (args == null || args.length == 0) {
			return "";
		} else if (args.length == 1) {
			return args[0];
		} else {
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				builder.append(arg).append(" ");
			}
			return builder.toString().trim();
		}
	}
}
