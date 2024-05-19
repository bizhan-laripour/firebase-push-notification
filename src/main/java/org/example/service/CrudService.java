package org.example.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.example.entity.Crud;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CrudService {

    public String save(Crud crud) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("Crud").document(crud.getName()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Crud get(String documentId) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("Crud").document(documentId);
        ApiFuture<DocumentSnapshot> documentSnapshot = documentReference.get();
        DocumentSnapshot document = documentSnapshot.get();
        return document.exists() ? document.toObject(Crud.class) : null;
    }

    public String update(Crud crud) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        return null;
    }

    public String delete(String documentId) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = firestore.collection("Crud").document(documentId).delete();
        return "successfully deleted";
    }
}
