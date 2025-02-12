package com.mrkanet.thebartender.dependencies

import kotlinx.coroutines.flow.Flow


interface FirebaseAuthRepository {
    fun signUp(email: String, password: String): Flow<AuthResult>
    fun signIn(email: String, password: String): Flow<AuthResult>
    fun signOut(): Flow<AuthResult>
    fun getCurrentUser(): Flow<AuthResult>
}

sealed class FirebaseAuthResult {
    data class Success(val userId: String) : AuthResult()
    data class Error(val message: String) : AuthResult()
    object Loading : AuthResult()
    object NotLoggedIn : AuthResult()
}

class AuthRepositoryImpl : FirebaseAuthRepository {
    private val auth = FirebaseAuth.getInstance()

    override fun signUp(email: String, password: String): Flow<AuthResult> = flow {
        emit(AuthResult.Loading)
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            emit(AuthResult.Success(result.user?.uid ?: ""))
        } catch (e: Exception) {
            emit(AuthResult.Error(e.message ?: "Unknown error"))
        }
    }

    override fun signIn(email: String, password: String): Flow<AuthResult> = flow {
        emit(AuthResult.Loading)
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            emit(AuthResult.Success(result.user?.uid ?: ""))
        } catch (e: Exception) {
            emit(AuthResult.Error(e.message ?: "Unknown error"))
        }
    }

    override fun signOut(): Flow<AuthResult> = flow {
        emit(AuthResult.Loading)
        try {
            auth.signOut()
            emit(AuthResult.NotLoggedIn)
        } catch (e: Exception) {
            emit(AuthResult.Error(e.message ?: "Unknown error"))
        }
    }

    override fun getCurrentUser(): Flow<AuthResult> = flow {
        emit(AuthResult.Loading)
        val user = auth.currentUser
        if (user != null) {
            emit(AuthResult.Success(user.uid))
        } else {
            emit(AuthResult.NotLoggedIn)
        }
    }
}