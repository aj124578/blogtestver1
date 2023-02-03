package shop.mtcoding.blog.util;

public class script {
    public static String back(String msg, String path){
	StringBuffer sb = new StringBuffer();
    sb.append("<script>");
	sb.append("alert('"+ msg + "');");
    sb.append("location.href = '"+ path + "';");
	sb.append("history.back();");
	sb.append("</script>");
    return sb.toString();
    }
}
