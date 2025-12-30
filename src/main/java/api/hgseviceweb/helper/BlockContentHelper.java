package api.hgseviceweb.helper;


import java.util.Arrays;
import java.util.List;

import api.hgseviceweb.security.ApiResponseHandler;

public class BlockContentHelper {
    public static class URL {
        public final static String List="api/block_content/list";
        public final static String Create="api/block_content/create";
        public final static String Update="api/block_content/update";
        public final static String Delete="api/block_content/delete";
    }
     public static class Type{
        public final static List<String> Type = Arrays.asList("Header", "Footer","Body","Service","AboutUs");
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Block content not found!");
    }
}
