package streamsAPI;

import classes.Animal;
import classes.Caballo;
import classes.Conejo;
import classes.Perro;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsAPI {

    public static void execute() {
        ArrayList<Animal> animals = generateAnimals();

        // for each simple, corren todos los animales
        System.out.println("____Corren todos los animales____");

        animals.stream().forEach(x -> x.correr());


        // suma velocidad solo caballos
        System.out.println("____Suma la velocidad de todos los caballos____");

        int suma = animals.stream().filter(x -> x.getClass().equals(Caballo.class)).mapToInt(x -> ((Caballo) x).velocidad).sum();

        System.out.println(suma);


        // aumenta velocidad solo perros
        System.out.println("____Aumenta velocidad solo perros____");
        System.out.println(animals.get(3));
        System.out.println(animals.get(3).velocidad());

        animals.stream().filter(x -> x.getClass().equals(Perro.class)).forEach(x -> x.setVelocidad(25));

        System.out.println(animals.get(3).velocidad());


        // obtener solo los conejos y perros por su comida
        System.out.println("____Obtener solo los conejos y perros por su comida___");

        List<String> comidas = new ArrayList<>(Arrays.asList("meat", "vegetables"));

        List<Animal> perrosyconejos = animals.stream().filter(x -> comidas.stream().anyMatch(c -> c.equals(x.comida()))).collect(Collectors.toList());

        System.out.println(perrosyconejos);


        // imprime comida de animales que tienen velocidad > 24
        System.out.println("____Imprime comida de animales que tienen velocidad > 24___");

        animals.stream().filter(x -> x.velocidad() > 24).map(x -> x.comida()).forEach(x -> System.out.println(x));


        // encuentra el primer animal con mas de 70 de velocidad, si no encuentra devuelve null
        System.out.println("____Encuentra el primer animal con mas de 70 de velocidad, si no encuentra devuelve null___");

        Animal veloz = animals.stream().filter(x -> x.velocidad() > 50).findFirst().orElse(null);

        System.out.println(veloz);

        // Aumenta la velocidad de los caballos, usando peek,imprime sus alimentos
        System.out.println("____Aumenta la velocidad de los caballos, usando peek, imprime sus alimentos__");

        animals.stream().filter(x -> x.getClass().equals(Caballo.class)).peek(c -> ((Caballo) c).setVelocidad(35)).forEach(x -> System.out.println(((Caballo) x).comida));

        // Muestra que porcentaje representa la velocidad de un animal respecto a la velocidad total de todos los animales
        System.out.println("____Muestra que porcentaje representa la velocidad de un animal respecto a la velocidad total de todos los animales__");

        int velocidadTotal = animals.stream().mapToInt(x -> x.velocidad()).sum();
        System.out.println("Velocidad total: " + velocidadTotal + " = 100%");

        animals.stream().forEach(x -> System.out.println(((x.velocidad() * 100) / velocidadTotal) + "%"));


        // Obtiene el animal mas lento
        System.out.println("____Obtiene el animal mas lento__");

        Animal lentejita = animals.stream().min((e1, e2) -> e1.velocidad() - e2.velocidad()).orElseThrow(NoSuchElementException::new);

        System.out.println(lentejita);

        // Obtiene el animal mas rapido
        System.out.println("____Obtiene el animal mas rapido__");

        veloz = animals.stream().max((e1, e2) -> e1.velocidad() - e2.velocidad()).orElseThrow(NoSuchElementException::new);

        System.out.println(veloz);


        System.out.println("____NUEVA LISTA DE ANIMALES____");
        // Ordena la lista
        System.out.println("____Ordenar la lista por velocidades: SORT____");

        ArrayList<Animal> newList = generateAnimals();
        System.out.println("Lista NO ordenada:");
        newList.forEach(x -> System.out.println(x.velocidad()));

        // por string usar .compareTo
        newList = (ArrayList<Animal>) newList.stream().sorted((e1, e2) -> e1.velocidad() - e2.velocidad()).collect(Collectors.toList());

        System.out.println("Lista ORDENADA:");
        newList.forEach(x -> System.out.println(x.velocidad()));


        // Algun elemento tiene velocidad menor a 10?
        System.out.println("____Algun elemento tiene velocidad menor a 10?__");

        if (newList.stream().anyMatch(x -> x.velocidad() < 10)) System.out.println("Si!");
        else System.out.println("NO!");

        System.out.println("Cual? (primero que matchea)");
        newList.stream().filter(x -> x.velocidad() < 10).limit(1).forEach(x -> System.out.println(x));

        // Todos los animales comen grass?
        System.out.println("____Todos los animales comen grass?__");

        if (newList.stream().allMatch(x -> x.comida().equals("grass"))) System.out.println("SI!");
        else System.out.println("No!!");


        // Promedio de velocidad:
        System.out.println("____Promedio de velocidad:____");

        double promedio = newList.stream().mapToInt(x -> x.velocidad()).average().orElse(0);

        System.out.println(promedio);

        // Imprime todas las comidas separadas por ,
        System.out.println("____ Imprime todas las comidas separadas por , ____");

        String all = newList.stream().map(Animal::comida).collect(Collectors.joining(", ")).toString();

        System.out.println(all);

        // Animales sin repetir:
        System.out.println("____ Comidas sin repetir____");

        Set<String> set = newList.stream().map(Animal::comida).collect(Collectors.toSet());
        System.out.println(set.stream().collect(Collectors.joining(" - ")).toString());


        // Estadisticas de mis animales por velocidad:

        System.out.println("____ Estadisticas de mis animales por velocidad ____");
        DoubleSummaryStatistics stats = newList.stream().collect(Collectors.summarizingDouble(Animal::velocidad));

        System.out.println("cantidad de animales:" + stats.getCount() +
                "\nvelocidad total (suma): " + stats.getSum() +
                "\nvelocidad minima: " + stats.getMin() +
                "\nvelocidad maxima: " + stats.getMax() +
                "\nvelocidad promedio: " + stats.getAverage()
        );


        // Dividir mis animales segun su clase
        System.out.println("____ Dividir mis animales segun su clase____");
        // GROUP BY: divide la lista en partes

        Map<String, List<Animal>> mapAnimals = newList.stream().collect(Collectors.groupingBy(x -> x.getClass().toString()));

        for (String k : mapAnimals.keySet()) {
            System.out.println("key: " + k + "  values: " + mapAnimals.get(k));
        }

    }

    public static ArrayList<Animal> generateAnimals() {
        return new ArrayList<Animal>(Arrays.asList(new Caballo(), new Conejo(), new Perro(), new Perro(), new Conejo(), new Caballo()));
    }

    public static void extra() {

        ArrayList<Animal> newList = generateAnimals();

        //SETS
        Set<Animal> setanimales = new HashSet<>(newList);


        // HASH MAPS --> .clear .remove(key) .get(key) .size
        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        List<Boolean> xd = list.stream().map(x -> x.equals("a")).collect(Collectors.toList());
        System.out.println(xd);
        HashMap<String, Integer> a = new HashMap<>();
        a.put("ap", 3);
        int s = a.get("ap");
        a.put("ap", s + 4);
        a.put("ap", 65);
        System.out.println(a.size());

    }
}
