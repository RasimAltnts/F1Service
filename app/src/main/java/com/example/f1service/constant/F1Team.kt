package com.example.f1service.constant

class F1Team {
    val redBullLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/red-bull-racing-logo.png.transform/2col/image.png"
    val ferrariLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/ferrari-logo.png.transform/2col/image.png"
    val mercedesLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/mercedes-logo.png.transform/2col/image.png"
    val mcLarenLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/mclaren-logo.png.transform/2col/image.png"
    val alphineLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/alpine-logo.png.transform/2col/image.png"
    val alfaLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/alfa-romeo-logo.png.transform/2col/image.png"
    val alphaTauriLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/alphatauri-logo.png.transform/2col/image.png"
    val haasLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/haas-f1-team-logo.png.transform/2col/image.png"
    val astonMartinLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/aston-martin-logo.png.transform/2col/image.png"
    val williamsLogoURL = "https://www.formula1.com/content/dam/fom-website/teams/2022/williams-logo.png.transform/2col/image.png"


    fun getLink(teamName: String): String {
        when(teamName) {
            "red_bull" -> return redBullLogoURL
            "mercedes" -> return mercedesLogoURL
            "ferrari" -> return ferrariLogoURL
            "alpine" -> return alphineLogoURL
            "alfa" -> return alfaLogoURL
            "aston_martin" -> return astonMartinLogoURL
            "williams" -> return williamsLogoURL
            "haas" -> return haasLogoURL
            "alphatauri" -> return alphaTauriLogoURL
            "mclaren" -> return mcLarenLogoURL
        }
        return "null"
    }
}