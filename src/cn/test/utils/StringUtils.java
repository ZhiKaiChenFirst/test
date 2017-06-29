package cn.test.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**判断是否存在空字符串
 * @author caolijian
 *
 */
public class StringUtils {
	public static boolean isEmpty(String... strings) {
		if (strings==null||strings.length<=0) {
			return true;
		}
		for (String string : strings) {
			if (string!=null&&string.trim().length()!=0&&!string.trim().toLowerCase().equals("null")) {
				continue;
			}
			return true;
		}
		return false;
	}
}
