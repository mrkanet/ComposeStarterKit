package com.mrkanet.thebartender

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform