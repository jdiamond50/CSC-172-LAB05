run: Driver.class URHashTable.class
	@java Driver
Driver.class: Driver.java
	@javac Driver.java
URHashTable.class: URHashTable.java UR_HashTable.class
	@javac URHashTable.java
UR_HashTable.class: UR_HashTable.java
	@javac UR_HashTable.java
