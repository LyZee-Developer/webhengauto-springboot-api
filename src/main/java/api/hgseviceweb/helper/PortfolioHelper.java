package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class PortfolioHelper {
    public static class FolderName {
        public final static String Portfolio="PORTFOLIO";
    }
    public static class URL {
        public final static String List="api/portfolio/list";
        public final static String Create="api/portfolio/create";
        public final static String Update="api/portfolio/update";
        public final static String Delete="api/portfolio/delete";
        public final static String DeleteImage="api/portfolio/delete_image";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Portfolio not found!");
    }
}
