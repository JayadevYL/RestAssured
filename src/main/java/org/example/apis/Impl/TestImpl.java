package org.example.apis.Impl;


import org.example.Pojo.testPost.PostRequestPayload;
import org.example.Pojo.testPost.PostResponseBody;
import org.example.utils.ApiHelper;
import org.example.utils.JsonReaderUtil;

public class TestImpl{
    public PostResponseBody getPostRequestResponse(String endPoint){
        PostRequestPayload requestPayload= JsonReaderUtil.getPayloadJsonFileAsPOJO("testPostPayload", PostRequestPayload.class);
        return ApiHelper.sendPostRequest(endPoint,requestPayload,PostResponseBody.class);
   }


}
