package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class ServiceTypeHelper {
    public static class URL {
        public final static String List="api/service_type/list";
        public final static String Create="api/service_type/create";
        public final static String Update="api/service_type/update";
        public final static String Delete="api/service_type/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Service type not found!");
    }
}
