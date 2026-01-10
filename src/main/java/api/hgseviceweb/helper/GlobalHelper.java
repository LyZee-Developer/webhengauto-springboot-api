package api.hgseviceweb.helper;
public class GlobalHelper {
    public static class Str {
        public static final String GlobalDatabase = "_";
        public static final String ADMIN = "ADMIN";
    }
    public static class Status {
        public final String Success = "Success";
        public final String Fail = "Fail";
    }
    public static class Path {
        public final static String upload = "E:\\Business LyZee\\HengAutoProject\\hgseviceweb\\src\\main\\resources\\static\\upload";
    }
    public String getCurrentPathUpload(){
        String currentWorkingDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentWorkingDirectory);
        return currentWorkingDirectory;
    }
   
}
