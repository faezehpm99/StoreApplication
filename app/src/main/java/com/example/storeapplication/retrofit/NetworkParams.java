package com.example.storeapplication.retrofit;

import java.util.HashMap;
import java.util.Map;

public class NetworkParams {
    public static final String Customer_KEY = "ck_ca237326f289cfbcfc1c2be0dec147ed53ca6d71";
    public static final String Cusomer_secret = "cs_dd9277e750a9c8e832c2f175ee5d7eff2586f1c1";
    public static final String BASE_URL = "https://woocmmerce.maktabsharif.ir/wp-json/wc/v3/";

    public static final Map<String, String> BaseMap = new HashMap<String, String>() {{
        BaseMap.put("consumer_key", Customer_KEY);
        BaseMap.put("consumer_secret", Cusomer_secret);
    }};
   /* public static final Map<String, String> newProductListMap = new HashMap<String, String>() {{
     newProductListMap.putAll(BaseMap);
     newProductListMap.put("orderBy","popularity");
    }};*/
    public static final Map<String, String> highRatedProductList = new HashMap<String, String>() {{
        highRatedProductList.putAll(BaseMap);
     highRatedProductList.put("orderBy","rating");
    }};
  /*  public static final Map<String, String> newProductList = new HashMap<String, String>() {{
       newProductList.putAll(BaseMap);
       newProductList.put("orderBy","New");
    }};*/

}
