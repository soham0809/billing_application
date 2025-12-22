package in.sohamjoshi.billingsoftware.service;

import in.sohamjoshi.billingsoftware.io.UserRequest;
import in.sohamjoshi.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {



    UserResponse createUser(UserRequest request);
    String getUserRole(String email);
    List<UserResponse> readUsers();
    void deleteUser(String id);
}
