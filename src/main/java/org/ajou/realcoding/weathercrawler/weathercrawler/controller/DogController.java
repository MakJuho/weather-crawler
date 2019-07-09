package org.ajou.realcoding.weathercrawler.weathercrawler.controller;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    List<Dog> dogs = new ArrayList<>();

    @PostMapping("/dogs") // http://localhost:8081/dogs
    public Dog createDog(@RequestBody Dog dog){
        dogs.add(dog);
        return dog;
    }

//    @GetMapping("/dogs/{name}") // /dogs/ian
//    public Dog findDog(@PathVariable String name){
//        for (int i =0 ; i< dogs.size(); i++){
//            if(dogs.get(i).getName().equals(name)) {
//                return dogs.get(i);
//            }
//        }
//        return null;
//    }
    @GetMapping("/dogs") // /dogs?name=ian&kind=martiz
    public Dog findDog(@RequestParam String name){
        for( Dog dog : dogs){
            if(dog.getName().equals(name)) {
                return dog;
            }
        }
        return null;
    }

//
    @DeleteMapping("/dogs")
    public String deleteDog(@RequestParam String name){
        for(int i=0 ; i<dogs.size(); i++){
            if(dogs.get(i).getName().equals(name)){
                dogs.remove(dogs.get(i));
                return "Remove - Success";
            }
        }
        return "Remove - Fail";
    }

    @PutMapping("/dogs") // /dogs?name=ian&kind=martiz
    public String updateDog(@RequestParam String name){
        for(int i=0 ; i<dogs.size(); i++){
            if(dogs.get(i).getName().equals(name)){
                dogs.get(i).setName("UPDATE");
                return "Update - Success";
            }
        }
        return "Update - Fail";
    }

}
