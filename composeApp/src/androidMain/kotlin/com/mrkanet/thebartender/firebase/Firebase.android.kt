package com.mrkanet.thebartender.firebase

import android.content.Context
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize

actual fun initializeFirebase() {
    // Android initialization is automatic
}

actual val firebaseAuth: FirebaseAuth
    get() = Firebase.auth

actual val firestore: FirebaseFirestore
    get() = Firebase.firestore
