package com.example.f1service.constant

class F1CircuitCountry {
    val bahreyh = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/bahrain-flag.png.transform/2col/image.png"
    val saudiArabia = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/saudi-arabia-flag.png.transform/2col/image.png"
    val australia = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/australia-flag.png.transform/2col/image.png"
    val italy = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/italy-flag.png.transform/2col/image.png"
    val unitedStates = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/united-states-flag.png.transform/2col/image.png"
    val spain = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/spain-flag.png.transform/2col/image.png"
    val monaco = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/monaco-flag.png.transform/2col/image.png"
    val azerbaijan = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/azerbaijan-flag.png.transform/2col/image.png"
    val canada = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/canada-flag.png.transform/2col/image.png"
    val greatBritain = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/great-britain-flag.png.transform/2col/image.png"
    val austria = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/austria-flag.png.transform/2col/image.png"
    val france = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/france-flag.png.transform/2col/image.png"
    val hungary = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/hungary-flag.png.transform/2col/image.png"
    val belgium = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/belgium-flag.png.transform/2col/image.png"
    val netherlands = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/netherlands-flag.png.transform/2col/image.png"
    val singapore = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/singapore-flag.png.transform/2col/image.png"
    val japan = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/japan-flag.png.transform/2col/image.png"
    val mexico = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/mexico-flag.png.transform/2col/image.png"
    val brazil = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/brazil-flag.png.transform/2col/image.png"
    val abuDhabi = "https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Flags%2016x9/abu-dhabi-flag.png.transform/2col/image.png"

    fun getLink(key:String):String? {
        var url:String ?= null
        when(key) {
            "Bahrain" -> url = bahreyh
            "Saudi Arabia" -> url = saudiArabia
            "Australia" -> url = australia
            "Italy" -> url = italy
            "USA" -> url = unitedStates
            "Spain" -> url = spain
            "Monaco" -> url = monaco
            "Azerbaijan" -> url = azerbaijan
            "Canada" -> url = canada
            "UK" -> url = greatBritain
            "France" -> url = france
            "Austria" -> url = austria
            "Hungary" -> url = hungary
            "Belgium" -> url = belgium
            "Netherlands" -> url = netherlands
            "Mexico" -> url = mexico
            "Singapore" -> url = singapore
            "Japan" -> url = japan
            "Brazil" -> url = brazil
            "UAE" -> url = abuDhabi
        }
        return url
    }
}