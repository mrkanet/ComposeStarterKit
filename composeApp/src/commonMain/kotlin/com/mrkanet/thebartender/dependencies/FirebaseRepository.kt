package com.mrkanet.thebartender.dependencies

import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.firestore.FirebaseFirestore

interface FirebaseRepository {
    suspend fun signInAnonymously(): String
    fun isUserSignedIn(): Boolean
}

class FirebaseRepositoryImpl(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : FirebaseRepository {
    override suspend fun signInAnonymously(): String {
        auth.signInAnonymously()
        return auth.currentUser?.uid ?: "Error"
    }

    override fun isUserSignedIn(): Boolean {
        return auth.currentUser != null
    }
}
