package com.mrkanet.thebartender.firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.firestore.FirebaseFirestore

expect fun initializeFirebase()

expect val firebaseAuth: FirebaseAuth

expect val firestore: FirebaseFirestore
