package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public Map<String, Object> getNoWaitPatientById(String email) throws ExecutionException, InterruptedException {
        return userDao.getNoWaitPatientById(email);
    }

    public Map<String, Object> getWaitPatientById(String email) throws ExecutionException, InterruptedException {
        return userDao.getWaitPatientById(email);
    }

    public List<Map<String, Object>> getNoWaitPatients() throws ExecutionException, InterruptedException {
        return userDao.getNoWaitPatients();
    }
    public int getWaitNum(String email) throws ExecutionException, InterruptedException {
        List<Map<String, Object>> list = userDao.getWaitPatients();
        return userDao.getWaitNum(list, email);
    }
    public Map<String, String> getAddInfo(String uid) throws ExecutionException, InterruptedException {
        return userDao.getAddInfo(uid);
    }

    public Role checkUserRole(String uid) {
        return userDao.checkUserRole(uid);
    }

    public void addUser(User newUser) throws ExecutionException, InterruptedException {
        userDao.addUser(newUser);
        userDao.getUsers();
    }

    public void deleteUser(String uid) throws ExecutionException, InterruptedException {
        userDao.deleteUser(uid);
    }

    public void adminDeleteUser(String email) throws ExecutionException, InterruptedException {
        userDao.adminDeleteUser(email);
    }

    public void addNoWaitPatient(User user) throws ExecutionException, InterruptedException {
        userDao.addNoWaitPatient(user);
    }

    public void addWaitPatient(User user) throws ExecutionException, InterruptedException {
        userDao.addWaitPatient(user);
    }

    public void addAdmin(User user) throws ExecutionException, InterruptedException {
        userDao.addAdmin(user);
    }

    public boolean callAdmin(String email) throws InterruptedException, ExecutionException {
        return userDao.callAdmin(email);
    }

    public boolean callPatient(String email) throws InterruptedException, ExecutionException {
        return userDao.callPatient(email);
    }

    public boolean callPatientOff(String email) throws InterruptedException, ExecutionException {
        return userDao.callPatientOff(email);
    }
}
