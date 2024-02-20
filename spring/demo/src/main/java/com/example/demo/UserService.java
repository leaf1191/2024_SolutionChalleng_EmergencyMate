package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface UserService {
    List<Map<String, Object>> getNoWaitPatients() throws ExecutionException, InterruptedException;
    int getWaitNum(String email) throws ExecutionException, InterruptedException;
        Map<String, String> getAddInfo(String uid) throws ExecutionException, InterruptedException;
    Role checkUserRole(String uid);
    void addUser(User newUser) throws ExecutionException, InterruptedException;
    void deleteUser(String Uid) throws ExecutionException, InterruptedException;
    void adminDeleteUser(String email) throws ExecutionException, InterruptedException;
    void addNoWaitPatient(User user) throws ExecutionException, InterruptedException;
    void addWaitPatient(User user) throws ExecutionException, InterruptedException;
    void addAdmin(User user) throws ExecutionException, InterruptedException;
    Map<String, Object> getNoWaitPatientById(String email) throws ExecutionException, InterruptedException;
    Map<String, Object> getWaitPatientById(String email) throws ExecutionException, InterruptedException;
    boolean callAdmin(String email) throws InterruptedException, ExecutionException;
    boolean callPatient(String email) throws InterruptedException, ExecutionException;
    boolean callPatientOff(String email) throws InterruptedException, ExecutionException;

}
