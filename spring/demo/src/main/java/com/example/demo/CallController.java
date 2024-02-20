package com.example.demo;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value= "/call", method = {RequestMethod.GET, RequestMethod.POST})
public class CallController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> callPatient(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        return ResponseEntity.ok(userService.callPatient(email));
    }
    @GetMapping("off/{id}")
    public ResponseEntity<Boolean> callPatientOff(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        return ResponseEntity.ok(userService.callPatientOff(email));
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Boolean> callAdmin(@PathVariable("id") String email, @RequestHeader("Authorization") String authorizationHeader) throws ExecutionException, InterruptedException, FirebaseAuthException {
        String idToken = authorizationHeader.replace("Bearer ", "");
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        return ResponseEntity.ok(userService.callAdmin(email));
    }
}
