package com.example.f1service.constant

import com.example.f1service.di.FirebaseService
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class F1Team @Inject constructor(
    service: FirebaseFirestore
) {

    private val teamImageURL: HashMap<String,String> = HashMap()

    init {
        service.collection("TeamImageURL")
            .get()
            .addOnSuccessListener { list ->
                list.forEach { doc ->
                    val data = doc.data
                    val iterator = data.iterator()
                    while (iterator.hasNext()) {
                        val value = iterator.next()
                        teamImageURL.put(value.key,value.value.toString())
                    }
                }
            }
    }

    fun getLink(teamName: String): String? {
        return teamImageURL.get(teamName)
    }
}