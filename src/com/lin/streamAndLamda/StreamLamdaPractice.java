package com.lin.streamAndLamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLamdaPractice {

   public static void main(String[] args){
       List<Person> person= getPeople();

//       for(int i=1;i<10;i++){
//           nums.add(i);
//       }
//       nums.stream().filter(x->x%3==0).forEach(System.out::println)
      List<Person> streamList= person.stream()
                 .filter(p->p.getGender().equals("male"))
                 .distinct()
                 .sorted(Comparator.comparing(Person::getAge).reversed())
                 //.max(Comparator.comparing(Person::getAge))
                 //.ifPresent(System.out::println);
                 //.allMatch(p->p.getAge()<35)
                 .collect(Collectors.toList());


      streamList.stream().
                 forEach(System.out::println);




   }

   private static List<Person> getPeople(){
      List<Person> person=new ArrayList<>();
          person.add( new Person("Md", 30, "male"));
       person.add( new Person("Hasan", 33, "male"));
       person.add( new Person("Ms", 29, "female"));
       person.add( new Person("Jhon", 37, "male"));
       person.add( new Person("Kiara", 25, "female"));

       return person;
   }



}
