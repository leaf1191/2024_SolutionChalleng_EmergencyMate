package com.example.demo;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;


import lombok.RequiredArgsConstructor;

import static com.example.demo.Role.WAIT_PATIENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(value= "/list", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNoWaitPatient(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        Map<String, Object> patient = userService.getNoWaitPatientById(email);
        if (patient != null) {
            return ResponseEntity.ok().body(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wait/{id}")
    public ResponseEntity<Object> getWaitPatient(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        Map<String, Object> patient = userService.getWaitPatientById(email);
        if (patient != null) {
            return ResponseEntity.ok().body(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get_no_wait_patients")
    public ResponseEntity<Object> getNoWaitPatients(@RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        List<Map<String, Object>> list = userService.getNoWaitPatients();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/add_info/{id}")
    public ResponseEntity<List<String>> addInfo(@PathVariable("id") String email, @RequestBody Map<String,Object> userInfo, @RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");
        try {
            FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = (String) userInfo.get("uid");
            String name = (String) userInfo.get("name");
            String date = (String) userInfo.get("date");
            String gender = (String) userInfo.get("gender");
            String symptom = (String) userInfo.get("symptom");
            String bloodType = (String) userInfo.get("bloodType");
            String phoneNum = (String) userInfo.get("phoneNum");
            String phoneNum2 = (String) userInfo.get("phoneNum2");

            List<String> userList = new ArrayList<>();
            userList.add(uid);
            userList.add(email);
            userList.add(String.valueOf(WAIT_PATIENT));
            userList.add(name);
            userList.add(date);
            userList.add(gender);
            userList.add(symptom);
            userList.add(bloodType);
            userList.add(phoneNum);
            userList.add(phoneNum2);

            User addInfo = new User();
            addInfo.setUid(uid);
            addInfo.setEmail(email);
            addInfo.setRole(WAIT_PATIENT);
            addInfo.setName(name);
            addInfo.setDate(date);
            addInfo.setGender(gender);
            addInfo.setSymptom(symptom);
            addInfo.setBloodType(bloodType);
            addInfo.setPhoneNum(phoneNum);
            addInfo.setPhoneNum2(phoneNum2);
            userService.addWaitPatient(addInfo);
            return ResponseEntity.ok().body(userList);

        } catch (ExecutionException | InterruptedException | FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/mine")
    public ResponseEntity<Map<String, String>> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            Map<String, String> addInfo = userService.getAddInfo(uid);
            return ResponseEntity.ok(addInfo);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Invalid token"));
        }
    }

    @GetMapping("/waitNum")
    public ResponseEntity<Integer> getWaitNum(@RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        String email = decodedToken.getEmail();
        return ResponseEntity.ok(userService.getWaitNum(email));
    }

    @PostMapping("/add_user")
    public ResponseEntity<List<String>> addUser(@RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();

            Role role = userService.checkUserRole(uid);

            List<String> user = new ArrayList<>();
            user.add(uid);
            user.add(email);
            user.add(role.toString());

            User newUser = new User();
            newUser.setUid(uid);
            newUser.setEmail(email);
            newUser.setRole(role);
            userService.addUser(newUser);
            return ResponseEntity.ok(user);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonList("Invalid token"));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<List<String>> deleteUser(@RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            userService.deleteUser(uid);
            return ResponseEntity.ok(Collections.singletonList("logout"));
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonList("Invalid token"));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<String>> AdminDeleteUser(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseAuth.getInstance().verifyIdToken(idToken);
            userService.adminDeleteUser(email);
            return ResponseEntity.ok(Collections.singletonList("delete"));
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonList("Invalid token"));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add_no_wait_patient")
    public ResponseEntity<User> addNoWaitPatient(@RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();
            userService.deleteUser(uid);

            User newUser = new User();
            newUser.setUid(uid);
            newUser.setEmail(email);
            newUser.setRole(Role.NO_WAIT_PATIENT);
            userService.addNoWaitPatient(newUser);
            return ResponseEntity.ok(newUser);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((User) Collections.singletonList("Invalid token"));
        }
    }
    @PostMapping("/add_wait_patient")
    public ResponseEntity<User> addWaitPatient(@RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();
            userService.deleteUser(uid);

            User newUser = new User();
            newUser.setUid(uid);
            newUser.setEmail(email);
            newUser.setRole(WAIT_PATIENT);
            userService.addWaitPatient(newUser);
            return ResponseEntity.ok(newUser);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((User) Collections.singletonList("Invalid token"));
        }
    }
    @PostMapping("/add_admin")
    public ResponseEntity<User> addAdmin(@RequestHeader("Authorization") String authorizationHeader) {
        String idToken = authorizationHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();
            userService.deleteUser(uid);

            User newUser = new User();
            newUser.setUid(uid);
            newUser.setEmail(email);
            newUser.setRole(Role.ADMIN);
            userService.addAdmin(newUser);
            return ResponseEntity.ok(newUser);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((User) Collections.singletonList("Invalid token"));
        }
    }
}


