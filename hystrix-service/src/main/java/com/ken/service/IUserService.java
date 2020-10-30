package com.ken.service;

import java.util.Map;

public interface IUserService {

    Map<String, Object> getUserList();

    Map<String, Object> getCacheUserList();

    void removeCache();
}
