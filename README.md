# New Way Of Learing Java 8 Streams
In this Repository we are giving you the best of best the implementations of streams in java 8, we are trying to show you how stream is similar to MySQL operation 
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

## Questions cover
   * Find all transactions in the year 2011 and sort them by value (small to high).
   * What are all the unique cities where the traders work?
   * Find all traders from Nanded and sort them by name.
   * Return a string of all traders’ names sorted alphabetically.
   * Are any traders based in Osmanabad?
   * Print all transactions’ values from the traders living in Cambridge.
   * What’s the highest value of all the transactions?
   * Find the transaction with the smallest value.
## Database Design
   ![Database Design](https://github.com/rohitchavan-git/Learn-Java-8-Stream/blob/master/github.png)
