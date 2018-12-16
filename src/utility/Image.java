package utility;
import javax.servlet.http.HttpServletRequest;

public class Image {
	public static String imageExtension(HttpServletRequest request, String imageLocation) 
	{
		String accept = request.getHeader("accept");

		if(accept.contains("jpg")) 
		{
			return imageLocation + ".jpg";
		} 
		else 
		{
			return imageLocation + ".webp";
		}
	}
}
