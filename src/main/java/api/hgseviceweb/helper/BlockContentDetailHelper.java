package api.hgseviceweb.helper;


import api.hgseviceweb.security.ApiResponseHandler;

public class BlockContentDetailHelper {
    public static class FolderName {
        public final static String icon="ICON";
    }
    public static class URL {
        public final static String List="api/block_content_detail/list";
        public final static String Create="api/block_content_detail/create";
        public final static String Update="api/block_content_detail/update";
        public final static String Delete="api/block_content_detail/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Block content detail not found!");
    }
}
