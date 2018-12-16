package com.example.anvesh.kfmessenger

class User(val uid: String, val username: String, val profileImageUrl: String) {
  constructor() : this("", "", "")
}