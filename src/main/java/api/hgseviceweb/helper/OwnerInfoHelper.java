package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class OwnerInfoHelper {
    
    public static class FolderName {
        public final static String Owner="OWNER";
    }

    public static class URL {
        public final static String List="api/owner_info/list";
        public final static String Create="api/owner_info/create";
        public final static String Update="api/owner_info/update";
        public final static String Delete="api/owner_info/delete";
        public final static String CheckCode="api/owner_info/check_code";
        public final static String DeleteImage="api/owner_info/delete_image";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Owner info not found!");
    }
}
