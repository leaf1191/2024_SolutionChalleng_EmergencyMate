package com.example.demo;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.*;
import com.google.cloud.Timestamp;
import org.springframework.stereotype.Repository;
import com.google.api.core.ApiFuture;
import com.google.firebase.cloud.FirestoreClient;

@Repository
public class UserDao {
    public static final String COLLECTION_NAME0 = "users";
    public static final String COLLECTION_NAME1 = "no_wait_patient";
    public static final String COLLECTION_NAME2 = "wait_patient";
    public static final String COLLECTION_NAME3 = "admin";


    public Map<String, Object> getNoWaitPatientById(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        Query query = db.collection(COLLECTION_NAME1).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
            return userMap;
        }
        return null;
    }

    public Map<String, Object> getWaitPatientById(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        Query query = db.collection(COLLECTION_NAME2).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
            userMap.put("name", document.getString("name"));
            userMap.put("date", document.getString("date"));
            userMap.put("gender", document.getString("gender"));
            userMap.put("symptom", document.getString("symptom"));
            userMap.put("bloodType", document.getString("bloodType"));
            userMap.put("phoneNum", document.getString("phoneNum"));
            userMap.put("phoneNum2", document.getString("phoneNum2"));
            userMap.put("callAdmin", document.getBoolean("callAdmin"));
            userMap.put("callPatient", document.getBoolean("callPatient"));
            return userMap;
        }
        return null;
    }

    public List<Map<String, String>> getUsers() throws ExecutionException, InterruptedException {
        List<Map<String, String>> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME0).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
            list.add(userMap);
        }
        return list;
    }

    public List<Map<String, Object>> getNoWaitPatients() throws ExecutionException, InterruptedException {
        List<Map<String, Object>> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME1).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();


        for (QueryDocumentSnapshot document : documents) {
            Map<String, Object> userMap = new HashMap<>();
            Timestamp timestamp = document.getTimestamp("timestamp");
            if(timestamp != null) {
                userMap.put("uid", document.getString("uid"));
                userMap.put("email", document.getString("email"));
                userMap.put("role", document.getString("role"));
                userMap.put("timestamp", timestamp.getSeconds() * 1000);
                list.add(userMap);
            }
            Comparator<Map<String, Object>> byTs = Comparator.comparingLong(a -> (long) a.get("timestamp"));
            list.sort(byTs);
        }
        return list;
    }
    public List<Map<String, Object>> getWaitPatients() throws ExecutionException, InterruptedException {
        List<Map<String, Object>> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME2).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();


        for (QueryDocumentSnapshot document : documents) {
            Map<String, Object> userMap = new HashMap<>();
            Timestamp timestamp = document.getTimestamp("timestamp");
            if(timestamp != null) {
                userMap.put("uid", document.getString("uid"));
                userMap.put("email", document.getString("email"));
                userMap.put("role", document.getString("role"));
                userMap.put("timestamp", timestamp.getSeconds() * 1000);
                userMap.put("name", document.getString("name"));
                userMap.put("date", document.getString("date"));
                userMap.put("gender", document.getString("gender"));
                userMap.put("symptom", document.getString("symptom"));
                userMap.put("bloodType", document.getString("bloodType"));
                userMap.put("phoneNum", document.getString("phoneNum"));
                userMap.put("phoneNum2", document.getString("phoneNum2"));
                userMap.put("callAdmin", document.getBoolean("callAdmin"));
                userMap.put("callPatient", document.getBoolean("callPatient"));
                list.add(userMap);
            }
            Comparator<Map<String, Object>> byTs = Comparator.comparingLong(a -> (long) a.get("timestamp"));
            list.sort(byTs);
        }
        return list;
    }

    public int getWaitNum(List<Map<String, Object>> list, String email) {
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> userMap = list.get(i);
            if (userMap.get("email").equals(email)) {
                return i + 1;
            }
        }
        return -1;
    }

    public Map<String, String> getAddInfo(String documentId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, String> userMap = new HashMap<>();
        if (documentExists(db.collection(COLLECTION_NAME2), documentId)) {
            DocumentReference documentReference = db.collection(COLLECTION_NAME2).document(documentId);
            DocumentSnapshot document = documentReference.get().get();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
            userMap.put("name", document.getString("name"));
            userMap.put("date", document.getString("date"));
            userMap.put("gender", document.getString("gender"));
            userMap.put("symptom", document.getString("symptom"));
            userMap.put("bloodType", document.getString("bloodType"));
            userMap.put("phoneNum", document.getString("phoneNum"));
            userMap.put("phoneNum2", document.getString("phoneNum2"));
        } else if (documentExists(db.collection(COLLECTION_NAME0), documentId)) {
            DocumentReference documentReference = db.collection(COLLECTION_NAME0).document(documentId);
            DocumentSnapshot document = documentReference.get().get();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
        } else if (documentExists(db.collection(COLLECTION_NAME1), documentId)) {
            DocumentReference documentReference = db.collection(COLLECTION_NAME1).document(documentId);
            DocumentSnapshot document = documentReference.get().get();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
        }
        else if (documentExists(db.collection(COLLECTION_NAME3), documentId)) {
            DocumentReference documentReference = db.collection(COLLECTION_NAME3).document(documentId);
            DocumentSnapshot document = documentReference.get().get();
            userMap.put("uid", document.getString("uid"));
            userMap.put("email", document.getString("email"));
            userMap.put("role", document.getString("role"));
        }
        return userMap;
    }

    public Role checkUserRole(String documentId) {
        Firestore db = FirestoreClient.getFirestore();

        if (documentExists(db.collection(COLLECTION_NAME0), documentId)) {
            return getRoleFromDocument(db.collection(COLLECTION_NAME0).document(documentId));
        } else if (documentExists(db.collection(COLLECTION_NAME1), documentId)) {
            return getRoleFromDocument(db.collection(COLLECTION_NAME1).document(documentId));
        } else if (documentExists(db.collection(COLLECTION_NAME2), documentId)) {
            return getRoleFromDocument(db.collection(COLLECTION_NAME2).document(documentId));
        } else if (documentExists(db.collection(COLLECTION_NAME3), documentId)) {
            return getRoleFromDocument(db.collection(COLLECTION_NAME3).document(documentId));
        }
        return Role.USER;
    }

    private Role getRoleFromDocument(DocumentReference documentReference) {
        try {
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                String role = document.getString("role");
                return role != null ? Role.valueOf(role) : Role.USER;
            }
        } catch (Exception e) {
        }

        return Role.USER;
    }

    public void addWaitPatient(User newUser) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> queryFuture = db.collection(COLLECTION_NAME2).get();
        QuerySnapshot querySnapshot = queryFuture.get();

        DocumentReference documentReference = db.collection(COLLECTION_NAME1).document(newUser.getUid());
        documentReference.delete();

        String documentId = newUser.getUid();
        deleteUser(documentId);

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", newUser.getUid());
        userMap.put("email", newUser.getEmail());
        userMap.put("role", newUser.getRole().toString());
        Timestamp timestamp = Timestamp.now();
        userMap.put("timestamp", timestamp);
        userMap.put("name", newUser.getName());
        userMap.put("date", newUser.getDate());
        userMap.put("gender", newUser.getGender());
        userMap.put("symptom", newUser.getSymptom());
        userMap.put("bloodType", newUser.getBloodType());
        userMap.put("phoneNum", newUser.getPhoneNum());
        userMap.put("phoneNum2", newUser.getPhoneNum2());
        userMap.put("callAdmin", false);
        userMap.put("callPatient", false);
        db.collection(COLLECTION_NAME2).document(newUser.getUid()).set(userMap);

        Map<String, Object> callCheckMap = new HashMap<>();
        callCheckMap.put("callAdmin", false);
        callCheckMap.put("callPatient", false);
        db.collection(COLLECTION_NAME2).document(newUser.getUid()).collection("callCheck").document("checkData").set(callCheckMap);
    }

    public void addUser(User newUser) {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", newUser.getUid());
        userMap.put("email", newUser.getEmail());
        userMap.put("role", newUser.getRole().toString());
        db.collection(COLLECTION_NAME0).document(newUser.getUid()).set(userMap);
    }

    public void deleteUser(String documentId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        if (documentExists(db.collection(COLLECTION_NAME0), documentId)) {
            deleteDocument(db.collection(COLLECTION_NAME0), documentId);
        } else if (documentExists(db.collection(COLLECTION_NAME1), documentId)) {
            deleteDocument(db.collection(COLLECTION_NAME1), documentId);
        }
        else if (documentExists(db.collection(COLLECTION_NAME2), documentId)) {
            deleteDocument(db.collection(COLLECTION_NAME2), documentId);
        }
        else if (documentExists(db.collection(COLLECTION_NAME3), documentId)) {
            deleteDocument(db.collection(COLLECTION_NAME3), documentId);
        }
    }

    public void adminDeleteUser(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        Query query = db.collection(COLLECTION_NAME2).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            String documentId = document.getId();
            deleteDocument(db.collection(COLLECTION_NAME2), documentId);
        }
    }

    private boolean documentExists(CollectionReference collection, String documentId) {
        DocumentReference documentReference = collection.document(documentId);

        try {
            DocumentSnapshot documentSnapshot = documentReference.get().get();
            return documentSnapshot.exists();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while checking document existence: " + e.getMessage());
            return false;
        }
    }
    private boolean deleteDocument(CollectionReference collection, String documentId) {
        DocumentReference documentReference = collection.document(documentId);

        try {
            ApiFuture<WriteResult> deleteFuture = documentReference.delete();
            deleteFuture.get();

            DocumentReference checkDataDocRef = documentReference.collection("callCheck").document("checkData");
            ApiFuture<WriteResult> deleteCheckDataFuture = checkDataDocRef.delete();
            deleteCheckDataFuture.get();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addNoWaitPatient(User user) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        Timestamp timestamp = Timestamp.now();

        DocumentReference documentReference = db.collection(COLLECTION_NAME0).document(user.getUid());
        documentReference.delete();

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", user.getUid());
        userMap.put("email", user.getEmail());
        userMap.put("role", user.getRole().toString());
        userMap.put("timestamp", timestamp);
        db.collection(COLLECTION_NAME1).document(user.getUid()).set(userMap);
    }

    public void addAdmin(User user) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        DocumentReference documentReference = db.collection(COLLECTION_NAME0).document(user.getUid());
        documentReference.delete();

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", user.getUid());
        userMap.put("email", user.getEmail());
        userMap.put("role", user.getRole().toString());
        db.collection(COLLECTION_NAME3).document(user.getUid()).set(userMap);
    }

    public boolean callAdmin(String email) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        Query query = db.collection(COLLECTION_NAME2).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            String documentId = document.getId();
            DocumentReference docRef = db.collection(COLLECTION_NAME2).document(documentId);
            docRef.update("callAdmin", true);
            DocumentReference subDocRef = docRef.collection("callCheck").document("checkData");
            subDocRef.update("callAdmin", true);
            return true;
        }
        return false;
    }

    public boolean callPatient(String email) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        Query query = db.collection(COLLECTION_NAME2).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            String documentId = document.getId();
            DocumentReference docRef = db.collection(COLLECTION_NAME2).document(documentId);
            docRef.update("callPatient", true);
            DocumentReference subDocRef = docRef.collection("callCheck").document("checkData");
            subDocRef.update("callPatient", true);
            return true;
        }
        return false;
    }

    public boolean callPatientOff(String email) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        Query query = db.collection(COLLECTION_NAME2).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            String documentId = document.getId();
            DocumentReference docRef = db.collection(COLLECTION_NAME2).document(documentId);
            docRef.update("callPatient", false);
            DocumentReference subDocRef = docRef.collection("callCheck").document("checkData");
            subDocRef.update("callPatient", false);
            return true;
        }
        return false;
    }
}
