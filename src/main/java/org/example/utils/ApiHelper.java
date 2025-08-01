package org.example.utils;

import org.example.apis.ApisInterfaceImp;

public class ApiHelper {
    public static <T, R> R sendPostRequest(String endPoint, T requestBody, Class<R> responseClass) {
        ApisInterfaceImp<T, R> api = new ApisInterfaceImp<>();
        return api.postApiRequest(endPoint, requestBody, responseClass);
    }
}
