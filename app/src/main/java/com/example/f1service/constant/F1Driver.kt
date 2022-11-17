package com.example.f1service.constant

class F1Driver {

    private var maxVerstappen = "https://www.formula1.com/content/dam/fom-website/drivers/M/MAXVER01_Max_Verstappen/maxver01.png.transform/2col/image.png"
    private var sergioPerez = "https://www.formula1.com/content/dam/fom-website/drivers/S/SERPER01_Sergio_Perez/serper01.png.transform/2col/image.png"
    private var charlesLeclerc = "https://www.formula1.com/content/dam/fom-website/drivers/C/CHALEC01_Charles_Leclerc/chalec01.png.transform/2col/image.png"
    private var georgeRussell = "https://www.formula1.com/content/dam/fom-website/drivers/G/GEORUS01_George_Russell/georus01.png.transform/2col/image.png"
    private var carlosSainz = "https://www.formula1.com/content/dam/fom-website/drivers/C/CARSAI01_Carlos_Sainz/carsai01.png.transform/2col/image.png"
    private var lewisHamilton = "https://www.formula1.com/content/dam/fom-website/drivers/L/LEWHAM01_Lewis_Hamilton/lewham01.png.transform/2col/image.png"
    private var landoNorris = "https://www.formula1.com/content/dam/fom-website/drivers/L/LANNOR01_Lando_Norris/lannor01.png.transform/2col/image.png"
    private var valtteriBottas = "https://www.formula1.com/content/dam/fom-website/drivers/V/VALBOT01_Valtteri_Bottas/valbot01.png.transform/2col/image.png"
    private var estebanOcon = "https://www.formula1.com/content/dam/fom-website/drivers/E/ESTOCO01_Esteban_Ocon/estoco01.png.transform/2col/image.png"
    private var fernandoAlanso = "https://www.formula1.com/content/dam/fom-website/drivers/F/FERALO01_Fernando_Alonso/feralo01.png.transform/2col/image.png"
    private var pierreGasly = "https://www.formula1.com/content/dam/fom-website/drivers/P/PIEGAS01_Pierre_Gasly/piegas01.png.transform/2col/image.png"
    private var kevinMagnussen = "https://www.formula1.com/content/dam/fom-website/drivers/K/KEVMAG01_Kevin_Magnussen/kevmag01.png.transform/2col/image.png"
    private var danielRiccardo = "https://www.formula1.com/content/dam/fom-website/drivers/D/DANRIC01_Daniel_Ricciardo/danric01.png.transform/2col/image.png"
    private var sebastianVettel = "https://www.formula1.com/content/dam/fom-website/drivers/S/SEBVET01_Sebastian_Vettel/sebvet01.png.transform/2col/image.png"
    private var yukiTsunoda = "https://www.formula1.com/content/dam/fom-website/drivers/Y/YUKTSU01_Yuki_Tsunoda/yuktsu01.png.transform/2col/image.png"
    private var zhou = "https://www.formula1.com/content/dam/fom-website/drivers/G/GUAZHO01_Guanyu_Zhou/guazho01.png.transform/2col/image.png"
    private var alexAlbon = "https://www.formula1.com/content/dam/fom-website/drivers/A/ALEALB01_Alexander_Albon/alealb01.png.transform/2col/image.png"
    private var lanceStroll = "https://www.formula1.com/content/dam/fom-website/drivers/L/LANSTR01_Lance_Stroll/lanstr01.png.transform/2col/image.png"
    private var mickSchumacher = "https://www.formula1.com/content/dam/fom-website/drivers/M/MICSCH02_Mick_Schumacher/micsch02.png.transform/2col/image.png"
    private var nikoHulkenberg = "https://www.formula1.com/content/dam/fom-website/drivers/N/NICHUL01_Nico_Hulkenberg/nichul01.png.transform/2col/image.png"
    private var goat = "https://www.formula1.com/content/dam/fom-website/drivers/N/NICLAF01_Nicholas_Latifi/niclaf01.png.transform/2col/image.png"


    fun getLink(driverName: String): String? {
        when(driverName) {
            "Max" -> return maxVerstappen
            "Sergio" -> return sergioPerez
            "Charles" -> return charlesLeclerc
            "George" -> return georgeRussell
            "Carlos" -> return carlosSainz
            "Lewis" -> return lewisHamilton
            "Lando" -> return landoNorris
            "Valtteri" -> return valtteriBottas
            "Esteban" -> return estebanOcon
            "Fernando" -> return fernandoAlanso
            "Pierre" -> return pierreGasly
            "Kevin" -> return kevinMagnussen
            "Daniel" -> return danielRiccardo
            "Sebastian" -> return sebastianVettel
            "Yuki" -> return yukiTsunoda
            "Guanyu" -> return zhou
            "Alexander" -> return alexAlbon
            "Lance" -> return lanceStroll
            "Mick" -> return mickSchumacher
            "Nico" -> return nikoHulkenberg
            "Nicholas" -> return goat

        }
        return null
    }
}