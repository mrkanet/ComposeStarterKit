package com.mrkanet.thebartender.firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize

actual fun initializeFirebase() {
    val options = FirebaseOptions.fromResource("GoogleService-Info")
    Firebase.initialize(options)
}

actual val firebaseAuth: FirebaseAuth
    get() = Firebase.auth

actual val firestore: FirebaseFirestore
    get() = Firebase.firestore
