package CinemaWeb;

import CinemaWeb.entities.Cinema;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;


public class Client {
    public static String ALL_FUR_URL = "http://localhost:8080/Administrator/cinemas";
    public static String FIND_BY_ID_URL = "http://localhost:8080/Administrator/cinemas/find/";
    public static String ADD_NEW_FUR_URL = "http://localhost:8080/Administrator/cinemas/new";
    public static String DELETE_FUR_URL = "http://localhost:8080/Administrator/cinemas/delete/";
    public static String EDIT_FUR_URL = "http://localhost:8080/Administrator/cinemas/edit/";

    static final int FIRST_KEY = 1, SECOND_KEY = 2, THIRD_KEY = 3, FOURTH_KEY = 4, FIFTH_KEY = 5,
            SIXTH_KEY = 6;

    public static ResponseEntity<List> allFur(RestTemplate restTemplate){
        return restTemplate.getForEntity(ALL_FUR_URL, List.class);
    }

    public static ResponseEntity<cinema> getFurById(int id, RestTemplate restTemplate){
        return restTemplate.getForEntity(FIND_BY_ID_URL + id, cinema.class);
    }

    public static void addFur(cinema cinema, RestTemplate restTemplate){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Cinema> requestEntity = new HttpEntity<>(cinema, headers);

        restTemplate.postForEntity(ADD_NEW_FUR_URL, requestEntity, Cinema.class);
    }

    public static void deleteFur(int id, RestTemplate restTemplate){
        restTemplate.delete(DELETE_FUR_URL + id);
    }


    public static void editFur(Cinema cinema, RestTemplate restTemplate){
        restTemplate.put(EDIT_FUR_URL + cinema.getId(), cinema);
    }

    public static void main(String[] args){
        boolean flag = true;
        int function;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("AAAAA", "1111"));

        while (flag){
            System.out.println("1)???????????????? ????????????");
            System.out.println("2)???????????????? ?????????????????? ???? id");
            System.out.println("3)???????????????? ?????????????????? ????????");
            System.out.println("4)?????????????? ?????????????????? ???? id");
            System.out.println("5)?????????????????????????? ????????");
            System.out.println("6)?????????? ???? ??????????????????");
            function = Check.getInt("???????????????? ?????????? ???? ????????");
            switch (function){
                case FIRST_KEY -> {
                    List cinemas = allFur(restTemplate).getBody();
                    System.out.println("??????????????????:");
                    assert cinemas != null;
                    for (Object cinema: cinemas) {
                        System.out.println("|||" + cinema + "|||");
                    }
                }
                case SECOND_KEY -> {
                    try {
                        int id = Check.getInt("id");
                        System.out.println("?????????????????? ->" + getFurById(id, restTemplate).getBody());
                    }catch (HttpClientErrorException httpClientErrorException){
                        System.out.println("????????????");
                    }
                }
                case THIRD_KEY -> {
                    try {
                        addFur(new Cinema(Check.getString("model"), Check.getString("Material"),
                                Check.getString("typeOfCinema"), Check.getInt( "price"),
                                Check.getInt("volume")), restTemplate);
                    }catch (HttpServerErrorException httpServerErrorException){
                        System.out.println("????????????");
                    }
                }
                case FOURTH_KEY -> {
                    try {
                        int id = Check.getInt("id");
                        deleteFur(id, restTemplate);
                    }catch (HttpClientErrorException httpClientErrorException){
                        System.out.println("????????????");
                    }
                }
                case FIFTH_KEY -> {
                    System.out.println("?????????????? id, ?????????? ?????????????????????????? ??????????????????");
                    int id = Check.getInt("id");
                    try {
                        getFurById(id, restTemplate);
                    }catch (HttpClientErrorException httpClientErrorException){
                        System.out.println("????????????");
                        break;
                    }

                    System.out.println("?????????????? ?????????? ????????????????");
                    Cinema cinema = new Cinema(Check.getString("model"), Check.getString("Material"),
                            Check.getString("typeOfCinema"), Check.getInt( "price"),
                            Check.getInt("volume"));
                    cinema.setId(id);
                    try {
                        editFur(cinema, restTemplate);
                    }catch (HttpServerErrorException httpServerErrorException){
                        System.out.println("????????????");
                    }
                }
                case SIXTH_KEY -> flag = false;
                default -> System.out.println("?????? ?????????? ??????????????, ???????????????????? ??????????");
            }
        }
    }
}