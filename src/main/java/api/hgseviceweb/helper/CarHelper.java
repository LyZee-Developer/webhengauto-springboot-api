package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class CarHelper {
    public static class FolderName {
        public final static String Car="car";
    }
    public static class URL {
        public final static String List="api/car/list";
        public final static String Create="api/car/create";
        public final static String Update="api/car/update";
        public final static String Delete="api/car/delete";
        public final static String DeleteImage="api/car/delete_image";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Car not found!");
    }
}
