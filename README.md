# Properties Comparator

The purpose of this project is to find differences between two properties files. 
The response is separated 

## Download the source code

## Building the project

`mvn clean package`

## To test

`java -jar target/comparator.jar -1 src/test/resources/first.properties -2 src/test/resources/second.properties`

The expected output is

>FIRST ONLY:
>  1 = 1
>  c = c
>
>SECOND ONLY:
>  4 = 4
>  d = d
>
>DIFFERENT:
>\> Property key - a
>--> value in first - a
>--> value in second - b
>\> Property key - b
>--> value in first - b
>--> value in second - c
>
>SAME:
>  2 = 2
>  3 = 3
>

To test the Hashicorp JSON format:
`java -jar target/comparator.jar -f hashicorp -1 src/test/resources/first.json -2 src/test/resources/second.json`

The expected output is

>FIRST ONLY:
>  1 = 1
>  c = c
>
>SECOND ONLY:
>  4 = 4
>  d = d
>
>DIFFERENT:
>\> Property key - a
>--> value in first - a
>--> value in second - b
>\> Property key - b
>--> value in first - b
>--> value in second - c
>
>SAME:
>  2 = 2
>  3 = 3
>


