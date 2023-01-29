package es.dar.tr25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MatchJsonParser
{
    private static final Logger LOGGER = LogManager.getLogger();

    private List<Match> matchList = new ArrayList<Match>();

    public static void main(String[] args)
    {
        MatchJsonParser matchJsonParser = new MatchJsonParser();

        try
        {
            matchJsonParser.startProcess();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void startProcess()
    {
        String nombreFichero = "43.json";
        try
        {

            String fileContent = FileUtils.readFileToString(new File(nombreFichero), "UTF-8");

            JsonNode rootJsonNode = Json.mapper().readTree(fileContent);

            if (rootJsonNode.isArray())
            {
                ArrayNode rootArrayJsonNode = (ArrayNode) rootJsonNode;

                final Iterator<JsonNode> iterator = rootArrayJsonNode.elements();

                while (iterator.hasNext())
                {
                    Match match = new Match();
                    Stage stage = new Stage();
                    Season season = new Season();
                    Team homeTeam = new Team();
                    Team awayTeam = new Team();
                    Manager homeManager = new Manager();
                    Manager awayManager = new Manager();
                    Country countryHomeManager = new Country();
                    Country countryAwayManager = new Country();
                    Country countryHomeTeam = new Country();
                    Country countryAwayTeam = new Country();



                    final JsonNode matchJsonNode = iterator.next();

                    if (matchJsonNode.has("match_date"))
                    {
                        final JsonNode matchDateNode = matchJsonNode.get("match_date");
                        match.setDate(matchDateNode.asText());
                    }


                    if (matchJsonNode.has("season"))
                    {
                        final JsonNode seasonNode = matchJsonNode.get("season");

                        if(seasonNode.has("season_name"))
                        {

                            final JsonNode seasonNameNode = seasonNode.get("season_name");

                            season.setSeasonName(seasonNameNode.asText());

                            match.setSeason(season);
                        }

                    }


                    if (matchJsonNode.has("home_team"))
                    {
                        final JsonNode homeTeamNode = matchJsonNode.get("home_team");

                        if(homeTeamNode.has("home_team_id"))
                        {

                            final JsonNode homeTeamNameNode = homeTeamNode.get("home_team_id");

                            homeTeam.setTeamName(homeTeamNameNode.asText());

                            match.setHomeTeam(homeTeam);

                        }

                        if(homeTeamNode.has("home_team_name"))
                        {

                            final JsonNode homeTeamNameNode = homeTeamNode.get("home_team_name");

                            homeTeam.setTeamName(homeTeamNameNode.asText());

                            match.setHomeTeam(homeTeam);

                        }

                        if(homeTeamNode.has("country"))
                        {
                            final JsonNode homeTeamCountryNode = homeTeamNode.get("country");

                            if(homeTeamCountryNode.has("name"))
                            {
                                final JsonNode homeTeamCountryNameNode = homeTeamCountryNode.get("name");

                                countryHomeTeam.setName(homeTeamCountryNameNode.asText());
                                homeTeam.setTeamCountry(countryHomeTeam);
                                match.setHomeTeam(homeTeam);
                            }
                        }

                        if(homeTeamNode.has("managers"))
                        {
                            final JsonNode managersNode = homeTeamNode.get("managers");



                            if(managersNode.isArray())
                            {
                                ArrayNode managerArrayJsonNode = (ArrayNode) managersNode;

                                final Iterator<JsonNode> managerIterator = managerArrayJsonNode.elements();

                                while (managerIterator.hasNext())
                                {
                                    final JsonNode managerNode = managerIterator.next();

                                    if(managerNode.has("name"))
                                    {
                                        final JsonNode managerNameNode = managerNode.get("name");

                                        homeManager.setName(managerNameNode.asText());

                                        homeTeam.getManager().add(homeManager);

                                        match.setHomeTeam(homeTeam);
                                    }

                                    if(managerNode.has("country"))
                                    {
                                        final JsonNode managerCountryNode = managerNode.get("country");

                                        if(managerCountryNode.has("name"))
                                        {
                                            final JsonNode managerCountryNameNode = managerCountryNode.get("name");

                                            countryHomeManager.setName(managerCountryNameNode.asText());

                                            homeManager.setNameCountry(countryHomeManager);

                                            homeTeam.getManager().add(homeManager);

                                            match.setHomeTeam(homeTeam);
                                        }

                                    }
                                }
                            }
                        }
                    }

                    if (matchJsonNode.has("away_team"))
                    {
                        final JsonNode awayTeamNode = matchJsonNode.get("away_team");

                        if(awayTeamNode.has("away_team_id"))
                        {

                            final JsonNode awayTeamNameNode = awayTeamNode.get("away_team_id");

                            awayTeam.setTeamName(awayTeamNameNode.asText());

                            match.setAwayTeam(awayTeam);
                        }

                        if(awayTeamNode.has("away_team_name"))
                        {

                            final JsonNode awayTeamNameNode = awayTeamNode.get("away_team_name");

                            awayTeam.setTeamName(awayTeamNameNode.asText());

                            match.setAwayTeam(awayTeam);
                        }

                        if(awayTeamNode.has("country"))
                        {
                            final JsonNode awayTeamCountryNode = awayTeamNode.get("country");

                            if(awayTeamCountryNode.has("name"))
                            {
                                final JsonNode awayTeamCountryNameNode = awayTeamCountryNode.get("name");

                                countryAwayTeam.setName(awayTeamCountryNameNode.asText());
                                awayTeam.setTeamCountry(countryAwayTeam);
                                match.setAwayTeam(awayTeam);
                            }
                        }


                        if(awayTeamNode.has("managers"))
                        {
                            final JsonNode managersNode = awayTeamNode.get("managers");

                            if(managersNode.isArray())
                            {
                                ArrayNode managerArrayJsonNode = (ArrayNode) managersNode;

                                final Iterator<JsonNode> managerIterator = managerArrayJsonNode.elements();

                                while (managerIterator.hasNext())
                                {
                                    final JsonNode managerNode = managerIterator.next();

                                    if(managerNode.has("id"))
                                    {
                                        final JsonNode managerIdNode = managerNode.get("id");

                                        awayManager.setId(Integer.parseInt(managerIdNode.asText()));

                                        awayTeam.getManager().add(awayManager);

                                        match.setAwayTeam(awayTeam);
                                    }

                                    if(managerNode.has("name"))
                                    {
                                        final JsonNode managerNameNode = managerNode.get("name");

                                        awayManager.setName(managerNameNode.asText());

                                        awayTeam.getManager().add(awayManager);

                                        match.setAwayTeam(awayTeam);
                                    }

                                    if(managerNode.has("country"))
                                    {
                                        final JsonNode managerCountryNode = managerNode.get("country");

                                        if(managerCountryNode.has("name"))
                                        {
                                            final JsonNode managerCountryNameNode = managerCountryNode.get("name");

                                            countryAwayManager.setName(managerCountryNameNode.asText());

                                            awayManager.setNameCountry(countryAwayManager);

                                            awayTeam.getManager().add(awayManager);

                                            match.setAwayTeam(awayTeam);

                                        }

                                    }
                                }
                            }
                        }
                    }

                    if (matchJsonNode.has("competition_stage"))
                    {
                        final JsonNode stageNode = matchJsonNode.get("competition_stage");

                        if(stageNode.has("name"))
                        {

                            final JsonNode stageNameNode = stageNode.get("name");

                            stage.setStageName(stageNameNode.asText());

                            match.setStage(stage);
                        }
                    }

                    matchList.add(match);
                }
            }
            matchFilter(matchList);
        }
        catch (IOException ioException)
        {
            LOGGER.error("Error mientras se trataba de leer el fichero " + nombreFichero , ioException);
            ioException.getStackTrace();

        }
    }

    private static void matchFilter(List<Match>matchList)
    {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String nombreFicheroSalida = "src/main/java/es/dar/tr25/partidos.txt";
        try
        {
            fileWriter = new FileWriter(nombreFicheroSalida);
            printWriter = new PrintWriter(fileWriter);

            printWriter.println("Nombres de los equipos que jugaron la final de la Europcopa 2020");

            for(Match match : matchList)
            {
                if(match.getStage().getStageName().equals("Final") && match.getSeason().getSeasonName().equals("2020") )
                {
                    printWriter.println("-" + match.getHomeTeam().getTeamName() + " / " + match.getAwayTeam().getTeamName());

                }
            }


            printWriter.println("\nNombre de los entrenadores cuya nacionalidad no coincide con el pais que se representa: ");

            Map<Integer,Team> teamList = new HashMap();

            for(Match match : matchList)
            {
                for(Manager manager : match.getHomeTeam().getManager())
                {
                    if(!match.getHomeTeam().getTeamCountry().getName().equals(manager.getNameCountry().getName()))
                    {
                        if(!teamList.containsKey(manager.getId()))
                        {
                            teamList.put(manager.getId(),match.getHomeTeam());

                        }
                    }
                }

                for(Manager manager : match.getAwayTeam().getManager())
                {
                    if(!match.getAwayTeam().getTeamCountry().getName().equals(manager.getNameCountry().getName()))
                    {
                        if(!teamList.containsKey(manager.getId()))
                        {
                            teamList.put(manager.getId(),match.getAwayTeam());

                        }
                    }
                }
            }

            for(Map.Entry<Integer,Team> team : teamList.entrySet()){

                printWriter.println("- " + team.getValue().getTeamName() + " Nacionalidad Equipos: " + team.getValue().getTeamCountry().getName() + " Entrenador: "
                        + team.getValue().getManager().get(0).getName() + " Nacionalidad Emtrenador: " +team.getValue().getManager().get(0).getNameCountry().getName());
            }

            printWriter.println("\nPartidos que se jugaron despues del 1 de julio de 2021:");

            for(Match match : matchList)
            {
                Date matchDate = null;
                Date dateFilter = null;

                try
                {
                    matchDate = new SimpleDateFormat("yyyy-MM-dd").parse(match.getDate());
                    dateFilter = new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-01");


                }
                catch (ParseException parseException)
                {
                    parseException.printStackTrace();
                }
                if(matchDate!=null && dateFilter!=null)
                {

                    if(matchDate.after(dateFilter) )
                    {
                        printWriter.println("- "+ match.getHomeTeam().getTeamName() + " / " + match.getAwayTeam().getTeamName());

                    }
                }
                else
                {
                    LOGGER.error("No se pudo parsear la fecha " );


                }
            }
            printWriter.flush();

        }
        catch (IOException fileNotFoundException)
        {
            fileNotFoundException.getStackTrace();

        }
        finally
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();

                }
                catch (IOException ioException)
                {
                    ioException.getStackTrace();
                }
            }

            if (printWriter != null)
            {
                printWriter.close();
            }
        }
    }
}
