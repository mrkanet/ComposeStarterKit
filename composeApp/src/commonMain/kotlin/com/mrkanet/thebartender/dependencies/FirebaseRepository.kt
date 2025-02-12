package com.mrkanet.thebartender.dependencies

interface FirebaseRepository {
    fun signIn(): String
    fun isUserSignedIn(): Boolean
}

class FirebaseRepositoryImpl(
    private val dbClient: DBClient
) : FirebaseRepository {
    override fun signIn(): String {
        return "Signed In"
    }

    override fun isUserSignedIn(): Boolean {
        return true
    }
}