package com.example.f1service.constant

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject


class F1Driver @Inject constructor(
     service:FirebaseFirestore
) {
    private val driverList:HashMap<String,String> = HashMap()

    init {
        service.collection("DriverImageURL")
            .get()
            .addOnSuccessListener { list ->
                list.forEach { doc ->
                    val data = doc.data
                    val iterator = data.iterator()
                    while (iterator.hasNext()) {
                        val value = iterator.next()
                        driverList.put(value.key,value.value.toString())
                    }
                }
            }
    }

    fun getLink(name:String): String? {
        return driverList[name]
    }
}