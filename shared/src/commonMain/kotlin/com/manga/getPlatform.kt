package com.manga

expect fun getPlatform(): Platform

interface Platform {
    val name: String
}