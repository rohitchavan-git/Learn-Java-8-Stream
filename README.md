# New Way Of Learing Java 8 Streams
In this Respository we are giving you the best of best the implemations of streams in java 8 , we are tries to show you how stream is similar to mysql operation 
## Topics Covers
  * lambda in java 8
  * Functional Interface
     * Predicate
     * Consumer
     * Function 
     * Comparetor
     * Comparable and more 
  * Streams
     * streams
     * map
     * filter
     * sotred
     * distinct
     * flatMap
     * IntStream.Of
     * IntStream.range
     * anyMatch
     * allMatch
     * noneMatch
     * sort
     * min
     * max
     * reduce
     * count
     * forEach
     * IntStream.rangeClosed
     * mapToObj ,mapToInt and more
  * Logically We are comapring all Stream operations to MYSQL Opearations
  ### Example
  ```bash
      select tid from transactions where city="hyd" (Logically Similar To) 
      allTransaction.stream()
                    .filter(p->p.getCity.equals("hyd"))
                    .map(Transactions::getTid)
                    .collect(Collectors.toList()); 
  ```

      
