package electronic.cart.validations;
/**
 * Util class
 * @author Sravya Yella
 *
 */
public class EcartValidateUtil {

	public static boolean emptyCheck(String string) {
		if(null == string || "".equals(string) || string.trim().length() == 0){
			return false;
		}
		return true;
	}
}
