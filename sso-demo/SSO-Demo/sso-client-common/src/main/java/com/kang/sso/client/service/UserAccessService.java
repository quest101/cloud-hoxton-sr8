package com.kang.sso.client.service;

public interface UserAccessService {

    String getUserToken(String user);

    void putUserStatus(String user, String ssoToken);

    void deleteToken(String token);
}
