package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class PartnerSupportHelper {
    public static class URL {
        public final static String List="api/partner_support/list";
        public final static String Create="api/partner_support/create";
        public final static String Update="api/partner_support/update";
        public final static String Delete="api/partner_support/delete";
        public final static String DeleteImage="api/partner_support/delete_image";
    }
    public static class FolderName {
        public final static String PartnerSupport="PARTNER_SUPPORT";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Partner support not found!");
    }
}
