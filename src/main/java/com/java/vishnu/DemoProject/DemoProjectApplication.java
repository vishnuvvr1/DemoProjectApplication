package com.java.vishnu.DemoProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories
public class DemoProjectApplication {

    public static void main(String[] args) {
        String jsonData = "[{\"id\":1,\"firstName\":\"sai kumar\",\"lastName\":\"vvr\",\"email\":\"vishnu52@gmail.com\",\"age\":26,\"dob\":\"1998-12-26\"},{\"id\":2,\"firstName\":\"vishnu\",\"lastName\":\"vvr\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":3,\"firstName\":\"vishnu\",\"lastName\":\"vvr\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":4,\"firstName\":\"vvr\",\"lastName\":\"vishnu\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":5,\"firstName\":\"saif\",\"lastName\":\"sk\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":6,\"firstName\":\"sk\",\"lastName\":\"saif\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":7,\"firstName\":\"vishnu good boy\",\"lastName\":\"vishnu bad boy\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":8,\"firstName\":\"vishnu bad boy\",\"lastName\":\"vishnu good boy\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"},{\"id\":9,\"firstName\":\"vishnu vardhan reddy\"," +
                "\"lastName\":\"vishnu good boy\",\"email\":\"vishnu52@gmail.com\",\"age\":23,\"dob\":\"1998-12-26\"}]";
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string to array of JSON nodes
            JsonNode[] nodes = mapper.readValue(jsonData, JsonNode[].class);

            // Iterate over each JSON node and print its properties line by line
            for (JsonNode node : nodes) {
                System.out.println("id: " + node.get("id").asText());
                System.out.println("firstName: " + node.get("firstName").asText());
                System.out.println("lastName: " + node.get("lastName").asText());
                System.out.println("email: " + node.get("email").asText());
                System.out.println("age: " + node.get("age").asText());
                System.out.println("dob: " + node.get("dob").asText());
                System.out.println("\n"); // Add an empty line between objects
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}