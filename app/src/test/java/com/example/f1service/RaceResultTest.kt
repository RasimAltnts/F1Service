package com.example.f1service

import com.example.f1service.mapper.LastRaceMapper
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

class RaceResultTest {
    val mLastRaceMapper = LastRaceMapper()
    val res = "{\n" +
            "  \"MRData\": {\n" +
            "    \"xmlns\": \"http://ergast.com/mrd/1.5\",\n" +
            "    \"series\": \"f1\",\n" +
            "    \"url\": \"http://ergast.com/api/f1/current/last/results.json\",\n" +
            "    \"limit\": \"30\",\n" +
            "    \"offset\": \"0\",\n" +
            "    \"total\": \"20\",\n" +
            "    \"RaceTable\": {\n" +
            "      \"season\": \"2022\",\n" +
            "      \"round\": \"22\",\n" +
            "      \"Races\": [\n" +
            "        {\n" +
            "          \"season\": \"2022\",\n" +
            "          \"round\": \"22\",\n" +
            "          \"url\": \"http://en.wikipedia.org/wiki/2022_Abu_Dhabi_Grand_Prix\",\n" +
            "          \"raceName\": \"Abu Dhabi Grand Prix\",\n" +
            "          \"Circuit\": {\n" +
            "            \"circuitId\": \"yas_marina\",\n" +
            "            \"url\": \"http://en.wikipedia.org/wiki/Yas_Marina_Circuit\",\n" +
            "            \"circuitName\": \"Yas Marina Circuit\",\n" +
            "            \"Location\": {\n" +
            "              \"lat\": \"24.4672\",\n" +
            "              \"long\": \"54.6031\",\n" +
            "              \"locality\": \"Abu Dhabi\",\n" +
            "              \"country\": \"UAE\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"date\": \"2022-11-20\",\n" +
            "          \"time\": \"13:00:00Z\",\n" +
            "          \"Results\": [\n" +
            "            {\n" +
            "              \"number\": \"1\",\n" +
            "              \"position\": \"1\",\n" +
            "              \"positionText\": \"1\",\n" +
            "              \"points\": \"25\",\n" +
            "              \"Driver\": {\n" +
            "                \"driverId\": \"max_verstappen\",\n" +
            "                \"permanentNumber\": \"33\",\n" +
            "                \"code\": \"VER\",\n" +
            "                \"url\": \"http://en.wikipedia.org/wiki/Max_Verstappen\",\n" +
            "                \"givenName\": \"Max\",\n" +
            "                \"familyName\": \"Verstappen\",\n" +
            "                \"dateOfBirth\": \"1997-09-30\",\n" +
            "                \"nationality\": \"Dutch\"\n" +
            "              },\n" +
            "              \"Constructor\": {\n" +
            "                \"constructorId\": \"red_bull\",\n" +
            "                \"url\": \"http://en.wikipedia.org/wiki/Red_Bull_Racing\",\n" +
            "                \"name\": \"Red Bull\",\n" +
            "                \"nationality\": \"Austrian\"\n" +
            "              },\n" +
            "              \"grid\": \"1\",\n" +
            "              \"laps\": \"58\",\n" +
            "              \"status\": \"Finished\",\n" +
            "              \"Time\": {\n" +
            "                \"millis\": \"5265914\",\n" +
            "                \"time\": \"1:27:45.914\"\n" +
            "              },\n" +
            "              \"FastestLap\": {\n" +
            "                \"rank\": \"6\",\n" +
            "                \"lap\": \"54\",\n" +
            "                \"Time\": {\n" +
            "                  \"time\": \"1:29.392\"\n" +
            "                },\n" +
            "                \"AverageSpeed\": {\n" +
            "                  \"units\": \"kph\",\n" +
            "                  \"speed\": \"212.676\"\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "}"

    @Test
    fun raceResultTest() {
        val json = JsonParser().parse(res) as JsonObject
        val result = mLastRaceMapper.encodeLastRaceResponse(json)

        val driver = result.pilot?.get(0)?.pilotName.toString()
        Assert.assertEquals(driver,"Max")
    }
}