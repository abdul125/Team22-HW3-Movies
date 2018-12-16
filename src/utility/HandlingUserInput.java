package utility;

public class HandlingUserInput {

	public static String filter (String text) {
		StringBuffer cleanText = new StringBuffer();
		char letter;

		for (int i = 0; i < text.length(); i++) {
			letter = text.charAt(i);

			switch(letter) {
				case '<':
					cleanText.append("&lt;");
					break;
				case '>':
					cleanText.append("&gt;");
					break;
				case '"':
					cleanText.append("&quot;");
					break;
				case '&':
					cleanText.append("&amp;");
					break;
				default:
					cleanText.append(letter);
			}
		}

		return cleanText.toString();
	}
}
