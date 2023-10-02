package com.example.f1service.constant

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class F1CircuitCountry @Inject constructor(
    service:FirebaseFirestore
) {

    private var flagList:HashMap<String,String> = HashMap()

    init {
        service.collection("CountryFlagURL")
            .get()
            .addOnSuccessListener { list ->
                list.forEach { doc ->
                    val data = doc.data.iterator()
                    val iterator = data.iterator()
                    while (iterator.hasNext()) {
                        val value = iterator.next()
                        flagList.put(value.key,value.value.toString())
                    }
                }
            }
    }

    fun getLink(name:String): String? {
        return flagList[name]
    }

}