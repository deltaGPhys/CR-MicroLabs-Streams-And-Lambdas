package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.anthropoid.PersonWarehouse;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        Random random = new Random();
        this.startingCharacter = String.valueOf(random.nextInt(26) + 'a');
        this.personStream = new PersonFactory().createPersonStream(100);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Stream.empty(), null);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(Stream.empty(), null);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        ArrayList<Person> results = new ArrayList<>();
        this.personStream.forEach(x -> {
            if (x.getName().substring(0,1).equals(this.startingCharacter)) {
                results.add(x);
            }
        });
        return results;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return this.personStream.filter(x -> x.getName().substring(0,1).equals(this.startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return toListOneLine().toArray(new Person[0]);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        ArrayList<Person> results = new ArrayList<>();
        this.personStream.forEach(x -> {
            if (x.getName().substring(0,1).equals(this.startingCharacter)) {
                results.add(x);
            }
        });
        return results.toArray(new Person[0]);
    }

}
